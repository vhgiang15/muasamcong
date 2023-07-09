package com.ungdungso.utility;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ungdungso.model.District;
import com.ungdungso.model.Province;
import com.ungdungso.repository.DistricRepository;
import com.ungdungso.repository.ProvinceRepository;


public class Common {
	public static HashMap<String, String> hashMapBidForm = new HashMap<String, String>();
	public static HashMap<String, String> hashMapBidMode = new HashMap<String, String>();
	public static HashMap<String, String> hashMapBidStatus = new HashMap<String, String>();
	public static HashMap<String, String> hashMapInvestField = new HashMap<String, String>();
	public static HashMap<Integer, String> hashMapInternet = new HashMap<Integer, String>();
	public static HashMap<Integer, String> hashMapProvince = new HashMap<Integer, String>();
	public static HashMap<Integer, String> hashMapDistrict = new HashMap<Integer, String>();	
	public static void setHashMap()
	{
		
		hashMapBidForm.put("CHCT", "Chào hàng cạnh tranh");
		hashMapBidForm.put("CHCTRG", "Chào hàng cạnh tranh rút gọn");
		hashMapBidForm.put("DTRR", "Đấu thầu rộng rãi");
		hashMapBidForm.put("DTHC", "Đấu thầu hạn chế");
		hashMapBidForm.put("TCTVCN", "Tuyển chọn tư vấn cá nhân");
		
		
		hashMapBidMode.put("1_MTHS", "Một giai đoạn một túi hồ sơ");
		hashMapBidMode.put("1_HTHS", "Một giai đoạn hai túi hồ sơ");
		
		hashMapInvestField.put("XL", "Xây lắp");
		hashMapInvestField.put("TV", "Tư vấn");
		hashMapInvestField.put("PTV", "Phi tư vấn");
		hashMapInvestField.put("HH", "Hàng hoá");
		hashMapInvestField.put("HON_HOP", "Hỗn hợp");
		
		hashMapBidStatus.put("01", "Chưa đóng thầu");
		hashMapBidStatus.put("OPEN_BID", "Đang xét thầu");
		hashMapBidStatus.put("OPEN_DXKT", "Đang xét thầu");
		hashMapBidStatus.put("OPEN_DXTC", "Đang xét thầu");
		hashMapBidStatus.put("IS_PUBLISH", "Có nhà thầu trúng thầu");
		hashMapBidStatus.put("NOT_PUBLISH", "Có nhà thầu trúng thầu");
		hashMapBidStatus.put("CANCEL_BID", "Đã huỷ thầu");
		hashMapBidStatus.put("PUB_KQLCNT", "Đã huỷ thầu");
		hashMapBidStatus.put("03", "Đã huỷ TBMT");
		
		hashMapInternet.put(1, "Qua mạng");
		hashMapInternet.put(0, "Không qua mạng");
	}

}
