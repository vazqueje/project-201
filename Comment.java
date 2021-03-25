package a201;


public class Comment{
	private final int pid;
	private String title;
	private String desc;

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
