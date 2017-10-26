<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<table>
	<tr>
		<td style="background-color: black;">
			<p class="big" style="color: cyan; font-size: 3em; font-weight: bold;">
				
<%-- 				<%= response.getWriter().write(String.format("The time is: %s", new Date())) %> --%>
				<% Locale local = request.getLocale(); %>
				<% DateFormat dateformat =DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local); %>
				<%= dateformat.format(new Date()) %>
			</p>
		</td>
	</tr>
</table>


