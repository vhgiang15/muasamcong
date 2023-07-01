package com.ungdungso.dto;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import com.ungdungso.model.BidsNotice;
import com.ungdungso.repository.BidsNoticeRepostory;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;
import com.ungdungso.utility.Common;


public class BidsNoticeDTO {
	private String notifyNo; // Số thông báo mời thầu
	private String notifyNoStand;
	private String bidName; // tên gói thầu
	private String link; // link gói thầu
	private String procuringEntityName; // tên đơn vị mời thầu
	private String investorName; 		// tên chủ đẩu tư
	private String publicDate;			// ngày đăng thầu
	private String bidCloseDate; 		// thời điểm đóng thầu
	private String isInternet; // đấu thầu qua mạng hay không
	private String investField; // lĩnh vực
	private String status; // trạng thái thông báo mời thầu
	private String planNo;				// số KHLCNT	
	private String bidForm;				// hình thức thầu
	private String bidPrice;
	private String location;
	private String contractorName;  // nhà thầu trúng thầu
	private String decisionDate; // ngày phê duyệt KQLCNT
	private String bidWinningPrice;	 // giá trúng thầu
	
	public BidsNoticeDTO() {
		super();
	}
	
	public BidsNoticeDTO(String notifyNo, String notifyNoStand, String bidName, String link, String procuringEntityName,
			String investorName, String publicDate, String bidCloseDate, String isInternet, String investField,
			String status, String planNo, String bidForm, String bidPrice, String location, String contractorName,
			String decisionDate, String bidWinningPrice) {
		super();
		this.notifyNo = notifyNo;
		this.notifyNoStand = notifyNoStand;
		this.bidName = bidName;
		this.link = link;
		this.procuringEntityName = procuringEntityName;
		this.investorName = investorName;
		this.publicDate = publicDate;
		this.bidCloseDate = bidCloseDate;
		this.isInternet = isInternet;
		this.investField = investField;
		this.status = status;
		this.planNo = planNo;
		this.bidForm = bidForm;
		this.bidPrice = bidPrice;
		this.location = location;
		this.contractorName = contractorName;
		this.decisionDate = decisionDate;
		this.bidWinningPrice = bidWinningPrice;
	}

	public String getNotifyNo() {
		return notifyNo;
	}
	public void setNotifyNo(String notifyNo) {
		this.notifyNo = notifyNo;
	}
	public String getNotifyNoStand() {
		return notifyNoStand;
	}
	public void setNotifyNoStand(String notifyNoStand) {
		this.notifyNoStand = notifyNoStand;
	}
	public String getBidName() {
		return bidName;
	}
	public void setBidName(String bidName) {
		this.bidName = bidName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getProcuringEntityName() {
		return procuringEntityName;
	}
	public void setProcuringEntityName(String procuringEntityName) {
		this.procuringEntityName = procuringEntityName;
	}
	public String getInvestorName() {
		return investorName;
	}
	public void setInvestorName(String investorName) {
		this.investorName = investorName;
	}
	public String getPublicDate() {
		return publicDate;
	}
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}
	public String getBidCloseDate() {
		return bidCloseDate;
	}
	public void setBidCloseDate(String bidCloseDate) {
		this.bidCloseDate = bidCloseDate;
	}
	public String getIsInternet() {
		return isInternet;
	}
	public void setIsInternet(String isInternet) {
		this.isInternet = isInternet;
	}
	public String getInvestField() {
		return investField;
	}
	public void setInvestField(String investField) {
		this.investField = investField;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPlanNo() {
		return planNo;
	}
	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}
	public String getBidForm() {
		return bidForm;
	}
	public void setBidForm(String bidForm) {
		this.bidForm = bidForm;
	}
	public String getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}	
	
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public String getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(String decisionDate) {
		this.decisionDate = decisionDate;
	}

	public String getBidWinningPrice() {
		return bidWinningPrice;
	}

	public void setBidWinningPrice(String bidWinningPrice) {
		this.bidWinningPrice = bidWinningPrice;
	}

	public void convertBidNoticeToDTO (BidsNotice bidsNotice, DistricRepository districRepository, ProvinceRepository provinceRepository) {
		Common.setHashMap();
		notifyNo=bidsNotice.getNotifyNo();
		notifyNoStand= bidsNotice.getNotifyNoStand();
		bidName=bidsNotice.getBidName();
		procuringEntityName=bidsNotice.getProcuringEntityName();
		investorName=bidsNotice.getInvestorName();
		SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		System.out.println("số thong bao moi thau:"+ bidsNotice.getNotifyNo());
		System.out.println("ngày thong bao moi thau:"+ bidsNotice.getPublicDate());
		
		publicDate=formatDate.format(bidsNotice.getPublicDate()).toString();	
		
		System.out.println("ngày thong bao dong thau:"+ bidsNotice.getBidCloseDate());	
		System.out.println("status:"+ bidsNotice.getStatus());
		
		if(bidsNotice.getBidCloseDate()==null) {
			bidCloseDate =formatDate.format(bidsNotice.getBidOpenDate()).toString();
		} else {
			bidCloseDate =formatDate.format(bidsNotice.getBidCloseDate()).toString();
			
		}
		System.out.println("ngày thong bao dong thau:"+ bidCloseDate);	
		isInternet =Common.hashMapInternet.get(bidsNotice.getIsInternet());
		investField=Common.hashMapInvestField.get(bidsNotice.getInvestField());
		status=Common.hashMapBidStatus.get(bidsNotice.getStatus());
		bidForm=Common.hashMapBidForm.get(bidsNotice.getBidForm());
		
		//private String location;
		//private String contractorName;
		//private String decisionDate;
		
		
		if((bidsNotice.getStatus().equals("IS_PUBLISH")||bidsNotice.getStatus().equals("NOT_PUBLISH"))&bidsNotice.getWinningCode()!=null) {
			bidWinningPrice=bidsNotice.getBidWinningPrice().toString();
			decisionDate=formatDate.format(bidsNotice.getDecisionDate()).toString();
			contractorName=bidsNotice.getContractorName();

		} else {
			contractorName="NOT";
			
		}
		
		if(bidsNotice.getLocation()!=null&bidsNotice.getLocation().length()>=3) {
		String[] arrlocation=bidsNotice.getLocation().split(";");
		location="";
		for (String locationcode : arrlocation) {
			System.out.println(locationcode);
			if(locationcode.length()>5) {
			location=location+" "+ districRepository.findById(Integer.parseInt(locationcode.substring(4))).get().getDistrictName()+"-"+provinceRepository.findById(Integer.parseInt(locationcode.substring(0, 3))).get().getProvName()+"; ";
		} else {
			
			location=location+" "+provinceRepository.findById(Integer.parseInt(locationcode.substring(0, 3))).get().getProvName();
		}
		}
		}


		
		
		
		
	}

}
