/*
 * Author: jensenpj@miamioh.edu
 * Filename: GameRequest.java
 * Date: March 23rd, 2021
 */
public class GameRequest {
	
	private String gameName;
	private String description;
	private String userName;
	private int id;
	
	/*
	 * Basic Constructor
	 */
	GameRequest() {
		setGame("");
		setDescription("");
		setUserName("");
	}
	
	/*
	 * Constructor that has a given game title, description, and userName of user submitting the request
	 * @param String game : String that contains the name of the game
	 * @param String description: String that contains the description of the game
	 * @param String userName : String that contains the userName of the user that made the request
	 */
	GameRequest(String game, String description, String userName) {
		setGame(game);
		setDescription(description);
		setUserName(userName);
	}
	
	/*
	 * Method that returns an array containing userName of the user making the request, the name of the game
	 * and the description
	 * @param GameRequest game : takes in a game object
	 * @return String[] : returns an array containing the elements of a request
	 */
	protected String[] getArr(GameRequest game) {
		String[] arr = {game.getUserName(), game.getGameName(), game.getDescription()};
		return arr;
	}
	
	/*
	 * Getter method for name of the game
	 * @return String : Returns name of the game
	 */
	protected String getGameName() {
		return gameName;
	}

	/*
	 * Setter method for the name of the game
	 * @param String gameName : Name of the new title of the game
	 */
	protected void setGame(String gameName) {
		this.gameName = gameName;
	}
	
	/*
	 * Getter method for description
	 * @return String : returns the contents of the description
	 */
	protected String getDescription() {
		return description;
	}

	/*
	 * Setter method for description
	 * @param String description : String containing the new description
	 */
	protected void setDescription(String description) {
		this.description = description;
	}

	/*
	 * Getter method for userName
	 * @return String : returns the userName
	 */
	protected String getUserName() {
		return userName;
	}

	/*
	 * Setter for userName
	 * @param String userName : String containing the updated userName
	 */
	protected void setUserName(String userName) {
		this.userName = userName;
	}
	/*
	 * Getter for ID
	 * @return int : returns the id.
	 */
	public int getId() {
		return id;
	}

	/*
	 * Method that combines the elements of the request into a string 
	 * @return String : String that contains the compiled request 
	 */
	protected String combineRequest() {
		String returnS = "UserName: " + this.getUserName() + "\n";
		returnS += "Game: " + this.getGameName() + "\n";
		returnS += "Description: " + this.getDescription();
		return returnS;
	}
}
