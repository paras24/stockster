package com.impetus.ee.actions.project;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.services.api.project.ProjectService;
import com.impetus.ee.vo.ProjectInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@Component
@Scope("prototype")
@Namespace("/project")
@ResultPath(value="/")

public class RetrieveProjectAction extends ActionSupport implements ModelDriven{
	
	@Autowired
	private ProjectService projectService;
	private QueryParameterDTO queryParameterDTO = new QueryParameterDTO();
	private List<ProjectInfo> projectInfoList;

	public List<ProjectInfo> getProjectInfoList() {
		return projectInfoList;
	}

	public void setProjectInfoList(List<ProjectInfo> projectInfoList) {
		this.projectInfoList = projectInfoList;
	}

	@Action(value="listProject", results={
			@Result(name="success",type="json")
	})
	public String projectJson() 
	{
		setProjectInfoList(projectService.getProject("abc"));
		return SUCCESS;
	}
	
	@Action(value="ProjectView", results={
			@Result(name="success",type="tiles",location="project.tiles")
	})
	public String projectView() 
	{
		return SUCCESS;
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return queryParameterDTO;
	}
}
