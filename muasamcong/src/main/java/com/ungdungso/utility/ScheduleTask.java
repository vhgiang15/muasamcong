package com.ungdungso.utility;
import java.io.IOException;
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

	@Scheduled(cron = "59 * * * * ?") 
	public void scheduleGetBidNotice() throws IOException {
		GetBidNotice.getBidsNoticeToDay(districRepository, bidsNoticeRepostory,provinceRepository);			
}
}
