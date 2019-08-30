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
    
</div>  

 <h3>User List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ID</th>
          <th>USERNAME</th>
          <th>Avatar</th>
          <th>MAIL</th>
          <th>PASSWORD</th>
          <th>ROLE</th>
          <th>EDIT</th>
          <th>DELETE</th>
       </tr>
       <c:forEach items="${userList}" var="user" >
          <tr>
             <td>${user.id}</td>
             <td>${user.userName}</td>
             <td>
             <img width="100" height="100" src="${pageContext.request.contextPath}/image?id=${user.id}">
					
             </td>
             
             <td>${user.mail}</td>
             <td>${user.password}</td>
             <td>${user.role}</td>
             <td>
                <a href="EditUser?id=${user.id}">Edit</a>
             </td>
             <td>
                <a href="deleteUser?id=${user.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
       
    </table>
    <span><a style="coler: green" href="${pageContext.request.contextPath}/AddUser">Add New User</a></span>
    <span><a style="coler: red" href="${pageContext.request.contextPath}/LogOut">LogOut</a></span>
</body>
</html>