package controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.DbConnection;

/**
 * Servlet implementation class FaqServlet
 */

public class FaqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private DbConnection db_con;

    private Statement statement;
    private ResultSet result;

	private Connection con;
    
    
	public FaqServlet() {
		
		con = db_con.connectionToDb();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<head>");
		int value = Integer.parseInt(request.getParameter("Topics"));
		String query = "SELECT * FROM FAQ WHERE TOPIC_ID =  "+value;
		try {
			result = statement.executeQuery(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("<title> eserci 13.01</title>");
		out.println("</head>");
		out.println("<body>");
			try {
				while(result.next()) {
					out.print(result.getString(1));
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		out.println("</body>");
		
	}

}
