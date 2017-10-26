<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Forward request to another JSP</title>
</head>
<body>
	<% String name = request.getParameter("firstName");%>
	
	<% if(name != null){ %>
		<jsp:forward page="forward2.jsp">
			<jsp:param value="<%= new Date() %>" name="date"/>
		</jsp:forward>
	<% 
		} //fine if
		else{ %> 
		
			<form action="forward1.jsp" method="get">
				<p>Type your first name and press the submit</p>
				<p>
					<input type="text" name="firstName"/>
					<input type="submit" name="Submit"/>
				</p>
			</form>
	
		<%} //fine else%> 
	
</body>
</html>