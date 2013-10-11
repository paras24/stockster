package com.impetus.ee.persistence.impl.project;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.project.ProjectDAO;

@Repository("ProjectDAO")
public class ProjectDAOImpl implements ProjectDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public void insertProject(Project project) throws DBException {
		// TODO Auto-generated method stub
		Transaction transaction=null;
		Session session=null;
		try
		{	
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			if(project!=null)
			{	
				session.saveOrUpdate(project);
				
				transaction.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(transaction!=null)
			{	
				transaction.rollback();
			}
			throw new DBException("error in project insertion",e);
			
		}
		finally
		{
			if(session!=null)
			{	
				session.close();
			}
		}
		

	}

	@Override
	public void updateProject(Project project) throws DBException {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction trns=null;
		try
		{	session=sessionFactory.openSession();
			if(project!=null)
			{	
				trns=session.beginTransaction();
				
			
				session.update(project);
				trns.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("Error in update project",e);
			
		}
		finally
		{
			
			if(session!=null)
			{	
				session.close();
			}
			
		}

	}

	@Override
	public boolean deleteProjectById(int projectID) throws DBException {
		// TODO Auto-generated method stub
		Session session=null;
		Transaction trns=null;
		try
		{
			session=sessionFactory.openSession();
			trns=session.beginTransaction();
			
			Project project=(Project)session.get(Project.class, projectID);
			if(project!=null)
			{	session.delete(project);
				trns.commit();
				return true;
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("error in project deletion",e);
			
		}
		finally
		{
			
			if(session!=null)
			{	
				session.close();
			}
			
		}
		
		return false;
	}
	
	

	@Override
	public List<Project> getProject(String groupHeadName) throws DBException {
		// TODO Auto-generated method stub
List<Project> projectList=new ArrayList<Project>();
		
		Session session =  null;
		
		try{
				session =  sessionFactory.openSession();
				projectList=session.createQuery("from Project where groupHeadName='"+groupHeadName+"'").list();
				
			}
		catch(HibernateException e)
		{
			
			throw new DBException("DB exception while retrieving Project",e);
		}
		finally
		{
			session.close();
		}
		
		
		
		return projectList;
		
		
	}

	@Override
	public Project getProjectByID(int projectId) throws DBException {
		// TODO Auto-generated method stub
		Session session =  null;
		Project project=null;
		try
		{
			session =  sessionFactory.openSession();
			project=(Project)session.get(Project.class,projectId);
			
			
		}	
		catch(HibernateException e)
		{
			
			
			throw new DBException("error in getting project by id",e);
		}
		finally
		{
			session.close();
		}
		
		
		
		return project;
	}

}
