package com.ungdungso.dto;

import java.text.SimpleDateFormat;

import org.hibernate.query.sqm.mutation.internal.MultiTableSqmMutationConverter;
import org.springframework.beans.factory.annotation.Autowired;

import com.ungdungso.model.BidsNotice;
import com.ungdungso.repository.BidFormRepository;
import com.ungdungso.repository.BidStatusRepository;
import com.ungdungso.repository.InvestFieldRepository;


public class BidsNoticeDTO {
	@Autowired
	private BidFormRepository bidFormRepository;
	

	//this.planNo = planNo;


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
	public BidsNoticeDTO() {
		super();
	}
	public BidsNoticeDTO(String notifyNo, String notifyNoStand, String bidName, String link, String procuringEntityName,
			String investorName, String publicDate, String bidCloseDate, String isInternet, String investField,
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
	
	
	public void convertBidNoticeToDTO (BidsNotice bidsNotice, InvestFieldRepository investFieldRepository,BidStatusRepository bidStatusRepository ) {
		BidsNoticeDTO bidsNoticeDTO= new BidsNoticeDTO();
		notifyNo=bidsNotice.getNotifyNo();
		notifyNoStand= bidsNotice.getNotifyNoStand();
		bidName=bidsNotice.getBidName();
		procuringEntityName=bidsNotice.getProcuringEntityName();
		investorName=bidsNotice.getInvestorName();
		SimpleDateFormat formatDate = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		publicDate=formatDate.format(bidsNotice.getPublicDate()).toString();		
		bidCloseDate =formatDate.format(bidsNotice.getBidCloseDate()).toString();
		isInternet = "Qua mạng";
		System.out.println("---------------------in ra");
		System.out.println(bidsNotice.getInvestField());
		//investField =investFieldRepository.queryName(bidsNotice.getInvestField());		
		investField =investFieldRepository.findById(bidsNotice.getInvestField()).get().getNameInvestField();	
		System.out.println(investField);
		
		//status=bidStatusRepository.findById(bidsNotice.getStatus()).get().getStatusName();
		//bidForm=bidFormRepository.findById(bidsNotice.getBidForm()).get().getNameBidForm()	;
		//this.planNo = planNo;
		//this.bidPrice = bidPrice;	
		//return bidsNoticeDTO;
		
	}

}
