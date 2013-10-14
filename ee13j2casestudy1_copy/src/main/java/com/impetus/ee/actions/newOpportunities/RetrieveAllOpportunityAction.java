package com.impetus.ee.actions.newOpportunities;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.opportunity.Opportunity;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.services.api.opportunity.OpportunityService;
import com.impetus.ee.services.api.user.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
@Namespace("/opportunity")
@ResultPath(value="/")
public class RetrieveAllOpportunityAction extends ActionSupport implements ModelDriven
{
	@Autowired
	private OpportunityService opportunityService;
	private List<Opportunity> opportunities;
	private QueryParameterDTO queryParameterDTO = new QueryParameterDTO();
	private int currentPage;
	private int totalPages;
	@Action(value="opportunityListJson", results={
			@Result(name="success",type="json")
	})
	public String opportunityJson() 
	{
		List<Opportunity> opportunities= opportunityService.getOpportunities(queryParameterDTO);
		int modulus = queryParameterDTO.getTotalDisplayRecords()% queryParameterDTO.getDisplayLength();
		setTotalPages(queryParameterDTO.getTotalDisplayRecords()/ queryParameterDTO.getDisplayLength());
		if (modulus != 0 || getTotalPages() == 0) {
			setTotalPages(getTotalPages() + 1);
		}
		setCurrentPage(queryParameterDTO.getDisplayStart()/ queryParameterDTO.getDisplayLength() + 1);
		setOpportunities(opportunities);		
		return SUCCESS;
	}

	@Action(value="OpportunityView", results={
			@Result(name="success",type="tiles",location="opportunity.tiles")
	})
	public String projectView() 
	{
		return SUCCESS;
	}
	public List<Opportunity> getOpportunities() {
		return opportunities;
	}


	public void setOpportunities(List<Opportunity> opportunities) {
		this.opportunities = opportunities;
	}




	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}
}
