package com.impetus.ee.services.api.joiningPipeline;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;
import com.impetus.ee.vo.TeamMemberInfo;
@Transactional
public interface JoiningPipelineMemberService {

	int addJPMember(JoiningPipelineMemberInfo jPMemberInfo);
	
	void updateJPMember(JoiningPipelineMemberInfo jPMemberInfo);
	
	List<JoiningPipelineMemberInfo> getJPMemberBySupervisor(String supervisorName);
	
	boolean removejPMemberById(int jPmemberId);
	
	JoiningPipelineMemberInfo getjPMemberByID(int jPmemberId);

	List<JoiningPipelineMemberInfo> getJoiningPipelineMembers(
			QueryParameterDTO queryParameterDTO);
}
