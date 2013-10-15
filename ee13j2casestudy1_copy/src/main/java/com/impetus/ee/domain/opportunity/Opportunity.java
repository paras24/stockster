package com.impetus.ee.domain.opportunity;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.impetus.ee.domain.DomainObject;
import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.teamMember.TeamMember;

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
private String subprojectName;

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

@Column(name="start_Date_Of_Resources")
private Date startDateOfResources;

@Column(name="Work_Duration")
private Integer duration;

@Column(name="requirementType")
private String requirementType;

@Column(name="requirementStatus")
private String requirementStatus;

@OneToMany(mappedBy="opportunity", cascade=CascadeType.ALL)  
private Set<OpportunityRemarks> opportunityRemarks;


@Column(name="primary_keyskills")
private String primaryKeyskills;

@Column(name="secondary_keyskills")
private String secondaryKeyskills;

@OneToMany(fetch = FetchType.LAZY, mappedBy = "relationKey.opportunity",cascade=CascadeType.ALL)
private Set<OpportunityMemberRelation> opportunityMemberRelation = new HashSet<OpportunityMemberRelation>(0);

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

public String getSubprojectName() {
	return subprojectName;
}

public void setSubprojectName(String subprojectName) {
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

public Integer getDuration() {
	return duration;
}

public void setDuration(Integer duration) {
	this.duration = duration;
}

public String getRequirementType() {
	return requirementType;
}

public void setRequirementType(String requirementType) {
	this.requirementType = requirementType;
}

public String getRequirementStatus() {
	return requirementStatus;
}

public void setRequirementStatus(String requirementStatus) {
	this.requirementStatus = requirementStatus;
}

public Set<OpportunityRemarks> getOpportunityRemarks() {
	return opportunityRemarks;
}

public void setOpportunityRemarks(Set<OpportunityRemarks> opportunityRemarks) {
	this.opportunityRemarks = opportunityRemarks;
}

public void setPrimaryKeyskills(String primaryKeyskills) {
	this.primaryKeyskills = primaryKeyskills;
}

public String getPrimaryKeyskills() {
	return primaryKeyskills;
}

public void setSecondaryKeyskills(String secondaryKeyskills) {
	this.secondaryKeyskills = secondaryKeyskills;
}

public String getSecondaryKeyskills() {
	return secondaryKeyskills;
}

public void setOpportunityMemberRelation(Set<OpportunityMemberRelation> opportunityMemberRelation) {
	this.opportunityMemberRelation = opportunityMemberRelation;
}

public Set<OpportunityMemberRelation> getOpportunityMemberRelation() {
	return opportunityMemberRelation;
}



}
