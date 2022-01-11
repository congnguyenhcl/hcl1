<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
!<!-- %= is where you can declare a single expression -->
<h3>The time is now <%= new java.util.Date() %></h3>
<h3>Simple multiplication <%= 100*25 %></h3>
<p>Converting a String to uppercase <%= new String("Hello Java").toUpperCase() %></p>

</body>
</html>