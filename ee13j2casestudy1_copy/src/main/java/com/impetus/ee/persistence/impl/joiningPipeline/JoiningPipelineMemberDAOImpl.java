package com.impetus.ee.persistence.impl.joiningPipeline;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.Join;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.domain.relation.ProjectJPMemberRelation;
import com.impetus.ee.domain.relation.ProjectMemberRelation;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.joiningPipeline.JoiningPipelineMemberDAO;
import com.impetus.ee.util.JoiningPipelineMemberObjectMapper;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;

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
			{	System.out.println("Going to update now");
				trns=session.beginTransaction();			
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
				//jPMemberList=session.createQuery("from JoiningPipelineMember where supervisorName='"+supervisorName+"'").list();
				jPMemberList=session.createQuery("from JoiningPipelineMember").list();
				System.out.println("jPMemberList size:"+jPMemberList.size());
				/*Iterator<JoiningPipelineMember> itr = jPMemberList.iterator();
				while(itr.hasNext())
				{
					Set<ProjectJPMemberRelation> pmr=itr.next().getProjectJPMemberRelation();
					
					if(pmr!=null && pmr.size()>0)
					{	System.out.println("pmr size:"+pmr.size());
						System.out.println("pmr"+pmr);
						
					}	
					
				}	*/

			
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
			{
				System.out.println("inside here");
				session.createQuery("delete from JoiningPipelineMember where jpmemberID="+jPmemberID).executeUpdate();
				//session.delete(jPMember);
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
				System.out.println("JP Member Name:"+jPMember.getJpmemberName());
			}	
			catch(HibernateException e)
			{		
				throw new DBException("error in getting Joining Pipeline member by id",e);
			}
			finally
			{
				session.close();
			}		
						
			return jPMember;
			
	}
	public int addProjectForJoiningPipelineMember(int jPmemberId,ProjectJPMemberRelation projectJPMemberRelation) throws DBException {
		Transaction trns=null;
		Session session=null;
		JoiningPipelineMember joiningPipelineMember=null;
		try
		{	
			session=sessionFactory.openSession();
			trns=session.beginTransaction();
			if(projectJPMemberRelation!=null)
			{	Set<ProjectJPMemberRelation> projectJPMemberRelations=new HashSet<ProjectJPMemberRelation>();
				
				joiningPipelineMember = getjPMemberByID(jPmemberId);
				projectJPMemberRelation.setJoiningPipelineMember(joiningPipelineMember);
				projectJPMemberRelations.add(projectJPMemberRelation);
				joiningPipelineMember.setProjectJPMemberRelation(projectJPMemberRelations);
				session.saveOrUpdate(joiningPipelineMember);
				trns.commit();
			}
		}
		
		catch(HibernateException e)
		{
			
			if(trns!=null)
			{	
				trns.rollback();
			}
			throw new DBException("error in addProjectForJPMember insertion",e);
			
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
	
	@Override
	public List<JoiningPipelineMemberInfo> getJoiningPipelineMembers(QueryParameterDTO queryParameterDTO) 
	{
		String pageQuery="from JoiningPipelineMember where jpmemberName like '%"+queryParameterDTO.getSearchString()+"%' order by "+ queryParameterDTO.getSortColName()+" "+queryParameterDTO.getSortOrder()+"" ;
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query1= session.createQuery(pageQuery);
		query1.setMaxResults(queryParameterDTO.getDisplayLength());
		query1.setFirstResult(queryParameterDTO.getDisplayStart());
		System.out.println("Sunny");
		ArrayList<JoiningPipelineMember> jpMemberList=(ArrayList<JoiningPipelineMember>) query1.list();	
		System.out.println("Vijay");
		Iterator<JoiningPipelineMember> itr = jpMemberList.iterator();
		List<JoiningPipelineMemberInfo> jPMemberInfoList = new ArrayList<JoiningPipelineMemberInfo>();
		int i=0;
		while (itr.hasNext() && i != jpMemberList.size())
		{
			System.out.println("Inside");
			 JoiningPipelineMemberInfo x = new JoiningPipelineMemberInfo();
			 x = JoiningPipelineMemberObjectMapper.toJoiningPipelineMemberInfo(jpMemberList.get(i));
			 jPMemberInfoList.add(x);
		}
		
		List<BigInteger> totalDisplayRecords =session.createSQLQuery("select count(*) from JoiningPipelineMembers where jpmemberName like '%"+queryParameterDTO.getSearchString()+"%'").list();
		List<BigInteger> totalRecords = session.createSQLQuery("select count(*) from JoiningPipelineMembers").list();
		queryParameterDTO.setTotalRecords((totalRecords.get(0)).intValue());
		queryParameterDTO.setTotalDisplayRecords((totalDisplayRecords.get(0)).intValue());
		return jPMemberInfoList;
	}	
	
}
