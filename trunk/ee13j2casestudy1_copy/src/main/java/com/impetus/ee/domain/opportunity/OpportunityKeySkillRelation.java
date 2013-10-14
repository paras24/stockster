package com.impetus.ee.domain.opportunity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Table;
import javax.persistence.Transient;

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
