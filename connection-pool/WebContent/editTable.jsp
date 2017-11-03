<%@page import="dbTest.DatabaseOperation"%>
<%@page import="dbTest.Person"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% Person p = (Person) request.getAttribute("person"); %>
<% String action = (String) request.getAttribute("action"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert</title>
</head>
<body>
	<form action="/connection-pool/CRUD-Servlet" method="get">
		<p><h1 align="center">Insert the person in the table:</h1></p>
		<table border="1px solid black;" style="width: 50%;" align="center" bordercolor="green">
					<tr>
						<th>ID</th>
						<th>FIRSTNAME</th>
						<th>LASTNAME</th>
						<th>AGE</th>
					</tr>
					<tr align="center">
						<td>
							<input type = "hidden" name = "id" value = "<%= p.getId() %>" />
						</td>
						<td>
							<input type = "text" name = "firstName" value = "<%= p.getFirstname() %>" />
						</td>
						<td>
							<input type = "text" name = "lastName" value = "<%= p.getLastname() %>" />
						</td>
						<td>
							<input type = "text" name = "age" value = "<%= p.getAge() %>" />
						</td>
					</tr>
				</table>
		<% if (action.equals("edit")) { %>
		<p align="center">
			<input type = "submit" name = "op" value = "do_update"/>
		</p>
		
		<% } %>
				
		<% if (action.equals("add")) { %>
		<p align="center">
			<input type = "submit" name = "op" value = "add"/>
		</p>
		
		<% } %>
	</form>
	
</body>
</html>