package com.impetus.ee.services.project;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.services.api.project.ProjectService;
import com.impetus.ee.vo.ProjectInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Test-applicationContext.xml" })
@Transactional
public class TestProjectService {

	@Autowired
	private ProjectService projectService;
	
	private ProjectInfo getProjectInfo()
	{
		ProjectInfo projectInfo=new ProjectInfo();
		projectInfo.setProjectName("BigData");
		projectInfo.setSubProjectName("Jumbune");
		projectInfo.setGroupHeadName("abc");
		projectInfo.setSupervisorName("def");
		projectInfo.setPointOfContact("fij");
		projectInfo.setPercentAllocation(40);
		return projectInfo;
		
	}
	public void setProjectService(ProjectService projectService)
	{
		this.projectService = projectService;
	}

	
	public ProjectService getProjectService()
	{
		return projectService;
	}
	@Test
	public void testAddProject()
	{
		ProjectInfo projectInfo=getProjectInfo();
		int projectID=getProjectService().addProject(projectInfo);
		assertNotNull(projectID);
	}
	
	@Test
	public void testUpdateProject()
	{	int projectID=getProjectService().addProject(getProjectInfo());
		ProjectInfo projectInfo=getProjectService().getProjectById(projectID);
		if(projectInfo!=null)
		{
			projectInfo.setProjectName("wxy");
			projectInfo.setGroupHeadName("quz");
			getProjectService().updateProject(projectInfo);
			assertTrue(!"abc".equalsIgnoreCase(projectInfo.getProjectName()));
		}
		
	}
	@Test
	public void testProjectRetrieval()
	{
		List<ProjectInfo> projectList=getProjectService().getProject("abc");
		
		assertFalse(projectList.isEmpty());
		
	}
	
	@Test
	public void testProjectDeletion()
	{
		int projectID=getProjectService().addProject(getProjectInfo());
		boolean flag=getProjectService().removeProjectById(projectID);
		
		assertTrue(flag);
		
	}
}
