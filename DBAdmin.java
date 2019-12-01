package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * uploads and updates to the admin table in MySQL
 * 
 *
 */
public class DBAdmin {
	private Connection connection;
	private Admin admin;
	/**
	 * method allows the object to be called from other classes
	 */
	DBAdmin(){
		
	}
	/**
	 * Connects and uploads an Admin Object to Database
	 * @param admin Admin Object to be uploaded/updated
	 */
	DBAdmin(Admin admin){
		try {
			this.admin = admin;
			this.setConnection();
			addAdmin(this.admin);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * method gets the connection to the database table
	 * @return Connection to Admin table
	 */
	public Connection getConnection() {
		setConnection();
		return this.connection;
	}
	/**
	 * sets up the connection to the database table
	 */
	private void setConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://45.55.136.114/csc3610_Group3_finalProject", "csc3610", "csc3610");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * MySQL statement that reads input from the program and puts it
	 * into a prepared statement
	 * @param a Calls Admin Object
	 * @throws SQLException
	 */
	private void addAdmin(Admin a) throws SQLException{
		String query = "insert into admin (id, username, password, firstName, middleInitial,"
				+ " lastName, birthDate, gender, email, phone, address, emergencyContact)"
				+ " values (null,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepared = connection.prepareStatement(query);
		prepared.setString(1, a.getUsername());
		prepared.setString(2, a.getPassword());
		prepared.setString(3, a.getFirstName());
		prepared.setString(4, a.getMiddleInitial());
		prepared.setString(5, a.getLastName());
		prepared.setString(6, a.getBirthDate());
		prepared.setString(7, a.getGender());
		prepared.setString(8, a.getEmail());
		prepared.setString(9, a.getPhone());
		prepared.setString(10, a.getAddress());
		prepared.setString(11, a.getEmergencyContact());
		
		prepared.execute();
	}
}
