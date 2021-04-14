import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Patrick Jensen
 *
 */
class testForgotPassword {

	@Test
	void testConstructor() {
		try {
			Date date = new Date(0);
			User u = new User( "username",  "password",  "email", date, 0);
			ForgotPassword f1 = new ForgotPassword(u);
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}
	
	@Test
	void testGetUser() {
		Date date = new Date(0);
		try {			
			User u = new User( "username",  "password",  "email", date, 0);
			ForgotPassword f1 = new ForgotPassword(u);
			User u1;
			u1 = f1.getUser();
			assertTrue (u1.equals(u));
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}
	
	@Test
	void testGetEmail() {
		Date date = new Date(0);
		try {
			User u = new User( "username",  "password",  "email", date, 0);
			ForgotPassword f1 = new ForgotPassword(u);
			String email = f1.getUser().getEmail();
			assertEquals(email, "email");
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}
	
	@Test
	void testCheckCompare() {
		Date date = new Date(0);
		try {
			String inputEmail = "123@gmail.com";
			User u = new User( "username",  "password",  "email", date, 0);
			ForgotPassword f1 = new ForgotPassword(u, inputEmail);
			String email = f1.getUser().getEmail();
			assertTrue(f1.checkCompare("email"));
			inputEmail = "123@gmail.com";
			assertTrue(f1.checkCompare(inputEmail));
		} catch (Exception e) {
			fail("Not yet implemented");
		}
	}
}
