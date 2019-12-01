package application;

import java.io.Serializable;
import java.util.Comparator;
/**
 * Class that stores Volunteer data 
 *
 */
@SuppressWarnings("serial")
public class Volunteer extends Person implements Serializable, Comparator, Comparable  {
	int VolunteerID;
	int HoursVolunteered;
	Boolean CourtOrdered;
	String UserName;
	String Password;
	
	public Volunteer() {
		
	}

	public Volunteer(int volunteerID, int hoursVolunteered, Boolean courtOrdered, String userName, String password) {
		super();
		VolunteerID = volunteerID;
		HoursVolunteered = hoursVolunteered;
		CourtOrdered = courtOrdered;
		UserName = userName;
		Password = password;
	}

	public Volunteer(String firstName, String middleInitial, String lastName, String email, String phone, String gender,
			String address, String birthDate, String emergencyContact, int volunteerID, int hoursVolunteered,
			Boolean courtOrdered, String userName, String password) {
		super(firstName, middleInitial, lastName, email, phone, gender, address, birthDate, emergencyContact);
		VolunteerID = volunteerID;
		HoursVolunteered = hoursVolunteered;
		CourtOrdered = courtOrdered;
		UserName = userName;
		Password = password;
	}

	/**
	 * @return the volunteerID
	 */
	public int getVolunteerID() {
		return VolunteerID;
	}

	/**
	 * @return the hoursVolunteered
	 */
	public int getHoursVolunteered() {
		return HoursVolunteered;
	}

	/**
	 * @return the courtOrdered
	 */
	public Boolean getCourtOrdered() {
		return CourtOrdered;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param volunteerID the volunteerID to set
	 */
	public void setVolunteerID(int volunteerID) {
		VolunteerID = volunteerID;
	}

	/**
	 * @param hoursVolunteered the hoursVolunteered to set
	 */
	public void setHoursVolunteered(int hoursVolunteered) {
		HoursVolunteered = hoursVolunteered;
	}

	/**
	 * @param courtOrdered the courtOrdered to set
	 */
	public void setCourtOrdered(Boolean courtOrdered) {
		CourtOrdered = courtOrdered;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Volunteer ID: " + VolunteerID + "\nHours Volunteered: " + HoursVolunteered + "\nCourt Ordered?: "
				+ CourtOrdered + "\nUsername: " + UserName + "\nPassword: " + Password + "\nFirst Name: " + FirstName
				+ "\nMiddle Initial: " + MiddleInitial + "\nLast Name: " + LastName + "\nEmail: " + Email + "\nPhone: "
				+ Phone + "\nGender: " + Gender + "\nAddress: " + Address + "\nBirth Date:" + BirthDate
				+ "\nEmergency Contact: " + EmergencyContact;
	}
	
	public String toString2() {
		return "\n" + VolunteerID + " " + HoursVolunteered + " "
				+ CourtOrdered + " " + UserName + " " + Password + " " + FirstName
				+ " " + MiddleInitial + " " + LastName + " " + Email + " "
				+ Phone + " " + Gender + " " + Address + " " + BirthDate
				+ " " + EmergencyContact;
	}
	
	/**
	 * uses comparator to sort objects by last name
	 */
	public int compare(Object o1, Object o2) {
		Volunteer v1 = (Volunteer) o1;
		Volunteer v2 = (Volunteer) o2;
		
		return v1.getLastName().compareToIgnoreCase(v2.getLastName());
	}
	/**
	 * uses comparable to sort objects by hours
	 */
	@Override
	public int compareTo(Object o) {
		int compareHours = ((Volunteer) o).getHoursVolunteered();
		return compareHours - this.HoursVolunteered;
	}

}
