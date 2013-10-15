package com.impetus.ee.services.impl.joiningPipeline;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.relation.ProjectJPMemberRelation;

import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.project.ProjectDAO;

import com.impetus.ee.persistence.api.joiningPipeline.JoiningPipelineMemberDAO;
import com.impetus.ee.services.api.joiningPipeline.AssignProjectToJoiningPipelineMemberService;

import com.impetus.ee.vo.AssignedProjectInfo;

@Service("AssignProjectToJoiningPipelineMemberService")
public class AssignProjectToJoiningPipelineMemberServiceImpl implements AssignProjectToJoiningPipelineMemberService{

	@Autowired
	private JoiningPipelineMemberDAO joiningPipelineMemberDAO;
	@Autowired
	private ProjectDAO projectDAO;
	
	
	public int assignProject(int jpMemberId,AssignedProjectInfo assignedProjectInfo) {
	
		Project project=null;
		try {
			
			ProjectJPMemberRelation projectJPMemberRelation=new ProjectJPMemberRelation();
			projectJPMemberRelation.setPercentAllocation(assignedProjectInfo.getAllocationPercent());
			project=projectDAO.getProjectByID(assignedProjectInfo.getProjectID());
			projectJPMemberRelation.setProject(project);
			joiningPipelineMemberDAO.addProjectForJoiningPipelineMember(jpMemberId,projectJPMemberRelation);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
