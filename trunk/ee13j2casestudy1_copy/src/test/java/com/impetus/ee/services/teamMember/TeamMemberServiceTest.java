package com.impetus.ee.services.teamMember;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.services.api.teamMember.TeamMemberService;
import com.impetus.ee.vo.TeamMemberInfo;





/**
 * The Class TeamMemberServiceTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Test-applicationContext.xml" })
@Transactional
public class TeamMemberServiceTest {
	@Autowired
	private TeamMemberService teamMemberService;
	
	private TeamMemberInfo getTeamMemberInfo()
	{
		TeamMemberInfo teamMemberInfo=new TeamMemberInfo();
		teamMemberInfo.setTeamMemberName("member2");
		teamMemberInfo.setGrade("G5");
		teamMemberInfo.setExperience(1);
		teamMemberInfo.setKeySkills("java,sql,css");
		teamMemberInfo.setRemarks("no commemnts");
		teamMemberInfo.setGroupHeadName("head1");
		return teamMemberInfo;
		
	}
	public void setTeamMemberService(TeamMemberService teamMemberService)
	{
		this.teamMemberService = teamMemberService;
	}

	
	public TeamMemberService getTeamMemberService()
	{
		return teamMemberService;
	}
	@Test
	public void testAddTeamMember()
	{
		TeamMemberInfo teamMemberInfo=getTeamMemberInfo();
		Long teamMemberId=getTeamMemberService().addTeamMember(teamMemberInfo);
		
		assertNotNull(teamMemberId);
	}
	
	@Test
	public void testUpdateTeamMember()
	{	Long teamMemberId=getTeamMemberService().addTeamMember(getTeamMemberInfo());
		TeamMemberInfo teamMemberInfo=getTeamMemberService().getTeamMemberByID(teamMemberId);
		if(teamMemberInfo!=null)
		{
			teamMemberInfo.setGrade("G6");
			teamMemberInfo.setRemarks("good java developer");
			getTeamMemberService().updateTeamMember(teamMemberInfo);
			
			assertTrue(!"G5".equalsIgnoreCase(teamMemberInfo.getGrade()));
		}
		
	}
	@Test
	public void testGetTeamMemberByGroupHead()
	{
		List<TeamMemberInfo> list=getTeamMemberService().getTeamMemberByGroupHead("head1");
		
		assertFalse(list.isEmpty());
		
	}
	
}
