package com.impetus.ee.services.impl.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.impetus.ee.domain.user.User;
import com.impetus.ee.services.api.user.UserService;


public class UserAuthenticationService implements UserDetailsService,Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3802207421090604381L;
	private UserService userService;
	
	
	
	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException 
	{
		final User user = userService.getUser(username);	
		if(user==null)
		{
			throw new UsernameNotFoundException("No user with the specified username exists.");
		}
		
		UserDetails userDetails = new UserDetails()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = -3807638583898139207L;

			
			public Collection<GrantedAuthority> getAuthorities() 
			{
				GrantedAuthority authority = new GrantedAuthority() 
				{
					/**
					 * 
					 */
					private static final long serialVersionUID = 4866292482579095227L;

					
					public String getAuthority() 
					{
						return user.getRole().getRoleName();
					}
				};
				
				
				Collection<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
				list.add(authority);
				return list;
			}

			
			public String getPassword() {
				return user.getPassword();
			}

			
			public String getUsername() 
			{
				return user.getEmail();
			}

			
			public boolean isAccountNonExpired() 
			{
				return true;
			}

			
			public boolean isAccountNonLocked() {
				
				return true;
			}

			
			public boolean isCredentialsNonExpired() {
				
				return true;
			}

			
			public boolean isEnabled()
			{
				return user.isEnabled();
			}
			
		};
		
		return userDetails;
	}
}
