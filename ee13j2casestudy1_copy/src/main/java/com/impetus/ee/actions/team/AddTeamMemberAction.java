package com.impetus.ee.actions.team;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;


import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.ee.services.api.teamMember.TeamMemberService;
import com.impetus.ee.vo.TeamMemberInfo;
import com.opensymphony.xwork2.ActionSupport;


public class AddTeamMemberAction extends ActionSupport{
	@Autowired
	private TeamMemberService teamMemberService;
	private String teamMemberName;
	private String grade;
	private int experience;
	private String keySkills;
	private String remarks;
	private Date dateOfJoining;
	private String groupHeadName;
	private String status;
	private String supervisor;
	@Action(value="addTeamMember", results={
			@Result(name=SUCCESS,type="redirect", location="showTeamMemberForm.action"),
			@Result(name=INPUT,type="tiles",location="showTeamMemberForm.tiles"),
			@Result(name=ERROR,type="tiles",location="showTeamMemberForm.tiles")
	})
	public String addTeamMember() 
	{	TeamMemberInfo teamMemberInfo=new TeamMemberInfo();
		teamMemberInfo.setTeamMemberName(teamMemberName);
		teamMemberInfo.setGrade(grade);
		teamMemberInfo.setExperience(experience);
		teamMemberInfo.setKeySkills(keySkills);
		teamMemberInfo.setRemarks(remarks);
		teamMemberInfo.setSupervisor(supervisor);
		teamMemberInfo.setStatus(status);
		teamMemberInfo.setGroupHeadName("head1");
		Long id=teamMemberService.addTeamMember(teamMemberInfo);
		if(id!=null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
	@RequiredStringValidator(trim=true,message="Team Member Name is required.")
	public String getTeamMemberName() {
		return teamMemberName;
	}
	public void setTeamMemberName(String teamMemberName) {
		this.teamMemberName = teamMemberName;
	}
	@RequiredStringValidator(trim=true,message="Grade is required.")
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
	public String getGroupHeadName() {
		return groupHeadName;
	}
	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
	}
	public String getStatus() {
		return status;
	}
	@RequiredStringValidator(trim=true,message="Status is required.")
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	
}
