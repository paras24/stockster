package com.impetus.ee.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.impetus.ee.domain.relation.ProjectMemberRelation;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.vo.AssignedProjectInfo;
import com.impetus.ee.vo.TeamMemberInfo;

public class MemberObjectMapper {
	
	private MemberObjectMapper() {}

	public static TeamMemberInfo toTeamMemberInfo(TeamMember teamMember)
	{
		TeamMemberInfo teamMemberInfo=new TeamMemberInfo();
		teamMemberInfo.setMemberID(teamMember.getMemberID());
		teamMemberInfo.setTeamMemberName(teamMember.getMemberName());
		teamMemberInfo.setDateOfJoining(teamMember.getDateOfJoining());
		teamMemberInfo.setExperirnce(teamMember.getExperirnce());
		teamMemberInfo.setKeySkills(teamMember.getKeySkills());
		teamMemberInfo.setRemarks(teamMember.getRemarks());
		teamMemberInfo.setGrade(teamMember.getGrade());
		teamMemberInfo.setGroupHeadName(teamMember.getGroupHeadName());
		Set<ProjectMemberRelation> projectMemberRelations = teamMember.getProjectMemberRelation();
		if(projectMemberRelations!=null)
		{
			List<AssignedProjectInfo> assignedProjectsList =new ArrayList<AssignedProjectInfo>(); 
			Iterator<ProjectMemberRelation> itr=projectMemberRelations.iterator();
			while(itr.hasNext())
			{
				AssignedProjectInfo assignedProjectInfo = new AssignedProjectInfo();
				ProjectMemberRelation projectMemberRelation=itr.next();
				assignedProjectInfo.setProjectName(projectMemberRelation.getProject().getProjectName());
				assignedProjectInfo.setProjectID(projectMemberRelation.getProject().getProjectId());
				assignedProjectInfo.setAllocationPercent(projectMemberRelation.getPercentAllocation());
				assignedProjectsList.add(assignedProjectInfo);
			}
			teamMemberInfo.setAssignedProjectInfo(assignedProjectsList);
		}
		return teamMemberInfo;
		
	}
	
	public static TeamMember toTeamMember(TeamMemberInfo teamMemberInfo)
	{
		TeamMember teamMember=new TeamMember();
		teamMember.setMemberID(teamMemberInfo.getMemberID());
		teamMember.setMemberName(teamMemberInfo.getTeamMemberName());
		teamMember.setDateOfJoining(teamMemberInfo.getDateOfJoining());
		teamMember.setExperirnce(teamMemberInfo.getExperirnce());
		teamMember.setKeySkills(teamMemberInfo.getKeySkills());
		teamMember.setRemarks(teamMemberInfo.getRemarks());
		teamMember.setGrade(teamMemberInfo.getGrade());
		teamMember.setGroupHeadName(teamMemberInfo.getGroupHeadName());
		return teamMember;
		
	}

}
