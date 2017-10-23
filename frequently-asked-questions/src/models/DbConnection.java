package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	public Connection connectionToDb() {
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loder worked correctly");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/faq_db" , "root" , "root");
			System.out.println("connection......");
			return con;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
