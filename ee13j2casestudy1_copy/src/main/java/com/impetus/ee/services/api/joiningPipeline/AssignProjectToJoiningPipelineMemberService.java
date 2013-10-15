package com.impetus.ee.services.api.joiningPipeline;

import com.impetus.ee.vo.AssignedProjectInfo;

public interface AssignProjectToJoiningPipelineMemberService {
	
	int assignProject(int jpMemberId,AssignedProjectInfo assignedProjectInfo);

}
