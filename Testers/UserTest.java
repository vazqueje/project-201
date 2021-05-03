/*
 * Author: Patrick Jensen | jensenpj@miamioh.edu
 * Filename: UserTest.java
 * Description: JUnit test file for User.java class
 */
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testConstructor() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getUsername(), "uName123");
		assertEquals(u1.getPassword(), "passwordxyz");
		assertEquals(u1.getEmail(), "1234@gmail.com");
		assertEquals(u1.getDob(), new Date(01, 01, 2000));
		assertEquals(u1.getPrivileges(), 0);
	}

	@Test
	void testGetPrivileges() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getPrivileges(), 0);
		
		User u2 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 1);
		assertEquals(u2.getPrivileges(), 1);
		
		User u3 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 2);
		assertEquals(u3.getPrivileges(), 2);
	}
	
	@Test
	void testSetPrivileges() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getPrivileges(), 0);
		
		u1.setPrivileges(1);
		assertEquals(u1.getPrivileges(), 1);
		
		u1.setPrivileges(2);
		assertEquals(u1.getPrivileges(), 2);
	}
	
	@Test
	void testGetUsername() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getUsername(), "uName123");
		
		User u2 = new User("myUsername", "passwordxyz", "1234@gmail.com", d1, 0);
		assertEquals(u2.getUsername(), "myUsername");
	}
	
	@Test
	void testSetUsername() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getUsername(), "uName123");
		u1.setUsername("newUsername");
		assertEquals(u1.getUsername(), "newUsername");
		u1.setUsername("anotherNewName");
		assertEquals(u1.getUsername(), "anotherNewName");
		assertTrue(u1.getUsername() != null);
	}
	
	@Test
	void testGetPassword() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getPassword(), "passwordxyz");
		
		User u2 = new User("uName123", "newPass", "1234@gmail.com", d1, 0);
		assertEquals(u2.getPassword(), "newPass");
	}
	
	@Test
	void testSetPassword() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getPassword(), "passwordxyz");
		
		u1.setPassword("mynewPass");
		assertEquals(u1.getPassword(), "mynewPass");
		
		u1.setPassword("1234ABC");
		assertEquals(u1.getPassword(), "1234ABC");
	}
	
	@Test
	void testGetEmail() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getEmail(), "1234@gmail.com");
		
		User u2 = new User("uName123", "passwordxyz", "newEmail@gmail.com", d1, 0);
		assertTrue(u2 != null);
		assertEquals(u2.getEmail(), "newEmail@gmail.com");
	}
	
	@Test
	void testSetEmail() {
		Date d1 = new Date(01, 01, 2000);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getEmail(), "1234@gmail.com");
		
		u1.setEmail("newMail@gmail.com");
		assertEquals(u1.getEmail(), "newMail@gmail.com");
		
		u1.setEmail("fakeMail@gmail.com");
		assertEquals(u1.getEmail(), "fakeMail@gmail.com");
	}
	
	@Test
	void testGetDob() {
		Date d1 = new Date(100, 0, 23);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getDob(), new Date(100,0,23));
	}
	
	@Test
	void testSetDob() {
		Date d1 = new Date(100, 0, 1);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getDob(), new Date(100, 0, 1));
		
		Date d2 = new Date(99, 0, 20);
		u1.setDob(d2);
		assertEquals(u1.getDob(), new Date(99, 0, 20));		
	}
	
	@Test
	void testGetAge() {
		Date d1 = new Date(100,0,1);
		User u1 = new User("uName123", "passwordxyz", "1234@gmail.com", d1, 0);
		assertTrue(u1 != null);
		assertEquals(u1.getDob(), new Date(100,0,1));
		
		assertEquals(u1.getAge(), java.time.LocalDate.now().getYear() -(1900+ u1.getDob().getYear()));
	}
}
