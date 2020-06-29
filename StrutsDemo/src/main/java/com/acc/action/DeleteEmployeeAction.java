package com.acc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.acc.service.DashBoardService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteEmployeeAction extends ActionSupport{
private boolean deleteRecord;
String empId;
	@Override
	public String execute() throws Exception {
	   deleteRecord=new DashBoardService().deleteEmployee(empId);
	    return "success";
	    }
	public boolean isDeleteRecord() {
		return deleteRecord;
	}
	public void setDeleteRecord(boolean deleteRecord) {
		this.deleteRecord = deleteRecord;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
}
