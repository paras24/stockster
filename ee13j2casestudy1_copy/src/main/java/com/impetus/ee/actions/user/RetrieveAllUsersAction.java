package com.impetus.ee.actions.user;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.services.api.user.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Component
@Scope("prototype")
@Namespace("/user")
@ResultPath(value="/")
public class RetrieveAllUsersAction extends ActionSupport implements ModelDriven
{
	@Autowired
	private UserService userService;
	private List<User> users;
	private QueryParameterDTO queryParameterDTO = new QueryParameterDTO();
	private int currentPage;
	private int totalPages;
	@Action(value="userListJson", results={
			@Result(name="success",type="json")
	})
	public String usersJson() 
	{
		
		List<User> users = userService.getUsers(queryParameterDTO);
		int modulus = queryParameterDTO.getTotalDisplayRecords()% queryParameterDTO.getDisplayLength();
		setTotalPages(queryParameterDTO.getTotalDisplayRecords()/ queryParameterDTO.getDisplayLength());
		if (modulus != 0 || getTotalPages() == 0) {
			setTotalPages(getTotalPages() + 1);
		}
		setCurrentPage(queryParameterDTO.getDisplayStart()/ queryParameterDTO.getDisplayLength() + 1);
		setUsers(users);		
		return SUCCESS;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public Object getModel() {
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
}
