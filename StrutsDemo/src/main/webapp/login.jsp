
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 logindiv">
				<form class="login100-form validate-form" action="userLogin" method="post">
				<div style="color: red"><html:errors />${msgId} <s:actionerror /></div>
					<span class="login100-form-title p-b-49">
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">User Name</span>
						 <s:textfield cssClass="userLoginForm" name = "userName" size = "20" ></s:textfield>
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>
					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						 <s:password cssClass="userLoginForm" name = "password" size = "20" ></s:password>
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="text-right p-t-8 p-b-31">
						<a href="#">
							Forgot password?
						</a>
					</div>
					
					<div class="container-login100-form-btn">
					 <div class="wrap-login100-form-btn">
					 <div class="login100-form-bgbtn"></div>
 						<button class="login100-form-btn">
						Login
					</button>
					</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	


</body>
</html>