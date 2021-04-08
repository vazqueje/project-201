import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameRequestTest {

	@Test
	void testConstructor() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");
		assertFalse(r == null);
		assertFalse(r1 == null);
	}

	@Test
	void testGetArr() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");
		String[] sArr = r.getArr(r);
		assertEquals(sArr[0], "");
		assertEquals(sArr[1], "");
		assertEquals(sArr[2], "");
		String[] sArr1 = r1.getArr(r1);
		assertEquals(sArr1[0], "donkey123");
		assertEquals(sArr1[1], "Donkey Kong");
		assertEquals(sArr1[2], "Great game");
	}

	@Test
	void testGetGameName() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");

		assertFalse(r.getGameName() == null);
		assertFalse(r1.getGameName() == null);

		assertEquals(r.getGameName(), "");
		assertEquals(r1.getGameName(), "Donkey Kong");
	}

	@Test
	void testSetGame() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");

		assertEquals(r.getGameName(), "");
		assertEquals(r1.getGameName(), "Donkey Kong");

		r.setGame("Mario 64");
		r1.setGame("Star Wars Battlefront");

		assertEquals(r.getGameName(), "Mario 64");
		assertEquals(r1.getGameName(), "Star Wars Battlefront");
	}

	@Test
	void testGetDescription() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");

		assertEquals(r.getDescription(), "");
		assertEquals(r1.getDescription(), "Great game");
	}

	@Test
	void testSetDescription() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");

		r.setDescription("My favorite game");
		r1.setDescription("I love the monkey");

		assertEquals(r.getDescription(), "My favorite game");
		assertEquals(r1.getDescription(), "I love the monkey");
	}
	
	@Test
	void testGetUserName() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");
		
		assertEquals(r.getUserName(), "");
		assertEquals(r1.getUserName(), "donkey123");
	}
	
	@Test
	void testSetUserName() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");
		
		r.setUserName("gamer49");
		r1.setUserName("user123456");
		
		assertEquals(r.getUserName(), "gamer49");
		assertEquals(r1.getUserName(), "user123456");
	}
	
	@Test
	void testCombineRequest() {
		GameRequest r = new GameRequest();
		GameRequest r1 = new GameRequest("Donkey Kong", "Great game", "donkey123");
		
		assertEquals(r.combineRequest(), "UserName: \nGame: \nDescription: ");
		assertEquals(r1.combineRequest(), "UserName: donkey123\nGame: Donkey Kong\nDescription: Great game");
	}
}
