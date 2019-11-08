package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class AdminTable {
	private HashMap<Integer, Admin> admin = new HashMap<Integer, Admin>();
	private Connection connection;
	private final String SELECT_QUERY = "SELECT id, username, password, firstName,"
			+ " middleInitial, lastName, email, phone, gender, address, birthDate,"
			+ " emergencyContact FROM csc3610_Group3_finalProject.admin";
	
	AdminTable(){
		setAdmin();
	}
	
	public void setAdmin() {
		setConnection();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rset = stmt.executeQuery(SELECT_QUERY);
			
			
			while(rset.next()) {
				Admin temp = new Admin();
				temp.setId(rset.getInt(1));
				temp.setUsername(rset.getString(2));
				temp.setPassword(rset.getString(3));
				temp.setFirstName(rset.getString(4));
				temp.setMiddleInitial(rset.getString(5));
				temp.setLastName(rset.getString(6));
				temp.setEmail(rset.getString(7));
				temp.setPhone(rset.getString(8));
				temp.setGender(rset.getString(9));
				temp.setAddress(rset.getString(10));
				temp.setBirthDate(rset.getString(11));
				temp.setEmergencyContact(rset.getString(12));
				admin.put(temp.getId(), temp);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public HashMap<Integer, Admin> getAdmin() {
		return admin;
	}
	
	public Admin getAdminByID(int id) {
		return admin.get(id);
	}
	
	
	public void setConnection() {
		DBAdmin ad = new DBAdmin();
		this.connection = ad.getConnection();
	}
	
}
