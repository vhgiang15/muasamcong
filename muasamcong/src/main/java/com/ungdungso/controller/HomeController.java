package com.ungdungso.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ungdungso.dto.BidsNoticeDTO;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.model.Province;
import com.ungdungso.repository.BidsNoticeRepostory;
import com.ungdungso.repository.ProvinceRepository;
import com.ungdungso.service.ProvinceService;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
	
	@Autowired 
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private ProvinceService provinceService;
	@Autowired
	private BidsNoticeRepostory bidsNoticeRepostory;
	
	@GetMapping(value = { "/", "/index","/login-page" })
	public ModelAndView loginPage(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/login-page");
	return  model;
	}
	
	@GetMapping(value = { "/user/home","/user/dashboard"})
	public ModelAndView home(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/dashboard");
		Date todayDate= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String todayString=sdf.format(todayDate).toString();
		List<Province> listMN= provinceService.getProvinceByArea("MN");
		for (Province province : listMN) {
			String linkString="/users/export/excel?provCode="+province.getProvCode()+"&dateFrom="+todayString+"&dateTo="+todayString+"&investFeild=all";
			province.setLink(linkString);
			//System.out.println(linkString);
			
		} 
		List<Province> listMT= provinceService.getProvinceByArea("MT");
		for (Province province : listMT) {
			String linkString="/users/export/excel?provCode="+province.getProvCode()+"&dateFrom="+todayString+"&dateTo="+todayString+"&investFeild=all";
			province.setLink(linkString);
			//System.out.println(linkString);
			
		}
		
		List<Province> listMB= provinceService.getProvinceByArea("MB");
		for (Province province : listMB) {
			String linkString="/users/export/excel?provCode="+province.getProvCode()+"&dateFrom="+todayString+"&dateTo="+todayString+"&investFeild=all";
			province.setLink(linkString);
			//System.out.println(linkString);
			
		}
		model.addObject("listMN", listMN);
		model.addObject("listMT", listMT);
		model.addObject("listMB", listMB);
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String toDateString=formatDate.format(todayDate).toString()+" 23:59:59.000000";
		String fromDateString=toDateString.substring(0, 4)+"-01-01"+" 00:00:00.000000"; //2023-06-19 00:00:00.00000
		//System.out.println(toDateString);
		//System.out.println(fromDateString);
		List<BidsNotice> list= bidsNoticeRepostory.queryReportByContractor("%", "%viễn thông quân đội%",fromDateString,toDateString,"%");
		model.addObject("total", list.size());
		
		fromDateString="01-01-"+toDateString.substring(0, 4);
		toDateString=sdf.format(todayDate).toString();
		String linkString="/user/export-report-key?provCodeKey=0&typeInfo=DVTT&key=viễn thông quân đội&dateFrom="+fromDateString+"&dateTo="+toDateString+"&investFeild=all";
		model.addObject("totalLink", linkString);
		
			
	return  model;
	}
	
	@GetMapping(value = { "/user/search"})
	public ModelAndView searchBidsNotice1(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/search-bids-notice");
		List<Province> list= provinceRepository.findAll();
		model.addObject("listProvince", list);
		Date fromDate= new Date();
		Date toDate= new Date();
		//System.out.println(fromDate);
		model.addObject("fromDate",fromDate);
		model.addObject("toDate",toDate);	
	return  model;
	}  
	
	@GetMapping(value = { "/user/report-detail"})
	public ModelAndView reportDetail(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/report-detail-by-province");
		List<Province> list= provinceRepository.findAll();
		model.addObject("listProvince", list);
		Date fromDate= new Date();
		Date toDate= new Date();
		//System.out.println(fromDate);
		model.addObject("fromDate",fromDate);
		model.addObject("toDate",toDate);	
	return  model;
	} 
	
	@GetMapping(value = { "/user/report-detail-by-key"})
	public ModelAndView reportDetailByKey(Authentication authentication) {
		ModelAndView model= new ModelAndView("client/report-detail-by-key");
		List<Province> list= provinceRepository.findAll();
		model.addObject("listProvince", list);
		Date fromDate= new Date();
		Date toDate= new Date();
		//System.out.println(fromDate);
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
		//System.out.println(fromDate);
		model.addObject("fromDate",fromDate);
		model.addObject("toDate",toDate);	
	return  model;
	} 
	
	@GetMapping(value="/403")
	public ModelAndView accessDenied(Principal principal)
	{
		ModelAndView model= new ModelAndView("client/403Page");
		if(principal!=null) {
			User loginedUser=(User)((Authentication) principal).getPrincipal();
			String userInfo =loginedUser.getUsername();
			model.addObject("userInfo",userInfo);
			String message= "Hi "+ userInfo+ " không có quyền truy cập vào trang web này";
			model.addObject("message",message);	
		}
		return model;
	}
	
}
