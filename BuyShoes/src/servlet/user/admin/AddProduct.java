package servlet.user.admin;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.Product;
import conn.ConnectionUtils;
import dao.ProductDao;
/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/AddProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 8, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher //
        = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addproduct.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   String name = request.getParameter("name");
		   String priceStr = request.getParameter("price");			  
		   float price=Float.parseFloat(priceStr);
		   int amount = Integer.parseInt(request.getParameter("amount"));
		   
		   String des = request.getParameter("des");
		   String detail = request.getParameter("detail");
		   String cate =request.getParameter("cate");
		   InputStream    image=null;
		   for (Part part : request.getParts()) {
			   image = part.getInputStream();
       
                // Ghi vào file.
                
            break;
        }    
		   
		   Product product = new Product();
	        @SuppressWarnings("unused")
			boolean hasError = false;
	        String errorString = null;
	        int i=0;
	        if (name == null || priceStr == null || name.length() == 0 || image==null) {
	            hasError = true;
	            errorString = "Required name, price and image!";
	        } else {
	            
	            try {
	                // Tìm user trong DB.
	            	Connection conn =  ConnectionUtils.getConnection();
	            
			        product.setImage(image);
			        product.setName(name);
			        product.setPrice(price);
			        product.setAmount(amount);
			        product.setDes(des);
			        product.setDetail(detail);
			        product.setCate(cate);
	                
	                 i = ProductDao.save(product, conn);
	 
	                if (i == 0) {
	                    hasError = true;
	                    errorString = "Product Name or price invalid";
	                }
	            } catch (SQLException | ClassNotFoundException e) {
	                e.printStackTrace();
	                hasError = true;
	                errorString = e.getMessage();
	            }
	        }
	        if(hasError==false) {
	        	
	        	request.setAttribute("errorString", errorString);
		        
	 		   if(i!=0) { 
	 			   RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ProductList");
         dispatcher.forward(request, response);	}
         else {
	        	request.setAttribute("errorString", errorString);
	        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addproduct.jsp");
	            dispatcher.forward(request, response);	
	        }
	   }
	   
	        else {
	        	request.setAttribute("errorString", errorString);
	        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/addproduct.jsp");
	            dispatcher.forward(request, response);	
	        }
	}

}
