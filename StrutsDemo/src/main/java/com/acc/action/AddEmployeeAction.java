package com.acc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acc.bean.EmployeeBean;
import com.acc.service.DashBoardService;
import com.opensymphony.xwork2.ActionSupport;

public class AddEmployeeAction extends ActionSupport {
	private int employeeId;
	private String id;
	private String name;
	private String dept;
	private String address;
	private String email;
	private String phone;
	private List<EmployeeBean> empBeanList=new ArrayList();
	@Override
	public String execute() throws Exception {
		//List<EmployeeBean> empBeanList=new ArrayList();
		DashBoardService dashBoardService =new DashBoardService();
		
		
		int savedIdOfEmployee=dashBoardService.saveEmployee(name,dept,address,email,phone) ;
		System.out.println("savedIdOfEmployee "+savedIdOfEmployee);
		
			
		 empBeanList=dashBoardService.getAllEmployees();
			
		
		return "success";
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<EmployeeBean> getEmpBeanList() {
		return empBeanList;
	}
	public void setEmpBeanList(List<EmployeeBean> empBeanList) {
		this.empBeanList = empBeanList;
	}

}
