package com.impetus.ee.services.api.project;

import java.util.List;

import com.impetus.ee.vo.ProjectInfo;



public interface ProjectService {
	
		int addProject(ProjectInfo  projectInfo);
		
	    void updateProject(ProjectInfo projectInfo);
		
		List<ProjectInfo> getProject(String groupHeadName);
		
		boolean removeProjectById(int projectId);
		
		ProjectInfo getProjectById(int projectId);

}
