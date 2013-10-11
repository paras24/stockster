package com.impetus.ee.persistence.api.project;

import java.util.List;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.exception.daoLayer.DBException;

public interface ProjectDAO 
{	
	void insertProject(Project project)throws DBException;
	
	void updateProject(Project project)throws DBException ;
	
	boolean deleteProjectById(int projectID)throws DBException ;
	
	List<Project> getProject(String groupHeadName) throws DBException;
	
	public Project getProjectByID(int projectId) throws DBException;
}
