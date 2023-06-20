package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="invest_field")
public class InvestField {
	@Id
	@Column(name="invest_field", columnDefinition = "NVARCHAR(5)")
	private String investField;
	
	@Column(name="invest_field_name", columnDefinition = "NVARCHAR(20)")
	private String nameInvestField;

	public InvestField() {
		super();
	}

	public InvestField(String investField, String nameInvestField) {
		super();
		this.investField= investField;
		this.nameInvestField = nameInvestField;
	}

	public String getCodeBidForm() {
		return investField;
	}

	public void setCodeBidForm(String codeBidForm) {
		this.investField = codeBidForm;
	}

	public String getNameInvestField() {
		return nameInvestField;
	}

	public void setNameInvestField(String nameInvestField) {
		this.nameInvestField = nameInvestField;
	}
	
	

}
