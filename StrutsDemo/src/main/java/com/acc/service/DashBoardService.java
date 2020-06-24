package com.acc.service;

import com.acc.dao.DbUtils;
import com.acc.form.EmployeeForm;

public class DashBoardService {

	public boolean deleteEmployee(String empId) {
		return DbUtils.deleteEmployeeDetails(empId);
	}
	public boolean updateEmployee(EmployeeForm updatedEmpForm) {
		return DbUtils.updateEmployee(updatedEmpForm);
	}
}
