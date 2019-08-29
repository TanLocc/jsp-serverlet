package servlet.User.Customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Product;
import conn.ConnectionUtils;
import dao.ProductDao;

/**
 * Servlet implementation class FindProduct
 */
@WebServlet("/FindProduct")
public class FindProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text = request.getParameter("text");
		List<Product> list =new ArrayList<Product>();
		String errorString = null;
		
		
			Connection conn;
			try {
				conn = ConnectionUtils.getConnection();
				list = ProductDao.finndByText( conn,text);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			// TODO Auto-generated catch block
			
		request.setAttribute("errorString", errorString);
        request.setAttribute("ProductList", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Start.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text = request.getParameter("text");
		List<Product> list =new ArrayList<Product>();
		String errorString = null;
		
		
			Connection conn;
			try {
				conn = ConnectionUtils.getConnection();
				list = ProductDao.finndByText( conn,text);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			// TODO Auto-generated catch block
			
		request.setAttribute("errorString", errorString);
        request.setAttribute("ProductList", list);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Start.jsp");
        dispatcher.forward(request, response);
	}

}
