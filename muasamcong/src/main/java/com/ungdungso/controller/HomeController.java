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
import com.ungdungso.model.Area;
import com.ungdungso.repository.AreaRepository;
import com.squareup.okhttp.RequestBody;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class HomeController {
	@Autowired
	private AreaRepository areaRepository;

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
	
	@GetMapping(value = { "/notice-today"})
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
		  .addHeader("Cookie", "COOKIE_SUPPORT=true; GUEST_LANGUAGE_ID=vi_VN; _ga=GA1.1.1221156877.1685954886; JSESSIONID=UEUscXFaemKW9NRDnm-CCJ-AH9loFeSxIfvv3Or4.dc_app1_03; NSC_WT_QSE_QPSUBM_NTD_NQJ=ffffffffaf183e2545525d5f4f58455e445a4a4217de; LFR_SESSION_STATE_20103=1686199259930; _ga_19996Z37EE=GS1.1.1686199210.3.1.1686199275.0.0.0; citrix_ns_id=AAM7p1uBZDuCx3QBAAAAADuFeyfrzB16Q6f2O3wkwp-X_KBiAk_jQriThj-xlt31Ow==d1-BZA==x81-xwKcAIb9NLBvrYD7jc5SWGc=; citrix_ns_id=AAA7wneBZDsl9BIBAAAAADuFeyfrzB16Q6f2OxDeCDxiBJX9T-shTsGBSczwUfQKOw==cHuBZA==FLFrosMyf9hKeuf0k1NxPlnNN14=; JSESSIONID=ZX3dbqDGzjBz0YeH2HASoS2sqijBLuQ3v_SXFB5R.dc_app1_03")
		  .addHeader("Origin", "https://muasamcong.mpi.gov.vn")
		  .addHeader("Referer", "https://muasamcong.mpi.gov.vn/web/guest/contractor-selection?render=index")
		  .addHeader("Sec-Fetch-Dest", "empty")
		  .addHeader("Sec-Fetch-Mode", "cors")
		  .addHeader("Sec-Fetch-Site", "same-origin")
		  .addHeader("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Mobile Safari/537.36")
		  .addHeader("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"")
		  .addHeader("sec-ch-ua-mobile", "?1")
		  .addHeader("sec-ch-ua-platform", "\"Android\"")
		  .build();	
			Response response;
			response = client.newCall(request).execute();
		    String jsonData = response.body().string();
		    JSONObject jobject = new JSONObject(jsonData);
		    System.out.println(jsonData);
		    JSONArray Jarray = jobject.getJSONArray("areas");
	    System.out.println(Jarray.length());
	    List<Area> list =new ArrayList<Area>();	    
	    for(int i=0; i<Jarray.length(); i++)
	    {
	    	ObjectMapper objectMapper = new ObjectMapper();
	    	Area area= objectMapper.readValue(Jarray.get(i).toString(), Area.class);
	    	list.add(area);
	    	areaRepository.save(area); //only once run
		}
	    for (Area area : list) {
	    	System.out.println(area.getNameTranslate());
		}
		
				
	return  model;
	}
}
