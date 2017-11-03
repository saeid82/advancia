package datasource;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Topics;

/**
 * Servlet implementation class MainTest
 */

public class MainTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ConnectToDb connectToDb;
	private Connection connection;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			connectToDb = new ConnectToDb();
			connection = connectToDb.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM FAQ_DB.topics;");
			
			LinkedList<Topics> linkedList = new LinkedList<Topics>();
			
			PrintWriter out = response.getWriter();
			
			while(resultSet.next()) {
				//out.println(resultSet.getInt(1));
				linkedList.add(new Topics(resultSet.getInt(1), resultSet.getString(2)));
			}
			String table = "";
			table+="<table><tr>";
			table+="<th>TOPIC_ID</th>";
			table+="<th>TOPIC_NAME</th>";
			
			for(int i=0 ; i <linkedList.size() ; i++) {
				table+="<tr>";
				table+="<td>"+linkedList.get(i).getTopic_id()+"</td>";
				table+="<td>"+linkedList.get(i).getTopic_name()+"</td>";
				table+="</tr>";
			}
			
			table+="</table>";
			out.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");

			out.append("<html><head></head><body>");
			
			out.append(table);
			
			out.append("</body></html>");
			
			response.setContentType("text/html");
			
			out.close();
		} catch (NamingException | SQLException e) {
			
			e.printStackTrace();
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
