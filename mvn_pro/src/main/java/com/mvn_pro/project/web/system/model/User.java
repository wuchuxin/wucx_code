package com.mvn_pro.project.web.system.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.mvn_pro.project.base.impl.BaseModel;

@Entity
@Table(name="user")
public class User
  extends BaseModel
  implements Serializable
{
  private static final long serialVersionUID = -180274656702869756L;
  private String id;
  private String userName;
  private String password;
  private Set<Role> roles = new HashSet<Role>(0);
  private String passwordConfirm;
  
  @Id
  @GeneratedValue(generator="uuid")
  @GenericGenerator(name="uuid", strategy="uuid")
  @Column(name="id", unique=true, nullable=false)
  public String getId()
  {
    return this.id;
  }
  
  public void setId(String id)
  {
    this.id = id;
  }
  
  @Column(name="user_name", length=20)
  public String getUserName()
  {
    return this.userName;
  }
  
  public void setUserName(String userName)
  {
    this.userName = userName;
  }
  
  @Column(name="password", length=200)
  public String getPassword()
  {
    return this.password;
  }
  
  public void setPassword(String password)
  {
    this.password = password;
  }
  
  @OneToMany(fetch=FetchType.EAGER, mappedBy="user")
  public Set<Role> getRoles()
  {
    return this.roles;
  }
  
  public void setRoles(Set<Role> roles)
  {
    this.roles = roles;
  }
  
  @Transient
  public String getPasswordConfirm()
  {
    return this.passwordConfirm;
  }
  
  public void setPasswordConfirm(String passwordConfirm)
  {
    this.passwordConfirm = passwordConfirm;
  }
}
