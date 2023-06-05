package com.ungdungso.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HomeController {

	@GetMapping(value = { "/", "/index" })
	public ModelAndView home(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/login-page");
	return  model;
	}
}
