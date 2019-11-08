package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBAdmin {
	private Connection connection;
	private Admin admin;
	
	DBAdmin(){
		
	}
	
	DBAdmin(Admin admin){
		try {
			this.admin = admin;
			this.setConnection();
			addAdmin(this.admin);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private void setConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://45.55.136.114/csc3610_Group3_finalProject", "csc3610", "csc3610");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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
