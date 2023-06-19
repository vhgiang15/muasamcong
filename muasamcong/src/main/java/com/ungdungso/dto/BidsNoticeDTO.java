package com.ungdungso.dto;

import com.ungdungso.model.BidsNotice;

public class BidsNoticeDTO {

	private String notifyNo; // Số thông báo mời thầu
	private String notifyNoStand;
	private String bidName; // tên gói thầu
	private String link; // link gói thầu
	private String procuringEntityName; // tên đơn vị mời thầu
	private String investorName; 		// tên chủ đẩu tư
	private String publicDate;			// ngày đăng thầu
	private String bidCloseDate; 		// thời điểm đóng thầu
	private int isInternet; // đấu thầu qua mạng hay không
	private String investField; // lĩnh vực
	private String status; // trạng thái thông báo mời thầu
	private String planNo;				// số KHLCNT	
	private String bidForm;				// hình thức thầu
	private String bidPrice;
	public BidsNoticeDTO() {
		super();
	}
	public BidsNoticeDTO(String notifyNo, String notifyNoStand, String bidName, String link, String procuringEntityName,
			String investorName, String publicDate, String bidCloseDate, int isInternet, String investField,
			String status, String planNo, String bidForm, String bidPrice) {
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
	public int getIsInternet() {
		return isInternet;
	}
	public void setIsInternet(int isInternet) {
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
	
	
	public BidsNoticeDTO convertBidNoticeToDTO (BidsNotice bidsNotice) {
		BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();
		notifyNo=bidsNotice.getNotifyNo();
		notifyNoStand= bidsNotice.getNotifyNoStand();
		bidName=bidsNotice.getBidName();
		procuringEntityName=bidsNotice.getProcuringEntityName();
		investorName=bidsNotice.getInvestorName();
		
		
		
		return bidsNoticeDTO;
		
	}

}
