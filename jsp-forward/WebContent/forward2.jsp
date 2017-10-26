<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Processing a forward request</title>

	<style type="text/css">
		.big{
			font-family: tahoma , halvetica , arial, sens-serif;
			font-weight: bold;
			font-size: 2em;
		}
	</style>
</head>
<body>
	<p class="big">
		Hello <%= request.getParameter("firstName") %> <br />
		your request was received and forwarded at <br />
	</p>
	
	<table>
		<tr>
			<td style="background-color: black; align-content: center;">
				<p class="big" style="color: cyan;">
					<%= request.getParameter("date") %>
				</p>
			</td>
		</tr>
	</table>
</body>
</html>