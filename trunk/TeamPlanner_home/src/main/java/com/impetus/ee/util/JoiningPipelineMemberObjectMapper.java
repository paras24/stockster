package com.impetus.ee.util;

import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;


public class JoiningPipelineMemberObjectMapper {

	public static JoiningPipelineMemberInfo toJoiningPipelineMemberInfo(JoiningPipelineMember jPMember)
	{
		JoiningPipelineMemberInfo jPMemberInfo=new JoiningPipelineMemberInfo();
		jPMemberInfo.setJPMemberID(jPMember.getjPMemberID());
		jPMemberInfo.setjPMemberName(jPMember.getjPMemberName());
		jPMemberInfo.setDateOfJoining(jPMember.getDateOfJoining());
		jPMemberInfo.setExperience(jPMember.getExperience());
		jPMemberInfo.setKeySkills(jPMember.getKeySkills());
		jPMemberInfo.setRemarks(jPMember.getRemarks());
		jPMemberInfo.setGrade(jPMember.getGrade());
		jPMemberInfo.setSupervisorName(jPMember.getSupervisorName());
		jPMemberInfo.setStatus(jPMember.getStatus());
		return jPMemberInfo;
		
	}
	
	public static JoiningPipelineMember toJoiningPipelineMember(JoiningPipelineMemberInfo jPMemberInfo)
	{
		JoiningPipelineMember jPMember=new JoiningPipelineMember();
		jPMember.setjPMemberID(jPMemberInfo.getJPMemberID());
		jPMember.setjPMemberName(jPMemberInfo.getjPMemberName());
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
