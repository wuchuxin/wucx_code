package com.mvn_pro.project.web.system.service;

import com.mvn_pro.project.common.ResponseBean;
import com.mvn_pro.project.web.system.model.User;

public interface UserManager {

	User login(String userName, String password);

	User findUserById(String id);

	User findUserByUserName(String userName);

	ResponseBean register(User user);

}