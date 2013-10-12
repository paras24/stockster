package com.impetus.ee.domain.opportunity;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.teamMember.TeamMember;


public class OpportunityKeySkillRelationId implements Serializable{
	
	private Opportunity opportunity;
	private KeySkill keySkill;

	@ManyToOne
	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	@ManyToOne
	public KeySkill getKeySkill() {
		return keySkill;
	}

	public void setKeySkill(KeySkill keySkill) {
		this.keySkill = keySkill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((keySkill == null) ? 0 : keySkill.hashCode());
		result = prime * result
				+ ((opportunity == null) ? 0 : opportunity.hashCode());
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
		OpportunityKeySkillRelationId other = (OpportunityKeySkillRelationId) obj;
		if (keySkill == null) {
			if (other.keySkill != null)
				return false;
		} else if (!keySkill.equals(other.keySkill))
			return false;
		if (opportunity == null) {
			if (other.opportunity != null)
				return false;
		} else if (!opportunity.equals(other.opportunity))
			return false;
		return true;
	}

	
	
}
