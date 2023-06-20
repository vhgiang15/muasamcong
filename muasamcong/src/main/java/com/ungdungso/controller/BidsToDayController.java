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
import com.ungdungso.model.InvestField;
import com.ungdungso.repository.InvestFieldRepository;
import com.ungdungso.service.BidsNoticeService;

@Controller
public class BidsToDayController {
	@Autowired
	private BidsNoticeService bidsNoticeService;
	
	@Autowired
	private InvestFieldRepository investFieldRepository;
	
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
			//String tmpString= bidsNotice.getInvestField();
			//System.out.println(tmpString);
			//System.out.println(tmpString.length());
			//String investField= investFieldRepository.queryName(tmpString);
			System.out.println(bidsNoticeDTO.getInvestField());			
		}
		//model.addObject("list", bidsNoticeService.getBidsNoticesByDate(todayDate, todayDate));		
	return  model;
	}
}
