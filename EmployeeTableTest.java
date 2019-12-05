package application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTableTest {
	EmployeeTable eh = new EmployeeTable();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*	public EmployeeClass(int employeeID, int workinHours, String employeeUser, String employeePass, 
			String firstName, String middleInitial, String lastName, String email, String phone,
			String gender, String address, String birthDate, String emergencyContact)*/
	@Test
	public void testGetAdmin() {
		HashMap<Integer, EmployeeClass> hash = eh.getEmployees();
		ArrayList<EmployeeClass> d = new ArrayList<EmployeeClass>();
		for(Integer ag : hash.keySet()) {
			d.add(hash.get(ag));
		}
		EmployeeClass sameTwo = new EmployeeClass(2, 6, "vancs", "angel", "", "", "Vivanco", 
				"avivanco01@aurora.edu", "3313018225", "Male", "4648", "105025","");
		EmployeeClass sameThree = new EmployeeClass(3,0,"CalHenry", "kljs87", "Cal", "M", "Henry",
				"khenry@gmail.com", "384-284-2843", "Male", "67 Bounce Lane", "12/28/99", "Calypso Henry");
		EmployeeClass sameFour = new EmployeeClass(25, 0, "klp27", "n8ihksk", "Owen", "R", "Ivan", "oivan35@yahoo.com", 
							"389-393-4942", "Male", "488 Meadow St", "4/23/99", "Joey Moline");
		EmployeeClass sameSix = new EmployeeClass(1, 11, "Scott", "m", "Scott", "L", "Meyers",
				"smeyers@gmail.com", "283-475-3742", "Male", "23 Gourd Ct", "12/23/89","Mary Meyers");
		assertNotNull(d);
		assertEquals(sameTwo.toString(),d.get(1).toString());
		assertEquals(sameThree.toString(),d.get(2).toString());
		assertEquals(sameFour.toString(),d.get(4).toString());
		assertEquals(sameSix.toString(),d.get(0).toString());
		
		
	}
	@Test
	public void testingGetEmployeeByID() {
		HashMap<Integer, EmployeeClass> hash = eh.getEmployees();
		ArrayList<EmployeeClass> d = new ArrayList<EmployeeClass>();
		for(Integer ag : hash.keySet()) {
			d.add(hash.get(ag));
		}
		int id = 3;
		int num = 0;
		boolean go  = true;
		while(go == true) {
			if (d.get(num).getEmployeeID() != id) num++;
			else if(id == d.get(num).getEmployeeID()) {
				go = false;
				assertEquals(id, d.get(num).getEmployeeID());
			}
		}
	}

}
