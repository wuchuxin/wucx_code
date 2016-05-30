package com.mvn_pro.project.web.system.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mvn_pro.project.web.system.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	  @Query("select u from User u where u.userName=?1 and u.password=?2")
	  public User login(String userName, String password);
	  
	  public User findByUserNameAndPassword(String userName, String password);
	  
	  public User findUserByUserName(String userName);
}
