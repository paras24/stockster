package com.impetus.ee.persistence.api.teamMember;

import java.util.List;

import com.impetus.ee.domain.relation.ProjectMemberRelation;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;

public interface TeamMemberDAO 
{	
	void insertTeamMember(TeamMember teamMember)throws DBException;
	
	void updateTeamMember(TeamMember teamMember)throws DBException ;
	
	boolean deleteTeamMemberById(Long memberID)throws DBException ;
	
	public List<TeamMember> getTeamMemberByGroupHeadName(String groupHeadName) throws DBException;
	
	public TeamMember getTeamMemberByID(Long memberId) throws DBException;
	
	int addProjectForTeamMember(long memberId,ProjectMemberRelation projectMemberRelation) throws DBException;
}
