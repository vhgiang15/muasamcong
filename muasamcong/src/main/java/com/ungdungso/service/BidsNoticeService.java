package com.ungdungso.service;

import java.util.Date;
import java.util.List;

import com.ungdungso.model.BidsNotice;

public interface BidsNoticeService {
	public List<BidsNotice> getBidsNoticesByDate(Date fromDate, Date toDate);
	
	

}