package com.impetus.ee.services.impl.user;

import java.util.List;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.impetus.ee.common.QueryParameterDTO;
import com.impetus.ee.domain.user.Role;
import com.impetus.ee.domain.user.User;
import com.impetus.ee.persistence.api.user.UserDAO;
import com.impetus.ee.services.api.user.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDAO userDAO;

	public User getUser(String username) 
	{
		return userDAO.getUser(username);
	}

	@Override
	public List<User> getUsers() 
	{
		return userDAO.getUsers();		
	}

	@Override
	public void deleteUser(int userID) 
	{
		userDAO.deleteUser(userID);
	}

	@Override
	public void addUser(User user) 
	{
		StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
		user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
		userDAO.addUser(user);
	}

	@Override
	public Role getRole(String roleName) 
	{
		return userDAO.getRole(roleName);
	}

	@Override
	public List<User> getUsers(QueryParameterDTO queryParameterDTO) {
		return userDAO.getUsers(queryParameterDTO);
	}
	
	
}
