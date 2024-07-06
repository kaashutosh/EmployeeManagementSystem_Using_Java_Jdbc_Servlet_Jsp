<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,employee.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean)session.getAttribute("abean");
ArrayList<EmployeeBean> al = (ArrayList<EmployeeBean>)session.getAttribute("alist");
out.println("page belongs to Admin :"+ab.getFname()+"<br>");
if(al.size()==0){
	out.println("Employees Not Available....<br>");
}else{
	Iterator<EmployeeBean> itr = al.iterator();
	while(itr.hasNext()){
		EmployeeBean eb = (EmployeeBean)itr.next();
		out.println(eb.getEid()+"&nbsp&nbsp"+eb.getEname()+"&nbsp&nbsp"+eb.getEdesg()+"&nbsp&nbsp"+eb.getBsal()+"&nbsp&nbsp"+eb.getHra()+"&nbsp&nbsp"+eb.getDa()+"&nbsp&nbsp"+eb.getTotsal()+"&nbsp&nbsp"+"<a href='edit?eid="+eb.getEid()+"'>Edit</a>"+"&nbsp&nbsp"+"<a href='delete?eid="+eb.getEid()+"'>Delete</a>"+"<br>");
	}
}
%>
<a href="Logout">Logout</a>
</body>
</html>