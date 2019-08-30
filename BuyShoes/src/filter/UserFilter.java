package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import beans.UserAccount;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter({"/UserFilter","/UserList","/ProductList","/OrderList","/Popular","/UserView","/Admin","/AddProduct","/BadView","/UserInfor","/OrderState","/AddUser","/DeleteUser","/DeleteProduct"})
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
	    UserAccount user = new UserAccount();
		HttpSession session = httpReq.getSession(false);
		user = (UserAccount) session.getAttribute("User");
		if(session !=null&&user!=null) {
			chain.doFilter(request,response);
		}else {
			RequestDispatcher dispatcher = httpReq.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/Login.jsp");
			dispatcher.forward(request,response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
