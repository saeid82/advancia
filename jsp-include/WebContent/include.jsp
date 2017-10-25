<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Using jsp: include</title>
</head>
<body>
	<table>
		<tr>
			<td style = "with: 160px; text-align: center">
				<img src = "image/logo.png"
					width = "140" height = "93" />
			</td>
			<td>
				<%-- include banner.html --%>
				<jsp:include page="banner.html" flush = "true" />
			</td>
		</tr>
		
		<tr>
			<td style = "width: 160px">
				<%-- include sidebar.html --%>
				<jsp:include page="sidebar.html" flush = "true"/>
			</td>
			
			<td style = "vertical-align: top">
				<%-- include clock2.jsp --%>
				<jsp:include page="clock2.jsp" flush = "true" />
			</td>
		</tr>
	</table>
</body>
</html>