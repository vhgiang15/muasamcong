package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="province")
public class Province {
	@Id
	@Column(name="prov_code")
	private int provCode;
	
	@Column(name="prov_Name",columnDefinition = "NVARCHAR(50)")
	private String provName;

	public Province() {
		super();
	}

	public Province(int provCode, String provName) {
		super();
		this.provCode = provCode;
		this.provName = provName;
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
