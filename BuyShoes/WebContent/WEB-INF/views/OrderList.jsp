<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>OrderList </title>
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

 <h3>ORDER List</h3>
 
    <p style="color: red;">${errorString}</p>
 
    <div class=" container-fluid w-75">
    <table class="table table-striped table-bordered table-responsive table-hover"  cellpadding="5" cellspacing="1" >
      <thead class="thead-light">
       <tr>
          <th>ID</th>
          <th>UERNAME</th>
          <th>AVATAR</th>
          <th>PRODUCTNAME</th>
          <th>PRODUCTIMAGE</th>
          <th>AMOUNT</th>
          <th>GMAIL
          <th>Phone</th>
          <th>Address</th>  
          <TH>STATE</TH>

       </tr>
       </thead>
       <tbody>
       <c:forEach items="${orderlist}" var="order" >
          <tr>
             <td>${order.id}</td>
             <td>${order.userName}</td>
             <td>
             <img width="100" height="100" src="${pageContext.request.contextPath}/image?id=${order.cus_id}">					
             </td>
             <td>${order.name}</td>             
             <td>
             <img width="100" height="100" src="${pageContext.request.contextPath}/ProductImage?id=${order.pro_id}">					
             </td>
             <td>${order.amount}</td>             
             <td>${order.mail}</td>
             <td>${order.phone}</td>
             <td>${order.address}</td>
             
             
             <td>
               <c:if  test="${order.state=='0'}" >
                <a style = "color:blue" href="OrderState?id=${order.id}&amount=${order.amount}&state=${order.state}&proID=${order.pro_id}">CONFIRM</a>  
               </c:if>
               <c:if  test="${order.state=='1'}" >
                <p>BE CONFIRMED</p>
                <a style = "color:blue" href="OrderState?id=${order.id}&amount=${order.amount}&state=${order.state}&proID=${order.pro_id}">CANCEL</a>   
               </c:if>
             </td>
             
          </tr>
       </c:forEach>
       </tbody>
    </table>
    </div>
    <span><a style="coler: green" href="${pageContext.request.contextPath}/AddUser">Add New User</a></span>
    <span><a style="coler: red" href="${pageContext.request.contextPath}/LogOut">LogOut</a></span>
</body>
</html>