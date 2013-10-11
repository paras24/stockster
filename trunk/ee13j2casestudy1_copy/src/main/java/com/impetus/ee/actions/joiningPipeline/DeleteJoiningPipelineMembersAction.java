package com.impetus.ee.actions.joiningPipeline;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.impetus.ee.services.api.joiningPipeline.JoiningPipelineMemberService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteJoiningPipelineMembersAction extends ActionSupport {

	@Autowired
	private JoiningPipelineMemberService jPMemberService;
	private int jPMemberID;
	@Action(value="deleteJPMember", results={
			@Result(name="success",type="json")
	})
	public String deleteJPMember() 
	{
		
		jPMemberService.removejPMemberById(jPMemberID);
		
		return SUCCESS;
	}
	/**
	 * @return the userID
	 */
	public int getJPMemberID() {
		return jPMemberID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setJPMemberID(int jPMemberID) {
		this.jPMemberID = jPMemberID;
	}
}
