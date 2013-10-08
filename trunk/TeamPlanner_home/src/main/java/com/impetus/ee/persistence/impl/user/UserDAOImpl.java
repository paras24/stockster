package com.impetus.ee.persistence.impl.user;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.user.Role;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.persistence.api.user.UserDAO;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public User getUser(String userName) 
	{
		User user=((User)getCurrentSession().createQuery("from User where username='"+userName+"'").uniqueResult());
		return user;
	}

	public Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<User> getUsers() 
	{
		List<User> users = (List<User>)getCurrentSession().createQuery("from User").list();
		return users;
	}

	@Override
	public void deleteUser(int userID) 
	{
		getCurrentSession().createQuery("delete from User where userID="+userID).executeUpdate();		
	}

	@Override
	public void addUser(User user) 
	{
		getCurrentSession().merge(user);
	}

	public Role getRole(String roleName) 
	{
		Role role = (Role)getCurrentSession().createQuery("from Role where roleName='"+roleName+"'").uniqueResult();
		return role;
	}

	@Override
	public List<User> getUsers(QueryParameterDTO queryParameterDTO) 
	{
		String pageQuery="from User where username like '%"+queryParameterDTO.getSearchString()+"%' order by "+ queryParameterDTO.getSortColName()+" "+queryParameterDTO.getSortOrder()+"" ;
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.Query query1= session.createQuery(pageQuery);
		query1.setMaxResults(queryParameterDTO.getDisplayLength());
		query1.setFirstResult(queryParameterDTO.getDisplayStart());
		ArrayList<User> userList=(ArrayList<User>) query1.list();		
		List<BigInteger> totalDisplayRecords =session.createSQLQuery("select count(*) from users where username like '%"+queryParameterDTO.getSearchString()+"%'").list();
		List<BigInteger> totalRecords = session.createSQLQuery("select count(*) from users").list();
		queryParameterDTO.setTotalRecords((totalRecords.get(0)).intValue());
		queryParameterDTO.setTotalDisplayRecords((totalDisplayRecords.get(0)).intValue());
		return userList;
	}	
}
