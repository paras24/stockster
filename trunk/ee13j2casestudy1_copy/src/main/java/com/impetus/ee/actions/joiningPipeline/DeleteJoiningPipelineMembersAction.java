package com.impetus.ee.actions.joiningPipeline;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.services.api.joiningPipeline.JoiningPipelineMemberService;
import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
@Namespace("/joiningPipeline")
@ResultPath(value="/")
public class DeleteJoiningPipelineMembersAction extends ActionSupport {

	@Autowired
	private JoiningPipelineMemberService jPMemberService;
	private int jpmemberID;
	@Action(value="deleteJPMember", results={
			@Result(name="success",type="json")
	})
	public String deleteJPMember() 
	{
		System.out.println("In delete");
		System.out.println("ID:"+jpmemberID);		
		jPMemberService.removejPMemberById(jpmemberID);
		
		return SUCCESS;
	}
	public int getJpmemberID() {
		return jpmemberID;
	}
	public void setJpmemberID(int jpmemberID) {
		this.jpmemberID = jpmemberID;
	}
}