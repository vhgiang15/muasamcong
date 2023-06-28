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
import com.ungdungso.model.Province;
import com.ungdungso.repository.ProvinceRepository;
import com.squareup.okhttp.RequestBody;
import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


@Controller
public class HomeController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired ProvinceRepository provinceRepository;

	@GetMapping(value = { "/", "/index" })
	public ModelAndView loginPage(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/login-page");
	return  model;
	}
	
	@GetMapping(value = { "/user/home","/user/dashboard"})
	public ModelAndView home(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/dashboard");
	return  model;
	}
	
	@GetMapping(value = { "/user/search"})
	public ModelAndView searchBidsNotice(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/search-bids-notice");
		List<Province> list= provinceRepository.findAll();
		model.addObject("listProvince", list);
		
	return  model;
	}
	
	
}
