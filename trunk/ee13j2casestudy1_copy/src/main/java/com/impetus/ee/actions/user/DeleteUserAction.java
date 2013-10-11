package com.impetus.ee.actions.user;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.domain.user.User;
import com.impetus.ee.services.api.user.UserService;
import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
@Namespace("/user")
@ResultPath(value="/")
public class DeleteUserAction extends ActionSupport
{
	@Autowired
	private UserService userService;
	private int userID;
	@Action(value="delete", results={
			@Result(name="success",type="json")
	})
	public String deleteUser() 
	{
		System.out.println("User ID>> "+userID);
		userService.deleteUser(userID);
		
		return SUCCESS;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
