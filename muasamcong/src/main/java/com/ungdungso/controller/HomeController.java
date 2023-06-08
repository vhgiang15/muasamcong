package com.ungdungso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {

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
	public ModelAndView noticeToday(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/notice-today");
	return  model;
	}
}
