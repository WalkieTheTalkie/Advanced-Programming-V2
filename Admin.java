package application;

import java.util.Comparator;
/**
 * Admin is how the Admin data within the database is uploaded, written,
 * and read.
 * Implements a Comparator interface to sort the Admin by Last Name
 * @author Ben Jaynes
 * @author Rachel Skonning
 *
 */
public class Admin extends Person implements Comparator{
	private String username;
	private String password;
	private int id;
	
	Admin(){
		
	}
	
	Admin(int id, String user, String pass){
		this.id = id;
		this.username = user;
		this.password = pass;
	}
	
	Admin(int id, String user, String pass, String fname, String middle, String lname, String email, String phone, String gender,
			String address, String birth, String contact){
		super(fname, middle, lname, email, phone, gender, address, birth, contact);
		this.id = id;
		this.username = user;
		this.password = pass;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() { // Admin password should be secure
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nUsername: " + username + "\npassword: " + password + "\nid: " + id + "\nFirstName: " + FirstName
				+ "\nMiddleInitial: " + MiddleInitial + "\nLastName: " + LastName + "\nEmail=" + Email + "\nPhone: "
				+ Phone + "\nGender: " + Gender + "\nAddress: " + Address + "\nBirthDate: " + BirthDate
				+ "\nEmergencyContact: " + EmergencyContact;
	}
	
	public String toString2() {
		return  "\n" + username + " " +  password + " " + id + " " + FirstName
				+ " " + MiddleInitial + " " + LastName + " " + Email + " "
				+ Phone + " " + Gender + " " + Address + " " + BirthDate
				+ " " + EmergencyContact;
	}

	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		Admin A1 = (Admin) arg0;
		Admin A2 = (Admin) arg1;
		
		return A1.FirstName.compareToIgnoreCase(A2.FirstName);
	}
	
}
