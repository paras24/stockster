package com.impetus.ee.services.api.teamMember;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import com.impetus.ee.vo.TeamMemberInfo;
@Transactional
public interface TeamMemberService 
{
	
		Long addTeamMember(TeamMemberInfo teamMemberInfo);
		
		void updateTeamMember(TeamMemberInfo teamMemberInfo);
		
		List<TeamMemberInfo> getTeamMemberByGroupHead(String groupHeadName);
		
		boolean removeTeamMemberById(Long memberId);
		
		TeamMemberInfo getTeamMemberByID(Long memberId);

}
