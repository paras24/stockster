package com.impetus.ee.util;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.vo.ProjectInfo;

public class ProjectMapperObject {
	
	
	public static ProjectInfo toProjectInfo(Project project)
	{
		ProjectInfo projectInfo=new ProjectInfo();
		projectInfo.setProjectId(project.getProjectId());
		projectInfo.setProjectName(project.getProjectName());
		projectInfo.setSubProjectName(project.getSubProjectName());
		projectInfo.setGroupHeadName(project.getGroupHeadName());
		projectInfo.setPointOfContact(project.getPointOfContact());
		projectInfo.setStatus(project.getStatus());
		projectInfo.setSupervisorName(project.getSupervisorName());
		projectInfo.setDateOfprojectAllocation(project.getDateOfprojectAllocation());
		projectInfo.setDateOfprojectDeallocation(project.getDateOfprojectDeallocation());
		projectInfo.setPercentAllocation(project.getPercentAllocation());
		
		return projectInfo;
		
	}
	
	public static Project toProject(ProjectInfo projectInfo)
	{
		Project project=new Project();
		project.setProjectId(projectInfo.getProjectId());
		project.setProjectName(projectInfo.getProjectName());
		project.setSubProjectName(projectInfo.getSubProjectName());
		project.setGroupHeadName(projectInfo.getGroupHeadName());
		project.setPointOfContact(projectInfo.getPointOfContact());
		project.setStatus(projectInfo.getStatus());
		project.setSupervisorName(projectInfo.getSupervisorName());
		project.setDateOfprojectAllocation(projectInfo.getDateOfprojectAllocation());
		project.setDateOfprojectDeallocation(projectInfo.getDateOfprojectDeallocation());
		project.setPercentAllocation(projectInfo.getPercentAllocation());
		return project;
		
	}

}
