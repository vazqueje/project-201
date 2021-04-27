/*
 * Author: Patrick Jensen | jensenpj@miamioh.edu
 * Filename: EntryTest.java
 * Description: JUnit test for Entry.java
 */
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

class EntryTest {

	@Test
	void testConstructor() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getName(), "Mario");
		assertEquals(e.getDescription(), "Mario Brothers!");
		assertEquals(e.getGenre(), "platformer");
		assertEquals(e.getDeveloper(), "Nintendo");
		assertEquals(e.getPublishDate(), d);
		assertEquals(e.getEsrbRating(), "E");
		assertEquals(e.getCommentList(), commentlist);
	}
	
	@Test
	void testGetName() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getName(), "Mario");
		
		Entry e1 = new Entry("Super Mario Brothers", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e1.getName(), "Super Mario Brothers");
	}
	
	@Test
	void testSetName() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getName(), "Mario");
		
		e.setName("Super Mario Brothers");
		assertEquals(e.getName(), "Super Mario Brothers");
		
		e.setName("Legend of Zelda");
		assertEquals(e.getName(), "Legend of Zelda");
	}
	
	@Test
	void testGetDescription() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getDescription(), "Mario Brothers!");
		
		Entry e1 = new Entry("Mario", "Great Platformer", "platformer", "Nintendo", d, "E", commentlist);
		assertEquals(e1.getDescription(), "Great Platformer");
	}
	
	@Test
	void testSetDescription() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getDescription(), "Mario Brothers!");
		
		e.setDescription("Ahead of its time!");
		assertEquals(e.getDescription(), "Ahead of its time!");
		
		e.setDescription("One of the best!");
		assertEquals(e.getDescription(), "One of the best!");
	}
	
	@Test
	void testGetGenre() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getGenre(), "platformer");
		
		Entry e1 = new Entry("Mario", "Mario Brothers!", "Action", "Nintendo", d, "E", commentlist);
		assertTrue(e1 != null);
		assertEquals(e1.getGenre(), "Action");
	}
	
	@Test
	void testSetGenre() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getGenre(), "platformer");
		
		e.setGenre("Action");
		assertEquals(e.getGenre(), "Action");
		
		e.setGenre("RPG");
		assertEquals(e.getGenre(), "RPG");
	}
	
	@Test
	void testGetDeveloper() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getDeveloper(), "Nintendo");
		
		Entry e1 = new Entry("Mario", "Mario Brothers!", "platformer", "EA", d, "E", commentlist);
		assertEquals(e1.getDeveloper(), "EA");
	}
	
	@Test
	void testSetDeveloper() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getDeveloper(), "Nintendo");
		
		e.setDeveloper("Riot Games");
		assertEquals(e.getDeveloper(), "Riot Games");
		
		e.setDeveloper("Valve");
		assertEquals(e.getDeveloper(), "Valve");
	}
	
	@Test
	void testGetPublishDate() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getPublishDate(), d);
		
		Date d1 = new Date(4, 27, 2021);
		Entry e1 = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d1, "E", commentlist);
		assertTrue(e1 != null);
		assertEquals(e1.getPublishDate(), d1);
	}
	
	@Test
	void testSetPublishDate() {
		Date d = new Date(4, 27, 2021);
		Date d1 = new Date(9, 25, 1999);
		Date d2 = new Date(5, 01, 2010);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getPublishDate(), d);

		e.setPublishDate(d1);
		assertEquals(e.getPublishDate(), d1);
		
		e.setPublishDate(d2);;
		assertEquals(e.getPublishDate(), d2);
	}
	
	@Test
	void testGetEsrbRating() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getEsrbRating(), "E");
		
		Entry e1 = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "T", commentlist);
		assertTrue(e1 != null);
		assertEquals(e1.getEsrbRating(), "T");
	}
	
	@Test
	void testSetEsrbRating() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getEsrbRating(), "E");
		
		e.setEsrbRating("E10+");
		assertEquals(e.getEsrbRating(), "E10+");
		
		e.setEsrbRating("M");
		assertEquals(e.getEsrbRating(), "M");
	}
	
	@Test
	void testGetCommentList() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getCommentList(), commentlist);
		
		CommentSection cs = new CommentSection();
		Entry e1 = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", cs);
		assertTrue(e1 != null);
		assertEquals(e1.getCommentList(), cs);
	}
	
	@Test
	void testSetCommentList() {
		Date d = new Date(4, 27, 2021);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.getCommentList(), commentlist);
		
		CommentSection cs = new CommentSection();
		e.setCommentList(cs);
		assertEquals(e.getCommentList(), cs);
	}
	
	@Test
	void testToString() {
		Date d = new Date(100, 5, 12);
		CommentSection commentlist = new CommentSection();
		Entry e = new Entry("Mario", "Mario Brothers!", "platformer", "Nintendo", d, "E", commentlist);
		assertTrue(e != null);
		assertEquals(e.toString(), "Mario\nMario Brothers!\nplatformer\nNintendo\n2000-06-12\nE");
	}
}
