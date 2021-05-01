import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class forgotPasswordTester {

	/**
	 * Test the constructor of ForgotPassword
	 */
	@Test
	void testConstructor() {
		String username = "ash";
		ForgotPassword f1 = new ForgotPassword(username);
		assertTrue(f1 != null);
	}
	
	/**
	 * Test getting the username from the ForgotPassword object
	 */
	@Test
	void testGetUsername() {
		String username = "ash";
		ForgotPassword f1 = new ForgotPassword(username);
		assertEquals(f1.getUsername(),"ash");
	}

	/**
	 * Test setting the username from the ForgotPassword object
	 */
	@Test
	void testSetUsername() {
		String username = "ash";
		ForgotPassword f1 = new ForgotPassword(username);
		assertEquals(f1.getUsername(),"ash");
		f1.setUsername("guest");
		assertEquals(f1.getUsername(),"guest");
	}
	
	/**
	 * Tests the finding of a user's information given username
	 */
	@Test
	void returnUser() {
		//tests to find a user's password that actually exists in the database
		String username = "ash";
		ForgotPassword f1 = new ForgotPassword(username);
		User foundUser = f1.returnUser();
		assertEquals(foundUser.getUsername(),"ash");
		assertEquals(foundUser.getPassword(),"123");
		
		//tests the edge case of if the username doesn't exist in the database should return null
		String username2 = "non-user";
		ForgotPassword f2 = new ForgotPassword(username2);
		User foundUser2 = f2.returnUser();
		assertEquals(foundUser2,null);
		
		//tests if a malicious user tries to find out information about the guest account should return null
		String username3 = "Guest";
		ForgotPassword f3 = new ForgotPassword(username3);
		User foundUser3 = f3.returnUser();
		assertEquals(foundUser3,null);
	}
}
