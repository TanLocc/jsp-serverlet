<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Register</title>	
	<style type="text/css">
		
		label.error {
			display: inline-block;
			color:red;
			width: 200px;
		}
	</style>
	<link rel="stylesheet"  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	<!-- Load Thư viện jQuery vào trước khi load jQuery Validate-->
	<script type="text/javascript" src="jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="jquery.validate.min.js"></script>
</head>
<body >
   
   <nav class="navbar fixed-top  navbar-expand-sm  bg-dark navbar-dark " id="myTab" role="tablist">
 		         
          <a class=" navbar-brand text-success "  href="Startbookstrap.html" >Start bootstrap</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
		 <div class="collapse   navbar-collapse " id="collapsibleNavbar">
		 
		 <ul class="navbar-nav   text-primary ml-auto ">          	   
		  <li class="nav-item " >
              <a class="nav-link "   href="About.html">About</a>
           </li>
           <li class="nav-item">
              <a class="nav-link "  href="Services.html">Services</a>
           </li>
		   <li class="nav-item ">
              <a class="nav-link"   href="Contact.html">Contact</a>
           </li>
		   <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Portfolio</a>
              <div class="dropdown-menu">
                  <a class="dropdown-item" href="Portfolio 1.html">Portfolio 1</a>
                  <a class="dropdown-item" href="#">Portfolio 2</a>
                  <a class="dropdown-item" href="#">Portfolio 3</a>
               </div>
		   </li>
		   <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Blog</a>
              <div class="dropdown-menu">
                  <a class="dropdown-item" href="Blog Home 1.html">Blog Home 1</a>
                  <a class="dropdown-item" href="#">Blog Home 2</a>
                  <a class="dropdown-item" href="#">Blog Home 3</a>
               </div>
		   </li>
		   <li class="nav-item dropdown ">
              <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Other pages</a>
              <div class="dropdown-menu">
                  <a class="dropdown-item" href="Other 20page - Pricing.html">Pricing</a>
                  <a class="dropdown-item" href="#">Sesion2</a>
                  <a class="dropdown-item" href="#">Sesion3</a>
               </div> 
		   </li>
		   <li class="nav-item ">
		    <a class="nav-link text-primary"   href="Lo-gin.html"><u>Register</u></a>
		   </li>
		   </ul>        		   	  			  
          </div>
		</nav>
		<h1>..............</h1>
		<div>		   
	       <ol class="breadcrumb ">
	        <li class="breadcrumb-item" >
		     <a href ="Startbookstrap.html">Home</a>
		    </li>
            <li class="breadcrumb-item " aria-current="page">Register</li>
           </ol>
	 </div>
		
		
	   <div align="center">	
		<form method="POST" enctype="multipart/form-data"  action="${pageContext.request.contextPath}/Register" accept-charset="utf-8" class="form-group" style="width:600px;margin: 0px auto;" id="formDemo">
		<h4>Nhập thông tin đăng ký</h4>
		<div class = "col-6" align="left" >
		<div >
				<label for="avatar">Avatar</label>
				<input  name="avatar" id="avatar" type="file" class="form-control" placeholder="Vui lòng chọn ảnh" required>
			</div>
					
			<div>
				<label for="username">UserName:</label>
				<input name="username" type="text" id = "username" class="form-control" placeholder="Vui lòng nhập tên" required>
			</div>
			
			
			<div>
				<label for="myEmail">Email</label>
				<input name="email" type="text" id = "myEmail" class="form-control" placeholder="Vui lòng nhập Email" required>
			</div>
			<div>
				<label for="password">Mật khẩu</label>
				<input id="password" name="password" type="password" class="form-control" placeholder="Vui lòng nhập Password" required>
			</div>
			<div>
				<label for="guest"></label>
				<input id="guest" name="guest" type="hidden" class="form-control" value= "1" required>
			</div>
			<div>
				<label for="ConfiPassword">Nhập lại mật khẩu</label>
				<input name="confirm_password" id="ConfiPassword" type="password" class="form-control" placeholder="Vui lòng nhập lại Password" required>
			</div>
			
			
			<div>
				<label for="DK">Điều khoản</label>
				<input name="dieukhoan" id="DK"  type="checkbox">
			</div>
			<div>
				<label for="infor">Thông tin thêm</label>
				<input name="thongtinthem" id = "infor" class="form-control" type="text" placeholder="Tùy chọn...">
			</div>
			<button type="submit" class = "btn-primary" >Register</button>
	        
		</div>
	</form>
   </div>	
	<script type="text/javascript">

	$(document).ready(function() {
		
		//Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
		$("#formDemo").validate({
					rules: {
						ho: "required",
						ten: "required",
						diachi: {
							required: true,
							minlength: 2
						},
						sodienthoai: {
							required: true,
							minlength: 5
						},
						password: {
							required: true,
							minlength: 5
						},
						confirm_password: {
							required: true,
							minlength: 5,
							equalTo: "#password"
						},
						email: {
							required: true,
							email: true
						},
						dieukhoan: "required"
					},
					messages: {
						ho: "Vui lòng nhập họ",
						ten: "Vui lòng nhập tên",
						diachi: {
							required: "Vui lòng nhập địa chỉ",
							minlength: "Địa chỉ ngắn vậy, chém gió ah?"
						},
						sodienthoai: {
							required: "Vui lòng nhập số điện thoại",
							minlength: "Số máy quý khách vừa nhập là số không có thực"
						},
						password: {
							required: 'Vui lòng nhập mật khẩu',
							minlength: 'Vui lòng nhập ít nhất 5 kí tự'
						},
						confirm_password: {
							required: 'Vui lòng nhập mật khẩu',
							minlength: 'Vui lòng nhập ít nhất 5 kí tự',
							equalTo: 'Mật khẩu không trùng'
						},
						email: {
							required: "Please provide a password",
							minlength: "Your password must be at least 5 characters long",
							equalTo: "Please enter the same password as above"
						},
						email: "Vui lòng nhập Email",
						agree: "Vui lòng đồng ý các điều khoản"
					}
				});
	});
	</script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</body>
</html>