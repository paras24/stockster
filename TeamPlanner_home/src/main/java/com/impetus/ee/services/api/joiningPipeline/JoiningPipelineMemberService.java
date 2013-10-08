package com.impetus.ee.services.api.joiningPipeline;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.vo.JoiningPipelineMemberInfo;
import com.impetus.ee.vo.TeamMemberInfo;
@Transactional
public interface JoiningPipelineMemberService {

	Long addJPMember(JoiningPipelineMemberInfo jPMemberInfo);
	
	void updateJPMember(JoiningPipelineMemberInfo jPMemberInfo);
	
	List<JoiningPipelineMemberInfo> getJPMemberBySupervisor(String supervisorName);
	
	boolean removejPMemberById(Long jPmemberId);
	
	JoiningPipelineMemberInfo getjPMemberByID(Long jPmemberId);
}
