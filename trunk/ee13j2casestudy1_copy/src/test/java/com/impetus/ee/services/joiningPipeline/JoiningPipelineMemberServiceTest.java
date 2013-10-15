package com.impetus.ee.services.joiningPipeline;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.services.api.joiningPipeline.JoiningPipelineMemberService;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Test-applicationContext.xml" })
@Transactional
public class JoiningPipelineMemberServiceTest {
	
	@Autowired
	private JoiningPipelineMemberService jPMemberService;
	
	private JoiningPipelineMemberInfo getjPMemberInfo()
	{
		JoiningPipelineMemberInfo jPMemberInfo=new JoiningPipelineMemberInfo();
		jPMemberInfo.setJpmemberName("jPmember5");
		jPMemberInfo.setGrade("G5");
		jPMemberInfo.setExperience(2);
		jPMemberInfo.setKeySkills("c++,sql,css");
		jPMemberInfo.setRemarks("no commemnts required");
		jPMemberInfo.setSupervisorName("sp");
		jPMemberInfo.setStatus("Active");
		jPMemberInfo.setDateOfJoining(new Date(2013, 9, 9));
		return jPMemberInfo;
		
	}
	public void setJoiningPipelineMemberService(JoiningPipelineMemberService joiningPipelineMemberService)
	{
		this.jPMemberService = joiningPipelineMemberService;
	}

	
	public JoiningPipelineMemberService getJoiningPipelineMemberService()
	{
		return jPMemberService;
	}
	
	@Test
	public void testAddJPMember() {
		JoiningPipelineMemberInfo jPMemberInfo=getjPMemberInfo();
		int jPMemberId=getJoiningPipelineMemberService().addJPMember(jPMemberInfo);
		System.out.println("Id is"+jPMemberId);
		assertNotNull(jPMemberId);
	}

	/*@Test
	public void testUpdateJPMember() {
		Long jPMemberId=getJoiningPipelineMemberService().addJPMember(getjPMemberInfo());
		JoiningPipelineMemberInfo jPMemberInfo=getJoiningPipelineMemberService().getjPMemberByID(jPMemberId);
			if(jPMemberInfo!=null)
			{
				jPMemberInfo.setGrade("G6");
				jPMemberInfo.setRemarks("good java developer");
				getJoiningPipelineMemberService().updateJPMember(jPMemberInfo);
				System.out.println(jPMemberInfo);
				assertTrue(!"G5".equalsIgnoreCase(jPMemberInfo.getGrade()));
			}
	}
*/
	@Test
	public void testGetJPMemberBySupervisor() {
		List<JoiningPipelineMemberInfo> list=getJoiningPipelineMemberService().getJPMemberBySupervisor("sp");
		
		assertFalse(list.isEmpty());
	}

	//@Test
	/*public void testRemovejPMemberById() {
		Long jPMemberId=getJoiningPipelineMemberService().addJPMember(getjPMemberInfo());
		JoiningPipelineMemberInfo jPMemberInfo=getJoiningPipelineMemberService().getjPMemberByID(jPMemberId);
		if(jPMemberInfo!=null)
		{
			boolean x = getJoiningPipelineMemberService().removejPMemberById(jPMemberId);
			System.out.println("x is"+x);
		}
		
	}*/

	@Test
	public void testGetjPMemberByID() {
		int jPMemberId=getJoiningPipelineMemberService().addJPMember(getjPMemberInfo());
		JoiningPipelineMemberInfo jPMemberInfo = getJoiningPipelineMemberService().getjPMemberByID(jPMemberId);
		if(jPMemberInfo!=null)
		{
			System.out.println("MemberName="+jPMemberInfo.getJpmemberName());
			System.out.println("Grade="+jPMemberInfo.getGrade());
			System.out.println("Experience="+jPMemberInfo.getExperience());
			System.out.println("Skills="+jPMemberInfo.getKeySkills());
		}
	}

}
