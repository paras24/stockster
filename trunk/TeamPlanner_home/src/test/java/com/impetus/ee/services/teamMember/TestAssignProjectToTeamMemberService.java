package com.impetus.ee.services.teamMember;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.services.api.teamMember.AssignProjectToTeamMemberService;
import com.impetus.ee.services.api.teamMember.TeamMemberService;
import com.impetus.ee.vo.AssignedProjectInfo;

/**
 * The Class AssignProjectToTeamMemberServiceTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Test-applicationContext.xml" })
@Transactional
public class TestAssignProjectToTeamMemberService {
	
	@Autowired
	private AssignProjectToTeamMemberService assignProjectToTeamMemberServiceTest;
	
	@Autowired
	private TeamMemberService teamMemberService;
	
	public AssignProjectToTeamMemberService getAssignProjectToTeamMemberServiceTest() {
		return assignProjectToTeamMemberServiceTest;
	}
	public void setAssignProjectToTeamMemberServiceTest(
			AssignProjectToTeamMemberService assignProjectToTeamMemberServiceTest) {
		this.assignProjectToTeamMemberServiceTest = assignProjectToTeamMemberServiceTest;
	}
	private AssignedProjectInfo getAssignedProjectInfo()
	{
		AssignedProjectInfo assignedProjectInfo=new AssignedProjectInfo();
		assignedProjectInfo.setProjectID(1);
		assignedProjectInfo.setProjectName("BigData");
		assignedProjectInfo.setAllocationPercent(30);
		return assignedProjectInfo;
		
	}
	@Test
	public void testAssignProject()
	{
		AssignedProjectInfo assignedProjectInfo=getAssignedProjectInfo();
		
		int flag = getAssignProjectToTeamMemberServiceTest().assignProject(1l, assignedProjectInfo);
		System.out.println("flag is"+flag);
		assert(true);
	}
	
	
}
