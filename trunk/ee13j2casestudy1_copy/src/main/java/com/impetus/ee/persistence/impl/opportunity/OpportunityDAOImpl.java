package com.impetus.ee.persistence.impl.opportunity;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.opportunity.Opportunity;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.persistence.api.opportunity.OpportunityDAO;

@Repository("OpportunityDAO")
public class OpportunityDAOImpl implements OpportunityDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	public List<Opportunity> getOpportunities(QueryParameterDTO queryParameterDTO) {
				//order by "+ queryParameterDTO.getSortColName()+" "+queryParameterDTO.getSortOrder()+"" ;
		ArrayList<Opportunity> opportunityList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			org.hibernate.Query query= session.createQuery("from Opportunity");
			//query.setMaxResults(queryParameterDTO.getDisplayLength());
			//query.setFirstResult(queryParameterDTO.getDisplayStart());
			opportunityList=(ArrayList<Opportunity>) query.list();		
			List<BigInteger> totalRecords = session.createSQLQuery("select count(*) from Opportunity").list();
			queryParameterDTO.setTotalRecords((totalRecords.get(0)).intValue());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return opportunityList;
	}

}
