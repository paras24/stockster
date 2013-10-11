package com.impetus.ee.common;

import java.util.List;

public class QueryParameterDTO {
	private Integer displayStart;
	private Integer displayLength;
	private Integer totalRecords;
	private Integer totalDisplayRecords;
	private String searchString;	
	private String sortOrder;
	private List<Object> data;
	private String sortColName;
	/**
	 * @return the displayStart
	 */
	public Integer getDisplayStart() {
		return displayStart;
	}
	/**
	 * @param displayStart the displayStart to set
	 */
	public void setDisplayStart(Integer displayStart) {
		this.displayStart = displayStart;
	}
	/**
	 * @return the displayLength
	 */
	public Integer getDisplayLength() {
		return displayLength;
	}
	/**
	 * @param displayLength the displayLength to set
	 */
	public void setDisplayLength(Integer displayLength) {
		this.displayLength = displayLength;
	}
	/**
	 * @return the totalRecords
	 */
	public Integer getTotalRecords() {
		return totalRecords;
	}
	/**
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	/**
	 * @return the totalDisplayRecords
	 */
	public Integer getTotalDisplayRecords() {
		return totalDisplayRecords;
	}
	/**
	 * @param totalDisplayRecords the totalDisplayRecords to set
	 */
	public void setTotalDisplayRecords(Integer totalDisplayRecords) {
		this.totalDisplayRecords = totalDisplayRecords;
	}
	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}
	/**
	 * @param searchString the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	/**
	 * @return the sortOrder
	 */
	public String getSortOrder() {
		return sortOrder;
	}
	/**
	 * @param sortOrder the sortOrder to set
	 */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	/**
	 * @return the data
	 */
	public List<Object> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(List<Object> data) {
		this.data = data;
	}
	/**
	 * @return the sortColName
	 */
	public String getSortColName() {
		return sortColName;
	}
	/**
	 * @param sortColName the sortColName to set
	 */
	public void setSortColName(String sortColName) {
		this.sortColName = sortColName;
	}	
}
