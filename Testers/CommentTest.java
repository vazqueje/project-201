/*
 * Author: Patrick Jensen | jensenpj@miamioh.edu
 * Filename: CommentTest.java
 * Description: Test file for Comment.java
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommentTest {

	@Test
	void testConstructor() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getcommentid(), 1);
		assertEquals(com.getTitle(), "Comment Title");
		assertEquals(com.getGame(), "Mario");
	}
	
	@Test
	void testGetGame() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getGame(), "Mario");
		
		Comment com1 = new Comment(1, "Comment Title", "Comment Description", "Zelda");
		assertTrue(com1 != null);
		assertEquals(com1.getGame(), "Zelda");
	}
	
	@Test
	void testSetGame() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getGame(), "Mario");
		
		com.setGame("Donkey Kong");
		assertEquals(com.getGame(), "Donkey Kong");
		
		com.setGame("League of Legends");
		assertEquals(com.getGame(), "League of Legends");
	}
	
	@Test
	void testGetCommentId() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getcommentid(), 1);
		
		Comment com1 = new Comment(20, "Comment Title", "Comment Description", "Mario");
		assertEquals(com1.getcommentid(), 20);
	}
	
	@Test
	void testGetTitle() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getTitle(), "Comment Title");
		
		Comment com1 = new Comment(1, "I hate this game!", "Comment Description", "Mario");
		assertTrue(com1 != null);
		assertEquals(com1.getTitle(), "I hate this game!");
	}
	
	@Test
	void testGetDescription() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getDescription(), "Comment Description");
		
		Comment com1 = new Comment(1, "Comment Title", "I really enjoyed this game!", "Mario");
		assertTrue(com1 != null);
		assertEquals(com1.getDescription(), "I really enjoyed this game!");
	}
	
	@Test
	void testSetTitle() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getTitle(), "Comment Title");
		
		com.setTitle("My new Title");
		assertEquals(com.getTitle(), "My new Title");
		
		com.setTitle("My favorite game ever");
		assertEquals(com.getTitle(), "My favorite game ever");
	}
	
	@Test
	void testSetDescription() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.getDescription(), "Comment Description");
		
		com.setDescription("This was a great game");
		assertEquals(com.getDescription(), "This was a great game");
		
		com.setDescription("I didn't like this game");
		assertEquals(com.getDescription(), "I didn't like this game");
	}
	
	@Test
	void testToString() {
		Comment com = new Comment(1, "Comment Title", "Comment Description", "Mario");
		assertTrue(com != null);
		assertEquals(com.toString(), "Title: Comment TitleDescription: Comment Description");
		
		Comment com1 = new Comment(1, "Great Game!", "I enjoyed this game a lot.", "Mario");
		assertTrue(com1 != null);
		assertEquals(com1.toString(), "Title: Great Game!Description: I enjoyed this game a lot.");
	}
}
