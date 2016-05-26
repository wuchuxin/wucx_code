package com.mvn_pro.project.web.system.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mvn_pro.project.web.system.model.User;

public interface UserRepository extends CrudRepository<User, String> {

	  @Query("select u from User u where u.userName=?1 and u.password=?2")
	  public abstract User login(String paramString1, String paramString2);
	  
	  public abstract User findByUserNameAndPassword(String paramString1, String paramString2);
	  
	  public abstract User findUserByUserName(String paramString);
}
