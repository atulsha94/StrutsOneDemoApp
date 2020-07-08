package com.acc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.acc.bean.UserLoginBean;
import com.acc.service.UserLoginService;
import com.opensymphony.xwork2.ActionSupport;

public class UserLoginAction extends ActionSupport{

	private String userName;
	private String password;
	private String msgId;

	@Override
	public String execute() throws Exception {
	    boolean checkUser=new UserLoginService().checkUserLoginDetails(userName,password);
	    if(checkUser) {
	    	msgId= "welcome to Employee Details Page";
	    return "SUCCESS";
	    }else {
	    	msgId= "User Name and Password does not match";
	    	return "ERROR";
	    }
	    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	 public void validate() {
	      if (userName == null || userName.trim().equals("")) {
	         addActionError("The name is required");
	      }
	      
	      if (password == null || password.trim().equals("")) {
	    	  addActionError("The Password is required");
		      }
	   }
}
