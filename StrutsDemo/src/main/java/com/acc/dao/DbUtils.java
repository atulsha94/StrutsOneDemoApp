package com.acc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.acc.bean.EmployeeBean;
import com.acc.bean.ProjectBean;
import com.acc.form.DepartmentForm;

public class DbUtils {

	public static int saveEmployee(String name, String dept, String address, String email, String phone) {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		int generatedEmpId = -1;
		if (conn != null) {
			try {
				st = conn.createStatement();
				String insertSql = "insert into employee(EMP_NAME,Dept_Name,Email,Address,PhoneNo) " + " values('"
						+ name + "','" + dept + "','" + email + "','" + address + "','" + phone + "')";

				System.out.println("query insert" + insertSql);
				int m = st.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);
				System.out.println("Ok its working");

				if (m > 0) {
					rs = st.getGeneratedKeys();

					if (rs.next()) {
						generatedEmpId = rs.getInt(1);
					}
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return generatedEmpId;

	}

	public static List<DepartmentForm> getAllDept() {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;

		List<DepartmentForm> listofdept = new ArrayList<DepartmentForm>();
		if (conn != null) {
			try {
				st = conn.createStatement();
				String Sql = "Select * from department";
				rs = st.executeQuery(Sql);
				while (rs.next()) {
					String id = rs.getString("Dept_ID");
					String dept = rs.getString("DEPT_NAME");
					
					DepartmentForm deptForm=new DepartmentForm();
					deptForm.setId(id);
					deptForm.setDeptName(dept);
					listofdept.add(deptForm);
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return listofdept;
	}

	public static boolean updateEmployee(String id, String name, String address, String email, String phone)
			throws SQLException {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		if (conn != null) {
			try {
				String updateSql = "update employee" + " set EMP_NAME='" + name + "'," + "EMAIL='" + email + "',"
						+ "ADDRESS='" + address + "'," + "PHONENO=" + phone + " where emp_id=" + id;

				System.out.println(updateSql);

				if (st.executeUpdate(updateSql) > 0) {
					return true;
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return false;

	}

	public static List<EmployeeBean> getALLEmployee() {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;

		List<EmployeeBean> listOfemp = new ArrayList<EmployeeBean>();
		if (conn != null) {
			try {
				st = conn.createStatement();
				String Sql = "Select EMP_ID,EMP_NAME,DEPT_NAME,Address,Email,PhoneNo from employee";
				rs = st.executeQuery(Sql);
				while (rs.next()) {
					EmployeeBean ef = new EmployeeBean();
					int employeeId = Integer.parseInt(rs.getString("EMP_ID"));
					String id = String.valueOf(employeeId);
					String name = rs.getString("EMP_NAME");
					String dept = rs.getString("DEPT_NAME");
					String address = rs.getString("Address");
					String email = rs.getString("Email");
					String phoneNo = rs.getString("PhoneNo");

					ef.setId(id);
					ef.setName(name);
					ef.setDept(dept);
					ef.setAddress(address);
					ef.setEmail(email);
					ef.setPhone(phoneNo);
					listOfemp.add(ef);
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return listOfemp;
	}

	public static boolean getuserDetails(String userName, String password) {
		Connection conn = DbConnection.getConnection();
		ResultSet rs = null;
		boolean found = false;
		if (conn != null) {
			try {
				String sql = "SELECT * FROM userdetails WHERE userName = ? and password = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, userName);
				statement.setString(2, password);

				rs = statement.executeQuery();

				if (rs.next()) {
					found = true;
				}
				return found;

			} catch (SQLException se) {
				found = false;
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}

					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return found;

	}

	public static boolean deleteEmployeeDetails(String empId) {
		Connection conn = DbConnection.getConnection();
		ResultSet rs = null;
		boolean delete = false;
		if (conn != null) {
			try {
				String sql = "DELETE FROM employee WHERE EMP_ID = ?";
				System.out.println(sql);
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, empId);
				int result = statement.executeUpdate();
				if (result == 1) {
					delete = true;
				}

			} catch (SQLException se) {
				delete = false;
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}

					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return delete;

	}
	
	
	public static boolean updateDepartment(DepartmentForm form)
			throws SQLException {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		if (conn != null) {
			try {
				String updateSql = "update department" + " set DEPT_NAME='" + form.getDeptName() + "'"+ " where DEPT_ID=" + form.getId();

				System.out.println(updateSql);

				if (st.executeUpdate(updateSql) > 0) {
					return true;
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return false;

	}
	
	public static boolean addDepartment(DepartmentForm form) {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		boolean generatedId = false;
		if (conn != null) {
			try {
				st = conn.createStatement();
				String insertSql = "insert into department(Dept_Name) " + " values('"
						+ form.getDeptName() + "')";

				System.out.println("query insert" + insertSql);
				int m = st.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);

				if (m > 0) {
					rs = st.getGeneratedKeys();

					if (rs.next()) {
						generatedId =true;
					}
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return generatedId;

	}
	public static List<ProjectBean> getAllProject() {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;

		List<ProjectBean> listofProject = new ArrayList<ProjectBean>();
		if (conn != null) {
			try {
				st = conn.createStatement();
				String Sql = "Select * from project";
				rs = st.executeQuery(Sql);
				while (rs.next()) {
					String id = rs.getString("PROJECT_ID");
					String projectName = rs.getString("PROJECT_NAME");
					
					ProjectBean deptForm=new ProjectBean();
					deptForm.setId(id);
					deptForm.setProjectName(projectName);
					listofProject.add(deptForm);
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return listofProject;
	}
	public static boolean updateProject(ProjectBean bean)
			throws SQLException {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		st = conn.createStatement();
		if (conn != null) {
			try {
				String updateSql = "update project" + " set PROJECT_NAME='" + bean.getProjectName() + "'"+ " where PROJECT_ID=" + bean.getId();

				System.out.println(updateSql);

				if (st.executeUpdate(updateSql) > 0) {
					return true;
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return false;

	}
	
	public static boolean addProject(ProjectBean bean) {
		Connection conn = DbConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		boolean generatedEmpId = false;
		if (conn != null) {
			try {
				st = conn.createStatement();
				String insertSql = "insert into project(Project_Name) " + " values('"
						+ bean.getProjectName() + "')";

				System.out.println("query insert" + insertSql);
				int m = st.executeUpdate(insertSql, Statement.RETURN_GENERATED_KEYS);

				if (m > 0) {
					rs = st.getGeneratedKeys();

					if (rs.next()) {
						generatedEmpId =true;
					}
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}
					if (st != null) {
						st.close(); // close statement
					}
					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return generatedEmpId;

	}
	public static boolean deleteProject(String projectId) {
		Connection conn = DbConnection.getConnection();
		ResultSet rs = null;
		boolean delete = false;
		if (conn != null) {
			try {
				String sql = "DELETE FROM PROJECT WHERE PROJECT_ID = ?";
				System.out.println(sql);
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, projectId);
				int result = statement.executeUpdate();
				if (result == 1) {
					delete = true;
				}

			} catch (SQLException se) {
				delete = false;
			} finally {
				try {
					if (rs != null) {
						rs.close(); // close result set
					}

					if (conn != null) {
						conn.close(); // close connection
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
		return delete;

	}
	
}
