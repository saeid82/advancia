package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RedirectServlet
 */
//@WebServlet("/redirect-servlet")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String location = request.getParameter("page");
		
		if(location != null) {
			if(location.equals("advancia"))
				response.sendRedirect("http://www.advancia.it/");
			else	
			
				response.setContentType("text/html");
			PrintWriter out = response.getWriter();
		
			out.println("<?xml version=\"1.0\" encoding=\"${encoding}\" ?>");
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "+
					"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
			out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
			out.println("<head>");
			out.println("<title> Invalid page </title>");
			out.println("</head>");
        
			out.println("<body>");
			out.println("<h1>");
			out.println("Invalid page requested<br />");
			out.println("</h1>");
        	out.println("<p>");
        	out.println("<a href = " + "/Redirect.html" + ">" );
        	out.println("Click hear to chose again</a>");
        	out.println("<p>");
        	out.println("</body>");
        	out.println("</html>");
        	out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
