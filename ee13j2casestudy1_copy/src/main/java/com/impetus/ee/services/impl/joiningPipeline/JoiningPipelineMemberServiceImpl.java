package com.impetus.ee.services.impl.joiningPipeline;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.joiningPipeline.JoiningPipelineMemberDAO;
import com.impetus.ee.services.api.joiningPipeline.JoiningPipelineMemberService;
import com.impetus.ee.util.JoiningPipelineMemberObjectMapper;
import com.impetus.ee.util.MemberObjectMapper;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;
import com.impetus.ee.vo.TeamMemberInfo;
@Service("JoiningPipelineMemberService")
public class JoiningPipelineMemberServiceImpl implements JoiningPipelineMemberService {
	
	@Autowired
	private JoiningPipelineMemberDAO jPMemberDAO;
	public int addJPMember(JoiningPipelineMemberInfo jPMemberInfo) 
	{
		JoiningPipelineMember jPmember=JoiningPipelineMemberObjectMapper.toJoiningPipelineMember(jPMemberInfo);
		try 
		{					
			jPMemberDAO.insertJoiningPipelineMember(jPmember);
		}
		catch(DBException ex)
		{	/*We need to add exception handing properly*/
			System.out.println(ex.getCause());
			
		}
		if(jPmember!=null)
		{	
			return jPmember.getjPMemberID();
		}
		else
		{
		return (Integer) null;
		}
	}
	public void updateJPMember(JoiningPipelineMemberInfo jPMemberInfo) {
		JoiningPipelineMember jPmember=JoiningPipelineMemberObjectMapper.toJoiningPipelineMember(jPMemberInfo);
		try 
		{
					
			jPMemberDAO.updateJoiningPipelineMember(jPmember);
		}
		catch(DBException ex)
		{	/*We need to add exception handing properly*/
			System.out.println(ex.getCause());
			
		}
		
	}
	public List<JoiningPipelineMemberInfo> getJPMemberBySupervisor(String supervisorName) {
		
		List<JoiningPipelineMemberInfo> infoList=new ArrayList<JoiningPipelineMemberInfo>();
		try{
			List<JoiningPipelineMember> list=jPMemberDAO.getJoiningPipelineMemberBySupervisorName(supervisorName);
			System.out.println(list);
			Iterator itr=list.iterator();
			while(itr.hasNext())
			{
				JoiningPipelineMember jPmember=(JoiningPipelineMember)itr.next();
				JoiningPipelineMemberInfo info=JoiningPipelineMemberObjectMapper.toJoiningPipelineMemberInfo(jPmember);
				infoList.add(info);
			}
		}
		catch(DBException ex)
		{	/*We need to add exception handing properly*/
			System.out.println(ex.getCause());
			
		}
		
		return infoList;
	}
	
	public JoiningPipelineMemberInfo getjPMemberByID(int jPmemberId)
	{
		JoiningPipelineMemberInfo joiningPipelineMemberInfo=null;
		try 
		{
			JoiningPipelineMember jPMember=jPMemberDAO.getjPMemberByID(jPmemberId);
			joiningPipelineMemberInfo=JoiningPipelineMemberObjectMapper.toJoiningPipelineMemberInfo(jPMember);
		} catch (DBException e) 
		{
			/*We need to add exception handing properly*/
			e.printStackTrace();
			System.out.println(e.getCause());
		}
		return joiningPipelineMemberInfo;
	}
	
	public boolean removejPMemberById(int jPmemberId) 
	{
		boolean flag=false;
		try 
		{
			flag = jPMemberDAO.removeJoiningPipelineMemberByID(jPmemberId);
		} catch (DBException e) 
		{
			/*We need to add exception handing properly*/
			System.out.println(e.getCause());
		}
		
		return flag;
	}
}
