package com.impetus.ee.persistence.api.joiningPipeline;

import java.util.List;

import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;

public interface JoiningPipelineMemberDAO {
	void insertJoiningPipelineMember(JoiningPipelineMember jPMember) throws DBException;
	
	void updateJoiningPipelineMember(JoiningPipelineMember jPMember) throws DBException ;
	
	boolean removeJoiningPipelineMemberByID(Long jPmemberID) throws DBException;
	
	public List<JoiningPipelineMember> getJoiningPipelineMemberBySupervisorName(String supervisorName) throws DBException;
	
	public JoiningPipelineMember getjPMemberByID(Long jPmemberId) throws DBException;
}
