package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VolunteerTableTest {

	public void testupdateVolunteer() {
		// get volunteer and edit successfully
		Volunteer v = new VolunteerTable().getVolunteerByID(1);
		// we're editing Jane's info
		System.out.print("Middle Initial: " + v.getMiddleInitial());
		v.setMiddleInitial("K"); // changing to K
		VolunteerTable v2 = new VolunteerTable();
		v2.updateVolunteer(v);
		
		Volunteer volun = new VolunteerTable().getVolunteerByID(1);
		// see if it updated 
		System.out.print("\nMiddle Initial Changed: " + volun.getMiddleInitial());
		assertEquals("K", volun.getMiddleInitial());
	}
	
	@Test
	void test() {
		//fail("Not yet implemented");
		testupdateVolunteer();
	}

}
