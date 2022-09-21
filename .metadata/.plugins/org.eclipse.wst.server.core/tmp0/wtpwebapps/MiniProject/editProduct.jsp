<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.connection.MyConnection"%>
<%@page import="com.servlets.MenuServlet"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.pojo.Menu"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
${m }
	
	<section>
		<h1>List of Products</h1>
		<!--  in action attribute put path of servlet bydefault is get request -->
		<form action="searchHome.jsp" method="post">
			<input type="text" placeholder="search" name="search" />
			<button type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
		</form>
		<form action="MenuServlet" method="post">
			<label for="id">
			<input type="number" value="${menu.id }" name="id">
			</label>
			<label for="name" >
			<input type="text" value="${menu.name }" name="name">
			</label>
			<label for="price">
			<input type="number" value="${menu.price }" name="price">
			</label>
			<label for="type">
			<input type="text" value="${menu.type }" name="type">
			</label>
			<label for="available">
			<input type="text" value="${menu.available }" name="available">
			</label>

			<input type="submit" value="Update"> 
			<input type="hidden" name="action" value="Update">
			
		</form>



	</section>
</body>
</html>