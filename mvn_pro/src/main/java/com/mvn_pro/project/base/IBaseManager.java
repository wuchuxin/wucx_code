package com.mvn_pro.project.base;

import java.io.Serializable;
import java.util.List;

public abstract interface IBaseManager<Model extends IBaseModel, PK extends Serializable>
{
  public static final String HANDLE_SUCCESS = "1";
  public static final String HANDLE_ERROR = "1";
  
  public abstract Model getById(PK paramPK);
  
  public abstract Model save(Model paramModel);
  
  public abstract Model update(Model paramModel);
  
  public abstract void remove(PK paramPK);
  
  public abstract List<Model> findAll();
}
