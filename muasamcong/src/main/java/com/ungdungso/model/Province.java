package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name="province")
public class Province {
	@Id
	@Column(name="prov_code")
	private int provCode;
	
	@Column(name="prov_Name",columnDefinition = "NVARCHAR(50)")
	private String provName;
	
	@Column(name="area",columnDefinition = "NVARCHAR(2)")
	private String area;
	
	@Column(name="amount_notice_today")
	private int amountNoticeToday;
	
	@Column(name="amount_notice_year")
	private int amountNoticeYear;
	
	@Transient
	private String link;

	public Province() {
		super();
	}

	public Province(int provCode, String provName, String area, int amountNoticeToday, int amountNoticeYear,
			String link) {
		super();
		this.provCode = provCode;
		this.provName = provName;
		this.area = area;
		this.amountNoticeToday = amountNoticeToday;
		this.amountNoticeYear = amountNoticeYear;
		this.link = link;
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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getAmountNoticeToday() {
		return amountNoticeToday;
	}

	public void setAmountNoticeToday(int amountNoticeToday) {
		this.amountNoticeToday = amountNoticeToday;
	}

	public int getAmountNoticeYear() {
		return amountNoticeYear;
	}

	public void setAmountNoticeYear(int amountNoticeYear) {
		this.amountNoticeYear = amountNoticeYear;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}



	
	
	
	

	
}
