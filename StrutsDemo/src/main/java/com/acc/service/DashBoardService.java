package com.acc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acc.bean.EmployeeBean;
import com.acc.dao.DbUtils;
import com.acc.form.DepartmentForm;

public class DashBoardService {

	public boolean deleteEmployee(String empId) {
		return DbUtils.deleteEmployeeDetails(empId);
	}

	public boolean updateEmployee(String id, String name, String address, String email, String phone)
			throws SQLException {
		return DbUtils.updateEmployee(id, name, address, email, phone);
	}

	public List<EmployeeBean> getAllEmployees() {
		return DbUtils.getALLEmployee();
	}

	public List<String> getAllDept() {
		List<String>deptList=new ArrayList<String>();
		for(DepartmentForm form : DbUtils.getAllDept()) {
			deptList.add(form.getDeptName());
		}
		return deptList;
	}

	public int saveEmployee(String name, String dept, String address, String email, String phone) {
		return DbUtils.saveEmployee(name, dept, address, email, phone);
	}

}
