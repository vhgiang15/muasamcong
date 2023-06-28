package com.ungdungso.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ungdungso.model.BidsNotice;
import com.ungdungso.repository.BidsNoticeRepostory;


@Service
public class BidsNoticeServiceImpl implements BidsNoticeService {
	@Autowired
	private BidsNoticeRepostory bidsNoticeRepostory;
	@Override
	public List<BidsNotice> getBidsNoticesByDate(Date fromDate, Date toDate) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";
		
		//String fromDateString="2023-06-24 00:00:00.000000";
		//String toDateString="2023-06-24 23:59:59.000000";	
		
		List<BidsNotice> list=bidsNoticeRepostory.queryGetBidsNotices(fromDateString, toDateString);
		System.out.println("Số lượng các thông báo mời thầu");
		System.out.println(list.size());
		return list;
	}
	@Override
	public List<BidsNotice> getBidsNoticesByDateByPage(Date fromDate, Date toDate, int page) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";
		
	//	String fromDateString="2023-06-24 00:00:00.000000";
	//	String toDateString="2023-06-24 23:59:59.000000";		
		
		List<BidsNotice> list=bidsNoticeRepostory.queryGetBidsNoticesByPage(fromDateString, toDateString, page*10-10);
		return list;
	}
	@Override
	public int countBidsNotice(Date fromDate, Date toDate) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";
		
	//	String fromDateString="2023-06-24 00:00:00.000000";
	//	String toDateString="2023-06-24 23:59:59.000000";	
		
		return bidsNoticeRepostory.queryCountGetBidsNotices(fromDateString, toDateString);
	}
}
