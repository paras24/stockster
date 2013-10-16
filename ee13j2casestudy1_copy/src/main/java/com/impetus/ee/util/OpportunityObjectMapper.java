package com.impetus.ee.util;

import com.impetus.ee.domain.opportunity.Opportunity;
import com.impetus.ee.domain.project.Project;
import com.impetus.ee.vo.OpportunityInfo;
import com.impetus.ee.vo.ProjectInfo;

public class OpportunityObjectMapper {
	public static OpportunityInfo toOpportunityInfo(Opportunity opportunity)
	{
		OpportunityInfo opportunityInfo = new OpportunityInfo();
		opportunityInfo.setOpportunityID(opportunity.getOpportunityID());
		opportunityInfo.setProjectName(opportunity.getProject().getProjectName());
		opportunityInfo.setSubProjectname(opportunity.getSubprojectName());
		opportunityInfo.setPointOfContact(opportunity.getContactPoint());
		opportunityInfo.setRequestDate(opportunity.getRequestDate());
		opportunityInfo.setRequirement(opportunity.getPeopleRequiredCount());
		opportunityInfo.setLocation(opportunity.getLocation().getLocName());
		opportunityInfo.setStartdate(opportunity.getStartDateOfResources());
		opportunityInfo.setDuration(opportunity.getDuration());
		opportunityInfo.setType(opportunity.getRequirementType());
		opportunityInfo.setStatus(opportunity.getRequirementStatus());
		return opportunityInfo;
		
		
	}
	
	public static Opportunity toOpportunity(OpportunityInfo opportunityInfo)
	{
		Opportunity opportunity = new Opportunity();
		
		return opportunity;
		
	}
}
