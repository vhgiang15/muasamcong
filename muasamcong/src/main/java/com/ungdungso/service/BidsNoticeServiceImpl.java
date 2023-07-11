package com.ungdungso.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		List<BidsNotice> list=bidsNoticeRepostory.queryGetBidsNotices(fromDateString, toDateString);
		return list;
	}
	@Override
	public List<BidsNotice> getBidsNoticesByDateByPage(Date fromDate, Date toDate, int page) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";	
		List<BidsNotice> list=bidsNoticeRepostory.queryGetBidsNoticesByPage(fromDateString, toDateString, page*10-10);
		return list;
	}
	@Override
	public int countBidsNotice(Date fromDate, Date toDate) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";		
		return bidsNoticeRepostory.queryCountGetBidsNotices(fromDateString, toDateString);
	}
	
	
	
	@Override
	public List<BidsNotice> searchBidsNotices(String notifyNo, int provCode, Date fromDate, Date toDate) {
		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");		
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";
		String location="";
		if(provCode==0) {
			location="%";
			
		} else { location="%"+provCode+"-%";}
			
		if(notifyNo.equals("all")) {
			notifyNo="%";
		}		
		List<BidsNotice> list=bidsNoticeRepostory.querySearchBidsNotices(notifyNo, location, fromDateString, toDateString);		
		return list;
	}
	@Override
	public List<BidsNotice> reportBidsNotices(int provCode, Date fromDate, Date toDate, String investField) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");		
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";
		String location="";
		if(provCode==0) {
			location="%";			
		} else { location="%"+provCode+"-%";}
		
		if(investField.equals("all")) {
			investField="%";
		}
		List<BidsNotice> list=bidsNoticeRepostory.queryReportBidsNotices(location, fromDateString, toDateString, investField);
		return list;
	}
	@Override
	public List<BidsNotice> reportBidsNoticesbyKey(int provCodeKey, String typeInfo, String key, Date fromDate,	Date toDate, String investField) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");		
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";
		String location="";
		List<BidsNotice> list = new ArrayList<>();
		if(provCodeKey==0) {
			location="%";
			
		} else { location="%"+provCodeKey+"-%";}
		
		if(investField.equals("all")) {
			investField="%";
		}
		key="%"+key+"%";
		
		switch (typeInfo) {
		case "CDT": {
			list= bidsNoticeRepostory.queryReportByInvetor(location, key, fromDateString, toDateString, investField);
			
			break;
		}
		
		case "DVMT": {
			list= bidsNoticeRepostory.queryReportByProcuring(location, key, fromDateString, toDateString, investField);
			
			break;
		}
		
		case "TGT": {
			list= bidsNoticeRepostory.queryReportByBidName(location, key, fromDateString, toDateString, investField);
			
			break;
		}
		
		case "DVTT": {
			list= bidsNoticeRepostory.queryReportByContractor(location, key, fromDateString, toDateString, investField);
			
			break;
		}		
	}
		return list;
}
	@Override
	public int countBidsNoticeByProvince(int proCode, Date fromDate, Date toDate) {
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";
		String location="%"+proCode+"-%";
		return bidsNoticeRepostory.queryCountGetBidsNoticesByLocation(location, fromDateString, toDateString);

	}
	@Override
	public List<BidsNotice> getBidNotFinish(Date fromDate, Date toDate) {		
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String fromDateString=formatDate.format(fromDate).toString()+" 00:00:00.000000"; //2023-06-19 00:00:00.000000
		String toDateString=formatDate.format(toDate).toString()+" 23:59:59.000000";		
		return bidsNoticeRepostory.queryGetBidNotFinish(fromDateString, toDateString);
	}
}
