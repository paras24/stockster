package com.impetus.ee.domain.opportunity;
import java.sql.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.teamMember.TeamMember;
@Entity
@Table(name = "member_project")
@AssociationOverrides({
		@AssociationOverride(name = "relationKey.opportunity", 
			joinColumns = @JoinColumn(name = "opportunityID")),
		@AssociationOverride(name = "relationKey.teamMember", 
			joinColumns = @JoinColumn(name = "teamMemberID")) })
public class OpportunityMemberRelation {

	private OpportunityMemberRelationId relationKey = new OpportunityMemberRelationId();
	
		
	
	@EmbeddedId
	public OpportunityMemberRelationId getRelationKey() {
		return relationKey;
	}
 
	public void setRelationKey(OpportunityMemberRelationId relationKey) {
		this.relationKey = relationKey;
	}
 
	@Transient
	public TeamMember getTeamMember() {
		return getRelationKey().getTeamMember();
	}
 
	public void setTeamMember(TeamMember teamMember) {
		getRelationKey().setTeamMember(teamMember);
	}
 
	@Transient
	public Opportunity getOpportunity() {
		return getRelationKey().getOpportunity();
	}
 
	public void setOpportunity(Opportunity opportunity) {
		getRelationKey().setOpportunity(opportunity);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((relationKey == null) ? 0 : relationKey.hashCode());
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
		OpportunityMemberRelation other = (OpportunityMemberRelation) obj;
		if (relationKey == null) {
			if (other.relationKey != null)
				return false;
		} else if (!relationKey.equals(other.relationKey))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpportunityMemberRelation [relationKey=" + relationKey + "]";
	}
	
	

}
