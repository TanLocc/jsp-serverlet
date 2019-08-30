package servlet.user.customer;

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
import javax.servlet.http.HttpSession;

import beans.Order;
import beans.Product;
import beans.UserAccount;
import conn.ConnectionUtils;
import dao.OrderDao;
import dao.ProductDao;

/**
 * Servlet implementation class BadView
 */
@WebServlet("/BadView")
public class BadView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BadView() {
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
       
        HttpSession session = request.getSession();
		UserAccount user = (UserAccount) session.getAttribute("User");		
		int cus_id =user.getId();		
		List<Order> orderList =  new ArrayList<Order>();
        Product product = null;
        try {
        	conn = ConnectionUtils.getConnection();
        	if(id!=0) {product = ProductDao.findProduct(conn, id);}
        	orderList = OrderDao.queryOrderByUser_ID(conn,cus_id);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
           
        }  
        // Lưu thông tin vào request attribute trước khi forward sang views.
       
        request.setAttribute("product", product);
        request.setAttribute("orderlist", orderList);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/BadView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int amount = Integer.parseInt(request.getParameter("soluong"));
		int pro_id = Integer.parseInt(request.getParameter("id"));
		int state=0;
		HttpSession session = request.getSession();
		UserAccount user = (UserAccount) session.getAttribute("User");
		
		int cus_id =user.getId();
		Connection conn;
		List<Order> orderList =  new ArrayList<Order>();
		Order order = new Order();
		order.setCus_id(cus_id);;
		order.setPro_id(pro_id);
		order.setAmount(amount);
		order.setState(state);
		try {
			conn = ConnectionUtils.getConnection();
			;
			OrderDao.save(order, conn);
			orderList = OrderDao.queryOrderByUser_ID(conn,cus_id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("So luong: "+soluong);
		request.setAttribute("orderlist", orderList);
        
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/BadView.jsp");
        dispatcher.forward(request, response);
	}

}
