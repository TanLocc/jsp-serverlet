<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<title>ProductList Page </title>

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

 <h3>Product List</h3>
 
    <p style="color: red;">${errorString}</p>
 <div class=" container-fluid w-75">
    <table class="table table-striped table-bordered table-hover"  cellpadding="5" cellspacing="1" >
      <thead class="thead-light">
       <tr>
          <th>ID</th>
          <th>IMAGE</th>
          <th>NAME</th>
          <th>CATEGORY</th>
          <th>PRICE</th>
          <th>AMOUNT</th>
          <th>DESCRIPTION</th>
          <th>DETAIL</th>
          <th>EDIT</th>
          <th>DELETE</th>
       </tr>
      </thead>
      <tbody>
       <c:forEach items="${ProductList}" var="product" >
          <tr>
             <td>${product.id}</td>
             <td>${product.name}</td>
             <td>
             <img width="100" height="100" src="${pageContext.request.contextPath}/ProductImage?id=${product.id}">
					
             </td>
             <td>${product.cate}</td>
             <td>${product.price}</td>
             <td>${product.amount}</td>
             <td>${product.des}</td>
             <td>${product.detail}</td>
             <td>
                <a href="EditProduct?id=${product.id}">Edit</a>
             </td>
             <td>
                <a href="DeleteProduct?id=${product.id}">Delete</a>
             </td>
          </tr>
       </c:forEach>
     </tbody>  
    </table>
    </div>
    <span><a style="coler: green" href="${pageContext.request.contextPath}/AddProduct">Add New Product</a></span>
    <span><a style="coler: red" href="${pageContext.request.contextPath}/LogOut">LogOut</a></span>
</body>
</html>