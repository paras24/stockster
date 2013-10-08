package com.impetus.ee.services.impl.project;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.project.ProjectDAO;
import com.impetus.ee.services.api.project.ProjectService;
import com.impetus.ee.util.MemberObjectMapper;
import com.impetus.ee.util.ProjectMapperObject;
import com.impetus.ee.vo.ProjectInfo;
import com.impetus.ee.vo.TeamMemberInfo;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService{
	
	
	
	
	@Autowired
	private ProjectDAO projectDAO;
	public int addProject(ProjectInfo projectInfo) {
		Project project=ProjectMapperObject.toProject(projectInfo);
		
		try 
		{
					
			projectDAO.insertProject(project);
		}
		catch(DBException ex)
		{
			//System.out.println(ex.getCause());
			
		}
		if(project!=null)
		{	
			return project.getProjectId();
		}
		else
		{
		return (Integer) null;
		}
	}
	@Override
	public void updateProject(ProjectInfo projectInfo) {
		// TODO Auto-generated method stub
		Project project=ProjectMapperObject.toProject(projectInfo);
		try 
		{
					
			projectDAO.updateProject(project);
		}
		catch(DBException ex)
		{	
			//System.out.println(ex.getCause());
		}
		
		
	}
	@Override
	public List<ProjectInfo> getProject(String groupHeadName) {
		// TODO Auto-generated method stub
		List<ProjectInfo> projectList=new ArrayList<ProjectInfo>();
		try{
			List<Project> list=projectDAO.getProject(groupHeadName);
			
			Iterator<Project> itr=list.iterator();
			while(itr.hasNext())
			{
				Project project=(Project)itr.next();
				ProjectInfo projectInfo=ProjectMapperObject.toProjectInfo(project);
				projectList.add(projectInfo);
			}
		}
		catch(DBException ex)
		{	/*We need to add exception handing properly*/
			System.out.println(ex.getCause());
			
		}
		
		return projectList;
	}
	@Override
	public boolean removeProjectById(int projectID) {
		// TODO Auto-generated method stub
		boolean flag=false;
		try 
		{
			flag = projectDAO.deleteProjectById(projectID);
		} catch (DBException e) 
		{
			//System.out.println(e.getCause());
		}
		
		return flag;
	}
	@Override
	public ProjectInfo getProjectById(int projectId) {
		// TODO Auto-generated method stub
		ProjectInfo projectInfo=null;
		try 
		{
			Project project=projectDAO.getProjectByID(projectId);
			projectInfo=ProjectMapperObject.toProjectInfo(project);
		} catch (DBException e) 
		{
			e.printStackTrace();
			
		}
		return projectInfo;
	}

}
