package com.impetus.ee.domain.project;

import java.sql.Date;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.impetus.ee.domain.relation.ProjectMemberRelation;

@Entity
@Table(name="Project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="projectID")
	private int projectId;
	@Column(name="projectName")
	private String projectName;
	@Column(name="groupHeadName")
	private String groupHeadName;
	@Column(name="subprojectName")
	private String subProjectName;
	@Column(name="pointOfContact")
	private String pointOfContact;
	@Column(name="supervisorName")
	private String supervisorName;
	@Column(name="percentAllocation")
	private int percentAllocation;
	@Column(name="status")
	private String status;
	@Column(name="dateOfprojectAllocation")
	private Date dateOfprojectAllocation;
	@Column(name="dateOfprojectDeallocation")
	private Date dateOfprojectDeallocation;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "relationKey.project")
	private Set<ProjectMemberRelation> projectMemberRelation = new HashSet<ProjectMemberRelation>(0);
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	
	public String getGroupHeadName() {
		return groupHeadName;
	}
	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
	}
	public String getSubProjectName() {
		return subProjectName;
	}
	public void setSubProjectName(String subProjectName) {
		this.subProjectName = subProjectName;
	}
	public String getPointOfContact() {
		return pointOfContact;
	}
	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}
	public String getSupervisorName() {
		return supervisorName;
	}
	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	public int getPercentAllocation() {
		return percentAllocation;
	}
	public void setPercentAllocation(int percentAllocation) {
		this.percentAllocation = percentAllocation;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDateOfprojectAllocation() {
		return dateOfprojectAllocation;
	}
	public void setDateOfprojectAllocation(Date dateOfprojectAllocation) {
		this.dateOfprojectAllocation = dateOfprojectAllocation;
	}
	public Date getDateOfprojectDeallocation() {
		return dateOfprojectDeallocation;
	}
	public void setDateOfprojectDeallocation(Date dateOfprojectDeallocation) {
		this.dateOfprojectDeallocation = dateOfprojectDeallocation;
	}
	
	public Set<ProjectMemberRelation> getProjectMemberRelation() {
		return projectMemberRelation;
	}
	public void setProjectMemberRelation(Set<ProjectMemberRelation> projectMemberRelation) {
		this.projectMemberRelation = projectMemberRelation;
	}
	
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName="
				+ projectName + ", groupHeadName=" + groupHeadName
				+ ", subProjectName=" + subProjectName + ", pointOfContact="
				+ pointOfContact + ", supervisorName=" + supervisorName
				+ ", percentAllocation=" + percentAllocation + ", status="
				+ status + ", dateOfprojectAllocation="
				+ dateOfprojectAllocation + ", dateOfprojectDeallocation="
				+ dateOfprojectDeallocation + "]";
	}
	
	

}
