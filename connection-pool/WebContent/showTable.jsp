<%@page import="dbTest.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String action = (String) request.getAttribute("action"); %>
<% List<Person> personList = (List<Person>) request.getAttribute("person"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>PERSON</title>
</head>
<body>
	
	<% if(action.equals("select") || action.equals("update") || action.equals("delete")){ %>
	
		<table border="1px solid black;" style="width: 50%;" align="center" bordercolor="green">
					<p><h1 align="center">The table of person:</h1></p>
					<th>
						<th>ID</th>
						<th>FIRSTNAME</th>
						<th>LASTNAME</th>
						<th>AGE</th>
					</th>
		</table>
	<%		for(Person p : personList){
	%>
	
				<table border="1px solid black;" style="width: 50%;" align="center" bordercolor="green">

					<tr align="center">
						<td><%= p.getId() %></td>
						<td><%= p.getFirstname() %></td>
						<td><%= p.getLastname() %></td>
						<td><%= p.getAge() %></td>
					</tr>
				</table>
	<%
			}
		}
	%>
	
		<% if (action.equals("update")) { %>
	<form action = "/connection-pool/CRUD-Servlet" method = "get">
		<p>Type the id of the person to edit:</p>
		<input type = "text" name = "id" />
		<input type = "submit" name = "op" value = "edit" />
	</form>
	<% } %>
	
			<% if (action.equals("delete")) { %>
	<form action = "/connection-pool/CRUD-Servlet" method = "get">
		<p>Type the id of the person to delete:</p>
		<input type = "text" name = "id" />
		<input type = "submit" name = "op" value = "Delete" />
	</form>
	<% } %>
	
	
		<p>Thank you! Click the button below to go back to the Hompage.</p>
	<form action = "/connection-pool/CRUD-Servlet" method = "get">
		<input type = "submit" name = "op" value = "Home" />
	</form>
</body>
</html>