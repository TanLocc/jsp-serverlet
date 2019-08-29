package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserAccount;
import conn.ConnectionUtils;
import dao.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");

         dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String userName = request.getParameter("username");
		 String password = request.getParameter("password");
		
		
		 Connection conn = null;	
		 UserAccount user = null;
		 String errorString = null;
		 boolean hasError = false;
	        if (userName == null || password == null || userName.length() == 0 || password.length() == 0) {
	            hasError = true;
	            errorString = "Required username and password!";
	        }
	        else {
	        
	        try {
	        conn = ConnectionUtils.getConnection();
	        user = UserDao.findUser(conn, userName, password);
	        request.setAttribute("user", user);
	       
	        if (user == null) {
                hasError = true;
                errorString = "User Name or password invalid";
            }
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
                hasError = true;
				e.printStackTrace();
				errorString =e.getMessage();
			
			}}
	        
	        if (hasError) {
	            // Lưu các thông tin vào request attribute trước khi forward.
	            request.setAttribute("errorString", errorString);
	            // Forward (Chuyển tiếp) tới trang /WEB-INF/views/login.jsp
	            RequestDispatcher dispatcher //
	                    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Login.jsp");
	            dispatcher.forward(request, response);
	        }
	        else {  
	        	HttpSession session = request.getSession();
	            session.setAttribute("username", user.getUserName());
	        	if(user.getRole()==1) {
	        		
	        		List<UserAccount> list = new ArrayList<UserAccount>(); 
	               
					try {
	                	list = UserDao.queryUser(conn);
	                    
	                } catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						errorString =e.getMessage();
					}
					request.setAttribute("errorString", errorString);
			        request.setAttribute("userList", list);
	        		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Admin.jsp");
	                dispatcher.forward(request, response);	
	        	}
	        	else {
	        		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/UserView");
                 dispatcher.forward(request, response);
	        }}
}}
