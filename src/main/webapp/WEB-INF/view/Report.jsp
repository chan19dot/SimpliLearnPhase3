<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sportyshoes.webproject.model.*" %>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reports</title>
</head>
<body>

<table border="1">



<% List<User> fp=(List<User>) request.getAttribute("ReportList");%>
<tr><th>Id</th><th>name</th><th>password</th><th>Date of Purchase</th><th>total Amount</th><th>Category</th></tr>
<%for(User f: fp) { 
String Id =  f.getUid() +"" ;
%>

<tr><td><%=Id %></td><td><%=f.getUname() %></td><td><%=f.getUpassword() %></td><td><%=f.getDateofpurchase() %></td><td><%=f.getTotalamount() %></td><td><%=f.getCategory() %></td></tr>
<%} %>


</body>
</html>