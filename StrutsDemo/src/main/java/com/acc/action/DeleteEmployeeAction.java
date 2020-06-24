package com.acc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.acc.dao.DbUtils;
import com.acc.service.DashBoardService;

public class DeleteEmployeeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
	    String empId=(String)request.getParameter("empId");
	   request.getSession().setAttribute("deleteRecord", new DashBoardService().deleteEmployee(empId));
		//ActionRedirect redirect = new ActionRedirect(mapping.findForward("success"));
	    return mapping.findForward("success");
	    }
}
