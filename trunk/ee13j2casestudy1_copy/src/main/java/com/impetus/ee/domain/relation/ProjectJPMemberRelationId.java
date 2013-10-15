package com.impetus.ee.domain.relation;

import java.io.Serializable;

import javax.persistence.ManyToOne;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;

public class ProjectJPMemberRelationId implements Serializable {

	private JoiningPipelineMember joiningPipelineMember;
	private Project project;
	
	@ManyToOne
	public JoiningPipelineMember getJoiningPipelineMember() {
		return joiningPipelineMember;
	}

	public void setJoiningPipelineMember(JoiningPipelineMember joiningPipelineMember) {
		this.joiningPipelineMember = joiningPipelineMember;
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
 
        ProjectJPMemberRelationId that = (ProjectJPMemberRelationId) o;
 
        if (joiningPipelineMember != null ? !joiningPipelineMember.equals(that.joiningPipelineMember) : that.joiningPipelineMember != null) return false;
        if (project != null ? !project.equals(that.project) : that.project != null)
            return false;
 
        return true;
    }
 
    public int hashCode() {
        int result;
        result = (joiningPipelineMember != null ? joiningPipelineMember.hashCode() : 0);
        result = 31 * result + (project != null ? project.hashCode() : 0);
        return result;
    }

	
}
