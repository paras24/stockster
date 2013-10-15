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
import com.impetus.ee.util.*;
import com.impetus.ee.services.api.joiningPipeline.JoiningPipelineMemberService;
import com.impetus.ee.vo.JoiningPipelineMemberInfo;

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
	private JoiningPipelineMemberInfo joiningPipelineMemberInfo;
	private int jpmemberID;
	public int getJpmemberID() {
		return jpmemberID;
	}

	public void setJpmemberID(int jpmemberID) {
		this.jpmemberID = jpmemberID;
	}

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
		jPMemberInfoList_new.add(jPmember_new);
		setJoiningPipelineMemberInfoList(jPMemberInfoList_new);*/
//		List<JoiningPipelineMemberInfo> jPMembers = jPMemberService.getJoiningPipelineMembers(queryParameterDTO);
//		int modulus = queryParameterDTO.getTotalDisplayRecords()% queryParameterDTO.getDisplayLength();
//		setTotalPages(queryParameterDTO.getTotalDisplayRecords()/ queryParameterDTO.getDisplayLength());
//		if (modulus != 0 || getTotalPages() == 0) {
//			setTotalPages(getTotalPages() + 1);
//		}
//		setCurrentPage(queryParameterDTO.getDisplayStart()/ queryParameterDTO.getDisplayLength() + 1);	
//		setJoiningPipelineMemberInfoList(jPMembers);
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
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	@Action(value="showJoiningPipelineMemberForm", results={
			@Result(name="success",type="tiles", location="showJoiningPipelineMemberForm.tiles")
	})
	public String showAddJoiningPipelineMemberForm()
	{	
		System.out.println("Hi Sunny");
		return SUCCESS;
	}
	
	@Action(value="addJoiningPipelineMember", results={
			@Result(name="success",type="tiles", location="joiningPipeline.tiles"),
			@Result(name=INPUT,type="redirect",location="showJoiningPipelineMemberForm.action"),
			@Result(name=ERROR,type="redirect",location="showJoiningPipelineMemberForm.action")
	})

	public String addJoiningPipelineMember() 
	{
		System.out.println("In Add ");
		System.out.println("JP Member ID:"+joiningPipelineMemberInfo.getJpmemberID());
		System.out.println("JP Member Name:"+joiningPipelineMemberInfo.getJpmemberName());
		Long id=(long) jPMemberService.addJPMember(joiningPipelineMemberInfo);
		if(id != null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public JoiningPipelineMemberInfo getJoiningPipelineMemberInfo() {
		System.out.println("aaya");
		return joiningPipelineMemberInfo;
	}
	public void setJoiningPipelineMemberInfo(JoiningPipelineMemberInfo jPMemberInfo) {
		this.joiningPipelineMemberInfo = jPMemberInfo;
	}
	
	@Action(value="editJPMemberForm", results={
			@Result(name="success",type="tiles", location="editJoiningPipelineMemberForm.tiles")
	})
	public String editJPMember()
	{
		System.out.println("in Edit");
		System.out.println("ID:"+jpmemberID);
		joiningPipelineMemberInfo = jPMemberService.getjPMemberByID(jpmemberID);
		System.out.println("Member Name:"+joiningPipelineMemberInfo.getJpmemberName());
		return SUCCESS;
	}
	
	@Action(value="editJoiningPipelineMember", results={
			@Result(name="success",type="tiles", location="joiningPipeline.tiles"),
			@Result(name=INPUT,type="redirect",location="editJPMemberForm.action"),
			@Result(name=ERROR,type="redirect",location="editJPMemberForm.action")
	})
	
	public String editJoiningPipelineMember()
	{
		jPMemberService.updateJPMember(joiningPipelineMemberInfo);
		return SUCCESS;
		
	}
}