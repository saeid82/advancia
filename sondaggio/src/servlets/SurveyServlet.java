package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SurveyServlet
 */
public class SurveyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String DB_DRIVER ="com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/survey";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	
	private Connection con;
	private Statement stat;
	
	
	
//	/**
//	 * @see Servlet#init(ServletConfig)
//	 */
//	public void init(ServletConfig config) throws ServletException {
//		try {
//			System.setProperty("sondaggio.system.home", config.getInitParameter(DB_URL));
//			Class.forName(DB_DRIVER);
//			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//			stat = con.createStatement();
//		} catch (Exception e) {
//			e.printStackTrace();
//			
//		}
//	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//System.setProperty("sondaggio.system.home", config.getInitParameter(DB_URL));
			Class.forName(DB_DRIVER).newInstance();
			con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			stat = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<?xml version=\"1.0\" encoding=\"${encoding}\" ?>");
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" "+
		"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println("<head>");
        out.println("<title> Sondaggio </title>");
        //Leggere la risposta corrente del sondaggio
        int value = Integer.parseInt(request.getParameter("animal"));
        
        try {
			stat.executeUpdate("UPDATE surveyresult set votes = votes+1 where animal_id = "+value);
			
			//Ottenere la somma di tutte le risposte
			String query ="SELECT SUM(VOTES) FROM SURVEYRESULT";
			ResultSet total = stat.executeQuery(query);
			total.next();
			int tot = total.getInt(1);
			query = "SELECT * FROM SURVEYRESULT ORDER BY ANIMAL_ID";
			ResultSet resultsRS = stat.executeQuery(query);
			out.println("<title>Thank you!</title>");
			out.println("</head>");
			
			out.println("<body>");
			out.println("<h1>SERVEY Results: </h1>");
			out.println("<p><h3>Thank you for participation.<h3><br />Results: </p><pre>");
			
			//elaborare i risultati:
			int votes;
			while(resultsRS.next()) {
				out.print(resultsRS.getString(2));
				out.print("->\t");
				votes = resultsRS.getInt(3);
				out.println((float) votes/tot * 100 +"% \tResponses: "+votes );	
			}
			out.println("\nTotal responses: " + tot);
			resultsRS.close();
			out.println("</pre>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        
        try {
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
