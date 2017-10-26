<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="rotator" scope="application" class="jsp.Rotator" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>JSP usebean action</title>
	<style type="text/css">
		.big{
			font-family: tahoma , halvetica , arial, sens-serif;
			font-weight: bold;
			font-size: 2em;
		}
	</style>
	
	<% rotator.nextAd(); %>
	
</head>
<body>
	<p class="big"/> 
		<h1> JSP UseBean example </h1>

	
	<p>
		<a href='<%= rotator.getLink() %>' >
			<img src='<%= rotator.getImage()%>'>
	</p>
</body>
</html>