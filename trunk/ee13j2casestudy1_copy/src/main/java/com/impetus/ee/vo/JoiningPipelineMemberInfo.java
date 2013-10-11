package com.impetus.ee.vo;

import java.util.Date;

public class JoiningPipelineMemberInfo {

	private int jpmemberID;
	private String jpMemberName;
	private String grade;
	private int experience;
	private String keySkills;
	private String remarks;
	private Date dateOfJoining;
	private String supervisorName;
	private String status;
	
	
	
	

	public int getJpmemberID() {
		return jpmemberID;
	}





	public void setJpmemberID(int jpmemberID) {
		this.jpmemberID = jpmemberID;
	}





	public String getJpMemberName() {
		return jpMemberName;
	}





	public void setJpMemberName(String jpMemberName) {
		this.jpMemberName = jpMemberName;
	}





	public String getGrade() {
		return grade;
	}





	public void setGrade(String grade) {
		this.grade = grade;
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





	@Override
	public String toString() {
		return "JoiningPipelineMemberInfo [jPmemberID=" + jpmemberID + ", jPMemberName="
				+ jpMemberName + ", Grade=" + grade + ", experience="
				+ experience + ", keySkills=" + keySkills + ", remarks="
				+ remarks + ", dateOfJoining=" + dateOfJoining
				+ ", supervisorName=" + supervisorName + "]";
	}
	
}
