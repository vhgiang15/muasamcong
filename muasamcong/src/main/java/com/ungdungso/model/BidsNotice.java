package com.ungdungso.model;
import java.math.BigInteger;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "bids_notice")
public class BidsNotice {
	@Id
	@Column( name="notify_no", columnDefinition = "NVARCHAR(20)")
	private String notifyNo; // Số thông báo mời thầu
	
	@Column( name="public_date")
	private Date publicDate;
	
	@Column( name="bid_close_date")
	private Date bidCloseDate; 
	
	@Column( name="bid_form", columnDefinition = "NVARCHAR(10)")
	private String bidForm;	// hình thức thầu
	
	@Column( name="bid_mode", columnDefinition = "NVARCHAR(20)")
	private String bidMode; // phương thức LCNT
	
	@Column( name="bid_name", columnDefinition = "TEXT(500)")
	private String bidName; // tên gói thầu
	
	@Column( name="invest_field", columnDefinition = "NVARCHAR(10)")
	private String investField; // lĩnh vực
	
	@Column( name="is_internet", columnDefinition = "NVARCHAR(10)")
	private int isInternet; // đấu thầu qua mạng hay không
	
	@Column( name="procuring_entity_code", columnDefinition = "NVARCHAR(20)")
	private String procuringEntityCode; // mã đơn vị mời thầu trên hệ thống mua sắm công
	
	@Column( name="procuring_entity_name")
	private String procuringEntityName; // tên đơn vị mời thầu
	
	@Column( name="investor_name")
	private String investorName; 		// tên chủ đẩu tư
	
	@Column( name="notify_version", columnDefinition = "NVARCHAR(2)")
	private String notifyVersion; 
	
	@Column( name="notify_no_stand", columnDefinition = "NVARCHAR(20)")
	private String notifyNoStand;
	
	@Column( name="status",columnDefinition = "NVARCHAR(20)")
	private String status; // trạng thái thông báo mời thầu
	

	@Column( name="bid_open_date")
	private Date bidOpenDate;
		
	@Column( name="plan_No", columnDefinition = "NVARCHAR(20)")
	private String planNo;				// số KHLCNT
	
	@Column( name="location", columnDefinition = "TEXT(1000)")
	private String location;
	
	@Column( name="bid_price")
	private BigInteger bidPrice; // giá gói thầu
	
	@Column( name="decision_date")
	private Date decisionDate; // ngày phê duyệt KQLCNT
	
	@Column( name="contractor_name", columnDefinition = "TEXT(1000)")
	private String contractorName; // tên nhà thầu trúng thầu
	
	@Column( name="bidWinning_price")
	private BigInteger bidWinningPrice; // giá trúng thầu
	
	@Column( name="num_bidder_join")
	private int numBidderJoin; // số lượng nhà thầu tham gia
	
	@Column( name="winning_code", columnDefinition = "TEXT(1000)")
	private String winningCode;
	
	@Column( name="id", columnDefinition = "TEXT(1000)")  // tham số cung cấp cho link TBMT trong DTO
	private String id;
	
	@Column( name="notify_id", columnDefinition = "TEXT(1000)") //// tham số cung cấp cho link TBMT trong DTO
	private String notifyId;

	public BidsNotice() {
		super();
	}

	public BidsNotice(String notifyNo, Date publicDate, Date bidCloseDate, String bidForm, String bidMode,
			String bidName, String investField, int isInternet, String procuringEntityCode, String procuringEntityName,
			String investorName, String notifyVersion, String notifyNoStand, String status, Date bidOpenDate,
			String planNo, String location, BigInteger bidPrice, Date decisionDate, String contractorName,
			BigInteger bidWinningPrice, int numBidderJoin, String winningCode, String id, String notifyId) {
		super();
		this.notifyNo = notifyNo;
		this.publicDate = publicDate;
		this.bidCloseDate = bidCloseDate;
		this.bidForm = bidForm;
		this.bidMode = bidMode;
		this.bidName = bidName;
		this.investField = investField;
		this.isInternet = isInternet;
		this.procuringEntityCode = procuringEntityCode;
		this.procuringEntityName = procuringEntityName;
		this.investorName = investorName;
		this.notifyVersion = notifyVersion;
		this.notifyNoStand = notifyNoStand;
		this.status = status;
		this.bidOpenDate = bidOpenDate;
		this.planNo = planNo;
		this.location = location;
		this.bidPrice = bidPrice;
		this.decisionDate = decisionDate;
		this.contractorName = contractorName;
		this.bidWinningPrice = bidWinningPrice;
		this.numBidderJoin = numBidderJoin;
		this.winningCode = winningCode;
		this.id = id;
		this.notifyId = notifyId;
	}

	public String getNotifyNo() {
		return notifyNo;
	}

	public void setNotifyNo(String notifyNo) {
		this.notifyNo = notifyNo;
	}

	public Date getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}

	public Date getBidCloseDate() {
		return bidCloseDate;
	}

	public void setBidCloseDate(Date bidCloseDate) {
		this.bidCloseDate = bidCloseDate;
	}

	public String getBidForm() {
		return bidForm;
	}

	public void setBidForm(String bidForm) {
		this.bidForm = bidForm;
	}

	public String getBidMode() {
		return bidMode;
	}

	public void setBidMode(String bidMode) {
		this.bidMode = bidMode;
	}

	public String getBidName() {
		return bidName;
	}

	public void setBidName(String bidName) {
		this.bidName = bidName;
	}

	public String getInvestField() {
		return investField;
	}

	public void setInvestField(String investField) {
		this.investField = investField;
	}

	public int getIsInternet() {
		return isInternet;
	}

	public void setIsInternet(int isInternet) {
		this.isInternet = isInternet;
	}

	public String getProcuringEntityCode() {
		return procuringEntityCode;
	}

	public void setProcuringEntityCode(String procuringEntityCode) {
		this.procuringEntityCode = procuringEntityCode;
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

	public String getNotifyVersion() {
		return notifyVersion;
	}

	public void setNotifyVersion(String notifyVersion) {
		this.notifyVersion = notifyVersion;
	}

	public String getNotifyNoStand() {
		return notifyNoStand;
	}

	public void setNotifyNoStand(String notifyNoStand) {
		this.notifyNoStand = notifyNoStand;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getBidOpenDate() {
		return bidOpenDate;
	}

	public void setBidOpenDate(Date bidOpenDate) {
		this.bidOpenDate = bidOpenDate;
	}

	public String getPlanNo() {
		return planNo;
	}

	public void setPlanNo(String planNo) {
		this.planNo = planNo;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public BigInteger getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(BigInteger bidPrice) {
		this.bidPrice = bidPrice;
	}

	public Date getDecisionDate() {
		return decisionDate;
	}

	public void setDecisionDate(Date decisionDate) {
		this.decisionDate = decisionDate;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public BigInteger getBidWinningPrice() {
		return bidWinningPrice;
	}

	public void setBidWinningPrice(BigInteger bidWinningPrice) {
		this.bidWinningPrice = bidWinningPrice;
	}

	public int getNumBidderJoin() {
		return numBidderJoin;
	}

	public void setNumBidderJoin(int numBidderJoin) {
		this.numBidderJoin = numBidderJoin;
	}

	public String getWinningCode() {
		return winningCode;
	}

	public void setWinningCode(String winningCode) {
		this.winningCode = winningCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	
	
	
}
