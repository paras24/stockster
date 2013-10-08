package com.impetus.ee.actions.joiningPipeline;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.joiningPipeline.JoiningPipelineMember;
import com.impetus.ee.services.api.joiningPipeline.JoiningPipelineMemberService;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;
import com.impetus.ee.vo.TeamMemberInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component
@Scope("prototype")
@Namespace("/joiningPipeline")
@ResultPath(value="/")
public class RetrieveJoiningPipelineMembersAction extends ActionSupport implements ModelDriven{

	@Autowired
	private JoiningPipelineMemberService jPMemberService;
	private QueryParameterDTO queryParameterDTO = new QueryParameterDTO();
	//private JoiningPipelineMember jPMember= new JoiningPipelineMember();
	private int currentPage;
	private int totalPages;
	private List<JoiningPipelineMemberInfo> jPMemberInfoList;
	
	public List<JoiningPipelineMemberInfo> getJoiningPipelineMemberInfoList() {
		return jPMemberInfoList;
	}

	public void setJoiningPipelineMemberInfoList(List<JoiningPipelineMemberInfo> jPMemberInfoList) {
		this.jPMemberInfoList = jPMemberInfoList;
		/*System.out.println(jPMemberInfoList.size());
		for(int i=0;i<jPMemberInfoList.size();i++){
			System.out.println(i+1+" :"+jPMemberInfoList.get(i).getjPMemberName());
			System.out.println(i+1+""+jPMemberInfoList.get(i).getGrade());
		}	*/	
	}
	
	@Action(value="jPMemberListJson", results={
			@Result(name="success",type="json")
	})
	public String jPMemberInfoListJson() 
	{
	/*	jPMember.setSupervisorName("sp");	
		jPMember.setjPMemberID(1);
		jPMember.setjPMemberName("sunny");
		jPMember.setGrade("G5");
		jPMember.setExperience(2);
		jPMember.setKeySkills("c++");*/
		setJoiningPipelineMemberInfoList(jPMemberService.getJPMemberBySupervisor("sp"));
		return SUCCESS;
	}
	
	@Action(value="jPMemberList", results={
			@Result(name="success",type="tiles", location="joiningPipeline.tiles")
	})
	public String jPMemberInfoList() 
	{
		return SUCCESS;
	}

	@Override
	public Object getModel() {
		//System.out.println("model");
		return queryParameterDTO;
	}	
	
}