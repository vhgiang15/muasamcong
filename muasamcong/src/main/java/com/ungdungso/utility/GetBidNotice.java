package com.ungdungso.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.model.District;
import com.ungdungso.repository.BidsNoticeRepostory;
import com.ungdungso.repository.DistricRepository;

public class GetBidNotice {
	private static int totalPage; //số lượng trang trả về khi get API
	public static List<BidsNotice> getBidsNoticedbyDate( Date dateFrom, Date dateTo, DistricRepository districRepository,BidsNoticeRepostory bidsNoticeRepostory) throws IOException
	{	
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json"); 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateFromString=format.format(dateFrom).toString();
		String dateToString=format.format(dateTo).toString();		
		String mediaTypeString="{\"pageNumber\":\"0\",\"query\":[{\"index\":\"es-contractor-selection\",\"matchFields\":[\"notifyNo\",\"bidName\"],\"filters\":[{\"fieldName\":\"publicDate\",\"searchType\":\"range\",\"from\":\"fromDayT00:00:00.000Z\",\"to\":\"toDayT23:59:59.059Z\"},{\"fieldName\":\"type\",\"searchType\":\"in\",\"fieldValues\":[\"es-notify-contractor\"]},{\"fieldName\":\"caseKHKQ\",\"searchType\":\"not_in\",\"fieldValues\":[\"1\"]}]}]}";
		System.out.println("Chi so indẽ trang");
		
		//System.out.println(mediaTypeString.substring(0, 17));
		//mediaTypeString=mediaTypeString.replace("{\"pageNumber\":\"0\"","{\"pageNumber\":\"4\"");
		
		System.out.println(mediaTypeString);
		mediaTypeString=mediaTypeString.replace("fromDay", dateFromString);
		mediaTypeString=mediaTypeString.replace("toDay", dateToString);				
		RequestBody body = RequestBody.create(mediaType,mediaTypeString);				
		Request request = new Request.Builder()
		  .url("https://muasamcong.mpi.gov.vn/o/egp-portal-contractor-selection-v2/services/smart/search")
		  .method("POST", body)
		  .addHeader("Accept", "application/json, text/plain, */*")
		  .addHeader("Accept-Language", "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5")
		  .addHeader("Connection", "keep-alive")
		  .addHeader("Content-Type", "application/json")
		  .addHeader("Origin", "https://muasamcong.mpi.gov.vn")
		  .addHeader("Referer", "https://muasamcong.mpi.gov.vn/web/guest/contractor-selection?render=index")
		  .build();
		Response response = client.newCall(request).execute();
		String jsonData = response.body().string();		   
	    int  tmp= jsonData.lastIndexOf("totalPages"); // tìm kiếm tổng số bản ghi và tổng số trang
	    int indexSpace=jsonData.indexOf(":", tmp);
	    int indexComma=jsonData.indexOf(",", tmp);
	    String totalPageString= jsonData.substring(indexSpace+1, indexComma);
	    System.out.println("chi so totalPage");
	    System.out.println(totalPageString);
		System.out.println(tmp);
		
		int tmp1=jsonData.indexOf("totalElements");
		System.out.println(tmp1);
	    
	    String temp3=jsonData.substring(8,tmp-2)+"}"; // chi lấy chuổi chứa dữ liệu thông báo mời thầu
	    JSONObject jobject = new JSONObject(temp3);			    
	    JSONArray Jarray = jobject.getJSONArray("content");  //2023-06-28T09:00:00
	    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false); 
	    objectMapper.setDateFormat(formatDate);
	    List<BidsNotice> lisBidsNotices= new ArrayList<>();
		for(int i=0; i<Jarray.length(); i++) { 				
			String tmpString=Jarray.get(i).toString();
			tmpString=reExcuteString(tmpString);
			BidsNotice bidsNotice= objectMapper.readValue(tmpString, BidsNotice.class);
			if(bidsNoticeRepostory.existsById(bidsNotice.getNotifyNo())) { 
				System.out.println("Đã tồn tại thông báo mời thầu");
				System.out.println(bidsNotice.getNotifyNo());
				continue;}			
			//bidsNoticeRepostory.save(bidsNotice);
			lisBidsNotices.add(bidsNotice);
			District district=objectMapper.readValue(tmpString, District.class);
			if(!districRepository.existsById(district.getDistrictCode())) {
				districRepository.save(district);
			}
		}						
	return lisBidsNotices;
	}
	
	private static String reExcuteString(String objectString) { // tiền xử lý data json
		
		int tmp=objectString.indexOf("\"pvccNew\":");   // xoá key pvccNew
		int tmp2= objectString.indexOf("],", tmp);
		String firString=objectString.substring(0, tmp);
		String lastString=objectString.substring(tmp2+2);
		objectString=firString+lastString;
		tmp=objectString.indexOf("\"goods\":");		//xoá key goods
		tmp2= objectString.indexOf("],", tmp);
		firString=objectString.substring(0, tmp);
		lastString=objectString.substring(tmp2+2);
		objectString=firString+lastString;
		objectString=objectString.replace("\"locations\":", "");// xoá key locations
		objectString=objectString.replace("{", "");
		objectString=objectString.replace("}", "");
		objectString=objectString.replace("[", "");
		objectString=objectString.replace("]", "");
		objectString="{"+objectString+"}";
		return objectString;
		
	}

}
