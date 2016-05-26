package com.mvn_pro.project.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mvn_pro.project.web.system.model.Role;
import com.mvn_pro.project.web.system.model.User;

public class SecurityUser extends User implements UserDetails {
	private static final long serialVersionUID = 1L;

	public SecurityUser(User user) {
		if (user != null) {
			setId(user.getId());
			setUserName(user.getUserName());
			setPassword(user.getPassword());
			setRoles(user.getRoles());
		}
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(0);
		Set<Role> userRoles = getRoles();
		if (userRoles != null) {
			for (Role role : userRoles) {
				SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
				authorities.add(authority);
			}
		}
		return authorities;
	}

	public String getPassword() {
		return super.getPassword();
	}

	public String getUsername() {
		return super.getUserName();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
}