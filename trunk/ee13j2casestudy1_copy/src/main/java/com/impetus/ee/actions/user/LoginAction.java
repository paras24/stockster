package com.impetus.ee.actions.user;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Component
@Scope("prototype")
@Namespace("/")
@ResultPath(value="/")
@Result(name="success",type="tiles",location="login.tiles")
public class LoginAction extends ActionSupport
{
	
}