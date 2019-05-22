package jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	 
	        // Lấy giá trị tham số (parameter) trên URL.
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        
	        if ("Admin".equals(username)&&"12345".equals(password)) {
	            System.out.println("Forward to Welcome");
	 
	            // Sét dữ liệu vào thuộc tính (attribute) của request.
	            request.setAttribute("username", //
	            		username);
	 
	            RequestDispatcher dispatcher //
	                    = request.getServletContext().getRequestDispatcher("/Welcome");
	            dispatcher.forward(request, response);
	 
	            return;
	        }
	        ServletOutputStream out = response.getOutputStream();
	        out.println("Invalid username & password");
	        out.println(username);
	    }
	 
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        this.doGet(request, response);
	    }
}
