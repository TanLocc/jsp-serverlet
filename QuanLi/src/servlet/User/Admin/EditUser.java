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

import beans.UserAccount;
import conn.ConnectionUtils;
import conn.MySQLConnUtils;
import dao.UserDao;
;


/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 8, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
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
 
        UserAccount user = null;
        
        String errorString = null;
        
        try {
        	conn = ConnectionUtils.getConnection();
            user = UserDao.findUser(conn, id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // Không có lỗi.
        // Sản phẩm không tồn tại để edit.
        // Redirect sang trang danh sách sản phẩm.
        if (errorString != null && user == null) {
            response.sendRedirect(request.getServletPath() + "/UserList");
            return;
        }
 
        // Lưu thông tin vào request attribute trước khi forward sang views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("user", user);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/EditUser.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		    Connection conn = null;
	        String idStr = (String) request.getParameter("id");
	        String userName = request.getParameter("username");
			String password = request.getParameter("password");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
			String address =request.getParameter("address");
			InputStream    avatar=null;
	     
			for (Part part : request.getParts()) {
				String imageName = extractFileName(part);
				 if (imageName != null && imageName.length() > 0) {
				   avatar = part.getInputStream();   
				   System.out.println("part2 = "+part);}
	               break;
	            
	           }  
			
	        int id = 0;
	        try {
	            id = Integer.parseInt(idStr);
	        } catch (Exception e) {
	        }
	        UserAccount user = new UserAccount(id,userName,avatar,mail,phone,address,password,0);
	        
	        String errorString = null;
	 
	        try {
	        	conn = ConnectionUtils.getConnection();
	            UserDao.updateUser(conn, user);
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        // Lưu thông tin vào request attribute trước khi forward sang views.
	        request.setAttribute("errorString", errorString);
	        request.setAttribute("user", user);
	 
	        // Nếu có lỗi forward sang trang edit.
	        if (errorString != null) {
	            RequestDispatcher dispatcher = request.getServletContext()
	                    .getRequestDispatcher("/WEB-INF/views/EditUser.jsp");
	            dispatcher.forward(request, response);
	        }
	        // Nếu m�?i thứ tốt đẹp.
	        // Redirect sang trang danh sách sản phẩm.
	        else {
	            response.sendRedirect(request.getContextPath() + "/UserList");
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


