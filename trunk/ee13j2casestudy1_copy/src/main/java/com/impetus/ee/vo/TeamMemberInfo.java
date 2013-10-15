package com.impetus.ee.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validation;
@Validation
public class TeamMemberInfo {
	
	
	private Long memberID;
	private String teamMemberName;
	private String grade;
	private int experience;
	private String keySkills;
	private String remarks;
	private Date dateOfJoining;
	private String groupHeadName;
	private String status;
	private String project;
	private String subProject;
	private String supervisor;
	private List<AssignedProjectInfo> assignedProjectInfo =new ArrayList<AssignedProjectInfo>(); 
	@RequiredFieldValidator( message = "The name is required" )
	public String getTeamMemberName() {
		return teamMemberName;
	}
	
	public void setTeamMemberName(String teamMemberName) {
		this.teamMemberName = teamMemberName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
	public Long getMemberID() {
		return memberID;
	}
	public void setMemberID(Long memberID) {
		this.memberID = memberID;
	}
	public String getGroupHeadName() {
		return groupHeadName;
	}
	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
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
		return "TeamMemberInfo [memberID=" + memberID + ", teamMemberName="
				+ teamMemberName + ", grade=" + grade + ", experirnce="
				+ experience + ", keySkills=" + keySkills + ", remarks="
				+ remarks + ", dateOfJoining=" + dateOfJoining
				+ ", groupHeadName=" + groupHeadName + ", status=" + status
				+ ", assignedProjectInfo=" + assignedProjectInfo + "]";
	}
	/**
	 * @return the project
	 */
	public String getProject() {
		return project;
	}
	/**
	 * @param project the project to set
	 */
	public void setProject(String project) {
		this.project = project;
	}
	/**
	 * @return the subProject
	 */
	public String getSubProject() {
		return subProject;
	}
	/**
	 * @param subProject the subProject to set
	 */
	public void setSubProject(String subProject) {
		this.subProject = subProject;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getExperience() {
		return experience;
	}
}
