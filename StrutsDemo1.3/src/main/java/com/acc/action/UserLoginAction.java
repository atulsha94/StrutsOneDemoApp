package com.acc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.acc.form.EmployeeForm;
import com.acc.form.UserLoginForm;
import com.acc.service.DashBoardService;
import com.acc.service.UserLoginService;

public class UserLoginAction extends Action{

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	    UserLoginForm userForm = (UserLoginForm) form;
	    boolean checkUser=new UserLoginService().checkUserLoginDetails(userForm);
	    if(checkUser) {
	    	DashBoardService dashBoardService=new DashBoardService();
	    	
	    	request.setAttribute("list",dashBoardService.getAllEmployees());
	    	
	    	request.setAttribute("deptlist",dashBoardService.getAllDept());
	    return mapping.findForward("success");
	    }else {
	    	request.setAttribute("msgId", "User Name and Password does not match");
	    	return mapping.findForward("error");
	    }
	    }
}
	