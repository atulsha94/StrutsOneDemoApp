package com.acc.form;

import org.apache.struts.action.ActionForm;

public class DepartmentForm extends ActionForm  {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String deptName;
	
	
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String name) {
		this.deptName = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
