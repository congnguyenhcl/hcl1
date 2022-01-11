<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>
	<h1>The student is confirmed: ${param.firstName} ${param.lastName }</h1>
	<h1>The student's country: ${param.country}</h1>

	<h1>Display confirmation info using a List and a loop</h1>
	<%
	List<String> info = Arrays.asList(request.getParameter("firstName"), request.getParameter("lastName"),
			request.getParameter("country"));
	for(String value:info){
		out.print("<li>" + value + "</li>");
	}
	%>
</body>
</html>