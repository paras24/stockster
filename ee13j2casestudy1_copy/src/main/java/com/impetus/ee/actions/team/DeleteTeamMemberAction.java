package com.impetus.ee.actions.team;



import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



import com.impetus.ee.services.api.teamMember.TeamMemberService;
import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
@Namespace("/team")
@ResultPath(value="/")
public class DeleteTeamMemberAction extends ActionSupport
{
	@Autowired
	private TeamMemberService teamMemberService;

	private long memberID;
	public long getMemberID() {
		return memberID;
	}
	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}
	@Action(value="deleteMember", results={
			@Result(name="success",type="json")
	})
	public String deleteMember() 
	{
		System.out.println("memberID ID>> "+memberID);
		teamMemberService.removeTeamMemberById(memberID);
		
		return SUCCESS;
	}

}
