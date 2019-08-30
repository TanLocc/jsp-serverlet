package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.ConnectionUtils;

/**
 * Servlet implementation class DisplayProductImage
 */
@WebServlet("/ProductImage")
public class DisplayProductImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayProductImage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
	      try {
	          // Lấy ra kết nối tới Database.
	          // (Xem thêm tài liệu JDBC).
	          conn = ConnectionUtils.getConnection();
	          int id =  0;
	          try {
	              id = Integer.parseInt(request.getParameter("id"));
	              
	          } catch (Exception e) {
	 
	          }
	          byte[] imageData=null;
	          try{  
	  	        Connection con=ConnectionUtils.getConnection();  
	  	        PreparedStatement ps=con.prepareStatement("select * from PRODUCT where id=?");  
	  	        ps.setInt(1,id);  
	  	        ResultSet rs=ps.executeQuery();  
	  	        while(rs.next()){  
	  	             imageData=rs.getBytes("image");  
	  	        }  
	  	    }catch(Exception e){System.out.println(e);}  
	          if (imageData == null) {
	              // Không có dữ liệu ảnh, chuyển hướng tới một ảnh mặc định.
	              response.sendRedirect(request.getContextPath() + "/images/noimage.jpg");
	              return;
	          }
	          response.setHeader("Content-Type","image/jpeg");
	          
	        
	          response.setHeader("Content-Length", String.valueOf(imageData.length));
	        
	          response.setHeader("Content-Disposition", "inline; filename=\"" + "product.jpg" + "\"");
	 
	          // Ghi dữ liệu ảnh vào Response.
	          response.getOutputStream().write(imageData);
	 
	      } catch (Exception e) {
	          throw new ServletException(e);
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
