
<%@page import="beans.GuestBean"%>
<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page errorPage="guestBookErrorPage.jsp" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="guestData" scope="page" class="beans.GuestDataBean" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Guest List</title>
	<style type="text/css">
		body {
			font-family: tahoma , helvetica , arial , sans-serif;
		}
		table {
			text-align: center;
			font-size: .9em;
			border: 3px groove;
			padding: 5px;
			background-color: #dddddd;
		}
	</style>
</head>
<body>
	<h1>Guest List</h1>
	
	<table>
		<thead>
			<tr>
				<th style="width: 100px;">First name</th>
				<th style="width: 100px;">Last name</th>
				<th style="width: 200px;">E-mail</th>
			</tr>
		</thead>
		
		<%
			List guestList = guestData.getGuestList();
			Iterator guestListIterator = guestList.iterator();
			GuestBean guest;
			while(guestListIterator.hasNext()){	
				guest = (GuestBean) guestListIterator.next();
			
		%>
			<tr>
				<td><%= guest.getName() %></td>
				<td><%= guest.getSurname() %> </td>
				<td><%= guest.getEmail() %></td>

			</tr>
		<%
			}
		%>
		<tbody>
		
		</tbody>
	</table>

</body>
</html>