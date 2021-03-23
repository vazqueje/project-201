/*
 * Author: jensenpj@miamioh.edu
 * Filename: FavoritesPage.java
 * Date: March 23rd, 2021
 * Description: Favorites Page method that contains a user's favorites list and wish list
 * where they can perform a variety of functions.
 */
import java.util.*;
public class FavoritesPage {
	
	private ArrayList<String> favorites;
	private ArrayList<String> wishList;
	
	/*
	 * Basic Constructor
	 */
	FavoritesPage() {
		favorites = new ArrayList<String>();
		wishList = new ArrayList<String>();
	}
	
	/*
	 * Getter method for the favorite game list
	 * @return ArrayList<String> : List contains the games on the user's favorites list.
	 */
	protected ArrayList<String> getGameList() {
		return favorites;
	}
	
	/*
	 * Getter method for the wish list
	 * @return ArrayList<String> : List that contains the games on the user's wish list
	 */
	protected ArrayList<String> getWishList() {
		return wishList;
	}
	
	/*
	 * Method that returns a formatted string containing the elements of a list
	 * @param ArrayList<String> : A list of Strings
	 * @return String : formatted string with the contents of the list passed into the method
	 */
	protected String toString(ArrayList<String> list) {
		String returnS = "[";
		if(list.size() == 0) {
			return "EMPTY LIST";
		} else {
			for(String s : list) {
				returnS += s + ", "; 
			}
			returnS = returnS.substring(0, returnS.length() - 2);
			returnS += "]";
			return returnS;
		}
	}
	
	/*
	 * Method that adds a game to the user's game list
	 * @param String : game that the user wishes to add
	 */
	protected void addGameList(String game) {
		this.getGameList().add(game);
	}
	
	/*
	 * Method that adds a game to the user's wish list
	 * @param String :  game that the user wishes to add
	 */
	protected void addWishList(String game) {
		this.getWishList().add(game);
	}
	
	/*
	 * Method that removes a game from the user's favorite game list
	 * @param Game that the user wishes to remove
	 * @return boolean : boolean value that will be true if successful, false if not
	 */
	protected boolean removeGameList(String game) {
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
	protected boolean removeWishList(String game) {
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
