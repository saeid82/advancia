<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Processing GET request with data</title>
</head>
<body>
	<%
		String name = request.getParameter("firstName");
		if(name != null){
	%>
	
		<h1>Hello <%= name %><br />Welcome to JavaServer</h1>
	<%
		}
		else{
	%>
	
	<form action="welcome.jsp" method="get">
		<p>Type your first name and press Submit</p>
		
		<p>
			<input type="text" name="firstName" />
			<input type="submit" name="Submit" />
		</p>
	</form>
	<%
		}
	%>
</body>
</html>