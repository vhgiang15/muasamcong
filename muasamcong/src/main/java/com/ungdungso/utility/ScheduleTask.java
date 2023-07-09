package com.ungdungso.utility;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ungdungso.model.Province;
import com.ungdungso.repository.BidsNoticeRepostory;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;
import com.ungdungso.service.BidsNoticeService;

@Component
@EnableScheduling 
public class ScheduleTask {
	@Autowired
	private BidsNoticeRepostory bidsNoticeRepostory;
	@Autowired
	private DistricRepository districRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;
	
	@Autowired
	private BidsNoticeService bidsNoticeService;

	//@Scheduled(cron = "59 40 21 * * ?") 
	public void scheduleGetBidNotice() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2022-11-01";
		String toString="2022-11-30";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t11");
}
	
	//@Scheduled(cron = "59 59 21 * * ?") 
	public void scheduleGetBidNoticeT10() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2022-10-01";
		String toString="2022-10-31";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t10");
}
	
	//@Scheduled(cron = "59 20 22 * * ?") 
	public void scheduleGetBidNoticeT12() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2022-12-01";
		String toString="2022-12-31";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t12");
}
	
	
	//@Scheduled(cron = "59 40 22 * * ?") 
	public void scheduleGetBidNoticeT1() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-01-01";
		String toString="2023-01-31";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t1");
}
	
	
	//@Scheduled(cron = "59 00 23 * * ?") 
	public void scheduleGetBidNoticeT2() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-02-01";
		String toString="2023-02-28";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t2");
}
	//@Scheduled(cron = "59 20 23 * * ?") 
	public void scheduleGetBidNoticeT3() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-03-01";
		String toString="2023-03-31";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t3");
}
	
	//@Scheduled(cron = "59 40 23 * * ?") 
	public void scheduleGetBidNoticeT4() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-04-01";
		String toString="2023-04-30";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t4");
}
	
	
	//@Scheduled(cron = "59 00 00 * * ?") 
	public void scheduleGetBidNoticeT5() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-05-01";
		String toString="2023-05-31";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t5");
}
	
	//@Scheduled(cron = "59 20 00 * * ?") 
	public void scheduleGetBidNoticeT6() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-06-01";
		String toString="2023-06-31";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t6");
}
	
	//@Scheduled(cron = "30 * * * * ?") 
	public void scheduleGetBidNoticeT7() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-07-06";
		String toString="2023-07-06";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);	
		System.out.println("hoàn thành lấy data t7");
}
	
	
	
	
	@Scheduled(cron = "59 * * * * ?") 
	public void scheduleGetBidNoticeToday() throws IOException, ParseException {
		
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-01-01";
		fromDate=format.parse(fromString);
		GetBidNotice.getBidsNoticeToDay(toDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);		
		System.out.println("hoàn thành lấy data ngay hom nay");			
		List<Province> list= provinceRepository.findAll();		
		for (Province province : list) {
			int countBidToday=bidsNoticeService.countBidsNoticeByProvince(province.getProvCode(), toDate, toDate);
			int countBidYear= bidsNoticeService.countBidsNoticeByProvince(province.getProvCode(), fromDate, toDate);
			province.setAmountNoticeToday(countBidToday);
			province.setAmountNoticeYear(countBidYear);
			provinceRepository.save(province);
		}
		
	}
	
	
}
