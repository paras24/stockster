package com.impetus.ee.actions.team;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.ee.services.api.teamMember.TeamMemberService;
import com.impetus.ee.vo.TeamMemberInfo;
import com.opensymphony.xwork2.ActionSupport;

public class AddTeamMemberAction extends ActionSupport{
	@Autowired
	private TeamMemberService teamMemberService;
	private TeamMemberInfo teamMemberInfo;
	@Action(value="addTeamMember", results={
			@Result(name="success",type="tiles", location="teamMembers.tiles"),
			@Result(name=INPUT,type="redirect",location="showTeamMemberForm.action"),
			@Result(name=ERROR,type="redirect",location="showTeamMemberForm.action")
	})
	public String addTeamMember() 
	{
		
		Long id=teamMemberService.addTeamMember(teamMemberInfo);
		if(id!=null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	@Action(value="showTeamMemberForm", results={
			@Result(name="success",type="tiles", location="showTeamMemberForm.tiles")
	})
	public String showAddTeamMemberForm()
	{
		return SUCCESS;
	}
	public TeamMemberInfo getTeamMemberInfo() {
		return teamMemberInfo;
	}
	public void setTeamMemberInfo(TeamMemberInfo teamMemberInfo) {
		this.teamMemberInfo = teamMemberInfo;
	}
	
}
