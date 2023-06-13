package com.ungdungso.model;

import jakarta.persistence.Id;

public class BidsNotice {
	@Id
	private String id; // ID trong database
	
	private String notifyId;
	private String bidCloseDate;  // ngày đóng thầu
	private String bidForm;	// hình thức thầu
	private String bidMode; // phương thức LCNT
	private String bidName; // tên gói thầu
	private String investField; // lĩnh vực
	private int isInternet; // đấu thầu qua mạng hay không
	private String locations; // địa điểm thực hiện thầu
	private String notifyNo; // sô thông báo mời thầu
	private String notifyVersion; 
	private String notifyNoStand;
	private String processApply; 
	private String procuringEntityCode; // mã đơn vị chủ đầu tư
	private String procuringEntityName; // tên chủ đầu tư
	private String publicDate; // ngày đăng thầu
	private String status; // trạng thái thông báo mời thầu
	private String bidOpenDate;

	
		
	/*
	 * "id": "3dc38628-f4e5-4f08-b0c4-e590fa58c60b", "notifyId":
	 * "3dc38628-f4e5-4f08-b0c4-e590fa58c60b", "bidCloseDate":
	 * "2023-06-14T10:00:00", "bidForm": "CHCT", "bidMode": "1_MTHS", "bidName": [
	 * "Mua sắm trang thiết bị bay không người lái (Flycam) phục vụ công tác tuần tra, kiểm tra quản lý, bảo vệ rừng"
	 * ], "investField": [ "HH" ], "isInternet": 1, "locations": [ { "provCode":
	 * "703", "provName": "Tỉnh Lâm Đồng", "districtCode": "70323", "districtName":
	 * "Huyện Đam Rông" } ], "notifyNo": "IB2300120225", "notifyVersion": "00",
	 * "notifyNoStand": "IB2300120225-00", "processApply": "LDT",
	 * "procuringEntityCode": "vn5801427635", "procuringEntityName":
	 * "CÔNG TY TNHH TMDV VÀ TVXD HOÀNG PHÚC GROUP", "publicDate":
	 * "2023-06-07T23:34:32.651", "status": "01", "bidOpenDate":
	 * "2023-06-14T10:00:00", "planType": "TX", "planNo": "PL2300089723",
	 * "stepCode": "notify-contractor-step-1-tbmt", "type": "es-notify-contractor",
	 * "statusForNotify": "", "goods": [ "Thiết Bị Bay Không Người Lái" ],
	 * "numPetition": 0, "numClarifyReq": 0, "numBidderTech": 0, "bidId":
	 * "cf919250-2595-473f-b134-68d08be2f04c", "createdBy": "vn5801427635",
	 * "bidPrice": 1.4473E8, "numPetitionHsmt": 0, "numPetitionLcnt": 0,
	 * "numPetitionKqlcnt": 0, "score": "NaN", "pvccNew": [ { "name":
	 * "Thiết Bị Bay Không Người Lái" } ] },
	 */
}
