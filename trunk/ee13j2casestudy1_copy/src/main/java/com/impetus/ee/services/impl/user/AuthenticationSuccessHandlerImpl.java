package com.impetus.ee.services.impl.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.impetus.ee.domain.user.User;
import com.impetus.ee.services.api.user.UserService;



public class AuthenticationSuccessHandlerImpl extends SimpleUrlAuthenticationSuccessHandler 
{
	
	@Autowired
	UserService userService;
	
	public AuthenticationSuccessHandlerImpl(String defaultTargetUrl) 
	{
		setDefaultTargetUrl(defaultTargetUrl);
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
			throws IOException, ServletException 
	{
		User user = userService.getUser(authentication.getName());
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("userid", user.getUserID());
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
