package com.impetus.ee.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.domain.relation.ProjectJPMemberRelation;
import com.impetus.ee.domain.relation.ProjectMemberRelation;
import com.impetus.ee.vo.AssignedProjectInfo;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;


public class JoiningPipelineMemberObjectMapper {

	public static JoiningPipelineMemberInfo toJoiningPipelineMemberInfo(JoiningPipelineMember jPMember)
	{
		JoiningPipelineMemberInfo jPMemberInfo=new JoiningPipelineMemberInfo();
		jPMemberInfo.setJpmemberID(jPMember.getJpmemberID());
		jPMemberInfo.setJpmemberName(jPMember.getJpmemberName());
		jPMemberInfo.setDateOfJoining(jPMember.getDateOfJoining());
		jPMemberInfo.setExperience(jPMember.getExperience());
		jPMemberInfo.setKeySkills(jPMember.getKeySkills());
		jPMemberInfo.setRemarks(jPMember.getRemarks());
		jPMemberInfo.setGrade(jPMember.getGrade());
		jPMemberInfo.setSupervisorName(jPMember.getSupervisorName());
		jPMemberInfo.setStatus(jPMember.getStatus());
		/*Set<ProjectJPMemberRelation> projectJPMemberRelations = jPMember.getProjectJPMemberRelation();
		if(projectJPMemberRelations!=null)
		{
			List<AssignedProjectInfo> assignedProjectsList =new ArrayList<AssignedProjectInfo>(); 
			Iterator<ProjectJPMemberRelation> itr=projectJPMemberRelations.iterator();
			while(itr.hasNext())
			{
				AssignedProjectInfo assignedProjectInfo = new AssignedProjectInfo();
				ProjectJPMemberRelation projectJPMemberRelation=itr.next();
				assignedProjectInfo.setProjectName(projectJPMemberRelation.getProject().getProjectName());
				assignedProjectInfo.setProjectID(projectJPMemberRelation.getProject().getProjectId());
				assignedProjectInfo.setAllocationPercent(projectJPMemberRelation.getPercentAllocation());
				assignedProjectsList.add(assignedProjectInfo);
			}
			jPMemberInfo.setAssignedProjectInfo(assignedProjectsList);
		}*/
		return jPMemberInfo;
		
	}
	
	public static JoiningPipelineMember toJoiningPipelineMember(JoiningPipelineMemberInfo jPMemberInfo)
	{
		JoiningPipelineMember jPMember=new JoiningPipelineMember();
		jPMember.setJpmemberID(jPMemberInfo.getJpmemberID());
		jPMember.setJpmemberName(jPMemberInfo.getJpmemberName());
		jPMember.setDateOfJoining(jPMemberInfo.getDateOfJoining());
		jPMember.setExperience(jPMemberInfo.getExperience());
		jPMember.setKeySkills(jPMemberInfo.getKeySkills());
		jPMember.setRemarks(jPMemberInfo.getRemarks());
		jPMember.setGrade(jPMemberInfo.getGrade());
		jPMember.setSupervisorName(jPMemberInfo.getSupervisorName());
		jPMember.setStatus(jPMemberInfo.getStatus());
		return jPMember;
		
	}
}
