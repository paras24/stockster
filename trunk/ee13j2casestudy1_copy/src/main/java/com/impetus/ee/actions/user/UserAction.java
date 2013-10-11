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
public class UserAction extends ActionSupport
{
	@Action(value="welcome", results={
			@Result(name="success",type="tiles",location="welcome.tiles")
	})
	public String welcomeScreen() 
	{
		return SUCCESS;
	}
	
	@Action(value="form", results={
			@Result(name="success",type="tiles",location="userform.tiles")
	})
	public String userForm() 
	{
		return SUCCESS;
	}	
}