<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sportyshoes.webproject.model.*" %>
<%@ page import="java.util.*" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Products</title>
</head>
<body>
<table border="1">

<% List<Product> fp=(List<Product>) request.getAttribute("products");%>
<tr><th>Id</th><th>name</th><th>quantity</th><th>Price</th><th>Category</th><th>Edit</th><th>Delete</th></tr>
<%for(Product f: fp) { 
String Id =  f.getProductid() +"" ;
%>

<tr><td><%=Id %></td><td><%=f.getShoename() %></td><td><%=f.getQuantity() %></td><td><%=f.getPrice() %></td><td><%=f.getCategory() %></td><td><a href="<%="manageproduct/edit?id="+Id%>">Edit</a></td><td><a href="<%="manageproduct/delete?id="+Id %>">Delete</a></td></tr>
<%} %>
</table>
<a href="manageproduct/add">Click here to add a new product</a>
</body>
</html>