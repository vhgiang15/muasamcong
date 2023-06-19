package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bid_form")
public class BidForm {
	@Id
	@Column(name="code_bid_form", columnDefinition = "NVARCHAR(10)")
	private String codeBidForm;
	
	@Column(name="name_bid_form", columnDefinition = "NVARCHAR(30)")
	private String nameBidForm;

	public BidForm() {
		super();
	}

	public BidForm(String codeBidForm, String nameBidForm) {
		super();
		this.codeBidForm = codeBidForm;
		this.nameBidForm = nameBidForm;
	}

	public String getCodeBidForm() {
		return codeBidForm;
	}

	public void setCodeBidForm(String codeBidForm) {
		this.codeBidForm = codeBidForm;
	}

	public String getNameBidForm() {
		return nameBidForm;
	}

	public void setNameBidForm(String nameBidForm) {
		this.nameBidForm = nameBidForm;
	}
	

}
