<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="employee.AdminBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
out.println("Welcome Admin:"+ab.getFname());
%>
<a href="Employee.html">AddEmployee</a>
<a href="view">View</a>
<a href="logout">Logout</a>
</body>
</html>