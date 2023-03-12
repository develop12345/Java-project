package tutorial.serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw= response.getWriter();
		
		String name= request.getParameter("name");
		String pass= request.getParameter("pass");
		String email= request.getParameter("email");
		String country= request.getParameter("country");
		
		Emp e= new Emp();
		e.setName(name);
		e.setPassword(pass);
		e.setEmail(email);
		e.setCountry(country);
		
		int status= EmpDao.save(e);
		
		if(status>0) {
			pw.print("<h3>Your record have been save Successfully !!!</h3>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			pw.print("<h1> Sorry unable to save record !!</h1>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		pw.close();
	}

}
