package com.ungdungso.config;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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



@Component
@EnableScheduling /// https://gpcoder.com/3231-huong-dan-phan-tich-noi-dung-html-su-dung-thu-vien-jsoup/
public class ScheduleTask {
	@Autowired
	private BidsNoticeRepostory bidsNoticeRepostory;
	
	@Autowired
	private DistricRepository districRepository;

	@Scheduled(cron = "5 * * * * ?") 
	public void scheduleGetBidNotice() throws IOException {	
				OkHttpClient client = new OkHttpClient();
				MediaType mediaType = MediaType.parse("application/json");
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date today= new Date();
				String dateString=format.format(today).toString();		
				String tempString="{\"pageNumber\":\"0\",\"query\":[{\"index\":\"es-contractor-selection\",\"matchFields\":[\"notifyNo\",\"bidName\"],\"filters\":[{\"fieldName\":\"publicDate\",\"searchType\":\"range\",\"from\":\"fromDayT00:00:00.000Z\",\"to\":\"toDayT23:59:59.059Z\"},{\"fieldName\":\"type\",\"searchType\":\"in\",\"fieldValues\":[\"es-notify-contractor\"]},{\"fieldName\":\"caseKHKQ\",\"searchType\":\"not_in\",\"fieldValues\":[\"1\"]}]}]}";
				//RequestBody body = RequestBody.create(mediaType, "{\"pageNumber\":\"0\",\"query\":[{\"index\":\"es-contractor-selection\",\"matchFields\":[\"notifyNo\",\"bidName\"],\"filters\":[{\"fieldName\":\"publicDate\",\"searchType\":\"range\",\"from\":\"2023-06-17T00:00:00.000Z\",\"to\":\"2023-06-17T23:59:59.059Z\"},{\"fieldName\":\"type\",\"searchType\":\"in\",\"fieldValues\":[\"es-notify-contractor\"]},{\"fieldName\":\"caseKHKQ\",\"searchType\":\"not_in\",\"fieldValues\":[\"1\"]}]}]}");
				tempString=tempString.replace("fromDay", dateString);
				tempString=tempString.replace("toDay", dateString);				
				RequestBody body = RequestBody.create(mediaType,tempString);				
				Request request = new Request.Builder()
				  .url("https://muasamcong.mpi.gov.vn/o/egp-portal-contractor-selection-v2/services/smart/search")
				  .method("POST", body)
				  .addHeader("Accept", "application/json, text/plain, */*")
				  .addHeader("Accept-Language", "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5")
				  .addHeader("Connection", "keep-alive")
				  .addHeader("Content-Type", "application/json")
				  //.addHeader("Cookie", "COOKIE_SUPPORT=true; GUEST_LANGUAGE_ID=vi_VN; _ga=GA1.1.709601728.1685634257; JSESSIONID=TrMGCXOJQqrB-llAsFZA6iNS-yG0NSJOOr0AgEo9.dc_app1_03; NSC_WT_QSE_QPSUBM_NTD_NQJ=ffffffffaf183e2545525d5f4f58455e445a4a4217de; LFR_SESSION_STATE_20103=1687012303169; _ga_19996Z37EE=GS1.1.1687012296.6.1.1687012348.0.0.0; citrix_ns_id=AAA7TquNZDuObCQBAAAAADuFeyfrzB16Q6f2OxDeCDxiBJX9T-shTsGBSczwUfQKOw==g8eNZA==21h5HeBj5XIUl3gaDB63APbFbws=; GUEST_LANGUAGE_ID=vi_VN; citrix_ns_id=AAA7TquNZDuObCQBAAAAADuFeyfrzB16Q6f2OxDeCDxiBJX9T-shTsGBSczwUfQKOw==vMeNZA==iiTqfpyds1n_6WVG0SvzG2YBmjA=; COOKIE_SUPPORT=true; NSC_WT_QSE_QPSUBM_NTD_NQJ=ffffffffaf183e2545525d5f4f58455e445a4a4217de")
				  .addHeader("Origin", "https://muasamcong.mpi.gov.vn")
				  .addHeader("Referer", "https://muasamcong.mpi.gov.vn/web/guest/contractor-selection?render=index")
				  .build();
				Response response = client.newCall(request).execute();
				String jsonData = response.body().string();		   
			    int  tmp= jsonData.lastIndexOf("totalPages");
			    String temp3=jsonData.substring(8,tmp-2)+"}";
			    JSONObject jobject = new JSONObject(temp3);			    
			    JSONArray Jarray = jobject.getJSONArray("content");  //2023-06-28T09:00:00
			    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			    ObjectMapper objectMapper = new ObjectMapper();
			    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false); 
			    objectMapper.setDateFormat(formatDate);
				for(int i=0; i<Jarray.length(); i++) { 				
					String tmpString=Jarray.get(i).toString();
					tmpString=reExcuteString(tmpString);
					BidsNotice bidsNotice= objectMapper.readValue(tmpString, BidsNotice.class);
					if(bidsNoticeRepostory.existsById(bidsNotice.getNotifyNo())) { 
						System.out.println("Đã tồn tại thông báo mời thầu");	
						continue;}		
					bidsNoticeRepostory.save(bidsNotice);
					District district=objectMapper.readValue(tmpString, District.class);
					if(!districRepository.existsById(district.getDistrictCode())) {
						districRepository.save(district);
					}
				}				
}
	private String reExcuteString(String objectString) { // tiền xử lý data json
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
