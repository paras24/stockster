package com.impetus.ee.vo;

import java.util.Date;

public class JoiningPipelineMemberInfo {

	private Long JPmemberID;
	private String JPMemberName;
	private String Grade;
	private int experience;
	private String keySkills;
	private String remarks;
	private Date dateOfJoining;
	private String supervisorName;
	private String status;
	
	public String getjPMemberName() {
		return JPMemberName;
	}
	public void setjPMemberName(String jPMemberName) {
		JPMemberName = jPMemberName;
	}
	public String getGrade() {
		return Grade;
	}
	public void setGrade(String grade) {
		Grade = grade;
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
	public Long getJPMemberID() {
		return JPmemberID;
	}
	public void setJPMemberID(Long jPmemberID) {
		this.JPmemberID = jPmemberID;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public String getStatus(){
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "JoiningPipelineMemberInfo [jPmemberID=" + JPmemberID + ", jPMemberName="
				+ JPMemberName + ", Grade=" + Grade + ", experience="
				+ experience + ", keySkills=" + keySkills + ", remarks="
				+ remarks + ", dateOfJoining=" + dateOfJoining
				+ ", supervisorName=" + supervisorName + "]";
	}
	
}
