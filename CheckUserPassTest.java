package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckUserPassTest {

	private CheckUserPass a = new CheckUserPass();
	
	@Test
	public void testCheckUserPass() {
		int pass = 1;
		int result = a.CheckUserPassAdmin("user", "pass");
		assertEquals(pass, result);
	}
	
	@Test
	public void testCheckUserPass1() {
		int pass = 0;
		int result = a.CheckUserPassAdmin("user", "pass");
		assertEquals(pass, result);
	}
	@Test
	public void testCheckUserPass2() {
		int pass = 1;
		int result = a.CheckUserPassEmployee("user", "pass");
		assertEquals(pass, result);
	}
	
	@Test
	public void testCheckUserPass3() {
		int pass = 0;
		int result = a.CheckUserPassEmployee("user", "pass");
		assertEquals(pass, result);
	}
	@Test
	public void testCheckUserPass4() {
		int pass = 1;
		int result = a.CheckUserPassVolunteer("user", "pass");
		assertEquals(pass, result);
	}
	
	@Test
	public void testCheckUserPass5() {
		int pass = 0;
		int result = a.CheckUserPassVolunteer("user", "pass");
		assertEquals(pass, result);
	}

}
