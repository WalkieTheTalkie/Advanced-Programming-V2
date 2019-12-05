package application;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class SearchByLastNameTest {

	
	public void runTest(){
		Admin a = new Admin(20, "hello", "pass", "fname", "a", "Jay", "", "365-895-985", "M",
				"210 S Oakhurst Dr.", "2/11/2000", "458-895-9658");
		EmployeeClass e = new EmployeeClass("hello", "a", "jAy", "hello@123.org", "589-895-986",
				"M", "210 S. Oakhurst Dr.", "2/58/5986", "254-598-8954");
		Volunteer v = new Volunteer("hell", "a", "jaY", "DevilsKnocking@678.org", "968-896-8569", "M",
				"210 S. Oakhurst Dr.", "2/11/5895", "154-895-8954", 1548, 20,
				true, "Devil", "1548");
		
		a.setLastName("Jay");
		e.setLastName("jAy");
		e.setEmployeeUser("hello");
		e.setEmployeePass("458");
		v.setLastName("jaY");
		
		
		DBAdmin A = new DBAdmin(a);
		DBEmployee E = new DBEmployee(e);
		DBVolunteer V = new DBVolunteer(v);
		
		ArrayList<Admin> sameA = SearchByLastName.AdminSearchByLastName("Jay");
		ArrayList<EmployeeClass> sameE = SearchByLastName.EmpSearchByLastName("jAy");
		ArrayList<Volunteer> sameV = SearchByLastName.VolunSearchByLastName("jaY");
		
		System.out.println();
		System.out.println(sameA);
		System.out.println();
		System.out.println();
		System.out.println(sameE);
		System.out.println();
		System.out.println();
		System.out.println(sameV);
		System.out.println();
	}

	

	@Test
	public void testAdminSearchByLastName() {
		runTest();
	}

}
