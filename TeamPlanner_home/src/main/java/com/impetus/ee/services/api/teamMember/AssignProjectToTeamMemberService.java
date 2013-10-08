package com.impetus.ee.services.api.teamMember;

import com.impetus.ee.vo.AssignedProjectInfo;


public interface AssignProjectToTeamMemberService {
	
	int assignProject(long teamMemberId,AssignedProjectInfo assignedProjectInfo);

}
