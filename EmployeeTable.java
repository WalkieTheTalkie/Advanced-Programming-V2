package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.sql.Statement;
/**
 * creates table of Employees from database
 *
 */
public class EmployeeTable {
	/**
	 * stores data of employees in a hashmap
	 */
	private HashMap<Integer, EmployeeClass> employees = new HashMap<Integer, EmployeeClass>();
	/**
	 * gets connection to database
	 */
	private Connection connection;
	/**
	 * MySQL statement that displays data
	 */
	private final String SELECT_QUERY = "SELECT empID, workHours, username, password, firstName,"
			+ " middleInitial, lastName, email, phone, gender, address, birthDate,"
			+ " emergencyContact FROM csc3610_Group3_finalProject.employees";
	/**
	 * MySQL statement that updates a row in a table
	 */
	private String update_query = "UPDATE csc3610_Group3_finalProject.employees SET"
			+ " workHours = ?, username = ?, password = ?, firstName = ?, middleInitial = ?,"
			+ " lastName = ?, email = ?, phone = ?, gender = ?, address = ?,"
			+ " birthDate = ?, emergencyContact = ? WHERE empID = ?;";
	/**
	 * MySQL Statement that deletes a row from a table based on ID
	 */
	private String delete_query = "DELETE FROM csc3610_Group3_finalProject.employees"
			+ " WHERE empID = ?;";
	/**
	 * calls setEmployees to update table with database values
	 */
	EmployeeTable(){
		setEmployees();
	}
	/**
	 * resultSet updated with Employee information
	 */
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
	/**
	 * identifies employee by ID
	 * @param id unique identifier
	 * @return employee information
	 */
	public EmployeeClass getEmployeeByID(int id) {
		return employees.get(id);
	}
	/**
	 * uses DBEmployee to connect to database
	 */
	public void setConnection() {
		DBEmployee emp = new DBEmployee();
		Connection connect = emp.getConnection();
		this.connection = connect;
	}
	/**
	 * calls employee table to update existing employee
	 * @param emp
	 */
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
	/**
	 * method deletes a profile
	 * @param num the ID to input to delete an employee
	 */
	public void delete(int num) {
		try {
			PreparedStatement prepared = connection.prepareStatement(delete_query);
			prepared.setInt(1, num);
			prepared.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
