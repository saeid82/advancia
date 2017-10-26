<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="guestBookErrorPage.jsp" %>
<jsp:useBean id="guest" scope="page" class="beans.GuestBean" />
<jsp:useBean id="guestData" scope="page" class="beans.GuestDataBean"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Guest Book Login</title>

	<style type="text/css">
		body {
			font-family: tahoma , helvetica , arial , sans-serif;
		}
		table {
			font-size: .9em;
			border: 3px groove;
			padding: 5px;
			background-color: #dddddd;
		}
	</style>
</head>

<body>
	<jsp:getProperty property="*" name="guest"/>
	
	<%
		if(guest.getName() == null ||
		   guest.getSurname() == null ||
		   guest.getEmail() == null){
	%>
	
	<form action="guestBookLogin.jsp" method="post">
		<p>
			<h2>Enter your name and surname and email to register in our GuestBook</h2>
		</p>
		<table>
			<tr>
				<td> First name</td>
				<td>
					<input type="text" name="firstName" />
				</td>
			</tr>
			
			<tr>
				<td> First name</td>
				<td>
					<input type="text" name="sureName" />
				</td>
			</tr>
			
			<tr>
				<td>E-mail</td>
				<td>
					<input type="text" name="email" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2">
					<input type="submit" name="Submit"/>
				</td>
			</tr>
		</table>
	
	</form>
	<%
		} // fine if
		else{
			guestData.addGuestToDb(guest);
	%>
		<jsp:forward page="guestBookView.jsp" />
	<%
		} // fine else
	%>
</body>
</html>