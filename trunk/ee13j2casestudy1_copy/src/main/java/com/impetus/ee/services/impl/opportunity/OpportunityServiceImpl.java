package com.impetus.ee.services.impl.opportunity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.opportunity.Opportunity;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.persistence.api.opportunity.OpportunityDAO;
import com.impetus.ee.persistence.api.user.UserDAO;
import com.impetus.ee.services.api.opportunity.OpportunityService;

@Service("OpportunityService")
public class OpportunityServiceImpl implements OpportunityService {

	@Autowired
	private OpportunityDAO opportunityDAO;
	
	public List<Opportunity> getOpportunities(QueryParameterDTO queryParameterDTO) {
		return opportunityDAO.getOpportunities(queryParameterDTO);
	}

}
