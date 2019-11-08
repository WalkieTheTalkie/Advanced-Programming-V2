package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBEmployee {
	private Connection connection;
	private EmployeeClass emp;
	
	DBEmployee(){
		
	}
	
	DBEmployee(EmployeeClass emp) {
		try {
			this.emp = emp;
			this.setConnection();
			addEmployee(this.emp);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		this.setConnection();
		return this.connection;
	}
	
	private void setConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://45.55.136.114/csc3610_Group3_finalProject", "csc3610", "csc3610");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addEmployee(EmployeeClass emp) throws SQLException{
		String query = "insert into employees (empID, workHours, username, password, firstName, middleInitial, lastName,"
				+ " email, phone, gender, address, birthDate, emergencyContact) values"
				+ " (null,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement prepared = connection.prepareStatement(query);
		prepared.setInt(1, emp.getWorkinHours());
		prepared.setString(2, emp.getEmployeeUser());
		prepared.setString(3, emp.getEmployeePass());
		prepared.setString(4, emp.getFirstName());
		prepared.setString(5, emp.getMiddleInitial());
		prepared.setString(6, emp.getLastName());
		prepared.setString(7, emp.getEmail());
		prepared.setString(8, emp.getPhone());
		prepared.setString(9, emp.getGender());
		prepared.setString(10, emp.getAddress());
		prepared.setString(11, emp.getBirthDate());
		prepared.setString(12, emp.getEmergencyContact());
		
		prepared.execute();
	}
}
