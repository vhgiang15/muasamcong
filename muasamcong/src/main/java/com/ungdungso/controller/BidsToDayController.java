package com.ungdungso.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ungdungso.dto.BidsNoticeDTO;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.service.BidsNoticeService;

@Controller
public class BidsToDayController {
	@Autowired
	private BidsNoticeService bidsNoticeService;

	@GetMapping(value = { "/notice-today" })
	public ModelAndView loginPage() {
		ModelAndView model= new ModelAndView("client/notice-today");
		Date todayDate= new Date();
		List<BidsNotice> list=bidsNoticeService.getBidsNoticesByDate(todayDate, todayDate);
		List<BidsNoticeDTO> listDTO= new ArrayList<>();
		for (BidsNotice bidsNotice : list) {
			BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();			
			bidsNoticeDTO.convertBidNoticeToDTO(bidsNotice);
			listDTO.add(bidsNoticeDTO);
		}
		model.addObject("listDTO",listDTO);		
	return  model;
	}
}
