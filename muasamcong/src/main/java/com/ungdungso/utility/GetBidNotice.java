package com.ungdungso.utility;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.model.District;
import com.ungdungso.model.Province;
import com.ungdungso.repository.BidsNoticeRepostory;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;

public class GetBidNotice {
	private static int totalPage; //số lượng trang trả về khi get API
	private static int totalElement; //số lượng thông báo mời thầu khi get API, xoá tham số provinceRepository và districRepository sau khi có đủ 2 thông số này trong databá
	
	// Lưu thông báo mời thầu tất cả các trang
	public static void getBidsNoticeToDay(DistricRepository districRepository,BidsNoticeRepostory bidsNoticeRepostory, ProvinceRepository provinceRepository) throws IOException {
		Date today= new Date();
		GetBidNotice.getTotalPageandElement(today);
		System.out.println("-------------------------");
		System.out.println(GetBidNotice.totalPage);
		System.out.println(GetBidNotice.totalElement);
				for(int i=0; i<totalPage;i++) {
					getBidsNoticedbyDate(today,i,districRepository, bidsNoticeRepostory,provinceRepository);
		}		
	}
	//Lưu thông báo mời thầu của 1 trang
	
	private static void getBidsNoticedbyDate( Date today,int page, DistricRepository districRepository,BidsNoticeRepostory bidsNoticeRepostory, ProvinceRepository provinceRepository) throws IOException
	{			
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json"); 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String todayString=format.format(today).toString();
		
		String fromDateString="2023-01-01";
		String toDateString="2023-06-30";

		
		String mediaTypeString="{\"pageNumber\":\"0\",\"query\":[{\"index\":\"es-contractor-selection\",\"matchFields\":[\"notifyNo\",\"bidName\"],\"filters\":[{\"fieldName\":\"publicDate\",\"searchType\":\"range\",\"from\":\"todayT00:00:00.000Z\",\"to\":\"todayT23:59:59.059Z\"},{\"fieldName\":\"type\",\"searchType\":\"in\",\"fieldValues\":[\"es-notify-contractor\"]},{\"fieldName\":\"caseKHKQ\",\"searchType\":\"not_in\",\"fieldValues\":[\"1\"]}]}]}";		
		String indexString="{\"pageNumber\":\""+page+"\"";		
		mediaTypeString=mediaTypeString.replace("{\"pageNumber\":\"0\"",indexString);		
		mediaTypeString=mediaTypeString.replace("today", todayString);
		
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
	    int  tmp= jsonData.lastIndexOf("totalPages");  
	    String temp3=jsonData.substring(8,tmp-2)+"}"; // chi lấy chuổi chứa dữ liệu thông báo mời thầu	    
	    System.out.println(temp3);
	    JSONObject jobject = new JSONObject(temp3);			    
	    JSONArray Jarray = jobject.getJSONArray("content");  //2023-06-28T09:00:00
	    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false); 
	    objectMapper.setDateFormat(formatDate);

		for(int i=0; i<Jarray.length(); i++) { 				
			String tmpString=Jarray.get(i).toString();			
			String jsonString =reExcuteString(tmpString);			
			BidsNotice bidsNotice= objectMapper.readValue(jsonString, BidsNotice.class);			
			List<District> location=getLocation(tmpString);
			System.out.println("So luong dia diem:" +location.size());		 
			
			if(bidsNoticeRepostory.existsById(bidsNotice.getNotifyNo())) { 
				System.out.println("Đã tồn tại thông báo mời thầu");
				continue;} else {					
				bidsNoticeRepostory.save(bidsNotice);				
				String locationBids="";
				for (District district : location) {				
					locationBids=locationBids+district.getProvCode()+"-"+district.getDistrictCode()+";";					
					Province province= new Province(district.getProvCode(), district.getProvName());
					if(!provinceRepository.existsById(province.getProvCode())&(province.getProvCode()!=0)) {
						provinceRepository.save(province);
					}				
					if(!districRepository.existsById(district.getDistrictCode())&(district.getDistrictCode()!=0)) {
						districRepository.save(district);				
					}
				}				
				bidsNotice.setLocation(locationBids);
				bidsNoticeRepostory.save(bidsNotice);				
			}
		}
					
	}
	
	private static void getTotalPageandElement(Date today) throws IOException {		
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json"); 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String todayString=format.format(today).toString();	
		String mediaTypeString="{\"pageNumber\":\"0\",\"query\":[{\"index\":\"es-contractor-selection\",\"matchFields\":[\"notifyNo\",\"bidName\"],\"filters\":[{\"fieldName\":\"publicDate\",\"searchType\":\"range\",\"from\":\"todayT00:00:00.000Z\",\"to\":\"todayT23:59:59.059Z\"},{\"fieldName\":\"type\",\"searchType\":\"in\",\"fieldValues\":[\"es-notify-contractor\"]},{\"fieldName\":\"caseKHKQ\",\"searchType\":\"not_in\",\"fieldValues\":[\"1\"]}]}]}";
		mediaTypeString=mediaTypeString.replace("today", todayString);				
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
	    totalPage= Integer.valueOf(jsonData.substring(indexSpace+1, indexComma));  
		int tmp1=jsonData.indexOf("totalElements");
	    indexSpace=jsonData.indexOf(":", tmp1);
	    indexComma=jsonData.indexOf(",", tmp1);
	    totalElement=Integer.valueOf(jsonData.substring(indexSpace+1, indexComma));
	} 
	
	private static String reExcuteString(String objectString) { // tiền xử lý data json, đầu ra là chuối json chỉ chứa dữ liệu thông báo mời thầu	
		int tmp1=-1;
		int tmp2=-1;
		String firString="";
		String lastString="";		
		tmp1=objectString.indexOf("\"pvccNew\":");   // xoá key pvccNew		
		if(tmp1!=-1) {
		tmp2=objectString.indexOf("\"bidCloseDate\":");
		firString=objectString.substring(0, tmp1);	
		lastString=objectString.substring(tmp2);
		objectString=firString+lastString;
		objectString=firString+lastString;
		}
		//System.out.println("Cat bo pvccNew");
		//System.out.println(objectString);
		
		tmp1=objectString.indexOf("\"goods\":"); //xoá key goods
		if(tmp1!=-1) {
		tmp2= objectString.indexOf("\"publicDate\":");
		firString=objectString.substring(0, tmp1);
		lastString=objectString.substring(tmp2);
		objectString=firString+lastString;
		}
		//System.out.println("Cat bo good");
		//System.out.println(objectString);
		
		tmp1=objectString.indexOf("\"locations\":");		// xoá location
		if(tmp1!=-1) {
			tmp2= objectString.indexOf("\"notifyVersion\":");
			firString=objectString.substring(0,tmp1);
			lastString=objectString.substring(tmp2);
			objectString=firString+lastString;
		}		
		objectString=objectString.replace("[","");
		objectString=objectString.replace("]","");	
		return objectString;		
	}
	
	private static List<District> getLocation(String objectString) throws JsonMappingException, JsonProcessingException
	{
		List<District> list = new ArrayList<>();
		int tmp1=objectString.indexOf("\"locations\":");		// xoá location
		String locationString="";
		if(tmp1!=-1) {
			int tmp2= objectString.indexOf("\"notifyVersion\":");
			locationString="{"+objectString.substring(tmp1, tmp2-1)+"}";
		}
		
		
	if(locationString.length()==0) { return list;}	
    JSONObject jobject = new JSONObject(locationString);			    
    JSONArray Jarray = jobject.getJSONArray("locations");  //2023-06-28T09:00:00
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);   
	for(int i=0; i<Jarray.length(); i++) { 				
		String tmpString=Jarray.get(i).toString();	
		District district= objectMapper.readValue(tmpString, District.class);
		list.add(district);		
	}
	return list;
	}

}
