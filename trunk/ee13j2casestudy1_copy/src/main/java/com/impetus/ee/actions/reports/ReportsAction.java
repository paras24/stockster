package com.impetus.ee.actions.reports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.services.api.teamMember.TeamMemberService;
import com.impetus.ee.util.TeamMemberInfoComparatorForStatusSummary;
import com.impetus.ee.vo.TeamMemberInfo;
import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
@Namespace("/reports")
@ResultPath(value="/")
public class ReportsAction extends ActionSupport
{
	@Autowired
	private TeamMemberService teamMemberService;
	private List<TeamMemberInfo> teamMembers;
	private QueryParameterDTO queryParameterDTO = new QueryParameterDTO();	
	@Action(value="teamListJson", results={
			@Result(name="success",type="json")
	})
	public String teamMembersJson() 
	{
		teamMembers = teamMemberService.getTeamMemberByGroupHead("head1");
		Collections.sort(teamMembers,new TeamMemberInfoComparatorForStatusSummary());		
		return SUCCESS;
	}
	
	
	@Action(value="view", results={@Result(name="success",type="tiles", location="report.tiles")})
	public String reportView() 
	{
		return SUCCESS;
	}
	
	/**
	 * @return the teamMembers
	 */
	public List<TeamMemberInfo> getTeamMembers() {
		return teamMembers;
	}
	/**
	 * @param teamMembers the teamMembers to set
	 */
	public void setTeamMembers(List<TeamMemberInfo> teamMembers) {
		this.teamMembers = teamMembers;
	}
}
