package application;

import java.io.Serializable;
import java.util.Comparator;

@SuppressWarnings("serial")
public class EmployeeClass extends Person implements Serializable, Comparator{
	private int EmployeeID;
	private int workinHours;
	private String employeeUser;
	private String employeePass;
	
	
	
	public EmployeeClass(int employeeID, int workinHours, String employeeUser, String employeePass) {
		super();
		EmployeeID = employeeID;
		this.workinHours = workinHours;
		this.employeeUser = employeeUser;
		this.employeePass = employeePass;
	}
	public EmployeeClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeClass(String firstName, String middleInitial, String lastName, String email, String phone,
			String gender, String address, String birthDate, String emergencyContact) {
		super(firstName, middleInitial, lastName, email, phone, gender, address, birthDate, emergencyContact);
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeClass(int employeeID, int workinHours, String employeeUser, String employeePass, 
			String firstName, String middleInitial, String lastName, String email, String phone,
			String gender, String address, String birthDate, String emergencyContact) {
		super(firstName, middleInitial, lastName, email, phone, gender, address, birthDate, emergencyContact);
		EmployeeID = employeeID;
		this.workinHours = workinHours;
		this.employeeUser = employeeUser;
		this.employeePass = employeePass;
	}
	
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public int getWorkinHours() {
		return workinHours;
	}
	public void setWorkinHours(int workinHours) {
		this.workinHours = workinHours;
	}
	public String getEmployeeUser() {
		return employeeUser;
	}
	public void setEmployeeUser(String employeeUser) {
		this.employeeUser = employeeUser;
	}
	public String getEmployeePass() {
		return employeePass;
	}
	public void setEmployeePass(String employeePass) {
		this.employeePass = employeePass;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nID: " + EmployeeID + "\nName: " + FirstName + " " + MiddleInitial + " " + LastName + "\nEmail: " + Email + "\nPhone Number: " +
				Phone + "\nGender: " + Gender + "\nAddress: " + Address + "\nDate of Birth: " + BirthDate + "\nEmergency Contact: " + EmergencyContact + "";
	}
	
	public String toString2() {
		return "\n" + EmployeeID + " " + FirstName + " " + MiddleInitial + " " + LastName + " " + Email + " " +
				Phone + " " + Gender + " " + Address + " " + BirthDate + " " + EmergencyContact;
	}
	@Override
	public int compare(Object o1, Object o2) {
		EmployeeClass E1 = (EmployeeClass) o1;
		EmployeeClass E2 = (EmployeeClass) o2;
		return E1.getLastName().compareToIgnoreCase(E2.getLastName());
	}
	
}
