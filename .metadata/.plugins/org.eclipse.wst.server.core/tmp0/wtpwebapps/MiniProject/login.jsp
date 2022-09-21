<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Form</title>
</head>
<body>
	<h2>LOGIN FORM</h2>
	<form action="UserServlet" method="post">
		<label>Email Id:</label><input type="email" name="email" required><br>
		<br> <label>Password:</label><input type="text" name="password"
			id="pass" required><br> <br> <input type="submit"
			value="LOGIN"> <input type="reset"> <input
			type="hidden" name="action" value="loginAction">
	</form>

<a href="forgotPassword.jsp">Forgot Password?</a>
	<button onclick="forgotPassword.jsp">Forgot Password?</button>

	<%
	String registerMsg = request.getParameter("msg");
	if ("valid".equals(registerMsg)) {
	%>
	<h1>Successfully Registered.</h1>
	<%
	}
	%>
	<%
	if ("invalid".equals(registerMsg)) {
	%>
	<h1>Something went wrong!</h1>
	<%
	}
	%>
	<%
	String forgotPasswordMsg = request.getParameter("msg");
	if("done".equals(forgotPasswordMsg)){
		%>
		<h1>Password Change Successful.</h1>
		<%
	}
	%>
</body>
</html>