package com.impetus.ee.persistence.api.opportunity;

import java.util.List;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.opportunity.Opportunity;
import com.impetus.ee.domain.user.User;

public interface OpportunityDAO {
	List<Opportunity> getOpportunities(QueryParameterDTO queryParameterDTO);
}
