<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">  
      <title>Edit User</title>
   </head>
   <body>
      <h3>Edit User</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty user}">
         <div align="center"> 
<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/UserInfor" accept-charset="utf-8" class="form-group" style="width:600px;margin: 0px auto;" id="formDemo">
            
            <div class = "col-4" align="left" >
                  
              <div >
				<label for="avatar">Avatar</label>
				<input  name="avatar" id="avatar" type="file" class="form-control" placeholder="Vui lòng chọn ảnh" >
			  </div>
			  <input type="hidden" name="id" value="${user.id}" />   
               <div>
               <label  for="username">Username:</label>
              <input name="username" type="text" id = "username" class="form-control" value="${user.userName}" required>
              </div>
              <div>
              <label  for="email">Email:</label>
              <input name="mail" type="email" id = "email" class="form-control" value="${user.mail}" required>
               </div>
               <div>
              <label  for="phone">Phone:</label>
              <input name="phone" type="tel" id = "phone" class="form-control" value="${user.phone}" required>
               </div>
               <div>
               <label  for="address">Address</label>
              <input name="address" type="text" id = "address" class="form-control" value="${user.address}" required>
              </div>
               <div>	 
	           <label for="myPassword">Password:</label>
               <input  name="password" type="password" id="myPassword" class="form-control" value="${user.password}" required>
               </div> 
               <div>
				<label for="ConfiPassword">Confirm Password</label>
				<input name="confirm_password" id="ConfiPassword" type="password" class="form-control" value="${user.password}" required>
			</div> 
			
			<div ><button type="submit" class="btn btn-primary">Edit</button>
			<a  href="${pageContext.request.contextPath}/UserList" class="btn ">Cancel</a></div>
          </div>    
         </form>
         </div>
      </c:if>
 <script type="text/javascript">

	$(document).ready(function() {
		
		//Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
		$("#formDemo").validate({
					rules: {
						
						password: {
							required: true,
							minlength: 5
						},
						confirm_password: {
							required: true,
							minlength: 5,
							equalTo: "#password"
						},
						
					},
					messages: {
						
						password: {
							required: 'Vui lòng nhập mật khẩu',
							minlength: 'Vui lòng nhập ít nhất 5 kí tự'
						},
						confirm_password: {
							required: 'Vui lòng nhập mật khẩu',
							minlength: 'Vui lòng nhập ít nhất 5 kí tự',
							equalTo: 'Mật khẩu không trùng'
						},
						
					}
				});
	});
	</script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> 
 
   </body>
</html>