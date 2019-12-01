package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Connects to the Database Table Volunteer
 * 
 *
 */
public class DBVolunteer {
	private Connection connection;
	private Volunteer volun;
	/**
	 * method allows the object to be called from other classes
	 */
	DBVolunteer(){
		
	}
	/**
	 * Method to upload/update a Volunteer
	 * @param volun Volunteer Object to be uploaded/updated
	 */
	DBVolunteer(Volunteer volun){
		try {
			this.volun = volun;
			this.setConnection();
			addVolunteer(this.volun);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	/**
	 * gets connection to database table
	 * @return connection to database
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
	 * MySQL statement to be utilized to interact with database
	 * @param volun Volunteer Object where data will be implemented from
	 * @throws SQLException
	 */
	private void addVolunteer(Volunteer volun) throws SQLException{
		String query = "insert into volunteers (volunID, hours, courtOrdered, username, password, firstName, middleInitial, lastName,"
				+ " email, phone, gender, address, birthDate, emergencyContact) values"
				+ " (null,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepared = connection.prepareStatement(query);
		prepared.setInt(1, volun.getHoursVolunteered());
		prepared.setBoolean(2, volun.getCourtOrdered());
		prepared.setString(3, volun.getUserName());
		prepared.setString(4, volun.getPassword());
		prepared.setString(5, volun.getFirstName());
		prepared.setString(6, volun.getMiddleInitial());
		prepared.setString(7, volun.getLastName());
		prepared.setString(8, volun.getEmail());
		prepared.setString(9, volun.getPhone());
		prepared.setString(10, volun.getGender());
		prepared.setString(11, volun.getAddress());
		prepared.setString(12, volun.getBirthDate());
		prepared.setString(13, volun.getEmergencyContact());
		
		prepared.execute();
	}
}
