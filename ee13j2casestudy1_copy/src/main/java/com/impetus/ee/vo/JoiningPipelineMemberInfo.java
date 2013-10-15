package com.impetus.ee.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JoiningPipelineMemberInfo {

	private int jpmemberID;
	private String jpmemberName;
	private String Grade;
	private int experience;
	private String keySkills;
	private String remarks;
	private Date dateOfJoining;
	private String supervisorName;
	//private String project;
	//private String subProject;
	private String status;
	private List<AssignedProjectInfo> assignedProjectInfo =new ArrayList<AssignedProjectInfo>(); 
	
	/*public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getSubProject() {
		return subProject;
	}
	public void setSubProject(String subProject) {
		this.subProject = subProject;
	}	*/
	
	public int getJpmemberID() {
		return jpmemberID;
	}
	public void setJpmemberID(int jpmemberID) {
		this.jpmemberID = jpmemberID;
	}

	public String getJpmemberName() {
		return jpmemberName;
	}
	public void setJpmemberName(String jpmemberName) {
		this.jpmemberName = jpmemberName;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String Grade) {
		this.Grade = Grade;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getKeySkills() {
		return keySkills;
	}
	public void setKeySkills(String keySkills) {
		this.keySkills = keySkills;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<AssignedProjectInfo> getAssignedProjectInfo() {
		return assignedProjectInfo;
	}
	public void setAssignedProjectInfo(List<AssignedProjectInfo> assignedProjectInfo) {
		this.assignedProjectInfo = assignedProjectInfo;
	}
	@Override
	public String toString() {
		return "JoiningPipelineMemberInfo [jPmemberID=" + jpmemberID + ", jpmemberName="
				+ jpmemberName + ", Grade=" + Grade + ", experience="
				+ experience + ", keySkills=" + keySkills + ", remarks="
				+ remarks + ", dateOfJoining=" + dateOfJoining
				+ ", supervisorName=" + supervisorName + ", status=" + status
				+ ", assignedProjectInfo=" + assignedProjectInfo + "]";
	}
	
}
