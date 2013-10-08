package com.impetus.ee.vo;

import java.sql.Date;

public class ProjectInfo {
	
	private int projectId;
	private String projectName;
	private String groupHeadName;
	private String subProjectName;
	private String pointOfContact;
	private String supervisorName;
	private int percentAllocation;
	private String status;
	private Date dateOfprojectAllocation;
	private Date dateOfprojectDeallocation;
	
	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getGroupHeadName() {
		return groupHeadName;
	}
	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
	}
	public String getSubProjectName() {
		return subProjectName;
	}
	public void setSubProjectName(String subProjectName) {
		this.subProjectName = subProjectName;
	}
	public String getPointOfContact() {
		return pointOfContact;
	}
	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public int getPercentAllocation() {
		return percentAllocation;
	}
	public void setPercentAllocation(int percentAllocation) {
		this.percentAllocation = percentAllocation;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOfprojectAllocation() {
		return dateOfprojectAllocation;
	}
	public void setDateOfprojectAllocation(Date dateOfprojectAllocation) {
		this.dateOfprojectAllocation = dateOfprojectAllocation;
	}
	public Date getDateOfprojectDeallocation() {
		return dateOfprojectDeallocation;
	}
	public void setDateOfprojectDeallocation(Date dateOfprojectDeallocation) {
		this.dateOfprojectDeallocation = dateOfprojectDeallocation;
	}
	@Override
	public String toString() {
		return "ProjectInfo [projectName=" + projectName + ", groupHead="
				+ groupHeadName + ", subProjectName=" + subProjectName
				+ ", pointOfContact=" + pointOfContact + ", supervisorName="
				+ supervisorName + ", percentAllocation=" + percentAllocation
				+ ", status=" + status + ", dateOfprojectAllocation="
				+ dateOfprojectAllocation + ", dateOfprojectDeallocation="
				+ dateOfprojectDeallocation + "]";
	}
	
	

}
