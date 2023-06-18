package com.ungdungso.dto;
public class AreaDTO {
	private int code;	
	private int areaType;
	private String name;
	private int orderIndex;
	private int status;
	private String createdDate;
	private String createdBy;
	private String lastModifiedDate;
	private String lastModifiedBy;
	private String parentCode;
	private String parent;
	private String nameTranslate;
	private int groupCode;
	private String parentDTO;
	public AreaDTO() {
		super();
	}
	public AreaDTO(int code, int areaType, String name, int orderIndex, int status, String createdDate,
			String createdBy, String lastModifiedDate, String lastModifiedBy, String parentCode, String parent,
			String nameTranslate, int groupCode, String parentDTO) {
		super();
		this.code = code;
		this.areaType = areaType;
		this.name = name;
		this.orderIndex = orderIndex;
		this.status = status;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.lastModifiedDate = lastModifiedDate;
		this.lastModifiedBy = lastModifiedBy;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getParentDTO() {
		return parentDTO;
	}
	public void setParentDTO(String parentDTO) {
		this.parentDTO = parentDTO;
	}
	
	
	

}
