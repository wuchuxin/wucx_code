package com.mvn_pro.project.base.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.mvn_pro.project.web.system.model.User;

public class BaseController {
	
	@ModelAttribute
	  public void init(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	  {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    User user = null;
	    if ((auth.getPrincipal() instanceof UserDetails))
	    {
	      user = (User)auth.getPrincipal();
	      System.out.println("current login user ====��" + user.getUserName());
	    }
	    model.addAttribute("loginUser", user);
	  }
}
