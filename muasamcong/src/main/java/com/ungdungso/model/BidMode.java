package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="bid_mode")
public class BidMode {
	@Id
	@Column(name="code_bid_mode", columnDefinition = "NVARCHAR(10)")
	private String codeBidMode;
	@Column(name="name_bid_mode", columnDefinition = "NVARCHAR(50)")
	private String nameBidMode;
	public BidMode() {
		super();
	}
	public BidMode(String codeBidMode, String nameBidMode) {
		super();
		this.codeBidMode = codeBidMode;
		this.nameBidMode = nameBidMode;
	}
	public String getCodeBidMode() {
		return codeBidMode;
	}
	public void setCodeBidMode(String codeBidMode) {
		this.codeBidMode = codeBidMode;
	}
	public String getNameBidMode() {
		return nameBidMode;
	}
	public void setNameBidMode(String nameBidMode) {
		this.nameBidMode = nameBidMode;
	}
	
	

}
