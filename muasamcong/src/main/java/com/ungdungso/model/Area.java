package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Area {
	@Id
	@Column( name="code")
	private int code;
	
	@Column( name="areatype")
	private int areaType;
	
	@Column( name="orderindex")
	private int orderIndex;
	
	@Column( name="status")
	private int status;
	
	@Column( name="parentcode")
	private String parentCode;
	
	@Column( name="parent")
	private String parent;
	
	@Column( name="nametranslate")
	private String nameTranslate;
	
	@Column( name="groupcode")
	private int groupCode;

	public Area() {
		super();
	}

	public Area(int code, int areaType, int orderIndex, int status, String parentCode, String parent,
			String nameTranslate, int groupCode) {
		super();
		this.code = code;
		this.areaType = areaType;
		this.orderIndex = orderIndex;
		this.status = status;
		this.parentCode = parentCode;
		this.parent = parent;
		this.nameTranslate = nameTranslate;
		this.groupCode = groupCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAreaType() {
		return areaType;
	}

	public void setAreaType(int areaType) {
		this.areaType = areaType;
	}

	public int getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(int orderIndex) {
		this.orderIndex = orderIndex;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getNameTranslate() {
		return nameTranslate;
	}

	public void setNameTranslate(String nameTranslate) {
		this.nameTranslate = nameTranslate;
	}

	public int getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(int groupCode) {
		this.groupCode = groupCode;
	}	
	

}
