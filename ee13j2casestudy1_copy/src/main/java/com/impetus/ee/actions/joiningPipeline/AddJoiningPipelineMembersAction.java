package com.impetus.ee.actions.joiningPipeline;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.ee.services.api.joiningPipeline.JoiningPipelineMemberService;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;
import com.opensymphony.xwork2.ActionSupport;

public class AddJoiningPipelineMembersAction extends ActionSupport{
	@Autowired
	private JoiningPipelineMemberService jPMemberService;
	private JoiningPipelineMemberInfo jPMemberInfo;
	@Action(value="addJPMember", results={
			@Result(name="success",type="json")
	})
	public String addJPMember() 
	{		
		Long id=(long) jPMemberService.addJPMember(jPMemberInfo);
		if(id != null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public JoiningPipelineMemberInfo getJoiningPipelineMemberInfo() {
		return jPMemberInfo;
	}
	public void setJoiningPipelineMemberInfo(JoiningPipelineMemberInfo jPMemberInfo) {
		this.jPMemberInfo = jPMemberInfo;
	}

}
