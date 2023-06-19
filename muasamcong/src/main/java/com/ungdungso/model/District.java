package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="district")
public class District {
	@Id
	@Column(name="district_code")
	private int districtCode;
	
	@Column(name="district_name",columnDefinition = "NVARCHAR(50)")
	private String districtName;
	
	@Column(name="prov_code")
	private int provCode;
	
	@Column(name="prov_Name",columnDefinition = "NVARCHAR(50)")
	private String provName;

	public District() {
		super();
	}

	public District(int districtCode, String districtName, int provCode, String provName) {
		super();
		this.districtCode = districtCode;
		this.districtName = districtName;
		this.provCode = provCode;
		this.provName = provName;
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
