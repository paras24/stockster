package com.impetus.ee.persistence.api.joiningPipeline;

import java.util.List;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.domain.relation.ProjectJPMemberRelation;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;

public interface JoiningPipelineMemberDAO {
	void insertJoiningPipelineMember(JoiningPipelineMember jPMember) throws DBException;
	
	void updateJoiningPipelineMember(JoiningPipelineMember jPMember) throws DBException ;
	
	boolean removeJoiningPipelineMemberByID(int jPmemberID) throws DBException;
	
	public List<JoiningPipelineMember> getJoiningPipelineMemberBySupervisorName(String supervisorName) throws DBException;
	
	public JoiningPipelineMember getjPMemberByID(int jPmemberId) throws DBException;
	
	int addProjectForJoiningPipelineMember(int jPmemberId,ProjectJPMemberRelation projectMemberJPRelation) throws DBException;

	List<JoiningPipelineMemberInfo> getJoiningPipelineMembers(
			QueryParameterDTO queryParameterDTO);
}
