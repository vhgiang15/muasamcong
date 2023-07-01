package com.ungdungso.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ungdungso.dto.BidsNoticeDTO;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.service.BidsNoticeService;

@Controller

public class ReportController {
	
	@Autowired
	private BidsNoticeService bidsNoticeService;
	@GetMapping(value = { "/user/export-report-detail"})
	public ModelAndView searchBidsNotice(
			@RequestParam(value = "provCode") int provCode,
			@RequestParam(value = "dateFrom") String dateFromString,
			@RequestParam(value = "dateTo") String dateToString,
			@RequestParam(value = "investFeild") String investFeild) throws ParseException {
		ModelAndView model= new ModelAndView("client/report-detail");

		System.out.println(provCode);
		System.out.println(dateFromString);
		System.out.println(dateToString);
		System.out.println("in ----" +investFeild);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date dateFrom= formatDate.parse(dateFromString);
		Date dateTo= formatDate.parse(dateToString);
		
		List<BidsNotice> list= bidsNoticeService.reportBidsNotices(provCode, dateFrom, dateTo,investFeild);
		System.out.println(list.size());		
			
	return  model;
	}  

}
