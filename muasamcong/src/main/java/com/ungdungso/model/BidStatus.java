package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class BidStatus {
	@Id
	@Column(name="status", columnDefinition = "NVARCHAR(10)")
	private String status;
	
	@Column(name="status_name", columnDefinition = "NVARCHAR(30)")
	private String statusName;

}
