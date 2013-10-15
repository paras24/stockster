package com.impetus.ee.actions.project;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.ee.services.api.project.ProjectService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteProjectAction extends ActionSupport{
	
	@Autowired
	private ProjectService projectService;
	private int projectID;
	@Action(value="deleteProject", results={
			@Result(name="success",type="json")
	})
	public String deleteProject() 
	{
		
		projectService.removeProjectById(projectID);
		
		return SUCCESS;
	}
	
	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

}
