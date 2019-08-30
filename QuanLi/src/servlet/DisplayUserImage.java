package servlet;



import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserAccount;
import conn.ConnectionUtils;
 

 
// /image?id=123
@WebServlet(urlPatterns = { "/image" })
public class DisplayUserImage extends HttpServlet {
  private static final long serialVersionUID = 1L;
 
  public DisplayUserImage() {
      super();
  }
 

  
  
 
  @SuppressWarnings("null")
@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
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
  	        PreparedStatement ps=con.prepareStatement("select * from USERACCOUNT where id=?");  
  	        ps.setInt(1,id);  
  	        ResultSet rs=ps.executeQuery();  
  	        while(rs.next()){  
  	             imageData=rs.getBytes("avatar");  
  	        }  
  	    }catch(Exception e){System.out.println(e);}  
  	
  	 
          
 
          if (imageData == null) {
              // Không có dữ liệu ảnh, chuyển hướng tới một ảnh mặc định.
              response.sendRedirect(request.getContextPath() + "/images/noimage.jpg");
              return;
          }
        
          // trump.jpg, putin.png
          
        
          // image/jpg
          // image/png
        
         
        
          response.setHeader("Content-Type","image/jpeg");
          
        
          response.setHeader("Content-Length", String.valueOf(imageData.length));
        
          response.setHeader("Content-Disposition", "inline; filename=\"" + "user.jpg" + "\"");
 
          // Ghi dữ liệu ảnh vào Response.
          response.getOutputStream().write(imageData);
 
      } catch (Exception e) {
          throw new ServletException(e);
      }
  }
 
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
      doGet(request, response);
  }
 
}
