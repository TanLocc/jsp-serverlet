<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
     <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" 	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">  
      <title>Edit product</title>
   </head>
   <body>
      <h3>Edit product</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty product}">
         <div align="center"> 
<form method="POST" enctype="multipart/form-data" action="${pageContext.request.contextPath}/EditProduct" accept-charset="utf-8" class="form-group" style="width:600px;margin: 0px auto;" >
            
            <div class = "col-4" align="left" >
                  
              <div >
				<label for="image">Image</label>
				<input  name="image" id="image" type="file" class="form-control" placeholder="Vui lòng chọn ảnh" >
			  </div>
			  <input type="hidden" name="id" value="${product.id}" />   
               <div>
               <label  for="name">ProductName:</label>
              <input name="name" type="text" id = "name" class="form-control" value="${product.name}" required>
              </div>
               <div>
               <label  for="cate">Category:</label>
                <select id="cate" name="cate" class="form-control">
                     <option selected>${product.cate}</option>
                     <option>The thao</option>
                     <option>Cong so</option>
                     <option>Da ngoai</option>
                </select>     
              </div>
              <div>
              <label  for="price">Price:</label>
              <input name="price" type="text" id = "price" class="form-control" value="${product.price}" required>
               </div>
                <div>
              <label  for="amount">Amount:</label>
              <input name="amount" type="number" id = "amount" class="form-control" value="${product.amount}" required>
               </div>
               <div>	 
	           <label for="des">Description:</label>
               <input  name="des" type="text" id="des" class="form-control" value="${product.des}" required>
               </div> 
               <div>
				<label for="detail">Detail</label>
				<input name="detail"  id="detail" type="text" class="form-control" value="${product.detail}" required>
			</div> 
			
			<div ><button type="submit" class="btn btn-primary">Edit</button>
			<a  href="${pageContext.request.contextPath}/ProductList" class="btn ">Cancel</a></div>
          </div>    
         </form>
         </div>
      </c:if>
 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> 
 
   </body>
</html>