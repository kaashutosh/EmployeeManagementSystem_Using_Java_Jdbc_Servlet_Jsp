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
EmployeeBean eb = (EmployeeBean)request.getAttribute("ebean");
out.println("Page belongs to Admin :"+ab.getFname()+"<br>");
%>
<form action="update" method="post">
<input type="hidden" name="eid" value=<%=eb.getEid() %>>
BasicSal :<input type="text" name="bsal" value=<%=eb.getBsal() %>><br>
HRA(1-100) :<input type="text" name="hra" value=<%=eb.getHra() %>><br>
DA(1-100) :<input type="text" name="da" value=<%=eb.getDa() %>><br>
<input type="submit" value="UpdateEmployee">
</form>
</body>
</html>