/**
 * 
 */
package dbTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Saeid
 *
 */
public class ConnectionPool {

		private static ConnectionPool connectionPool;
		private Vector<Connection> freeConnections;
		
		private String db_url;
		private String db_driver;
		private String db_username;
		private String db_password;
		  
		private Context context;
		//private Connection connection;
		private DataSource dataSource;
		
	/**
	 * @throws ConnectionPoolException
	 */
	private ConnectionPool() throws ConnectionPoolException{

		freeConnections = new Vector<Connection>();
	}
	
	/**
	 * @return connection pool
	 * @throws ConnectionPoolException
	 */
	public static synchronized ConnectionPool getConnectionPool() throws ConnectionPoolException {
		
		if(connectionPool == null)
			connectionPool = new ConnectionPool();
		return connectionPool;
		
	}
	
	@SuppressWarnings("resource")
	public synchronized Connection getConnection() throws NamingException, SQLException {
		Connection connection;
		if(freeConnections.size() > 0) {
			connection = freeConnections.firstElement();
			freeConnections.removeElementAt(0);
				try {
					if(connection.isClosed())
						connection = getConnection();
				} catch (SQLException e) {
					
					e.printStackTrace();
					connection = getConnection();
				}
		}
		else {
			loadParameters();
			connection = dataSource.getConnection();
		}
		return connection;
	}
	
	private Connection newConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(db_url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public synchronized void releaseConnection(Connection con) {
		freeConnections.add(con);
	}
	
	
	private void loadParameters() throws NamingException {
		context = new InitialContext();
		dataSource = (DataSource) context.lookup("java:comp/env/jdbc/prova");
	}
	
	
	private void loadDriver() {
		try {
			Class.forName(db_driver+"?user="+db_username+"&password="+db_password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
