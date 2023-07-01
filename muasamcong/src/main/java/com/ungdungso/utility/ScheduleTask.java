package com.ungdungso.utility;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ungdungso.repository.BidsNoticeRepostory;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;

@Component
@EnableScheduling 
public class ScheduleTask {
	@Autowired
	private BidsNoticeRepostory bidsNoticeRepostory;
	@Autowired
	private DistricRepository districRepository;
	
	@Autowired
	private ProvinceRepository provinceRepository;

	@Scheduled(cron = "59 15 0 * * ?") 
	public void scheduleGetBidNotice() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromString="2023-01-01";
		String toString="2023-01-31";
		fromDate=format.parse(fromString);
		toDate= format.parse(toString);	
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);			
}
	
	@Scheduled(cron = "59 0 * * * ?") 
	public void scheduleGetBidNoticeToday() throws IOException, ParseException {
		Date fromDate= new Date();
		Date toDate= new Date();
		GetBidNotice.getBidsNoticeToDay(fromDate,toDate,districRepository,bidsNoticeRepostory,provinceRepository);			
}
}
