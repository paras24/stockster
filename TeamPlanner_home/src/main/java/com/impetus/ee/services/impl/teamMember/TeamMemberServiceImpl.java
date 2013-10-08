package com.impetus.ee.services.impl.teamMember;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.domain.teamMember.TeamMember;
import com.impetus.ee.exception.daoLayer.DBException;
import com.impetus.ee.persistence.api.teamMember.TeamMemberDAO;
import com.impetus.ee.services.api.teamMember.TeamMemberService;
import com.impetus.ee.util.MemberObjectMapper;
import com.impetus.ee.vo.TeamMemberInfo;
@Service("TeamMemberService")
public class TeamMemberServiceImpl implements TeamMemberService{
	
	
	@Autowired
	private TeamMemberDAO teamMemberDAO;
	public Long addTeamMember(TeamMemberInfo teamMemberInfo) 
	{
		TeamMember teamMember=MemberObjectMapper.toTeamMember(teamMemberInfo);
		try 
		{
					
			teamMemberDAO.insertTeamMember(teamMember);
		}
		catch(DBException ex)
		{	/*We need to add exception handing properly*/
			System.out.println(ex.getCause());
			
		}
		if(teamMember!=null)
		{	
			return teamMember.getMemberID();
		}
		else
		{
		return null;
		}
	}
	public void updateTeamMember(TeamMemberInfo teamMemberInfo) {
		/*We need to change update logic in future*/
		TeamMember teamMember=MemberObjectMapper.toTeamMember(teamMemberInfo);
		try 
		{
					
			teamMemberDAO.updateTeamMember(teamMember);
		}
		catch(DBException ex)
		{	/*We need to add exception handing properly*/
			System.out.println(ex.getCause());
			
		}
		
		
	}
	public List<TeamMemberInfo> getTeamMemberByGroupHead(String groupHeadName) {
		List<TeamMemberInfo> infoList=new ArrayList<TeamMemberInfo>();
		try{
			List<TeamMember> list=teamMemberDAO.getTeamMemberByGroupHeadName(groupHeadName);
			System.out.println(list);
			Iterator<TeamMember> itr=list.iterator();
			while(itr.hasNext())
			{
				TeamMember member=itr.next();
				TeamMemberInfo info=MemberObjectMapper.toTeamMemberInfo(member);
				infoList.add(info);
			}
		}
		catch(DBException ex)
		{	/*We need to add exception handing properly*/
			System.out.println(ex.getCause());
			
		}
		
		return infoList;
	}
	public boolean removeTeamMemberById(Long memberId) 
	{
		boolean flag=false;
		try 
		{
			flag = teamMemberDAO.deleteTeamMemberById(memberId);
		} catch (DBException e) 
		{
			/*We need to add exception handing properly*/
			System.out.println(e.getCause());
		}
		
		return flag;
	}
	public TeamMemberInfo getTeamMemberByID(Long memberId) 
	{
		TeamMemberInfo teamMemberInfo=null;
		try 
		{
			TeamMember teamMember=teamMemberDAO.getTeamMemberByID(memberId);
			teamMemberInfo=MemberObjectMapper.toTeamMemberInfo(teamMember);
		} catch (DBException e) 
		{
			/*We need to add exception handing properly*/
			e.printStackTrace();
			System.out.println(e.getCause());
		}
		return teamMemberInfo;
	}

}
