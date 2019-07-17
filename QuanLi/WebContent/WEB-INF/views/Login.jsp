<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">      
      <link rel="stylesheet" 	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	
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
 		         
          <a class=" navbar-brand text-success active "  href="Startbookstrap.html" >Start bootstrap</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
		 <div class="collapse   navbar-collapse " id="collapsibleNavbar">
		 <div class= "ml-auto">
		 <ul class="navbar-nav   text-primary ">          	   
		  <li class="nav-item " >
              <a class="nav-link "   href="About.html">About</a>
           </li>
           <li class="nav-item">
              <a class="nav-link"  href="Services.html">Services</a>
           </li>
		   <li class="nav-item">
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
                  <a class="dropdown-item" href="Other page - Pricing.html">Pricing</a>
                  <a class="dropdown-item" href="#">Sesion2</a>
                  <a class="dropdown-item" href="#">Sesion3</a>
               </div> 
		   </li >
		   
		   <li class="nav-item ">
		    <a class="nav-link text-primary"   href="Lo-gin.html"><u>Log in</u></a>
		   </li>	
		   </ul>   
		  </div> 		   
          </div>
  		  
	   </nav>
	    <h1>aaaa</h1> 
	    <p style="color: red;">${errorString}</p>
	   <div>		   
	       <ol class="breadcrumb ">
	        <li class="breadcrumb-item" >
		     <a href ="Startbookstrap.html">Home</a>
		    </li>
            <li class="breadcrumb-item " aria-current="page">Login</li>
           </ol>
	 </div>
<div align="center">	
  
  <form method="POST" action="${pageContext.request.contextPath}/Login" accept-charset="utf-8" class="form-group" style="width:600px;margin: 0px auto;" id="formDemo">
 
   <!-- Vertical -->
    <h4>Nhập thông tin đăng nhập</h4>
   <div class = "col-4" align="left" >
     <div>
      <label  for="username">Username or Email</label>
      <input name="username" type="text" id = "username" class="form-control" placeholder="Username or Email" required>
     </div>
     <div>	 
	  <label for="myPassword">Password</label>
      <input name="password" type="password" id="myPassword" class="form-control" placeholder="Password" required>
     </div>  
	  <button type="submit" class="btn btn-primary">Login</button>
      
   </div>
   <span> Chưa đăng ký, bấm vào<a class="link" href="file:///C:/Users/XuanVinh/Desktop/html/Register.html"> đây </a>để đăng ký.</span>
   
 
</form>
</div>
      <script type="text/javascript">

	$(document).ready(function() {
		
		//Khi bàn phím được nhấn và thả ra thì sẽ chạy phương thức này
		$("#formDemo").validate({
					rules: {
						
						password: {
							required: true,
							minlength: 5
						},
						
						text: {
							required: true,
							text: true
						},
						
					},
					messages: {
						
						password: {
							required: 'Vui lòng nhập mật khẩu',
							minlength: 'Vui lòng nhập ít nhất 5 kí tự'
						},
						
						text: "Vui lòng nhập Username hoặc Email",
						
					}
				});
	});
	</script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
   </body>
</html>