package com.ungdungso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class HomeController {

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(value = { "/", "/index" })
	public ModelAndView loginPage(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/login-page");
	return  model;
	}
	
	@GetMapping(value = { "/user/home","/dashboard"})
	public ModelAndView home(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/dashboard");
	return  model;
	}
	
	@GetMapping(value = { "/notice-today1"})
	public ModelAndView noticeToday(Authentication authentication) throws IOException {
		ModelAndView model= new ModelAndView("client/notice-today");		
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"areaType\":\"1\",\"parentCode\":\"VN\"}");
		Request request = new Request.Builder()
		  .url("https://muasamcong.mpi.gov.vn/o/egp-portal-contractor-selection-v2/services/get/area")
		  .method("POST", body)
		  .addHeader("Accept", "application/json, text/plain, */*")
		  .addHeader("Accept-Language", "vi-VN,vi;q=0.9,fr-FR;q=0.8,fr;q=0.7,en-US;q=0.6,en;q=0.5")
		  .addHeader("Connection", "keep-alive")
		  .addHeader("Content-Type", "application/json")
		  .addHeader("Referer", "https://muasamcong.mpi.gov.vn/web/guest/contractor-selection?render=index")
		  .build();	
			Response response = client.newCall(request).execute();
		    String jsonData = response.body().string();	
		    
		    JSONObject jobject = new JSONObject(jsonData);
		    System.out.println(jsonData);
		    JSONArray Jarray = jobject.getJSONArray("areas");  
	    for(int i=0; i<Jarray.length(); i++)
	    {
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    	//areaRepository.save(area); //only once run
		}				
	return  model;
	}
}
