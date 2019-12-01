package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
/**
 * Creates a table of Admins from database 
 *
 */
public class AdminTable {
	/**
	 * stored data of an admin in a hashmap
	 */
	private HashMap<Integer, Admin> admin = new HashMap<Integer, Admin>();
	/**
	 * database connection
	 */
	private Connection connection;
	/**
	 * MySQL statement that displays data
	 */
	private final String SELECT_QUERY = "SELECT id, username, password, firstName,"
			+ " middleInitial, lastName, email, phone, gender, address, birthDate,"
			+ " emergencyContact FROM csc3610_Group3_finalProject.admin";
	/**
	 * Updates a row in a table
	 */
	private String update_query = "UPDATE csc3610_Group3_finalProject.admin SET"
			+ " username = ?, password = ?, firstName = ?, middleInitial = ?,"
			+ " lastName = ?, email = ?, phone = ?, gender = ?, address = ?,"
			+ " birthDate = ?, emergencyContact = ? WHERE id = ?;";
	
	private String delete_query = "DELETE FROM csc3610_Group3_finalProject.admin"
			+ " WHERE id = ?;";
	/**
	 * calls setAdmin to update a table with database values
	 */
	AdminTable(){
		setAdmin();
	}
	/**
	 * A resultSet updated with Admin information
	 */
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
	/**
	 * identifies admin by ID
	 * @param id unique identifier
	 * @return admin information
	 */
	public Admin getAdminByID(int id) {
		return admin.get(id);
	}
	
	/**
	 * uses DBAdmin to connect to database
	 */
	public void setConnection() {
		DBAdmin ad = new DBAdmin();
		this.connection = ad.getConnection();
	}
	/**
	 * calls admin table to update an existing admin
	 * @param ad Admin Object
	 */
	public void updateAdmin(Admin ad) {
		try {
			PreparedStatement prepared = connection.prepareStatement(update_query);
			prepared.setString(1, ad.getUsername());
			prepared.setString(2, ad.getPassword());
			prepared.setString(3, ad.getFirstName());
			prepared.setString(4, ad.getMiddleInitial());
			prepared.setString(5, ad.getLastName());
			prepared.setString(6, ad.getEmail());
			prepared.setString(7, ad.getPhone());
			prepared.setString(8, ad.getGender());
			prepared.setString(9, ad.getAddress());
			prepared.setString(10, ad.getBirthDate());
			prepared.setString(11, ad.getEmergencyContact());
			prepared.setInt(12, ad.getId());
			
			prepared.execute();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	/**
	 * method deletes a profile
	 * @param num the ID to input to delete an admin
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
