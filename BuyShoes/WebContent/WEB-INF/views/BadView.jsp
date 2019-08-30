<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
   <head>
      <meta charset="utf-8">      
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"	 
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
	 
  </head>
   <body >
    <nav class="navbar fixed-top  navbar-expand-sm  bg-dark navbar-dark " id="myTab" role="tablist">
 		         
          <a class=" navbar-brand text-success active "  href="${pageContext.request.contextPath}/UserView" >ShopShoes</a>
		  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
          </button>
		 <div class="collapse   navbar-collapse " id="collapsibleNavbar">
		 <div class= "ml-auto">
		 <ul class="navbar-nav   text-primary ">          	   
		 
		   <li class="nav-item">
              <a class="nav-link"   href="${pageContext.request.contextPath}/Popular">Popular</a>
           </li>
		   <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">ShoesType</a>
              <div class="dropdown-menu">
                  <a class="dropdown-item" href="${pageContext.request.contextPath}/FindProduct?text=the thao">Sport</a>
                  <a class="dropdown-item" href="${pageContext.request.contextPath}/FindProduct?text=cong so">Office</a>
                  <a class="dropdown-item" href="${pageContext.request.contextPath}/FindProduct?text=da ngoai">Picnic</a>
               </div>
		   </li>
		   
		   
		   <li class="nav-item">
              <a class="nav-link"   href="${pageContext.request.contextPath}/BadView?id=0">ProductBad</a>
		   <li class="nav-item ">
		   
		   <li>
		   <form method="post" action="${pageContext.request.contextPath}/FindProduct" class="input-group mb-3" >
            <input type="text" name = "text"  class="form-control" placeholder="Search">
             <div class="input-group-append">
              <button class="btn btn-success" type="submit">Go</button>
            </div>
           </form>
           </li>
		    <li class="nav-item">
            <a class="nav-link " href="#">
            <img   src="${pageContext.request.contextPath}/image?id=${User.id}" style="width:30px;height:30px">
            </a>
            
           </li>
		   <li>
		    <a class="nav-link text-primary"   href="${pageContext.request.contextPath}/LogOut">LogOut</a>
		   </li>	
		   </ul>   
		  </div> 		   
          </div>
  		  
  		  
	   </nav>
	   <h3>aaaa</h3> 
	   <h3>aaaa</h3>
	   <div>		   
	       <ol class="breadcrumb ">
	        <li class="breadcrumb-item" >
		     <a href="${pageContext.request.contextPath}/UserView">Home</a>
		    </li>
            <li class="breadcrumb-item " aria-current="page">BadView</li>
           </ol>
	 </div>
	    
        <div id="myCarousel" class="carousel slide border " data-ride="carousel">
		    <ol class="carousel-indicators">
              <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#myCarousel" data-slide-to="1"></li>
              <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                  <img class="d-block w-100 " src="https://dacaocapcyvy.com.vn/uploads/images/news/giay-the-thao.jpg" alt="Panther" height ="600" >
                  <div class="carousel-caption">
                    <h5>GIRL 1</h5>
                    <small>
                    This is image of girl 1.
                    </small>
                  </div>
			  </div>
               <div class="carousel-item">
                  <img class="d-block w-100" src="http://s1.storage.5giay.vn/image/2016/11/20161110_5833138a073beec28c492a4fb6bf4ce6_1478792091.jpg" alt="Black Cat"  height ="600">
                   <div class="carousel-caption">
                    <h5>GIRL 2</h5>
                    <small>
                    This is image of girl 2.
                    </small>
                  </div>
			   </div>
               <div class="carousel-item">
                  <img class="d-block w-100" src="http://nguabac.com/wp-content/uploads/2017/10/giay-cong-so-nam-cao-cap-GB-008.jpg" alt="Lion"  height ="600">
                   <div class="carousel-caption">
                    <h5>GIRL 3</h5>
                    <small>
                    This is image of girl 3.
                    </small>
                  </div>
			   </div>
            </div>
         
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
     <span class="carousel-control-prev-icon" aria-hidden="true"></span>
     <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
     <span class="carousel-control-next-icon" aria-hidden="true"></span>
     <span class="sr-only">Next</span>
    </a>
   </div>
  
	<div class=" container-fluid w-75">
	  <div >
		<h4 class="mb-4 pt-4">Welcome to your order</h4>
        <table class="table table-borderless">
        
        <c:if test="${not empty product}">
        
        <div  class="mb-4   p-2">
        <thead >
        <tr>
         <th><h5 >${product.name}</h5></th>
         <th></th>
         <th></th>
        </tr> 
        </thead>
        
         <tbody>
          
             <tr>
              <td colspan="3" ><img   width="300" height="300" src="${pageContext.request.contextPath}/ProductImage?id=${product.id}"/>
              </td>
             </tr>
             <tr>
             <td colspan="2">${product.des}</td>
             <td></td>
             </tr>
             <tr>
             <td colspan="2">${product.detail}</td>
             <td></td>
             </tr>
             <tr>
              <td colspan="2"><h5 ><span>Giá mỗi đôi: ${product.price} $</span></h5></td>
              <td></td>
             </tr>
             <form method="POST"  action="${pageContext.request.contextPath}/BadView"  class="form-group" style="width:600px;margin: 0px auto;" id="formDemo">
             <tr>
              <td class="form-group" colspan="1" >
               
               <p>Số lượng: <input class="col-1" type="number" name="soluong" min="1" max="100">  </p>
               <input  type="hidden" name="id" value="${product.id}" >
              </td>
             <td colspan="2"></td>
              </tr>  
		      <tr>
		      <td colspan="3"  >
              <button type="submit" class="btn btn-primary">BUY</button>
			  
			  </td> 
             </tr>
             </form>
     </tbody>
         </div>
       
         </c:if>
         </table>  
         
       <h3>Your orderList</h3>         
       <table class="table table-striped table-bordered table-hover"   >
       
       <thead class="thead-light"><tr>
          <th>ID</th>
          <th>PRODUCTNAME</th>
          <th>IMAGE</th>
          <th>AMOUNT</th>
          <th>GMAIL
          <th>Phone</th>
          <th>Address</th>  
          <TH>STATE</TH>

       </tr></thead >
        <tbody>
       <c:forEach items="${orderlist}" var="order" >
          <tr>
             <td>${order.id}</td>
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
                <p style="color:black">Waiting for confirm<p>  
               </c:if>
               <c:if  test="${order.state=='1'}" >
                <p style="color:blue">Be confirmed<p>  
               </c:if>
             </td>
             
          </tr>
       </c:forEach>
       </tbody>
    </table>  
          </div>
		</div>
	
		

 
 <div class = "row text-dark mt-4">
  <div class = "col-lg-6">
   <h2><strong>Modern Business Peatures</strong></h2>
    <p><strong>The Modern Business template by Start Bootstrap by Bootstrap includes:</strong></p>
	<ul>
     <li>
      <Strong>Bootstrap v4</strong>
     </li>
     <li><strong>jquery</strong></li>
     <li><strong>Working contact from with validation</strong></li>
     <li><strong>Unstyled page elements for easy customization</strong></li>
    </ul>
    <p><strong>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnics doloremque non cum id reprehenderit, quisquam totam aspermatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</strong></p>
   </div>
   <div class="col-lg-6 ">
    <img class="img-fluid rounded" src = "https://s3-eu-central-1.amazonaws.com/centaur-wp/fundstrategy/prod/content/uploads/2013/05/Japan-Mount-Fuji-Pagoda-700x450.jpg" alt="">
   </div>
 </div>  
 <div class = "row text-dark border-top border-primary">
  <div class = "col-lg-9">
   <strong> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi</strong>
  </div> 
  <div class = "col-lg-3">
     <button href="#" class="btn btn-block btn-secondary "  >
              Call to Action
	 </button> 
</div>
</div>


  <!-- footer -->   
  <div id="footer" class=" bg-dark nav justify-content-center navbar   " style="height: 50px;">
     <a href="#" class=" text-primary">Learn more</a>
  </div>

      
		 <div class="tab-content" >
		  <div class="tab-pane fade" id="Start">
          NULL
          </div>
          <div class="tab-pane fade" id="About">
          NULL
          </div>
         <div class="tab-pane fade" id="content-css"
          role="tabpanel" aria-labelledby="tab-css">
          CSS stands for Cascading Style Sheets. ...
         </div>
         <div class="tab-pane fade " id="content-bootstrap"
          role="tabpanel" aria-labelledby="tab-bootstrap">
          Bootstrap is a free front-end framework for faster and easier web development...
         </div>
        </div>
    
 
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
   </body>
</html>