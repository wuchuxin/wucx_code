package com.mvn_pro.project.web.system.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.mvn_pro.project.base.impl.BaseManager;
import com.mvn_pro.project.common.ResponseBean;
import com.mvn_pro.project.utils.PasswordEncoderUtils;
import com.mvn_pro.project.web.system.dao.UserRepository;
import com.mvn_pro.project.web.system.model.User;
import com.mvn_pro.project.web.system.service.UserManager;

@Service
public class UserManagerImpl
  extends BaseManager<User, String, UserRepository> implements UserManager
{
  /* (non-Javadoc)
 * @see com.mvn_pro.project.web.system.service.impl.UserManager#login(java.lang.String, java.lang.String)
 */
@Override
public User login(String userName, String password)
  {
    return null;
  }
  
  /* (non-Javadoc)
 * @see com.mvn_pro.project.web.system.service.impl.UserManager#findUserById(java.lang.String)
 */
@Override
public User findUserById(String id)
  {
    return null;
  }
  
  /* (non-Javadoc)
 * @see com.mvn_pro.project.web.system.service.impl.UserManager#findUserByUserName(java.lang.String)
 */
@Override
public User findUserByUserName(String userName)
  {
    return ((UserRepository)getRepository()).findUserByUserName(userName);
  }
  
  /* (non-Javadoc)
 * @see com.mvn_pro.project.web.system.service.impl.UserManager#register(com.mvn_pro.project.web.system.model.User)
 */
@Override
public ResponseBean register(User user)
  {
    String err = "";
    if ((user != null) && (StringUtils.isNotBlank(user.getUserName())))
    {
      if ((StringUtils.isNotBlank(user.getPassword())) && 
        (StringUtils.isNotBlank(user.getPasswordConfirm())) && 
        (StringUtils.equals(user.getPassword(), user.getPasswordConfirm())))
      {
        User existUser = findUserByUserName(user.getUserName());
        if (existUser == null)
        {
          String pwd = user.getPassword();
          
          user.setPassword(PasswordEncoderUtils.encode(pwd));
          
          save(user);
          
          return new ResponseBean("1", "����������", null);
        }
        err = "��������������������";
      }
      else
      {
        err = "������������������";
      }
    }
    else {
      err = "����������������������";
    }
    return new ResponseBean("1", err);
  }
}
