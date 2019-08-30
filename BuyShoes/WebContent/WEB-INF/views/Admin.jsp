<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page </title>
</head>
<body>
<h1 style ="color:blue">This is Admin's page</h1>

<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/Admin">Home</a>
   |
   <a href="${pageContext.request.contextPath}/UserList">User List</a>
   |
   <a href="${pageContext.request.contextPath}/ProductList">Product List</a>
   |
   <a href="${pageContext.request.contextPath}/OrderList">Order List</a>
    
</div>  

   
</body>
</html>