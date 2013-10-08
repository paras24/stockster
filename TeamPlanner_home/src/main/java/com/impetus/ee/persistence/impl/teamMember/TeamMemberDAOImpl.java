package com.impetus.ee.persistence.impl.teamMember;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ee.domain.relation.ProjectMemberRelation;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.teamMember.TeamMemberDAO;

@Repository("TeamMemberDAO")
public class TeamMemberDAOImpl implements TeamMemberDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertTeamMember(TeamMember teamMember) throws DBException 
	{
		Transaction trns=null;
		Session session=null;
		try
		{	
			session=sessionFactory.openSession();
			trns=session.beginTransaction();
			if(teamMember!=null)
			{	
				session.saveOrUpdate(teamMember);
				
				trns.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("error in teamMember insertion",e);
			
		}
		finally
		{
			if(session!=null)
			{	
				session.close();
			}
		}
		
	}

	
	public void updateTeamMember(TeamMember teamMember) throws DBException 
	{
		Session session=null;
		Transaction trns=null;
		try
		{	session=sessionFactory.openSession();
			if(teamMember!=null)
			{	
				trns=session.beginTransaction();
				
			
				session.update(teamMember);
				trns.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("Error in update team member",e);
			
		}
		finally
		{
			
			if(session!=null)
			{	
				session.close();
			}
			
		}
		
	}

	public List<TeamMember> getTeamMemberByGroupHeadName(String groupHeadName) throws DBException
	{
		
		List<TeamMember> teamMemberList=new ArrayList<TeamMember>();
		
		Session session =  null;
		
		try{
				session =  sessionFactory.openSession();
				teamMemberList=session.createQuery("from TeamMember where groupHeadName='"+groupHeadName+"'").list();
				System.out.println("teamMemberList size:"+teamMemberList.size());
				Iterator<TeamMember> itr = teamMemberList.iterator();
				while(itr.hasNext())
				{
					Set<ProjectMemberRelation> pmr=itr.next().getProjectMemberRelation();
					
					if(pmr!=null && pmr.size()>0)
					{	System.out.println("pmr size:"+pmr.size());
						System.out.println("pmr"+pmr);
						
					}	
					
				}	
				
			}
		catch(HibernateException e)
		{
			
			throw new DBException("DB exception while retrieving team member",e);
		}
		finally
		{
			session.close();
		}
		
		
		
		return teamMemberList;
		
		
		
	}
	public TeamMember getTeamMemberByID(Long memberId) throws DBException
	{
		
		Session session =  null;
		TeamMember teamMember=null;
		try
		{
			session =  sessionFactory.openSession();
			teamMember=(TeamMember)session.get(TeamMember.class, memberId);
			
			
		}	
		catch(HibernateException e)
		{
			
			
			throw new DBException("error in getting tem member by id",e);
		}
		finally
		{
			session.close();
		}
		
		
		
		return teamMember;
		
	}
	public boolean deleteTeamMemberById(Long memberId) throws DBException 
	{
		
			
			Session session=null;
			Transaction trns=null;
			try
			{
				session=sessionFactory.openSession();
				trns=session.beginTransaction();
				
				TeamMember teamMember=(TeamMember)session.get(TeamMember.class, memberId);
				if(teamMember!=null)
				{	session.delete(teamMember);
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
				throw new DBException("error in deletion",e);
				
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
	public int addProjectForTeamMember(long memberId,ProjectMemberRelation projectMemberRelation) throws DBException {
		Transaction trns=null;
		Session session=null;
		TeamMember teamMember=null;
		try
		{	
			session=sessionFactory.openSession();
			trns=session.beginTransaction();
			if(projectMemberRelation!=null)
			{	Set<ProjectMemberRelation> projectMemberRelations=new HashSet<ProjectMemberRelation>();
				
				teamMember = getTeamMemberByID(memberId);
				projectMemberRelation.setTeamMember(teamMember);
				projectMemberRelations.add(projectMemberRelation);
				teamMember.setProjectMemberRelation(projectMemberRelations);
				session.saveOrUpdate(teamMember);
				trns.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("error in addProjectForTeamMember insertion",e);
			
		}
		finally
		{
			if(session!=null)
			{	
				session.close();
			}
		}
		return 0;
	}	
	

}
