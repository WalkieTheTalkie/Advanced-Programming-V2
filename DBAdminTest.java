package application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBAdminTest {

	public void TestDBAdmin() {
		Admin a = new Admin(3, "Hello", "admin", "Han", "J", "Solo",
				"Hansolo@StarWars.com", "999-999-9999", "Male", 
				"214. interstellar Dr.", "2/99/4529","365-598-895");
		DBAdmin yo = new DBAdmin(a);
		Admin sameThing = new AdminTable().getAdminByID(3);
		assertEquals(a.getFirstName(), sameThing.getFirstName());
	}
	@Test
	public void test() {
		TestDBAdmin();
	}

}
