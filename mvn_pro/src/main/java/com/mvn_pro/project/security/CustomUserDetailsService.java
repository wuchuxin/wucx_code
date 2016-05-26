package com.mvn_pro.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mvn_pro.project.web.system.model.User;
import com.mvn_pro.project.web.system.service.UserManager;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserManager userManager;

	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = this.userManager.findUserByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("UserName " + userName + " not found");
		}
		return new SecurityUser(user);
	}
}
