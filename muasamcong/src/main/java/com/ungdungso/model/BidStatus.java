package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "bid_status")
public class BidStatus {
	@Id
	@Column(name="status", columnDefinition = "NVARCHAR(10)")
	private String status;
	
	@Column(name="status_name", columnDefinition = "NVARCHAR(30)")
	private String statusName;

	public BidStatus() {
		super();
	}

	public BidStatus(String status, String statusName) {
		super();
		this.status = status;
		this.statusName = statusName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	

}
