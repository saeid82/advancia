<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Connection Pools and Data Sources</title>
</head>
<body>
	<p align="center"><h1>Connection Pools and Data Sources</h1></p><br />
	
	<form action="/connection-pool/CRUD-Servlet" method="get" >
		<p>Which operation would you like to perform?</p>
		<p >
			<input type="radio" name="op" value="select" checked="checked" />SELECT<br />
			<input type="radio" name="op" value="insert" />INSERT<br />
			<input type="radio" name="op" value="update" />UPDATE<br />
			<input type="radio" name="op" value="delete" />DELETE
		</p>
		<p> <input type="submit" name="Submit"/> </p>
	</form>
</body>
</html>