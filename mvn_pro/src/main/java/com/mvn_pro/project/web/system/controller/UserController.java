package com.mvn_pro.project.web.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.mvn_pro.project.base.impl.BaseController;
import com.mvn_pro.project.web.system.model.User;

@Controller
@RequestMapping({"/user"})
public class UserController
  extends BaseController
{
  @RequestMapping({"/loginPage"})
  public String loginPage(ModelMap model, User user, HttpServletRequest request, HttpServletResponse response)
  {
    user.setUserName("userName");
    user.setPassword("password");
    model.addAttribute("user", user);
    return "/login";
  }
  
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String login(ModelMap model, User user, HttpServletRequest request, HttpServletResponse response)
  {
    System.out.println(JSON.toJSONString(user));
    if ((user != null) && (user.getUserName().equals("userName")) && (user.getPassword().equals("password"))) {
      return "redirect:/index";
    }
    return "/login";
  }
}

