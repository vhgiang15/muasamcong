package com.ungdungso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ungdungso.model.BidsNotice;
import com.ungdungso.service.BidsNoticeService;
@Controller
public class BidsNoticeController {
	
	@Autowired
	private BidsNoticeService bidsNoticeService;
	@GetMapping(value = { "/user/search-bidsnotice"})
	public ModelAndView searchBidsNotice(
			@RequestParam(value = "noticeNo", defaultValue = "") String noticeNo ,
			@RequestParam(value = "proCode", defaultValue = "0") int provCode,
			@RequestParam(value = "dateFrom", defaultValue = "") String dateFromString,
			@RequestParam(value = "dateTo", defaultValue = "") String dateToString) {
		ModelAndView model= new ModelAndView("client/search-bids-notice");
		System.out.println(noticeNo);
		System.out.println(provCode);
		System.out.println(dateFromString);
		System.out.println(dateToString);
		List<BidsNotice> list= bidsNoticeService.searchBidsNotices(noticeNo,provCode, dateFromString, dateToString);
		System.out.println("---------------so lung TBMT search");
		System.out.println(list.size());
		

		//.addObject("listProvince", list);
		
	return  model;
	}  


}
