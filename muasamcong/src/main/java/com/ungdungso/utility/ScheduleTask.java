package com.ungdungso.utility;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.repository.BidsNoticeRepostory;
import com.ungdungso.repository.DistricRepository;

@Component
@EnableScheduling 
public class ScheduleTask {
	@Autowired
	private BidsNoticeRepostory bidsNoticeRepostory;
	@Autowired
	private DistricRepository districRepository;

	@Scheduled(cron = "5 * * * * ?") 
	public void scheduleGetBidNotice() throws IOException {
		Date toDay= new Date();
		List<BidsNotice> listBid=GetBidNotice.getBidsNoticedbyDate(toDay, toDay,districRepository, bidsNoticeRepostory);
		for (BidsNotice bidsNotice : listBid) {			
			bidsNoticeRepostory.save(bidsNotice);
		}				
}
}
