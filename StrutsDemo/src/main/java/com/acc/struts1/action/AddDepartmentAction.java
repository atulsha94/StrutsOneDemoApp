package com.acc.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.acc.dao.DbUtils;
import com.acc.form.DepartmentForm;
import com.acc.service.DashBoardService;

public class AddDepartmentAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DepartmentForm addEmpForm = (DepartmentForm) form;
		
		ActionRedirect redirect=new ActionRedirect(mapping.findForward("success"));
		DbUtils.addDepartment(addEmpForm) ;
		
			
			
		
		return redirect;
		
		
		 
	}

}
