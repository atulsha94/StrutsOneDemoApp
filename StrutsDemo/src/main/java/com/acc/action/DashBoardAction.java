package com.acc.action;
import java.util.ArrayList;
import java.util.List;
import com.acc.bean.EmployeeBean;
import com.acc.service.DashBoardService;
import com.opensymphony.xwork2.ActionSupport;

public class DashBoardAction extends ActionSupport {
	
	private List<EmployeeBean> empBeanList=new ArrayList();
	List<String> listofdept=new ArrayList<String>();
	@Override
	public String execute() throws Exception {
		DashBoardService dashBoardService=new DashBoardService();
		
		empBeanList=dashBoardService.getAllEmployees();
		
		listofdept=dashBoardService.getAllDept();
	
	    return SUCCESS;
	
	    }
	public List<EmployeeBean> getEmpBeanList() {
		return empBeanList;
	}
	public void setEmpBeanList(List<EmployeeBean> empBeanList) {
		this.empBeanList = empBeanList;
	}
	public List<String> getListofdept() {
		return listofdept;
	}
	public void setListofdept(List<String> listofdept) {
		this.listofdept = listofdept;
	}


}