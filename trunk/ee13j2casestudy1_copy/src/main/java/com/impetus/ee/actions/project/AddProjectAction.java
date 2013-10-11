package com.impetus.ee.actions.project;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.services.api.project.ProjectService;
import com.impetus.ee.vo.ProjectInfo;
import com.opensymphony.xwork2.ActionSupport;

@Component
@Scope("prototype")
@Namespace("/project")
@ResultPath(value="/")
public class AddProjectAction extends ActionSupport{
	
	@Autowired
	private ProjectService projectService;
	private ProjectInfo projectInfo;
	@Action(value="addProject", results={
			@Result(name="success",type="json")
	})
	public String addProject() 
	{
		
		projectService.addProject(projectInfo);
		
		return SUCCESS;
		
	}
	
	@Action(value="form", results={
			@Result(name="success",type="tiles",location="projectform.tiles")
	})
	public String projectForm() 
	{
		return SUCCESS;
	}	
	
	
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	

}
