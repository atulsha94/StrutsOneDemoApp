package com.acc.struts1.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.acc.dao.DbUtils;
import com.acc.form.DepartmentForm;
import com.acc.service.DashBoardService;

public class UpdateDeptAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DepartmentForm updateEmpForm = (DepartmentForm) form;
		request.getSession().setAttribute("updateRecord", DbUtils.updateDepartment(updateEmpForm));
		return mapping.findForward("success");
		 
	}

}
