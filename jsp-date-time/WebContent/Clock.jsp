<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- primo eseempio jsp -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>A simple JSP example</title>
	<style type="text/css">
		.big{font-family: helvetica , arial , sans-serif;
			 font-weignt: bold;
		 	font-size: 2em;}
	</style>
</head>
<body>
	<p class = "big" align="center">Simple JSP example</p>
	
	<table style="border: 6px outset;" align="center">
		<tr>
			<td style="background-color: yellow;">
				<p class = "big" style="color: blue;">
					
					<%= new java.util.Date() %>
				</p>
			</td>
		</tr>
	</table>
</body>
</html>