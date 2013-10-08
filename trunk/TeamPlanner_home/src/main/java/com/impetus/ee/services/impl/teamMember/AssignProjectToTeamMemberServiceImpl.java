package com.impetus.ee.services.impl.teamMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.domain.project.Project;
import com.impetus.ee.domain.relation.ProjectMemberRelation;

import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.project.ProjectDAO;

import com.impetus.ee.persistence.api.teamMember.TeamMemberDAO;
import com.impetus.ee.services.api.teamMember.AssignProjectToTeamMemberService;

import com.impetus.ee.vo.AssignedProjectInfo;

@Service("AssignProjectToTeamMemberService")
public class AssignProjectToTeamMemberServiceImpl implements AssignProjectToTeamMemberService{
	@Autowired
	private TeamMemberDAO teamMemberDAO;
	@Autowired
	private ProjectDAO projectDAO;
	
	
	public int assignProject(long teamMemberId,AssignedProjectInfo assignedProjectInfo) {
	
		Project project=null;
		try {
			
			ProjectMemberRelation projectMemberRelation=new ProjectMemberRelation();
			projectMemberRelation.setPercentAllocation(assignedProjectInfo.getAllocationPercent());
			project=projectDAO.getProjectByID(assignedProjectInfo.getProjectID());
			projectMemberRelation.setProject(project);
			teamMemberDAO.addProjectForTeamMember(teamMemberId,projectMemberRelation);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
