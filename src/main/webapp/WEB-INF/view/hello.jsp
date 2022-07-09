<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import= "com.sportyshoes.webproject.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
<%Admin admin =(Admin) request.getAttribute("admin");
%>
Welcome <%=admin.getAdminname() %> 
<form method=POST action=admin/purchasereports >
<input type="submit" value="Purchase Reports">
</form>
<form method=POST action=admin/manageproducts >
<input type="submit" value="Manage Products">
</form>

<form method=POST action=admin/passwordchange>
<input type="submit" value="Change Password">
</form>

<form method=POST action=admin/allusers>
<input type="submit" value="List All Users">
</form>
</body>
</html>