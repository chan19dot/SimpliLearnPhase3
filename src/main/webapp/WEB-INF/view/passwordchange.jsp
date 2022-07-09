<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "com.sportyshoes.webproject.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method=POST action="passchangevalidation">
New Password<input type="password" name="newPassword"><br>
Old Password<input type="password" name="oldPassword"><br>
<input type="submit" value=submit>
</form>
</body>
</html>