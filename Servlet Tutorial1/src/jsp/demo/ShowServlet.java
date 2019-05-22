package jsp.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/Show/*" })
public class ShowServlet extends HttpServlet {
    
	   private static final long serialVersionUID = 1L;
	 private static String name="loc";
	 private static String pass="123456";   
	   public ShowServlet() {
	   }
	 
	   @Override
	   protected void doGet(HttpServletRequest request,
	           HttpServletResponse response) throws ServletException, IOException {
	        String message = (String) request.getAttribute("message");
	       ServletOutputStream out = response.getOutputStream();
	        
	       out.println("<html>");
	       out.println("<head><title>Hello Servlet</title></head>");
	        
	       out.println("<body>");
	       out.println("<h3>Hello World</h3>");
	       out.println("This is show servlet");
	       
	       out.println("This is message from ForwardDemoServlet: " + message);
	       out.println("</body>");
	       out.println("<html>");
	   }
	 
	   @Override
	   protected void doPost(HttpServletRequest request,
	           HttpServletResponse response) throws ServletException, IOException {
	       this.doGet(request, response);
	   }
	 
	}
