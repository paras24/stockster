package com.impetus.ee.persistence.api.user;


import java.util.List;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.user.Role;
import com.impetus.ee.domain.user.User;

public interface UserDAO
{
	User getUser(String userName);
	List<User> getUsers();
	void deleteUser(int userID);
	void addUser(User user);
	Role getRole(String roleName);
	List<User> getUsers(QueryParameterDTO queryParameterDTO);
}
