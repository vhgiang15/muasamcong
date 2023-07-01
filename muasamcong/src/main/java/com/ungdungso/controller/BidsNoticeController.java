package com.ungdungso.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ungdungso.dto.BidsNoticeDTO;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;
import com.ungdungso.service.BidsNoticeService;
@Controller
public class BidsNoticeController {
	
	@Autowired
	private BidsNoticeService bidsNoticeService;
	
	@Autowired
	private  ProvinceRepository provinceRepository;
	@Autowired
	private DistricRepository districRepository;
	
	@GetMapping(value = { "/user/search-bidsnotice"})
	public ModelAndView searchBidsNotice(
			@RequestParam(value = "noticeNo", defaultValue = "all") String noticeNo ,
			@RequestParam(value = "proCode", defaultValue = "0") int provCode,
			@RequestParam(value = "dateFrom") String dateFromString,
			@RequestParam(value = "dateTo") String dateToString) throws ParseException {
		ModelAndView model= new ModelAndView("client/notice-search-result");
		System.out.println(noticeNo);
		System.out.println(provCode);
		System.out.println(dateFromString);
		System.out.println(dateToString);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date dateFrom= formatDate.parse(dateFromString);
		Date dateTo= formatDate.parse(dateToString);		
		List<BidsNotice> list= bidsNoticeService.searchBidsNotices(noticeNo,provCode, dateFrom, dateTo);
		
		System.out.println("---------------so lung TBMT search");
		System.out.println(list.size());		
		List<BidsNoticeDTO> listDTO= new ArrayList<>();
		for (BidsNotice bidsNotice : list) {
			BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();			
			bidsNoticeDTO.convertBidNoticeToDTO(bidsNotice,districRepository,provinceRepository);
			listDTO.add(bidsNoticeDTO);	
		}
		model.addObject("listDTO",listDTO);			
	return  model;
	}  


}
