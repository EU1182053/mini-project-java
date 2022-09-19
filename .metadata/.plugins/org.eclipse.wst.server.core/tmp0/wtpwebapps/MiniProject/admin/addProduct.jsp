<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.Connection"%>
<%@page import="com.connection.MyConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product Form</title>
</head>
<body>

<%
	int id = 1;
	Connection conn = MyConnection.connect();
	
	String sql = "select max(id) from menu;";
	PreparedStatement stmt = conn.prepareStatement(sql);
	ResultSet rs = stmt.executeQuery();
	
	while(rs.next()){
	 	id=rs.getInt(1);
	 	id=id+1;
	}
	
	
%>
    <section>
        <h1>Add Product Form</h1>
        <!--  in action attribute put path of servlet bydefault is get request -->
        <form action="MenuServlet" method="post">
            <!-- text field-->
            
            <h3>Product Id:<% out.println(id);%></h3>
            <input type="hidden" name="id" value="<% out.println(id);%>"  required>
            
            <label for="name">Name: </label>
            <input type="text" name="name"  required>
            
            <label for="price">Price: </label>
            <input type="number" name="price"  required>
            
            <label for="type">Type: </label>
            <input type="text" name="type"  required>
            
            <label for="in_stock">In Stock: </label>
            <input type="text" name="in_stock"  required></input>
 
            
            <input type="submit" value="Add Product">
            <input type="reset">
            <input type="hidden" name="act" value="addProduct"> 
        </form>
    </section>
</body>
</html>