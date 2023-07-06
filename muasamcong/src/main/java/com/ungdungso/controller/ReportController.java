package com.ungdungso.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletResponse;
import com.ungdungso.dto.BidsNoticeDTO;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;
import com.ungdungso.service.BidsNoticeService;
import com.ungdungso.utility.UserExcelExporter;

@Controller

public class ReportController {
	
	@Autowired
	private BidsNoticeService bidsNoticeService;
	@Autowired
	private  ProvinceRepository provinceRepository;
	@Autowired
	private DistricRepository districRepository;
	
	@GetMapping(value = { "/user/export-report-detail"})
	public void reportDetail(
			@RequestParam(value = "provCode") int provCode,
			@RequestParam(value = "dateFrom") String dateFromString,
			@RequestParam(value = "dateTo") String dateToString,
			@RequestParam(value = "investFeild") String investFeild, HttpServletResponse response) throws  IOException, ParseException {
		//ModelAndView model= new ModelAndView("client/report-detail");
		System.out.println(provCode);
		System.out.println(dateFromString);
		System.out.println(dateToString);
		System.out.println("in ----" +investFeild);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date dateFrom= formatDate.parse(dateFromString);
		Date dateTo= formatDate.parse(dateToString);		
		List<BidsNotice> list= bidsNoticeService.reportBidsNotices(provCode, dateFrom, dateTo,investFeild);		
		System.out.println(list.size());
		List<BidsNoticeDTO> listDTO= new ArrayList<>();
		for (BidsNotice bidsNotice : list) {
			BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();			
			bidsNoticeDTO.convertBidNoticeToDTO(bidsNotice,districRepository,provinceRepository);
			listDTO.add(bidsNoticeDTO);	
		}	
		
		
		response.setContentType("application/octet-stream");
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        UserExcelExporter excelExporter = new UserExcelExporter(listDTO);   
        excelExporter.export(response);    
		System.out.println("hoan thanh");
	}  
	
	
	///provCodeKey,typeInfo,key,dateFrom, dateTo,investFeild   
	@GetMapping(value = { "/user/export-report-key"})
	public void reportDetailbyKey(
			@RequestParam(value = "provCodeKey") int provCode,
			@RequestParam(value = "typeInfo") String typeInfo,
			@RequestParam(value = "key") String key,
			@RequestParam(value = "dateFrom") String dateFromString,
			@RequestParam(value = "dateTo") String dateToString,
			@RequestParam(value = "investFeild") String investFeild) throws ParseException, IOException {
		//ModelAndView model= new ModelAndView("client/report-detail");
		System.out.println(provCode);
		System.out.println(typeInfo);
		System.out.println(key);
		System.out.println(dateFromString);
		System.out.println(dateToString);
		System.out.println("in ----" +investFeild);
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date dateFrom= formatDate.parse(dateFromString);
		Date dateTo= formatDate.parse(dateToString);		
		/*
		 * List<BidsNotice> list=
		 * bidsNoticeService.reportBidsNoticesbyKey(provCode,typeInfo, key, dateFrom,
		 * dateTo, investFeild); System.out.println(list.size()); List<BidsNoticeDTO>
		 * listDTO= new ArrayList<>(); for (BidsNotice bidsNotice : list) {
		 * BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();
		 * bidsNoticeDTO.convertBidNoticeToDTO(bidsNotice,districRepository,
		 * provinceRepository); listDTO.add(bidsNoticeDTO); } final String excelFilePath
		 * = "C:/demo/books.xlsx"; ExportToExcell.writeExcel(listDTO, excelFilePath);
		 */
		System.out.println("hoan thanh");
	}  

}
