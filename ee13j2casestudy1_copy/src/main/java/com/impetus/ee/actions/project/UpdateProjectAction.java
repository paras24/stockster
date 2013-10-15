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
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;


@Component
@Scope("prototype")
@Namespace("/project")
@ResultPath(value="/")
public class UpdateProjectAction extends ActionSupport{
	
	@Autowired
	private ProjectService projectService;
	private ProjectInfo projectInfo;
	private String projectName;
	private String groupHeadName;
	private String subProjectName;
	private String pointOfContact;
	private String supervisorName;
	
	@Action(value="updateProject", results={
			@Result(name="success",type="tiles",location="project.tiles")
			//@Result(name=INPUT,type="tiles",location="projectform.tiles")
	})
	public String updateProject() 
	{
		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setProjectName(projectName);
		projectInfo.setSubProjectName(subProjectName);
		projectInfo.setGroupHeadName(groupHeadName);
		projectInfo.setPointOfContact(pointOfContact);
		projectInfo.setSupervisorName(supervisorName);
		projectService.updateProject(projectInfo);
		
		return SUCCESS;
		
	}
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	
	
	@RequiredStringValidator(trim=true,message="Project Name is required.")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@RequiredStringValidator(trim=true,message="Group Head is required.")
	public String getGroupHeadName() {
		return groupHeadName;
	}

	public void setGroupHeadName(String groupHeadName) {
		this.groupHeadName = groupHeadName;
	}

	@RequiredStringValidator(trim=true,message="Sub Project Name is required.")
	public String getSubProjectName() {
		return subProjectName;
	}

	public void setSubProjectName(String subProjectName) {
		this.subProjectName = subProjectName;
	}

	@RequiredStringValidator(trim=true,message="Point of Contact is required.")
	public String getPointOfContact() {
		return pointOfContact;
	}

	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}
	
	@RequiredStringValidator(trim=true,message="Supervisor Name is required.")
	public String getSupervisorName() {
		return supervisorName;
	}

	public void setSupervisorName(String supervisorName) {
		this.supervisorName = supervisorName;
	}
	

}
