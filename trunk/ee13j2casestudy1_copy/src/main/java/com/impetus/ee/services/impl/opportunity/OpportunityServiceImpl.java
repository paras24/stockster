package com.impetus.ee.services.impl.opportunity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.opportunity.Opportunity;
import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.opportunity.OpportunityDAO;
import com.impetus.ee.persistence.api.user.UserDAO;
import com.impetus.ee.services.api.opportunity.OpportunityService;
import com.impetus.ee.util.OpportunityObjectMapper;
import com.impetus.ee.util.ProjectMapperObject;
import com.impetus.ee.vo.OpportunityInfo;
import com.impetus.ee.vo.ProjectInfo;

@Service("OpportunityService")
public class OpportunityServiceImpl implements OpportunityService {

	@Autowired
	private OpportunityDAO opportunityDAO;
	
	public List<OpportunityInfo> getOpportunities(QueryParameterDTO queryParameterDTO) {
		
		//return opportunityDAO.getOpportunities(queryParameterDTO);
		
		List<OpportunityInfo> opportunityInfos = new ArrayList<OpportunityInfo>();
		List<Opportunity> list= opportunityDAO.getOpportunities(queryParameterDTO);
		
		Iterator<Opportunity> itr=list.iterator();
		while(itr.hasNext())
		{
			Opportunity opportunity =(Opportunity)itr.next();
			OpportunityInfo opportunityInfo = OpportunityObjectMapper.toOpportunityInfo(opportunity);
			opportunityInfos.add(opportunityInfo);
		}
		
		return opportunityInfos;
	}

}
