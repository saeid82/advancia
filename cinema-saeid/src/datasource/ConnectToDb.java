package datasource;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectToDb {
	
	private Connection connection;
	private Context context = null;
	private DataSource dataSource;



	public ConnectToDb() {
		
	}



	public Connection getConnection() throws NamingException, SQLException {
		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/faq_db");
		connection = dataSource.getConnection();
		return connection;
	}
}
