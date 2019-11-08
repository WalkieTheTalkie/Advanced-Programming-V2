package application;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable{
	String FirstName;
	String MiddleInitial;
	String LastName;
	String Email;
	String Phone;
	String Gender;
	String Address;
	String BirthDate;
	String EmergencyContact;
	
	public Person() {
		
	}
	
	public Person(String firstName, String middleInitial, String lastName, String email, String phone, String gender,
			String address, String birthDate, String emergencyContact) {
		super();
		FirstName = firstName;
		MiddleInitial = middleInitial;
		LastName = lastName;
		Email = email;
		Phone = phone;
		Gender = gender;
		Address = address;
		BirthDate = birthDate;
		EmergencyContact = emergencyContact;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @return the middleInitial
	 */
	public String getMiddleInitial() {
		return MiddleInitial;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return Phone;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return Gender;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return BirthDate;
	}

	/**
	 * @return the emergencyContact
	 */
	public String getEmergencyContact() {
		return EmergencyContact;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @param middleInitial the middleInitial to set
	 */
	public void setMiddleInitial(String middleInitial) {
		MiddleInitial = middleInitial;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		Phone = phone;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		Gender = gender;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	/**
	 * @param emergencyContact the emergencyContact to set
	 */
	public void setEmergencyContact(String emergencyContact) {
		EmergencyContact = emergencyContact;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [FirstName=" + FirstName + ", MiddleInitial=" + MiddleInitial + ", LastName=" + LastName
				+ ", Email=" + Email + ", Phone=" + Phone + ", Gender=" + Gender + ", Address=" + Address
				+ ", BirthDate=" + BirthDate + ", EmergencyContact=" + EmergencyContact + "]";
	}
	
	
	
}
