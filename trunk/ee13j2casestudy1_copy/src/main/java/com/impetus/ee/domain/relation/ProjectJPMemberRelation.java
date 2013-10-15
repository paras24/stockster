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
import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
@Entity
@Table(name = "jpmember_project")
@AssociationOverrides({
		@AssociationOverride(name = "relationKey.joiningPipelineMember", 
			joinColumns = @JoinColumn(name = "jPmemberID")),
		@AssociationOverride(name = "relationKey.project", 
			joinColumns = @JoinColumn(name = "projectID")) })
public class ProjectJPMemberRelation {

	private ProjectJPMemberRelationId relationKey = new ProjectJPMemberRelationId();
	
	@Column(name="percentAllocation")
	private int percentAllocation;
	
	@Column(name="dateOfprojectAllocation")
	private Date dateOfprojectAllocation;
	
	@Column(name="dateOfprojectDeallocation")
	private Date dateOfprojectDeallocation;
	
	public ProjectJPMemberRelation() {
	}
 
	@EmbeddedId
	public ProjectJPMemberRelationId getRelationKey() {
		return relationKey;
	}
 
	public void setRelationKey(ProjectJPMemberRelationId relationKey) {
		this.relationKey = relationKey;
	}
 
	@Transient
	public JoiningPipelineMember getJoiningPipelineMember() {
		return getRelationKey().getJoiningPipelineMember();
	}
 
	public void setJoiningPipelineMember(JoiningPipelineMember joiningPipelineMember) {
		getRelationKey().setJoiningPipelineMember(joiningPipelineMember);
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
 
		ProjectJPMemberRelation that = (ProjectJPMemberRelation) o;
 
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
		return "ProjectJPMemberRelation [relationKey=" + relationKey
				+ ", percentAllocation=" + percentAllocation
				+ ", dateOfprojectAllocation=" + dateOfprojectAllocation
				+ ", dateOfprojectDeallocation=" + dateOfprojectDeallocation
				+ "]";
	}
}
