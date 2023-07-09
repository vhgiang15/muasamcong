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
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;
import com.ungdungso.service.BidsNoticeService;

@Controller
public class BidsToDayController {
	@Autowired
	private BidsNoticeService bidsNoticeService;
	
	@Autowired
	private  ProvinceRepository provinceRepository;
	@Autowired
	private DistricRepository districRepository;

	@GetMapping(value = { "/user/notice-today"})
	public ModelAndView bidsNoticeToDay()  {

		ModelAndView model= new ModelAndView("client/notice-today");
		Date todayDate= new Date();
	
		List<BidsNotice> list=bidsNoticeService.getBidsNoticesByDate(todayDate, todayDate);
		List<BidsNoticeDTO> listDTO= new ArrayList<>();
		for (BidsNotice bidsNotice : list) {
			BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();			
			bidsNoticeDTO.convertBidNoticeToDTO(bidsNotice,districRepository,provinceRepository);
			listDTO.add(bidsNoticeDTO);		
		}

		System.out.println("Today page 0--------------");
		System.out.println(listDTO.size());
		model.addObject("listDTO",listDTO);	
		model.addObject("totalBid",list.size());	
		
	return  model;
	}
	

	
}
