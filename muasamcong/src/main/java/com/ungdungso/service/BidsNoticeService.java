package com.ungdungso.service;

import java.util.Date;
import java.util.List;

import com.ungdungso.model.BidsNotice;

public interface BidsNoticeService {
	public List<BidsNotice> getBidsNoticesByDate(Date fromDate, Date toDate);
	public List<BidsNotice> getBidsNoticesByDateByPage(Date fromDate, Date toDate, int page);
	public int countBidsNotice(Date fromDate, Date toDate);
	public int countBidsNoticeByProvince(int proCode,Date fromDate, Date toDate);
	public List<BidsNotice> searchBidsNotices(String notifyNo, int provCode, Date fromDate, Date toDate);
	public List<BidsNotice> reportBidsNotices(int provCode, Date fromDate, Date toDate, String investField);
	public List<BidsNotice> reportBidsNoticesbyKey(int provCodeKey,String typeInfo,String key, Date fromDate, Date toDate, String investField);
	
}
