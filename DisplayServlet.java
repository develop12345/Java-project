package tutorial.serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw= response.getWriter();
		
		
		pw.print("<a href='index.html'>ADD NEW EMPLOYEE</a><br>");
		pw.print("<h1>Employee List</h1>");
		
		List<Emp> list= new ArrayList<>();
		list= EmpDao.getAllEmployee();
		
		pw.print("<table border='1' width='100%'>");
		
		pw.print("<tr><th>ID</th><th>NAME</th><th>PASSWORD</th><th>EMAIL</th><th>COUNTRY</th><th>EDIT</th><th>DELETE</th></tr>");
		
		for(Emp e: list) {
			pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+
					"</td><td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+"'>Edit</td><td><a href='DeleteServlet?id="+e.getId()+"'>Delete</td></tr>");				
		}
		pw.print("</table>");
		pw.close();
	}

}
