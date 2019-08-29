package servlet.User.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conn.ConnectionUtils;
import dao.OrderDao;

/**
 * Servlet implementation class OrderState
 */
@WebServlet("/OrderState")
public class OrderState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderState() {
        super();       
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int state = Integer.parseInt(request.getParameter("state"));
		int id = Integer.parseInt(request.getParameter("id"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		int proID = Integer.parseInt(request.getParameter("proID"));
		try {
			Connection conn = ConnectionUtils.getConnection();
			OrderDao.updateAmount(conn,amount,proID,state);
			OrderDao.updateState(conn, id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/OrderList");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
