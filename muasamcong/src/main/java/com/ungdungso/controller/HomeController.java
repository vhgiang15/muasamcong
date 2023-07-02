package com.ungdungso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ungdungso.model.Province;
import com.ungdungso.repository.ProvinceRepository;
import java.util.Date;
import java.util.List;





@Controller
public class HomeController {

	
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
	public ModelAndView searchBidsNotice1(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/search-bids-notice");
		List<Province> list= provinceRepository.findAll();
		model.addObject("listProvince", list);
		Date fromDate= new Date();
		Date toDate= new Date();
		System.out.println(fromDate);
		model.addObject("fromDate",fromDate);
		model.addObject("toDate",toDate);	
	return  model;
	}  
	
	@GetMapping(value = { "/user/report-detail"})
	public ModelAndView reportDetail(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/report-detail");
		List<Province> list= provinceRepository.findAll();
		model.addObject("listProvince", list);
		Date fromDate= new Date();
		Date toDate= new Date();
		System.out.println(fromDate);
		model.addObject("fromDate",fromDate);
		model.addObject("toDate",toDate);	
	return  model;
	} 
	
	@GetMapping(value = { "/user/report-statistical"})
	public ModelAndView reportStatistica(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/report-statistical");
		List<Province> list= provinceRepository.findAll();
		model.addObject("listProvince", list);
		Date fromDate= new Date();
		Date toDate= new Date();
		System.out.println(fromDate);
		model.addObject("fromDate",fromDate);
		model.addObject("toDate",toDate);	
	return  model;
	} 
	
}
