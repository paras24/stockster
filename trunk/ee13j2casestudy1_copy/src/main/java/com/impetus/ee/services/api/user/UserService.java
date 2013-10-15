package com.impetus.ee.services.api.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.user.Role;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.exception.user.DuplicateUserException;

@Transactional
public interface UserService
{
	User getUser(String userName);
	List<User> getUsers();
	void deleteUser(int userID);
	void addUser(String username,String password) throws DuplicateUserException;
	Role getRole(String roleName);
	List<User> getUsers(QueryParameterDTO queryParameterDTO);
}
