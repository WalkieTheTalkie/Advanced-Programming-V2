package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DBEmployeeTest {

	public void testDBEmployee() {
		// test that the constructor does add an employee to the database table
		EmployeeClass emp = new EmployeeClass(0, 0, "mbean", "348", "Margaret", "L", "Bean", 
				"mbean@gmail.com", "890-373-2843", "Female", "12 Jordan Ct.", 
				"243-382-2348", "Nathan Bean");
		DBEmployee instance = new DBEmployee(emp); // sends it to be saved in database
		EmployeeClass sameEmp = new EmployeeTable().getEmployeeByID(25008); // id number changes based on autoincrement
		assertEquals(emp.getFirstName(), sameEmp.getFirstName());                                         // please change id number if using
	}
	
	@Test
	void test() {
		//fail("Not yet implemented");
		testDBEmployee();
	}

}
