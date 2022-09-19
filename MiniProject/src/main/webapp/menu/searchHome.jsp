<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.connection.MyConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Menu</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>

	<section>
		<h1>Start Search Menu</h1>
		<!--  in action attribute put path of servlet bydefault is get request -->
		
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Price</th>
					<th>Type</th>
					<th>Available</th>

				</tr>
			</thead>
			<tbody>
				<%
				try{
					String search = request.getParameter("search");
					out.println("search: "+search);
					Connection conn = MyConnection.connect();
					String sql = "SELECT * FROM menu WHERE name LIKE ?%;";
					out.println("sql: "+sql);
					PreparedStatement stmt = conn.prepareStatement(sql);
			
					stmt.setString(1, search);
					
					ResultSet rs = stmt.executeQuery();
					out.println("rs: "+rs);
					if(rs.next()){
						out.println("rs: "+rs);
						while (rs.next()) {
							%>
							<tr>
								<td>
									<%
									out.println(rs.getInt(1));
									%>
								</td>
								<td>
									<%
									out.println(rs.getString(2));
									%>
								</td>
								<td>
									<%
									out.println(rs.getInt(3));
									%>
								</td>
								<td>
									<%
									out.println(rs.getString(4));
									%>
								</td>
								<td>
									<%
									out.println(rs.getString(5));
									%>
								</td>
							</tr>
							
							
							<%
							}
					}
					else{
						%>
						<h2>Nothing to show</h2>
						
						<%
					}
				}
				catch(Exception e){
					System.out.println(e);
				}
				%>
			</tbody>
		</table>




		<%
		String msg = request.getParameter("msg");
		if ("valid".equals(msg)) {
		%>
		<h1>User Log in Successful.</h1>

		<%
		}
		%>
	</section>
</body>
</html>