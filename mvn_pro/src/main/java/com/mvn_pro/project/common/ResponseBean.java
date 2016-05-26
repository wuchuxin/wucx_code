package com.mvn_pro.project.common;

public class ResponseBean
{
  private String code;
  private String msg;
  private String error;
  private Object data;
  
  public ResponseBean() {}
  
  public ResponseBean(String code, String error)
  {
    this(code, null, error, null);
  }
  
  public ResponseBean(String code, Object data)
  {
    this(code, null, null, data);
  }
  
  public ResponseBean(String code, String msg, Object data)
  {
    this(code, msg, null, data);
  }
  
  public ResponseBean(String code, String msg, String error, Object data)
  {
    this.code = code;
    this.msg = msg;
    this.error = error;
    this.data = data;
  }
  
  public String getCode()
  {
    return this.code;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getMsg()
  {
    return this.msg;
  }
  
  public void setMsg(String msg)
  {
    this.msg = msg;
  }
  
  public String getError()
  {
    return this.error;
  }
  
  public void setError(String error)
  {
    this.error = error;
  }
  
  public Object getData()
  {
    return this.data;
  }
  
  public void setData(Object data)
  {
    this.data = data;
  }
}
