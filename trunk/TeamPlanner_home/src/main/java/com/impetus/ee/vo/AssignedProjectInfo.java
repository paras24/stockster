package com.impetus.ee.vo;

public class AssignedProjectInfo {
	private int projectID;
	private String projectName;
	private int allocationPercent;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getAllocationPercent() {
		return allocationPercent;
	}
	public void setAllocationPercent(int allocationPercent) {
		this.allocationPercent = allocationPercent;
	}
	public int getProjectID() {
		return projectID;
	}
	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}
	@Override
	public String toString() {
		return "AssignedProjectInfo [projectID=" + projectID + ", projectName="
				+ projectName + ", allocationPercent=" + allocationPercent
				+ "]";
	}
	
}
