<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="employee.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
String msg = (String)request.getAttribute("msg");
out.println("page belongs to Admin :"+ab.getFname()+"<br>");
out.println(msg);
%>
<a href="Employee.html">AddEmployee</a>
<a href="view">ViewAllEmployee</a>
<a href="Logout">Logout</a>
</body>
</html>