package com.mvn_pro.project.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvn_pro.project.base.impl.BaseController;
import com.mvn_pro.project.common.ResponseBean;
import com.mvn_pro.project.web.system.model.User;
import com.mvn_pro.project.web.system.service.UserManager;

@Controller
@RequestMapping("/")
public class IndexController extends BaseController {
	
	@Autowired
	private UserManager userManager;

	@RequestMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String home(ModelMap model, User user, HttpServletRequest request, HttpServletResponse response) {
		return "/index";
	}

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ((auth.getPrincipal() instanceof UserDetails)) {
			User user = (User) auth.getPrincipal();
			if (user != null) {
				return "redirect:/index";
			}
		}
		return "/login";
	}

	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if ((auth.getPrincipal() instanceof UserDetails)) {
			User user = (User) auth.getPrincipal();
			if (user != null) {
				return "redirect:/index";
			}
		}
		return "/register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(ModelMap model, User user, HttpServletRequest request, HttpServletResponse response) {
		ResponseBean resp = this.userManager.register(user);
		model.addAttribute("result", resp);
		if (StringUtils.equals(resp.getCode(), "1")) {
			return "/login";
		}
		return "/login";
	}

	@RequestMapping("/hello")
	public String hello() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		if ((auth.getPrincipal() instanceof UserDetails)) {
			User user = (User) auth.getPrincipal();
			System.out.println(user.getUserName());
		}
		return "/hello";
	}
}
