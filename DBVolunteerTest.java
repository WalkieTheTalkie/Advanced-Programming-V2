package application;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class DBVolunteerTest {

	public void testDBVolunteer() {
		Volunteer vol = new Volunteer("Ben", "A", "Jaynes", "bjaynes@aurora.edu", "630-958-8956", "M",
				"210 S. Oakhurst Dr.", "2/11/2000", "685-895-9865", 10256, 20,
				true, "BJAY", "password");
		System.out.println(vol.toString());
		DBVolunteer instance = new DBVolunteer(vol);
		Volunteer sameVol = new VolunteerTable().getVolunteerByID(20);
		//System.out.println(sameVol.toString());
		assertEquals(vol.getFirstName(), sameVol.getFirstName());
	}

	@Test
	public void test() {
		testDBVolunteer();
	}

}
