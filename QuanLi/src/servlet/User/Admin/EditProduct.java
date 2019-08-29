package servlet.User.Admin;

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
import beans.UserAccount;
import conn.ConnectionUtils;
import dao.ProductDao;
import dao.UserDao;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/EditProduct")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 8, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
        int id = Integer.parseInt(request.getParameter("id"));
 
        Product product = null;
        
        String errorString = null;
        
        try {
        	conn = ConnectionUtils.getConnection();
        	product = ProductDao.findProduct(conn, id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // Không có lỗi.
        // Sản phẩm không tồn tại để edit.
        // Redirect sang trang danh sách sản phẩm.
        if (errorString != null && product == null) {
            response.sendRedirect(request.getServletPath() + "/ProductList");
            return;
        }
 
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/EditProduct.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    Connection conn = null;
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
			float price = Float.parseFloat(request.getParameter("price"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			String des = request.getParameter("des");
			String detail = request.getParameter("detail");
			String cate = request.getParameter("cate");
			InputStream    image=null;
	     
			for (Part part : request.getParts()) {
				String imageName = extractFileName(part);
				 if (imageName != null && imageName.length() > 0) {
				   image = part.getInputStream();   
				   System.out.println("part2 = "+part);}
	               break;
	            
	           }  
	        
	        Product product = new Product(id,image,name,cate,price,amount,des,detail);
	        
	        String errorString = null;
	 
	        try {
	        	conn = ConnectionUtils.getConnection();
	            ProductDao.updateProduce(conn, product);
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Lưu thông tin vào request attribute trước khi forward sang views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("product", product);
	 
	        // Nếu có lỗi forward sang trang edit.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/EditProduct.jsp");
	            dispatcher.forward(request, response);
	        }
	        // Nếu m�?i thứ tốt đẹp.
	        // Redirect sang trang danh sách sản phẩm.
	        else {
	            response.sendRedirect(request.getContextPath() + "/ProductList");
	        }
}

	
	 private String extractFileName(Part part) {
	       // form-data; name="file"; filename="C:\file1.zip"
	       // form-data; name="file"; filename="C:\Note\file2.zip"
	       String contentDisp = part.getHeader("content-disposition");
	       String[] items = contentDisp.split(";");
	       for (String s : items) {
	           if (s.trim().startsWith("filename")) {
	               // C:\file1.zip
	               // C:\Note\file2.zip
	               String clientFileName = s.substring(s.indexOf("=") + 2, s.length() - 1);
	               clientFileName = clientFileName.replace("\\", "/");
	               int i = clientFileName.lastIndexOf('/');
	               // file1.zip
	               // file2.zip
	               return clientFileName.substring(i + 1);
	           }
	       }
	       return null;
	   }
	

}
