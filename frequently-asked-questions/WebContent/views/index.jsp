<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>FAQ</title>
</head>
	<h1>How can I help you?</h1>
<body>
	<div>
		<form action="/frequently-asked-questions/controls/faqservlet" method="get">
			<h3>Choose the topic for which you would like assistance:</h3>
			<select>
				<option> Select..... </option>
				<option value="01"> Topic 01 </option>
				<option value="02"> Topic 02 </option>
				<option value="03"> Topic 03 </option>
				<option value="04"> Topic 04 </option>
				<option value="05"> Topic 05 </option>
				<option value="06"> Topic 06 </option>
			</select>
			</br>
			<input type="submit" value="FAQ" />
		</form>
	</div>
</body>
</html>