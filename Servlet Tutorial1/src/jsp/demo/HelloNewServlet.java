package jsp.demo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/HelloMe/product/*" }, initParams = {
        @WebInitParam(name = "email", value = "lephantanloc299@.com"),
         })
/**
 * Servlet implementation class HelloNewServlet
 */

public class HelloNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String email;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
 
        this.email = config.getInitParameter("email");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletOutputStream out = response.getOutputStream();
        
	       out.println("<html>");
	       out.println("<head><title>Hello Servlet</title></head>");
	       out.println("<p>email = " + this.email + "</p>"); 
	       out.println("<body>");
	       out.println("<h3>Hello World</h3>");
	       out.println("This is HelloNewServlet");
	       out.println("</body>");
	       out.println("<html>");
	       
	       
	       
	        out.println("<style> span {color:blue;} </style>");
	 
	        String param1 = request.getParameter("id");
	        out.println("<br><span>getParameter id:</span>");
	        out.println(param1);
	 
	        String param2 = request.getParameter("name");
	        out.println("<br><span>getParameter name:</span>");
	        out.println(param2);
	        
	        String contextPath = request.getContextPath();
	        out.println("<br><span>contextPath:</span>");
	        out.println(contextPath);
	 
	        out.println("<br><span>servletPath:</span>");
	        String servletPath = request.getServletPath();
	        out.println(servletPath);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
