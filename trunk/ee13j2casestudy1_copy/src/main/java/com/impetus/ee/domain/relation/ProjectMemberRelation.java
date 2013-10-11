package com.impetus.ee.domain.relation;
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
		@AssociationOverride(name = "relationKey.teamMember", 
			joinColumns = @JoinColumn(name = "memberID")),
		@AssociationOverride(name = "relationKey.project", 
			joinColumns = @JoinColumn(name = "projectID")) })
public class ProjectMemberRelation {

	private ProjectMemberRelationId relationKey = new ProjectMemberRelationId();
	
	@Column(name="percentAllocation")
	private int percentAllocation;
	
	@Column(name="dateOfprojectAllocation")
	private Date dateOfprojectAllocation;
	
	@Column(name="dateOfprojectDeallocation")
	private Date dateOfprojectDeallocation;
	
	public ProjectMemberRelation() {
	}
 
	@EmbeddedId
	public ProjectMemberRelationId getRelationKey() {
		return relationKey;
	}
 
	public void setRelationKey(ProjectMemberRelationId relationKey) {
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
	public Project getProject() {
		return getRelationKey().getProject();
	}
 
	public void setProject(Project project) {
		getRelationKey().setProject(project);
	}
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
 
		ProjectMemberRelation that = (ProjectMemberRelation) o;
 
		if (getRelationKey() != null ? !getRelationKey().equals(that.getRelationKey())
				: that.getRelationKey() != null)
			return false;
 
		return true;
	}
 
	public int hashCode() {
		return (getRelationKey() != null ? getRelationKey().hashCode() : 0);
	}

	public int getPercentAllocation() {
		return percentAllocation;
	}

	public void setPercentAllocation(int percentAllocation) {
		this.percentAllocation = percentAllocation;
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

	@Override
	public String toString() {
		return "ProjectMemberRelation [relationKey=" + relationKey
				+ ", percentAllocation=" + percentAllocation
				+ ", dateOfprojectAllocation=" + dateOfprojectAllocation
				+ ", dateOfprojectDeallocation=" + dateOfprojectDeallocation
				+ "]";
	}
}
