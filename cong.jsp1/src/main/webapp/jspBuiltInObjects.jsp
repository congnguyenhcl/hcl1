<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Built-in Objects</title>
</head>
<body>
Request user agent: <%= request.getHeader("User-Agent") %>
<br>
Request locale: <%= request.getLocale() %>

</body>
</html>