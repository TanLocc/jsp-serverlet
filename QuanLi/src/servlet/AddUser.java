package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserAccount;
import conn.ConnectionUtils;
import dao.UserDao;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/AddUser")
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
		   String mail = request.getParameter("email");
		   
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
