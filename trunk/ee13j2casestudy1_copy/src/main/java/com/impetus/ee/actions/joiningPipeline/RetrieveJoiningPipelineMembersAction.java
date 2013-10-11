package com.impetus.ee.actions.joiningPipeline;

import java.util.ArrayList;
import java.util.Arrays;
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
	private JoiningPipelineMember jPMember= new JoiningPipelineMember();
	private int currentPage;
	private int totalPages;
	private List<JoiningPipelineMemberInfo> jPMemberInfoList ;	
	
	
	public List<JoiningPipelineMemberInfo> getJoiningPipelineMemberInfoList() {
		return jPMemberInfoList;
	}

	public void setJoiningPipelineMemberInfoList(List<JoiningPipelineMemberInfo> jPMemberInfoList) {
		this.jPMemberInfoList = jPMemberInfoList;
		/*System.out.println(this.jPMemberInfoList.size());
		for(int i=0;i<this.jPMemberInfoList.size();i++){
			System.out.println(i+1+" :"+this.jPMemberInfoList.get(i).getJpmemberID());
			System.out.println(i+1+""+this.jPMemberInfoList.get(i).getGrade());
		}*/		
	}
	
	@Action(value="jPMemberListJson", results={
			@Result(name="success",type="json")
	})
	public String jPMemberInfoListJson() 
	{
		/*List<JoiningPipelineMemberInfo> jPMemberInfoList_new = new ArrayList<JoiningPipelineMemberInfo>();
		JoiningPipelineMemberInfo jPmember_new = new JoiningPipelineMemberInfo();
		jPmember_new.setSupervisorName("sp");	
		jPmember_new.setJpmemberID(1);
		jPmember_new.setJpMemberName("sunny");
		jPmember_new.setGrade("G5");
		jPmember_new.setExperience(2);
		jPmember_new.setKeySkills("c++");
		jPMemberInfoList_new.add(jPmember_new);*/
		//setJoiningPipelineMemberInfoList(jPMemberInfoList_new);
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