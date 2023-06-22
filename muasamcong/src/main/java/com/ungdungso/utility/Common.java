package com.ungdungso.utility;
import java.util.HashMap;
public class Common {
	public static HashMap<String, String> hashMapBidForm = new HashMap<String, String>();
	public static HashMap<String, String> hashMapBidMode = new HashMap<String, String>();
	public static HashMap<String, String> hashMapBidStatus = new HashMap<String, String>();
	public static HashMap<String, String> hashMapInvestField = new HashMap<String, String>();
	public static HashMap<Integer, String> hashMapInternet = new HashMap<Integer, String>();
	
	public static void setHashMap()
	{
		
		hashMapBidForm.put("CHCT", "Chào hàng cạnh tranh");
		hashMapBidForm.put("CHCTRG", "Chào hàng cạnh tranh rút gọn");
		hashMapBidForm.put("DTRR", "Đấu thầu rộng rãi");
		hashMapBidForm.put("DTHC", "Đấu thầu hạn chế");
		
		hashMapBidMode.put("1_MTHS", "Một giai đoạn một túi hồ sơ");
		hashMapBidMode.put("1_HTHS", "Một giai đoạn hai túi hồ sơ");
		
		hashMapInvestField.put("XL", "Xây lắp");
		hashMapInvestField.put("TV", "Tư vấn");
		hashMapInvestField.put("PTV", "Phi tư vấn");
		hashMapInvestField.put("HH", "Hàng hoá");
		hashMapInvestField.put("HON_HOP", "Hỗn hợp");
		
		hashMapBidStatus.put("01", "Chưa đóng thầu");
		
		hashMapInternet.put(1, "Qua mạng");
		hashMapInternet.put(0, "Không qua mạng");

	}

}
