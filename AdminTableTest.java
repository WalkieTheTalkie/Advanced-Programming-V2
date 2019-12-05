package application;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AdminTableTest {
	private static AdminTable a;

	/**
	 * makes sure that the admin arraylist is populated
	 * quick test to check 
	 */
	@Test
	public void testGetAdmin() {
		HashMap<Integer, Admin> hash = a.getAdmin();
		ArrayList<Admin> d = new ArrayList<Admin>();
		for(Integer ag : hash.keySet()) {
			d.add(hash.get(ag));
		}
		Admin sameTwo = new Admin(2, "Bjaynes", "4341", "Ben", "A",
				"Jaynes", "ben.jaynes@comcast.net", "630-945-6315", "M", "210 S. Oakhurst Dr.", "11/12/20","no one");
		Admin sameThree = new Admin(3,"Hello", "admin", "Han", "J", "Solo",
				"Hansolo@StarWars.com", "999-999-9999", "Male", 
				"214. interstellar Dr.", "2/99/4529","365-598-895");
		Admin sameFour = new Admin(4,"alex", "alex", "alex", "a", "alex", "alexalex@gmail.com", 
							"789-456-1230", "Male", "254. N. Baker's St.", "2/5/99", "258-963-9514");
		Admin sameSix = new Admin(6, "Hello", "admin", "Han", "J", "Solo",
				"Hansolo@StarWars.com", "999-999-9999", "Male", 
				"214. interstellar Dr.", "2/99/4529","365-598-895");
		assertNotNull(d);

		assertEquals(d.get(1).toString(), sameTwo.toString());
		assertEquals(d.get(2).toString(), sameThree.toString());
		assertEquals(d.get(3).toString(), sameFour.toString());
		assertEquals(d.get(4).toString(), sameSix.toString());
		
		
	}
	/**checks for an ID of an admin
	 * 
	 */
	@Test
	public void testGetAdminByID() {
		HashMap<Integer, Admin> hash = a.getAdmin();
		ArrayList<Admin> d = new ArrayList<Admin>();
		for(Integer ag : hash.keySet()) {
			d.add(hash.get(ag));
		}
		int id = 3;
		int num=0;
		boolean go  = true;
		while(go == true) {
			if (d.get(num).getId() != id) num++;
			else if(id == d.get(num).getId()) {
				go = false;
				assertEquals(id, d.get(num).getId());
			}
		}
	}

}
