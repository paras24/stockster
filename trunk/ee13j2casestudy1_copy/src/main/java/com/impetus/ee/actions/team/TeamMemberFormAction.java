package com.impetus.ee.actions.team;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

public class TeamMemberFormAction extends ActionSupport{
	
	@Action(value="showTeamMemberForm", results={
			@Result(name="success",type="tiles", location="showTeamMemberForm.tiles")
	})
	public String showAddTeamMemberForm()
	{
		return SUCCESS;
	}
}
