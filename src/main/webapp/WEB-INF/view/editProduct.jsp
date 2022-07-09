<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.sportyshoes.webproject.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method=POST action="editsub">
name<input type="text" name="name"><br>
category<input type="text" name="category"><br>
quantity<input type="text" name="quantity"><br>
price<input type="text" name="price"><br>

<% String id = request.getParameter("id");%>
<input type="hidden" value=<%=id %> name="id">
<input type="submit" value="Submit">
</from>
</body>
</html>