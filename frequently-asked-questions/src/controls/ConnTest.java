package controls;

import java.io.IOException;
import java.io.SequenceInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConnTest extends HttpServlet {
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Statement stat;

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loder is ok.");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faq_db" , "root" , "root");
			System.out.println("the connection is stabilished");
			stat = con.createStatement();
			stat.executeQuery("select * from topics;").next();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}


}
