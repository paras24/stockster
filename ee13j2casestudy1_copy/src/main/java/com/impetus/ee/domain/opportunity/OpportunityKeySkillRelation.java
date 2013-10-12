package com.impetus.ee.domain.opportunity;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.relation.AssociationOverride;
import com.impetus.ee.domain.relation.AssociationOverrides;
import com.impetus.ee.domain.relation.Column;
import com.impetus.ee.domain.relation.EmbeddedId;
import com.impetus.ee.domain.relation.Entity;
import com.impetus.ee.domain.relation.JoinColumn;
import com.impetus.ee.domain.relation.ProjectMemberRelationId;
import com.impetus.ee.domain.relation.Table;
import com.impetus.ee.domain.relation.Transient;
import com.impetus.ee.domain.teamMember.TeamMember;

@Entity
@Table(name = "Opportunity_keyskill")
@AssociationOverrides({
		@AssociationOverride(name = "relationKey.opportunity", 
			joinColumns = @JoinColumn(name = "opportunityID")),
		@AssociationOverride(name = "relationKey.skill", 
			joinColumns = @JoinColumn(name = "skillID")) })
public class OpportunityKeySkillRelation {

	private OpportunityKeySkillRelationId relationKey = new OpportunityKeySkillRelationId();
	
	@Column(name="type")
	private Integer type;
	

	@EmbeddedId
	public OpportunityKeySkillRelationId getRelationKey() {
		return relationKey;
	}
 
	public void setRelationKey(OpportunityKeySkillRelationId relationKey) {
		this.relationKey = relationKey;
	}
	
	@Transient
	public Opportunity getOpportunity() {
		return getRelationKey().getOpportunity();
	}
 
	public void setOpportunity(Opportunity opportunity) {
		getRelationKey().setOpportunity(opportunity);
	}
 
	@Transient
	public KeySkill getKeySkill() {
		return getRelationKey().getKeySkill();
	}
 
	public void setKeySkill(KeySkill keySkill) {
		getRelationKey().setKeySkill(keySkill);
	}
	

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
