package servlet;

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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.UserAccount;
import conn.ConnectionUtils;
import dao.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 8, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/Register.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
		
		   String userName = request.getParameter("username");
		   String password = request.getParameter("password");
		   String mail = request.getParameter("email");	
		   String phone = request.getParameter("phone");
		   String address =request.getParameter("address");
		   InputStream avatar=null;
		  // avatar = request.getParameter("avatar");
		   
		   UserAccount user = new UserAccount();
	        @SuppressWarnings("unused")
			boolean hasError = false;
	        String errorString = null;
	        int i=0;
	        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
	            hasError = true;
	            errorString = "Required username and password!";
	        } else {
	            
	            try {
	                // Tìm user trong DB.
	            	Connection conn =  ConnectionUtils.getConnection();
	            	
	            	 for (Part part : request.getParts()) {
	                     String Name = extractFileName(part);
	                     
	                         // Dữ liệu file.
	                    	 System.out.println("part="+part);
	    	                 avatar = part.getInputStream();
	                
	                         // Ghi vào file.
	                         
	                     break;
	                 }    
	                    
	                        // Dữ liệu file.
	                  
	            	user.setAvatar(avatar);
	                user.setUserName(userName);
	                user.setPassword(password);
	                user.setMail(mail);
	                user.setPhone(phone);
	                user.setAddress(address);
	                
	                 i = UserDao.save(user, conn);
	                if (i == 0) {
	                    hasError = true;
	                    errorString = "User Name or password invalid";
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
	 			  HttpSession session = request.getSession();
		            session.setAttribute("User", user);
	 			   RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Startbookstrap.jsp");
            dispatcher.forward(request, response);	}
            else {
	        	request.setAttribute("errorString", errorString);
	        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Register.jsp");
	            dispatcher.forward(request, response);	
	        }
	   }
	   
	        else {
	        	request.setAttribute("errorString", errorString);
	        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Register.jsp");
	            dispatcher.forward(request, response);	
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
