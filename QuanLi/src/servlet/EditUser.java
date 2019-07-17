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
import conn.MySQLConnUtils;
import dao.UserDao;
;


/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
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
		
		 
        String password = (String) request.getParameter("password");
 
        UserAccount user = null;
        
        String errorString = null;
        
        try {
        	conn = ConnectionUtils.getConnection();
            user = UserDao.findUser(conn, password);
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
			 
	        float id = 0;
	        try {
	            id = Float.parseFloat(idStr);
	        } catch (Exception e) {
	        }
	        UserAccount user = new UserAccount(id,userName,mail,password,0);
	        
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
	        // Nếu mọi thứ tốt đẹp.
	        // Redirect sang trang danh sách sản phẩm.
	        else {
	            response.sendRedirect(request.getContextPath() + "/UserList");
	        }
	    }
	}


