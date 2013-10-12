package com.impetus.ee.domain.opportunity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.impetus.ee.domain.DomainObject;
import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.relation.ProjectMemberRelation;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.domain.user.ManyToOne;

@Entity
@Table(name="Opportunity")
public class Opportunity extends DomainObject{
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="Id")
private Integer id;

@OneToOne
@JoinColumn(name="Project_Id")
private Project project;

@Column(name="Sub_Project_Name")
private Integer subprojectName;

@OneToOne
@JoinColumn(name="ContactPoint_Id")
private TeamMember contactPoint;

@Column(name="RequestDt")
private Date requestDate;

@Column(name="People_Required_Count")
private Integer peopleRequiredCount;

@ManyToOne(fetch=FetchType.EAGER)
@JoinColumn(name="Loc_Id")
private Location location;


private Date startDateOfResources;

@Column(name="Work_Duration")
private Integer durationUpto;

@Column(name="requirementType")
private Integer requirementType;

@Column(name="requirementStatus")
private Integer requirementStatus;

@OneToMany(mappedBy="opportunity", cascade=CascadeType.ALL)  
private Set<OpportunityRemarks> opportunityRemarks;


@OneToMany(fetch = FetchType.LAZY, mappedBy = "relationKey.opportunity")
private Set<OpportunityKeySkillRelation> opportunityKeySkillRelation = new HashSet<OpportunityKeySkillRelation>(0);

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Project getProject() {
	return project;
}

public void setProject(Project project) {
	this.project = project;
}

public Integer getSubprojectName() {
	return subprojectName;
}

public void setSubprojectName(Integer subprojectName) {
	this.subprojectName = subprojectName;
}

public TeamMember getContactPoint() {
	return contactPoint;
}

public void setContactPoint(TeamMember contactPoint) {
	this.contactPoint = contactPoint;
}

public Date getRequestDate() {
	return requestDate;
}

public void setRequestDate(Date requestDate) {
	this.requestDate = requestDate;
}

public Integer getPeopleRequiredCount() {
	return peopleRequiredCount;
}

public void setPeopleRequiredCount(Integer peopleRequiredCount) {
	this.peopleRequiredCount = peopleRequiredCount;
}

public Location getLocation() {
	return location;
}

public void setLocation(Location location) {
	this.location = location;
}

public Date getStartDateOfResources() {
	return startDateOfResources;
}

public void setStartDateOfResources(Date startDateOfResources) {
	this.startDateOfResources = startDateOfResources;
}

public Integer getDurationUpto() {
	return durationUpto;
}

public void setDurationUpto(Integer durationUpto) {
	this.durationUpto = durationUpto;
}

public Integer getRequirementType() {
	return requirementType;
}

public void setRequirementType(Integer requirementType) {
	this.requirementType = requirementType;
}

public Integer getRequirementStatus() {
	return requirementStatus;
}

public void setRequirementStatus(Integer requirementStatus) {
	this.requirementStatus = requirementStatus;
}

public Set<OpportunityRemarks> getOpportunityRemarks() {
	return opportunityRemarks;
}

public void setOpportunityRemarks(Set<OpportunityRemarks> opportunityRemarks) {
	this.opportunityRemarks = opportunityRemarks;
}

public Set<OpportunityKeySkillRelation> getOpportunityKeySkillRelation() {
	return opportunityKeySkillRelation;
}

public void setOpportunityKeySkillRelation(
		Set<OpportunityKeySkillRelation> opportunityKeySkillRelation) {
	this.opportunityKeySkillRelation = opportunityKeySkillRelation;
}



}
