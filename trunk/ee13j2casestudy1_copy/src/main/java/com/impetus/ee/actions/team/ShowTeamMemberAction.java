package com.impetus.ee.actions.team;

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
import com.impetus.ee.vo.TeamMemberInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component
@Scope("prototype")
@Namespace("/team")
@ResultPath(value="/")
public class ShowTeamMemberAction extends ActionSupport implements ModelDriven{
	@Autowired
	private TeamMemberService teamMemberService;
	private QueryParameterDTO queryParameterDTO = new QueryParameterDTO();
	private int currentPage;
	private int totalPages;
	private List<TeamMemberInfo> teamMemberInfoList;

	public List<TeamMemberInfo> getTeamMemberInfoList() {
		return teamMemberInfoList;
	}

	public void setTeamMemberInfoList(List<TeamMemberInfo> teamMemberInfoList) {
		this.teamMemberInfoList = teamMemberInfoList;
	}
	
	@Action(value="listAllTeamMemberJson", results={
			@Result(name="success",type="json")
	})
	public String teamJson() 
	{
		setTeamMemberInfoList(teamMemberService.getTeamMemberByGroupHead("head1"));
		return SUCCESS;
	}

	@Action(value="listAllTeamMember", results={
			@Result(name="success",type="tiles", location="teamMembers.tiles")
	})
	public String teamList() 
	{
		return SUCCESS;
	}

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()
	 */
	@Override
	public Object getModel() {
		return queryParameterDTO;
	}
	
	
	
}
