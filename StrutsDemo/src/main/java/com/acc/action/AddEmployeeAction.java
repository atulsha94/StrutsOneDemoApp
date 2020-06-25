package com.acc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.acc.dao.DbUtils;
import com.acc.form.EmployeeForm;

public class AddEmployeeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		EmployeeForm addEmpForm = (EmployeeForm) form;
		ActionRedirect redirect=new ActionRedirect(mapping.findForward("success"));
		
		
System.out.println("runn" );
		int savedIdOfEmployee=DbUtils.saveEmployee(addEmpForm) ;
		System.out.println("savedIdOfEmployee "+savedIdOfEmployee);
		
			
			request.setAttribute("list",DbUtils.getALLEmployee());
			
			addEmpForm.setEmployeeId(savedIdOfEmployee);
			request.setAttribute("savedId", savedIdOfEmployee);
			return redirect;
		
		
		 
	}

}
