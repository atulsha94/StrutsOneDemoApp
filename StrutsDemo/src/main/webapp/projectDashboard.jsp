<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%> --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.acc.bean.ProjectBean"%>
<%@ taglib uri="WEB-INF/mytags.tld" prefix="t" %>  
<%@ taglib uri="WEB-INF/message.tld" prefix="m" %>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/dataTables.bootstrap4.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/dataTables.bootstrap4.min.js"></script>
<script>
		$(document).ready(function() {
			$('#example').DataTable();
		});
		
		function deletefun(val){
			 //alert(document.forms[0].action);
			 document.forms[2].action="deleteProject?projectId="+val;
			document.getElementById("deleteId").click();
			}
		function editfun(id,name){
			 document.getElementById("editProjectId").value=id;
			 document.getElementById("editProjectId1").value=id;
			 document.getElementById("editProjectName").value=name;
			
			document.getElementById("editId").click();
			}
		function clear(){
			alert("clear");
			 document.getElementById("name").value="";
		
			}
		
	</script>

</head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Management</title>
</head>

<body>

<div align="right" class="col-sm-7">
		<h2>
			<m:message mess = "Manage Project"/>  
		</h2>
	</div>
	<div align="right">
		Time: <t:time/>
	</div>
	<!-- <div class="col-sm-6">
		<h2>
			Manage <b>Project</b>
		</h2>
	</div> -->
	<div align="right">
		<a href="#addEmployeeModal" class="btn btn-success"
			data-toggle="modal"><span>Add New Project</span></a>
			<a href="../dashboard" class="btn btn-success"
			><span>View Employee Dashboard</span></a>
			<a href="../deptDashboard.do" class="btn btn-success"
			><span>View Department Dashboard</span></a>
	</div>
	<br />
	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">

		<thead align="center">
			<tr>
				<th>Project Id</th>
				<th>Project Name</th>
				<th>Update?</th>
				<th>Delete?</th>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="project" items="${projectList}">
				<tr>
					<td>${project.id}</td>
					<td>${project.projectName}</td>
					
					
					<td>
					<button type="button" class="btn btn-primary" onclick="editfun('${project.id}', '${project.projectName}')">Edit</button>
						<a href="#editEmployeeModal" class="edit" data-toggle="modal" id="editId"></a>
					</td>
					<td>
						<button type="button" class="btn btn-primary"
							onclick="deletefun('${project.id}')">Delete</button>
						<a href="#deleteEmployeeModal1" class="delete" data-toggle="modal" id="deleteId"></a>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>

	<%-- <html:link action="/addEmployee">Add Employee</html:link>
	<br></br>
	<%-- <html:link action="/updateEmployee">Update Employee</html:link> --%>
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="addProject" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Add Project</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Project Name</label>
							<!--                         <input type="text" id="name"   class="employeeForm" required> -->

							<input type="text" class="form-control" id="name" name="projectName"
								required="required" value="">

						</div>
						

						
						
					</div>

					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel" oncancel="clear();"> <input type="submit"
							class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div> 

	<div id="editEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="updateProject" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Edit Project</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Project Id</label> <input type="text"
								class="form-control" id="editProjectId" name="id1"
								disabled="disabled"> <input type="hidden"
								class="form-control" id="editProjectId1" name="id">

						</div>
						<div class="form-group">
							<label>Project Name</label> <input type="text"
								class="form-control" id="editProjectName" name="projectName"
								required="required">
						</div>
						
						
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit" class="btn btn-info"
							value="Save">
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Delete Modal HTML -->
	 <div id="deleteEmployeeModal1" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="deleteEmployee" method="post">
					<div class="modal-header">
						<h4 class="modal-title">Delete Employee</h4>
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true" onclick="clear();">&times;</button>
					</div>
					<div class="modal-body">
						<p>Are you sure you want to delete these record?</p>
						<p class="text-warning">
							<small>This action cannot be undone.</small>
						</p>
						
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal"
							value="Cancel"> <input type="submit"
							class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div> 

</body>
</html>