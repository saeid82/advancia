package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GuestDataBean {
	private Connection con;
	private Statement stat;
	private static final String DB_DRIVER ="com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/guestBook";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "root";
	private static final String QUERY_SELECT = "SELECT * FROM CLIENT";
	
	
	public GuestDataBean() throws Exception {
		Class.forName(DB_DRIVER);
		con = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		stat = con.createStatement();
	}
	
	public List<GuestBean> getGuestList() throws SQLException {
		List<GuestBean> guestList = new ArrayList<GuestBean>();
		ResultSet resultSet = stat.executeQuery(QUERY_SELECT);
		
		while(resultSet.next()) {
			GuestBean guest = new GuestBean();
			guest.setName(resultSet.getString(1));
			guest.setSurname(resultSet.getString(2));
			guest.setEmail(resultSet.getString(3));
			
			guestList.add(guest);
		}
		return guestList;
	}
	
	public void addGuestToDb(GuestBean guest) throws SQLException {
		String QUERY_INSERT = "INSERT INTO CLIENT(NAME , SURNAME , EMAIL)"
				+ "VALUE("+guest.getName()+","+guest.getSurname()+","+guest.getEmail()+")";
		stat.executeUpdate(QUERY_INSERT);
	}
	
	public void closeConnection() {
		try {
			stat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
