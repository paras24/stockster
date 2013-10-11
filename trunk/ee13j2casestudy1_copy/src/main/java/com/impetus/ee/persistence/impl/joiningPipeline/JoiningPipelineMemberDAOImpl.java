package com.impetus.ee.persistence.impl.joiningPipeline;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Join;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.joiningPipeline.JoiningPipelineMemberDAO;

@Repository("JoiningPipelineMemberDAO")
public class JoiningPipelineMemberDAOImpl implements JoiningPipelineMemberDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertJoiningPipelineMember(JoiningPipelineMember jPMember) throws DBException 
	{
		Transaction trns=null;
		Session session=null;
		try
		{	
			session=sessionFactory.openSession();
			trns=session.beginTransaction();
			if(jPMember!=null)
			{	
				session.saveOrUpdate(jPMember);				
				trns.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("error in Joining Pipeline Member insertion",e);
			
		}
		finally
		{
			if(session!=null)
			{	
				session.close();
			}
		}
		
	}

	
	public void updateJoiningPipelineMember(JoiningPipelineMember jPMember) throws DBException 
	{
		Session session=null;
		Transaction trns=null;
		try
		{	session=sessionFactory.openSession();
			if(jPMember!=null)
			{	
				trns=session.beginTransaction();
				
			
				session.update(jPMember);
				trns.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("Error in update joining pipeline member",e);
			
		}
		finally
		{
			
			if(session!=null)
			{	
				session.close();
			}
			
		}
		
	}

	public List<JoiningPipelineMember> getJoiningPipelineMemberBySupervisorName(String supervisorName) throws DBException
	{
		
		List<JoiningPipelineMember> jPMemberList=new ArrayList<JoiningPipelineMember>();
		
		Session session =  null;
		
		try{
				session =  sessionFactory.openSession();
				jPMemberList=session.createQuery("from JoiningPipelineMember where supervisorName='"+supervisorName+"'").list();
			
			}
		catch(HibernateException e)
		{	
			throw new DBException("DB exception while retrieving joining Pipeline member");
		}
		finally
		{
			session.close();
		}
				
		return jPMemberList;		
		
	}
	public boolean removeJoiningPipelineMemberByID(int jPmemberID) throws DBException
	{
		Session session=null;
		Transaction trns=null;
		try
		{
			session=sessionFactory.openSession();
			trns=session.beginTransaction();
			
			JoiningPipelineMember jPMember=(JoiningPipelineMember)session.get(JoiningPipelineMember.class, jPmemberID);
			if(jPMember!=null)
			{	session.delete(jPMember);
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
	
	
	public JoiningPipelineMember getjPMemberByID(int jPmemberId) throws DBException
	{
			Session session =  null;
			JoiningPipelineMember jPMember=null;
			try
			{
				session =  sessionFactory.openSession();
				jPMember=(JoiningPipelineMember)session.get(JoiningPipelineMember.class, jPmemberId);			
				
			}	
			catch(HibernateException e)
			{
				
				
				throw new DBException("error in getting tem member by id",e);
			}
			finally
			{
				session.close();
			}		
						
			return jPMember;
			
	}
}
