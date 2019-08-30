package servlet.user.admin;

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
import dao.UserDao;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 8, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adduser.jsp");

 dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		   String userName = request.getParameter("username");
		   String password = request.getParameter("password");
		   String phone  = request.getParameter("phone");
		   String mail = request.getParameter("email");
		   String address =request.getParameter("address");
		   InputStream    avatar=null;
		   for (Part part : request.getParts()) {
			   avatar = part.getInputStream();

               break;
           }    
		   
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
	                user.setUserName(userName);
	                user.setPassword(password);
	                user.setMail(mail);
	                user.setPhone(phone);
	                user.setAddress(address);
	                user.setAvatar(avatar);
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
	 			   RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/UserList");
            dispatcher.forward(request, response);	}
            else {
	        	request.setAttribute("errorString", errorString);
	        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adduser.jsp");
	            dispatcher.forward(request, response);	
	        }
	   }
	   
	        else {
	        	request.setAttribute("errorString", errorString);
	        	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/adduser.jsp");
	            dispatcher.forward(request, response);	
	        }
	}

}
