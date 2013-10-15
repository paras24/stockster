package com.impetus.ee.actions.project;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;


@Component
@Scope("prototype")
@Namespace("/project")
@ResultPath(value="/")
public class ProjectAction  extends ActionSupport
 {

	
	@Action(value="form", results={
			@Result(name="success",type="tiles",location="projectform.tiles")
	})
	public String projectForm() 
	{
		return SUCCESS;
	}	
}
