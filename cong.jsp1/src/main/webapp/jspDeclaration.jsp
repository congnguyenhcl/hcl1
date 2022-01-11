<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.codingnotes.cong.jsp1.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Declaration</title>
</head>
<body>
<%!
	String upper(String str){
	return str.toUpperCase();
}

%>
Uppercase "cap this: "<%= upper("cap this") %>
<br>
Uppercase "cap this: "<%= UpperCaseThis.m1("cap this") %>

</body>
</html>