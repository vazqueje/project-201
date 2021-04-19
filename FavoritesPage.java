/*
 * Author: jensenpj@miamioh.edu
 * Filename: FavoritesPage.java
 * Date: March 23rd, 2021
 * Description: Favorites Page method that contains a user's favorites list and wish list
 * where they can perform a variety of functions.
 */
import java.util.*;
public class FavoritesPage {
	
	private ArrayList<Entry> favorites;
	private ArrayList<Entry> wishList;
	
	/*
	 * Basic Constructor
	 */
	FavoritesPage() {
		favorites = new ArrayList<Entry>();
		wishList = new ArrayList<Entry>();
	}
	
	FavoritesPage(ArrayList<Entry> favorites, ArrayList<Entry> wishlist) {
        this.favorites = favorites;
        this.wishList = wishList;
    } 
	
	/*
	 * Getter method for the favorite game list
	 * @return ArrayList<String> : List contains the games on the user's favorites list.
	 */
	protected ArrayList<Entry> getGameList() {
		return favorites;
	}
	
	/*
	 * Getter method for the wish list
	 * @return ArrayList<String> : List that contains the games on the user's wish list
	 */
	protected ArrayList<Entry> getWishList() {
		return wishList;
	}
	
	/*
	 * Method that returns a formatted string containing the elements of a list
	 * @param ArrayList<String> : A list of Strings
	 * @return String : formatted string with the contents of the list passed into the method
	 */
	protected String toString(ArrayList<Entry> list) {
		String returnS = "[";
		if(list.size() == 0) {
			return "EMPTY LIST";
		} else {
			for(Entry e : list) {
				returnS += "{";
				returnS += e.toString() + ", ";
				returnS = returnS.substring(0, returnS.length() - 2);
				returnS += "} ";
			}
			returnS += "]";
			return returnS;
		}
	}
	
	/*
	 * Method that adds a game to the user's game list
	 * @param String : game that the user wishes to add
	 */
	protected void addGameList(Entry game) {
		this.getGameList().add(game);
	}
	
	/*
	 * Method that adds a game to the user's wish list
	 * @param String :  game that the user wishes to add
	 */
	protected void addWishList(Entry game) {
		this.getWishList().add(game);
	}
	
	/*
	 * Method that removes a game from the user's favorite game list
	 * @param Game that the user wishes to remove
	 * @return boolean : boolean value that will be true if successful, false if not
	 */
	protected boolean removeGameList(Entry game) {
		if (!this.getGameList().contains(game)) {
			return false;
		}else {
			this.getGameList().remove(game);
			return true;
		}
	}
	
	/*
	 * Method that removes a game from the user's wish list
	 * @param String : Game that the user wishes to remove
	 * @return boolean : boolean value that will be true if successful, false if not
	 */
	protected boolean removeWishList(Entry game) {
		if(!this.getWishList().contains(game)) {
			return false;
		}else {
			this.getWishList().remove(game);
			return true;
		}
	}
	
	/*
	 * Method that clears the favorite game list
	 */
	protected void clearFavorites() {
		this.getGameList().clear();
	}
	
	/*
	 * Method that clears the wish list
	 */
	protected void clearWishlist() {
		this.getWishList().clear();
	}
	
	/*
	 * Method that returns the size of the user's favorite game list
	 * @return int : size of the favorite game list
	 */
	protected int getGameListSize() {
		return this.getGameList().size();
	}
	
	/*
	 * Method that returns the size of the user's wish list
	 * @return int :  size of the wish list
	 */
	protected int getWishListSize() {
		return this.getWishList().size();
	}	
}
