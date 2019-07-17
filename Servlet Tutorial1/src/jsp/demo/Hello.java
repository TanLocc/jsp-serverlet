package jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Hello1")
public class Hello {
	private static final long serialVersionUID = 1L;
	 
    // Request:
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    
        
       
 
            RequestDispatcher dispatcher //
                    = request.getServletContext().getRequestDispatcher("/index.html");
            dispatcher.forward(request, response);
 
           
     
    }
 

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
 
}
