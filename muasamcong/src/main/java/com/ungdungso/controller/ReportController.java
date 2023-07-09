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
import com.ungdungso.model.User;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;
import com.ungdungso.service.BidsNoticeService;
import com.ungdungso.utility.UserExcelExporter;
import com.ungdungso.utility.UserExcelExporterArr;

@Controller

public class ReportController {
	
	@Autowired
	private BidsNoticeService bidsNoticeService;
	@Autowired
	private  ProvinceRepository provinceRepository;
	@Autowired
	private DistricRepository districRepository;
	
	@GetMapping(value = { "/users/export/excel"})
	public void ExportReportDetailByProvince( HttpServletResponse response,
			@RequestParam(value = "provCode") int provCode,
			@RequestParam(value = "dateFrom") String dateFromString,
			@RequestParam(value = "dateTo") String dateToString,
			@RequestParam(value = "investFeild") String investFeild) throws  IOException, ParseException {
		response.setContentType("application/octet-stream");
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date dateFrom= formatDate.parse(dateFromString);
		Date dateTo= formatDate.parse(dateToString);
		
        response.setContentType("application/octet-stream");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=report_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);	
		List<BidsNotice> list= bidsNoticeService.reportBidsNotices(provCode, dateFrom, dateTo,investFeild);	
		int size=list.size();
		
		//List<BidsNoticeDTO> listDTO= new ArrayList<>();
		BidsNoticeDTO[] listDTOarr= new BidsNoticeDTO[size];
		  
		  for(int i=0; i<size; i++) {
			  BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();
			  bidsNoticeDTO.convertBidNoticeToDTO(list.get(i),districRepository,provinceRepository);	
			  listDTOarr[i]=bidsNoticeDTO;
		  }
		
		  
			/*
			 * for (BidsNotice bidsNotice : list) { BidsNoticeDTO bidsNoticeDTO= new
			 * BidsNoticeDTO();
			 * bidsNoticeDTO.convertBidNoticeToDTO(bidsNotice,districRepository,
			 * provinceRepository); listDTO.add(bidsNoticeDTO); }
			 */
		UserExcelExporterArr excelExporter = new UserExcelExporterArr(listDTOarr); 
        //UserExcelExporter excelExporter = new UserExcelExporter(listDTO);         
        excelExporter.export(response);           
		System.out.println("hoan thanh users/export/excel");
	}  
	
	
	///provCodeKey,typeInfo,key,dateFrom, dateTo,investFeild   
	@GetMapping(value = { "/user/export-report-key"})
	public void ExportEeportDetailbyKey(
			HttpServletResponse response,
			@RequestParam(value = "provCodeKey") int provCode,
			@RequestParam(value = "typeInfo") String typeInfo,
			@RequestParam(value = "key") String key,
			@RequestParam(value = "dateFrom") String dateFromString,
			@RequestParam(value = "dateTo") String dateToString,
			@RequestParam(value = "investFeild") String investFeild) throws ParseException, IOException {
		/*
		 * System.out.println(provCode); System.out.println(typeInfo);
		 * System.out.println(key); System.out.println(dateFromString);
		 * System.out.println(dateToString); System.out.println("in ----" +investFeild);
		 */
		SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");
		Date dateFrom= formatDate.parse(dateFromString);
		Date dateTo= formatDate.parse(dateToString);		
		
		  List<BidsNotice> list=bidsNoticeService.reportBidsNoticesbyKey(provCode,typeInfo, key, dateFrom,dateTo, investFeild); 
		  int size=list.size();
		  //System.out.println("Ket qua tìm kiem: "+ list.size());
		  //List<BidsNoticeDTO> listDTO= new ArrayList<>(); 
		  BidsNoticeDTO[] listDTOarr= new BidsNoticeDTO[size];
		  
		  for(int i=0; i<size; i++) {
			  BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();
			  bidsNoticeDTO.convertBidNoticeToDTO(list.get(i),districRepository,provinceRepository);	
			  listDTOarr[i]=bidsNoticeDTO;
		  }
		  		  
			/*
			 * for (BidsNotice bidsNotice : list) { BidsNoticeDTO bidsNoticeDTO= new
			 * BidsNoticeDTO();
			 * bidsNoticeDTO.convertBidNoticeToDTO(bidsNotice,districRepository,
			 * provinceRepository); listDTO.add(bidsNoticeDTO); }
			 */
		  
		  
		  
	    response.setContentType("application/octet-stream");
	    SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	    String currentDateTime = dateFormatter.format(new Date());         
	    String headerKey = "Content-Disposition";
	    String headerValue = "attachment; filename=report_" + currentDateTime + ".xlsx";
	    response.setHeader(headerKey, headerValue);
	    UserExcelExporterArr excelExporter = new UserExcelExporterArr(listDTOarr); 
        //UserExcelExporter excelExporter = new UserExcelExporter(listDTO);   
        excelExporter.export(response);           
		System.out.println("hoan thanh /user/export-report-key");

	}  

}
