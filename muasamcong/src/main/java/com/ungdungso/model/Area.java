package com.ungdungso.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Area {
	@Id
	@Column( name="code")
	private int code;
	
	@Column( name="areatype")
	private int areaType;
	@Transient
	private String name;
	
	@Column( name="orderindex")
	private int orderIndex;
	
	@Column( name="status")
	private int status;
	
	@Column( name="status12")
	private int status12;
	
	@Transient
	private String createdDate;
	
	@Transient
	private String createdBy;
	
	@Transient
	private String lastModifiedDate;
	
	@Transient
	private String lastModifiedBy;
	
	@Transient
	private String lastModifiedBy12;/////
	
	@Column( name="parentcode")
	private String parentCode;
	
	@Column( name="parent")
	private String parent;
	
	@Column( name="nametranslate")
	private String nameTranslate;
	
	@Column( name="groupcode")
	private int groupCode;
	
	@Transient
	private String parentDTO;
	
	
	
	

	public Area() {
		super();
	}



	



	







	public int getStatus12() {
		return status12;
	}















	public void setStatus12(int status12) {
		this.status12 = status12;
	}















	public String getLastModifiedBy12() {
		return lastModifiedBy12;
	}















	public void setLastModifiedBy12(String lastModifiedBy12) {
		this.lastModifiedBy12 = lastModifiedBy12;
	}















	public Area(int code, int areaType, String name, int orderIndex, int status, int status12, String createdDate,
			String createdBy, String lastModifiedDate, String lastModifiedBy, String lastModifiedBy12,
			String parentCode, String parent, String nameTranslate, int groupCode, String parentDTO) {
		super();
		this.code = code;
		this.areaType = areaType;
		this.name = name;
		this.orderIndex = orderIndex;
		this.status = status;
		this.status12 = status12;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedBy12 = lastModifiedBy12;
		this.parentCode = parentCode;
		this.parent = parent;
		this.nameTranslate = nameTranslate;
		this.groupCode = groupCode;
		this.parentDTO = parentDTO;
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



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getLastModifiedDate() {
		return lastModifiedDate;
	}



	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}



	public String getLastModifiedBy() {
		return lastModifiedBy;
	}



	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}



	public String getParentDTO() {
		return parentDTO;
	}



	public void setParentDTO(String parentDTO) {
		this.parentDTO = parentDTO;
	}
	
	

}
