package dbTest;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import javax.naming.NamingException;

import uk.ltd.getahead.dwr.util.Logger;


public class DatabaseOperation {
	
	private static Connection connection;
	
	static {
		
		try {
			connection = ConnectionPool.getConnectionPool().getConnection();
		} catch (NamingException  e) {
			System.out.println("Il datasource non collabora");
		} catch (ConnectionPoolException e) {
			System.out.println("ConnectionPool non collabora");
		} catch (SQLException e) {
			System.out.println("Il database non collabora");
		}
	}

	private static Connection getConnection() {
		return connection;
	}
	
	public static List<Person> readPersonTable(){
		List<Person> persons = new LinkedList<Person>();
		
		try {
			Statement statement = getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON");
			System.out.println("Risultati select su people:\n");
			while(resultSet.next()) {
				persons.add(new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getInt(4));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return persons;
	}
	
	
	public static void addPerson(Person p) throws SQLException {
		String sql = "INSERT INTO person (ID, FIRSTNAME, LASTNAME, AGE) VALUES (null, ?, ?, ?)";
		java.sql.PreparedStatement preparedStatement =  getConnection().prepareStatement(sql);
		preparedStatement.setString(1, p.getFirstname());
		preparedStatement.setString(2, p.getLastname());
		preparedStatement.setInt(3, p.getAge());
		preparedStatement.execute();
	}
	
	
	public static Person getPersonByID(int i) throws SQLException {
		try {
			String query = "SELECT ID, FIRSTNAME, LASTNAME, AGE FROM PROVA.person WHERE  ID="+i;
			Statement statement = getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if(!resultSet.next()) 
				throw new IllegalArgumentException();
			int id = resultSet.getInt(1);
			String firstname = resultSet.getString(2);
			String lastname = resultSet.getString(3);
			int age = resultSet.getInt(4);
			return new Person(id, firstname, lastname, age);
			
			
		} catch (Exception e) {
			Logger.getLogger(DatabaseOperation.class);
			
		}
		
		return null;
	}
	
	public static void editPersonByID(int id , Person person) throws SQLException {
		try {
			String quey = "UPDATE PERSON SET FIRSTNAME=? , LASTNAME=?, AGE=? WHERE ID=?";
			java.sql.PreparedStatement preparedStatement = getConnection().prepareStatement(quey);
			preparedStatement.setString(1, person.getFirstname());
			preparedStatement.setString(2, person.getLastname());
			preparedStatement.setInt(3, person.getAge());
			preparedStatement.setInt(4, id);
			System.out.println("Executing statement " + preparedStatement.toString());
			preparedStatement.execute();
		} catch (Exception e) {
			System.out.println("non riesce a eseguire preparedstatement....");
			e.getMessage();
		}
		
	}
	
	public static void deletePersonByID(int i) {
		String query = "DELETE FROM PROVA.person WHERE ID= "+i+";";
		
		try {
			Statement statement = getConnection().createStatement();
			statement.execute(query);
		} catch (SQLException e) {
			System.out.println("non riesce ad eseguire query....");
			e.printStackTrace();
		}
		
	}
	
	
}
