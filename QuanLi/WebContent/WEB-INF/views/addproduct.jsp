<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">  
<title>Add User Form</title>  
</head>  
<body>  
<p style="color: red;">${errorString}</p>  
<a href="addproduct.jsp">View All Records</a><br/>  
  
<h1>Add New Product</h1>  
<div align="center"> 
<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddProduct" accept-charset="utf-8" class="form-group" style="width:600px;margin: 0px auto;" id="formDemo">
 
   <!-- Vertical -->
    <h4>Nhập thông tin new user</h4>
   <div class = "col-4" align="left" >
     <div >
		<label for="image">Image</label>
		<input  name="image" id="image" type="file" class="form-control" placeholder="Vui lòng chọn ảnh" required>
	 </div>
     <div>
      <label  for="name">ProductName</label>
      <input name="name" type="text" id = "name" class="form-control" placeholder="ProductName" required>
     </div>
      <div>
      <label  for="cate">Category</label>
      <input name="cate" type="text" id = "cate" class="form-control" placeholder="Category" required>
     </div>
     <div>
      <label  for="price">Price</label>
      <input name="price" type="text" id = "price" class="form-control" placeholder=" Price" required>
     </div>
     <div>	 
	  <label for="Des">Description</label>
      <input name="des" type="text" id="Des" class="form-control" placeholder="Description" required>
     </div> 
     <div>	 
	  <label for="detail">Detail</label>
      <input name="detail" type="text" id="detail" class="form-control" placeholder="Detail" required>
     </div> 
	  <button type="submit" class="btn btn-primary">AddProduct</button>
      
   </div>
   <span> Quay lại product list thì bấm vào<a class="link" href="Admin.jsp"> đây </a>.</span>
   
 
</form>   
</div> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>  
</html> 