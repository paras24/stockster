package com.impetus.ee.domain.relation;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.teamMember.TeamMember;


public class ProjectMemberRelationId implements Serializable{
	
	private TeamMember teamMember;
	private Project project;
	
	@ManyToOne
	public TeamMember getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(TeamMember teamMember) {
		this.teamMember = teamMember;
	}
	@ManyToOne
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
 
        ProjectMemberRelationId that = (ProjectMemberRelationId) o;
 
        if (teamMember != null ? !teamMember.equals(that.teamMember) : that.teamMember != null) return false;
        if (project != null ? !project.equals(that.project) : that.project != null)
            return false;
 
        return true;
    }
 
    public int hashCode() {
        int result;
        result = (teamMember != null ? teamMember.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }

	
}
