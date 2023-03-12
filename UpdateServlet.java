package tutorial.serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw= response.getWriter();
		
		String i= request.getParameter("id");
		int id= Integer.parseInt(i);
		String Name= request.getParameter("name");
		String Pass= request.getParameter("pass");
		String Email= request.getParameter("email");
		String Country= request.getParameter("country");
		
		Emp e= new Emp();
		
		e.setId(id);
		e.setName(Name);
		e.setPassword(Pass);
		e.setEmail(Email);
		e.setCountry(Country);
		
		int status= EmpDao.update(e);
		
	if(status>0) {
		pw.print("Successfully Updated!!!!<br><a href='DisplayServlet'>View Employees</a>");
	}
	else {
		pw.print("Unable to Update");
	}
	}

}
