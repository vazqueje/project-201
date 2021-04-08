import static org.junit.Assert.*;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

public class FavoritesPageTester {
	Date d = new Date(1999,11,22);
	Date d2 = new Date(2018,12,07);
	Entry DK64 = new Entry("Donkey Kong 64", "Desc","Adventure","Rare",d,"E", null);
	Entry SSBU = new Entry("Super Smash Bros", "Desc","Fighting","Sora Ltd.",d2,"T",null);
	ArrayList<Entry> fl = new ArrayList<Entry>();
	ArrayList<Entry> wl = new ArrayList<Entry>();
	
	
	
	@Test
	public void testFavoritesPage() {
		FavoritesPage fp = new FavoritesPage();
		assertEquals(fp.getWishListSize(), 0);
		assertEquals(fp.getGameListSize(), 0);
	}
	
	/**
	 * Error caught: Typo in FavoritesPage.java constructor
	 * "Wishlist" vs "WishList"
	 */
	@Test
	public void testFavoritesPageArrayListOfEntryArrayListOfEntry() {
		
		fl.add(SSBU);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertEquals(1,fp2.getGameListSize());
		assertEquals(1,fp2.getWishListSize());
	}

	@Test
	public void testGetGameList() {
		//Case 1: GameList is not empty
		fl.add(DK64);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertTrue(fp2.getGameList().equals(fl));
		
		//Case 2: GameList is empty 
		FavoritesPage fp = new FavoritesPage();
		assertEquals(fp.getGameList().size(),0);
	}

	@Test
	public void testGetWishList() {
		//Case 1: Wish list is not empty
		fl.add(DK64);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertTrue(fp2.getWishList().equals(wl));
		assertEquals(fp2.getWishListSize(),1);
		//Case 2: Wish list is empty
		FavoritesPage fp = new FavoritesPage();
		assertEquals(fp.getWishList().size(),0);
		
	}
	
	/**
	 * Date(int, int, int) deprecated??
	 * 
	 */
	@Test
	public void testToStringArrayListOfEntry() {
		//CASE 1: The ArrayList is not empty
		fl.add(DK64);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		
		String expected = "[Donkey Kong 64\nDesc\nAdventure\nRare\n3899-12-22\nE]";
		assertEquals(fl.toString(),expected);
		
		//CASE 2: The ArrayList is empty
		ArrayList<Entry> empty = new ArrayList<Entry>();
		FavoritesPage fp3 = new FavoritesPage(empty,empty);
		assertEquals(empty.size(),0);
		String emptyString = "EMPTY LIST";
		assertEquals(fp3.toString(empty),emptyString);
		
	}

	@Test
	public void testAddGameList() {
		FavoritesPage fp = new FavoritesPage();
		
		assertEquals(fp.getGameListSize(), 0);
		fp.addGameList(DK64);
		assertEquals(fp.getGameListSize(), 1);
	}

	@Test
	public void testAddWishList() {
		FavoritesPage fp = new FavoritesPage();
		
		assertEquals(fp.getWishListSize(), 0);
		fp.addWishList(SSBU);
		assertEquals(fp.getWishListSize(), 1);
	}

	@Test
	public void testRemoveGameList() {
		fl.add(DK64);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertEquals(fp2.getGameListSize(),1);
		assertTrue(fp2.removeGameList(DK64));
		assertEquals(fp2.getGameListSize(),0);
		
		//CASE 2: game does not exist in list
		assertFalse(fp2.removeGameList(SSBU));
	}

	@Test
	public void testRemoveWishList() {
		//CASE 1: game exists in list
		fl.add(DK64);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertEquals(fp2.getWishListSize(),1);

		assertTrue(fp2.removeWishList(SSBU));
		assertEquals(fp2.getWishListSize(),0);
		
		//CASE 2: game does not exist in list
		assertFalse(fp2.removeWishList(DK64));
		
	}

	@Test
	public void testClearFavorites() {
		fl.add(DK64);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertEquals(fp2.getGameListSize(),1);
		fp2.clearFavorites();
		assertEquals(fp2.getGameListSize(),0);
	}

	@Test
	public void testClearWishlist() {
		fl.add(DK64);
		wl.add(SSBU);
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertEquals(fp2.getWishListSize(),1);
		fp2.clearWishlist();
		assertEquals(fp2.getWishListSize(),0);
	}

	@Test
	public void testGetGameListSize() {
		fl.add(DK64);
		
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertEquals(fp2.getGameListSize(),1);
		fl.add(SSBU);
		assertEquals(fp2.getGameListSize(),2);
		
	}

	@Test
	public void testGetWishListSize() {
		wl.add(DK64);
		
		FavoritesPage fp2 = new FavoritesPage(fl,wl);
		assertEquals(fp2.getWishListSize(),1);
		wl.add(SSBU);
		assertEquals(fp2.getWishListSize(),2);
	}

}
