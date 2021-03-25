
public class Comment{
	private final int pid;
	private String title;
	private String desc;
	private String game;

	/*
	 * Basic Constructor
	 */
	Comment(int pid) {
		title = null;
		desc = null;
		this.pid = pid;
	}
	/*
	 * Constructor with given comment title and main body (description)
	 */
	Comment(int pid, String title, String desc){
		this.pid  = pid;
		this.title = title;
		this.desc = desc;
		this.game = game;
	}
	/*
	 * Getter method for the game associated with comment
	 * @return String : String that contains the game name.
	 */
	public String getGame() {
		return game;
	}
	/*
	 * Method that set the game associated with comment
	 * @param String : game title that can be edited.
	 */
	public void setGame(String game) {
		this.game = game;
	}
	/*
	 * Getter method for the current comment title
	 * @return String : String that contains current comment's title.
	 */
	protected int getpid() {
		return this.pid;
	}
	/*
	 * Getter method for the current comment title
	 * @return String : String that contains current comment's title.
	 */
	protected String getTitle() {
		return this.title;
	}
	/*
	 * Getter method for the current comment's main body (Descriptions).
	 * @return String : String that contains current comment's main body (Descriptions).
	 */
	protected String getDescription() {
		return this.desc;
	}
	/*
	 * Method that set current comment's title information. 
	 * @param String : comment title that the user wishes to edit.
	 */
	protected void setTitle(String input) {
		this.title = input;
	}
	/*
	 * Method that set current comment's main body information. 
	 * @param String : comment main body that the user wishes to edit.
	 */
	protected void setDescription(String description) {
		this.title = description;
	}
	/*
	 * Method that returns current comment's information in standard String format
	 * @return String : formatted string with the current Comment's contents.
	 */
	public String toString() {
		String ret = "";
		ret = ret + "Title: " + this.title + "Description: " + this.desc;
		return ret;
	}
	
}
