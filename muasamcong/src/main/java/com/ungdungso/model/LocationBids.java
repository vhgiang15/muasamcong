package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="location_bids")
public class LocationBids {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="notify_no", columnDefinition = "NVARCHAR(20)")
	private String notifyNo;
	
	@Column(name="district_code")
	private int districtCode;
	
	@Column(name="district_name",columnDefinition = "NVARCHAR(50)")
	private String districtName;
	
	@Column(name="prov_code")
	private int provCode;
	
	@Column(name="prov_Name",columnDefinition = "NVARCHAR(50)")
	private String provName;

	public LocationBids() {
		super();
	}

	public LocationBids(int id, String notifyNo, int districtCode, String districtName, int provCode, String provName) {
		super();
		this.id = id;
		this.notifyNo = notifyNo;
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.provCode = provCode;
		this.provName = provName;
	}

	public int getId() {
		return id;
	}


	public String getNotifyNo() {
		return notifyNo;
	}

	public void setNotifyNo(String notifyNo) {
		this.notifyNo = notifyNo;
	}

	public int getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(int districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public int getProvCode() {
		return provCode;
	}

	public void setProvCode(int provCode) {
		this.provCode = provCode;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}
	


}
