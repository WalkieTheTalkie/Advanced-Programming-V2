package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.Statement;

public class EmployeeTable {
	private HashMap<Integer, EmployeeClass> employees = new HashMap<Integer, EmployeeClass>();
	private Connection connection;
	private final String SELECT_QUERY = "SELECT empID, workHours, username, password, firstName,"
			+ " middleInitial, lastName, email, phone, gender, address, birthDate,"
			+ " emergencyContact FROM csc3610_Group3_finalProject.employees";
	
	private String update_query = "UPDATE csc3610_Group3_finalProject.employees SET"
			+ " workHours = ?, username = ?, password = ?, firstName = ?, middleInitial = ?,"
			+ " lastName = ?, email = ?, phone = ?, gender = ?, address = ?,"
			+ " birthDate = ?, emergencyContact = ? WHERE empID = ?;";
	
	EmployeeTable(){
		setEmployees();
	}
	
	public void setEmployees() { // Connection must be set before using
		setConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rset = stmt.executeQuery(SELECT_QUERY);
			
			
			while(rset.next()) {
				EmployeeClass temp = new EmployeeClass();
				temp.setEmployeeID(rset.getInt(1));
				temp.setWorkinHours(rset.getInt(2));
				temp.setEmployeeUser(rset.getString(3));
				temp.setEmployeePass(rset.getString(4));
				temp.setFirstName(rset.getString(5));
				temp.setMiddleInitial(rset.getString(6));
				temp.setLastName(rset.getString(7));
				temp.setEmail(rset.getString(8));
				temp.setPhone(rset.getString(9));
				temp.setGender(rset.getString(10));
				temp.setAddress(rset.getString(11));
				temp.setBirthDate(rset.getString(12));
				temp.setEmergencyContact(rset.getString(13));
				employees.put(temp.getEmployeeID(), temp);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		
	}
	
	public HashMap<Integer, EmployeeClass> getEmployees() {
		return employees;
	}
	
	public EmployeeClass getEmployeeByID(int id) {
		return employees.get(id);
	}
	
	public void setConnection() {
		DBEmployee emp = new DBEmployee();
		Connection connect = emp.getConnection();
		this.connection = connect;
	}
	
	public void updateEmployee(EmployeeClass emp) {
		try {
			PreparedStatement prepared = connection.prepareStatement(update_query);
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
			prepared.setInt(13, emp.getEmployeeID());
			
			prepared.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}
