<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
 <%@ taglib uri="WEB-INF/mytags.tld" prefix="m" %>  
Current Date and Time is: <m:today/>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
Employee saved with id ${savedId}
<%-- <bean:write name="employeeForm" property="employeeId"/> --%>
</body>
</html>