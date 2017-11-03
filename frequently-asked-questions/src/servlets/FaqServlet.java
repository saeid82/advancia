package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class FaqServlet
 */

public class FaqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String DB_DRIVER ="com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/faq_db";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
    //private DbConnection db_con;

    private Statement statement;
    private ResultSet result;

	private Connection con;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName(DB_DRIVER).newInstance();
			con = DriverManager.getConnection(DB_URL , USER_NAME , PASSWORD);
			System.out.println("connection......");
			//con = db_con.connectionToDb();
			statement = con.createStatement();
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<head>");
			out.println("<title> eserci 13.01</title>");
			out.println("</head>");
			int value = Integer.parseInt(request.getParameter("topic"));
			String query = "SELECT F.QUESTION, F.ANSWER FROM FAQ WHERE F.TOPIC_ID =  "+value;
			try {
				ResultSet result = statement.executeQuery(query);
				result.next();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			out.println("<body>");
				try {
					while(result.next()) {
						out.print("- "+result.getString(1));
						out.print("\t"+result.getString(2));
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			out.println("</body>");
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
	}

}
