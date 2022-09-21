<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.connection.MyConnection"%>
<%@page import="com.servlets.MenuServlet"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<section>
		<h1>Product to Update</h1>
		<!--  in action attribute put path of servlet bydefault is get request -->
		<form action="searchHome.jsp" method="post">
			<input type="text" placeholder="search" name="search" />
			<button type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
		</form>
		
		


		<table>
			<tr>
				<th>Id</th>
				<th>name</th>
				<th>Price</th>
				<th>Type</th>
				<th>Available</th>
			</tr>
			
			<c:forEach items="${menuList}" var="menu">
				<tr>
					<td>${menu.id }</td>
					<td>${menu.name}</td>
					<td>${menu.price}</td>
					<td>${menu.type}</td>
					<td>${menu.available}</td>
					<td><a href="MenuServlet?action=editById&id=${menu.id}">Edit</a></td>
					<td><a href="MenuServlet?action=deleteById&id=${menu.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>


	</section>
</body>
</html>