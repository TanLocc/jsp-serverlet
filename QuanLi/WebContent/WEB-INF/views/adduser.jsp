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
<a href="adduser.jsp">View All Records</a><br/>  
  
<h1>Add New User</h1>  
<div align="center"> 
<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/AddUser" accept-charset="utf-8" class="form-group" style="width:600px;margin: 0px auto;" id="formDemo">
 
   <!-- Vertical -->
    <h4>Nhập thông tin new user</h4>
   <div class = "col-4" align="left" >
     <div >
				<label for="avatar">Avatar</label>
				<input  name="avatar" id="avatar" type="file" class="form-control" placeholder="Vui lòng chọn ảnh" required>
	 </div>
     <div>
      <label  for="username">Username</label>
      <input name="username" type="text" id = "username" class="form-control" placeholder="Username" required>
     </div>
     <div>
      <label  for="phone">Phone</label>
      <input name="phone" type="tel" id = "phone" class="form-control" placeholder=" Phone" required>
     </div>
     <div>
      <label  for="email">Email</label>
      <input name="email" type="email" id = "email" class="form-control" placeholder=" Email" required>
     </div>
     <div>
      <label  for="address">Address</label>
      <input name="address" type="text" id = "address" class="form-control" placeholder="Address" required>
     </div>
     <div>	 
	  <label for="myPassword">Password</label>
      <input name="password" type="password" id="myPassword" class="form-control" placeholder="Password" required>
     </div>  
	  <button type="submit" class="btn btn-primary">AddUser</button>
      
   </div>
   <span> Quay lại user list thì bấm vào<a class="link" href="Admin.jsp"> đây </a>.</span>
   
 
</form>   
</div> 
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>  
</html> 