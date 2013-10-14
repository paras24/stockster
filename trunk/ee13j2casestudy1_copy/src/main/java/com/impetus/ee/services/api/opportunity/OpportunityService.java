package com.impetus.ee.services.api.opportunity;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.opportunity.Opportunity;
import com.impetus.ee.domain.user.User;

@Transactional
public interface OpportunityService
{
	List<Opportunity> getOpportunities(QueryParameterDTO queryParameterDTO);
}
