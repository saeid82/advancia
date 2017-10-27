<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage= "true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Error !</title>

	<style type="text/css">
		.bigRed {
			font-family: tahoma , helvetica , arial , sans-serif;
			font-size: 2em;
			color: red;
			font-weight: bold;
		}
	</style>
</head>

<body>
	<p class="bigRed">
	<%
		if(exception instanceof SQLException)
	%>
			An SQLException
	<%
		else if(exception instanceof ClassNotFoundException)
	%>
			A ClassNotFoundException
	<%
		else
	%>
			An exception
		Occurred while interacting with the guestBook database.
	</p>
	<p class="bigRed">
		The error mrssage was:<br />
		<%= exception.getMessage() %>
	</p>
</body>
</html>