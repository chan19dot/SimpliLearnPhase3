<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter products</title>
</head>
<body>
<form method=POST action=purchasereports/sortedResults>
<%List<String> categories = ((List<String>) request.getAttribute("categories"));%>

<label for="category" >Choose a category:</label>
<select name= "category" id="category">
<% for (String category: categories){ %>
<option value=<%=category %>><%=category %></option>
<%} %>
</select>
<input type="date" name="date">
<input type="submit" value="select">
</form>
</body>
</html>