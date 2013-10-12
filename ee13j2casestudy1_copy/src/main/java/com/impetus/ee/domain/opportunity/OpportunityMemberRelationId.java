package com.impetus.ee.domain.opportunity;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.teamMember.TeamMember;


public class OpportunityMemberRelationId implements Serializable{
	
	private Opportunity opportunity;
	private TeamMember teamMember;
	
	@ManyToOne
	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}

	@ManyToOne
	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opportunity == null) ? 0 : opportunity.hashCode());
		result = prime * result
				+ ((teamMember == null) ? 0 : teamMember.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpportunityMemberRelationId other = (OpportunityMemberRelationId) obj;
		if (opportunity == null) {
			if (other.opportunity != null)
				return false;
		} else if (!opportunity.equals(other.opportunity))
			return false;
		if (teamMember == null) {
			if (other.teamMember != null)
				return false;
		} else if (!teamMember.equals(other.teamMember))
			return false;
		return true;
	}
	
	
	
	
	


	
}
