package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class BinarySearchSortByIDTest {

	
	public void testEmpBinarySearchByID(){
		int idNumber = 4; // this is the employee id we are searching for
		EmployeeClass emp = BinarySearchSortByID.EmpBinarySearchByID(idNumber);
		System.out.print(emp.toString()); // will print an employee
		// if there is no id number that matches the above, it returns an employee 
		// with all its categories as null
		// id of 4 does not exist so it returns a null employee
		int id = 1;
		EmployeeClass emp2 = BinarySearchSortByID.EmpBinarySearchByID(id);
		System.out.print(emp2.toString());
		// id of 1 does exist, so it displays the employee information
		String emp2Name = emp2.getFirstName(); // first name = Scott
		assertEquals("Scott", emp2Name);
	}
	
	
	public void testAdBinarySearchByID() {
		int idNumber = 100;
		Admin ad = BinarySearchSortByID.AdBinarySearchByID(idNumber);
		System.out.print(ad.toString());
		
		int id = 1; // username = admin
		Admin ad2 = BinarySearchSortByID.AdBinarySearchByID(id);
		System.out.print(ad2.toString());
		String username = ad2.getUsername();
		assertEquals("admin", username);
	}
	
	public void testVBinarySearchByID() {
		int id = 0;
		Volunteer v = BinarySearchSortByID.VBinarySearchByID(id);
		System.out.print(v.toString());
		
		int id2 = 3;
		Volunteer v2 = BinarySearchSortByID.VBinarySearchByID(id2);
		System.out.print(v2.toString());
		assertEquals("Copper", v2.getLastName());
	}
	
	// Sort by ID methods are just a way of displaying data, so no need to test
	
	@Test
	void test() {
		//fail("Not yet implemented");
		testEmpBinarySearchByID();
		testAdBinarySearchByID();
		testVBinarySearchByID();
	}

}
