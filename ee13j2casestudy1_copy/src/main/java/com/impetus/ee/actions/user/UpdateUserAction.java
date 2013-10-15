package com.impetus.ee.actions.user;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.domain.user.User;
import com.impetus.ee.exception.user.DuplicateUserException;
import com.impetus.ee.services.api.user.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.ExpressionValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;
import com.opensymphony.xwork2.validator.annotations.ValidatorType;

@Component
@Scope("prototype")
@Namespace("/user")
@ResultPath(value="/")
@Validations
public class UpdateUserAction extends ActionSupport
{
	@Autowired
	private UserService userService;
	
	private String username = null;
	
	private String password = null;
	
	@Action(value="update", results={
			@Result(name=SUCCESS,type="redirect",location="welcome.action"),
			@Result(name=INPUT,type="tiles",location="userform.tiles")
	})
	public String addUser() 
	{
		try {
			userService.addUser(getUsername(),getPassword());
		} catch (DuplicateUserException e) {
			addActionError(e.getMessage());
			return INPUT;	
		}
		return SUCCESS;
	}

	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * @param username the username to set
	 */
	@RequiredStringValidator(trim=true,message="Username is required.")
	@EmailValidator(message="Not a valid email.")
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	@RequiredStringValidator(trim=true,message="Password is required.")
	@StringLengthFieldValidator(trim=true,message="Password should have atleast ${minLength} characters.",minLength="6",maxLength="15")
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}