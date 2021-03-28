
import java.util.ArrayList;

public class CommentSection {
	/*Starts from 0*/
	private int maxpid;
	private ArrayList<Comment> all;
	/*
	 * Basic Constructor
	 */
	CommentSection() {
		maxpid = 0;
		all = new ArrayList<Comment>();
	}
	/*
	 * Getter method for the current comment section's total comments.
	 * @return int : Current section's comment maxpid.
	 */
	protected int getmaxpid() {
		return this.maxpid;
	}
	/*
	 * Method that adds comment to current comment section. 
	 * @param String : comment title.
	 * @param String : comment main body.
	 */
	protected void addcomment(String title, String desc) {
		Comment c = new Comment(maxpid+1, title, desc);
		all.add(c);
		maxpid +=1;
	}
	/*
	 * Method that adds comment to current comment section. 
	 * @param Comment : created comment.
	 */
	protected void addcomment(Comment e) {
		all.add(e);
		maxpid +=1;
	}
	/*
	 * Method that removes comment from current comment section. 
	 * @param int : Comment's pid.
	 */
	protected void deletecomment(int pid) {
		all.set(pid, null);
	}
	/*
	 * Method that edits comment in current comment section. 
	 * @param int : Comment's pid.
	 * @param String : Comment's title.
	 * @param String : Comment's main body.
	 */
	protected void editcomment(int pid, String title, String desc) {
		all.get(pid).setTitle(title);
		all.get(pid).setDescription(desc);;
	}
	/*
	 * Method that returns all of current comment section's comments in standard String format
	 * @return String : formatted string with all of current Comment section's contents.
	 */
	public String toString() {
		String ret = "";
		if(all.size() == 0) {
			return "EMPTY LIST";
		} else {
			for(Comment s : all) {
				ret += s.toString() + ", "; 
			}
			ret = ret.substring(0, ret.length() - 2);
			return ret;
		}
	}
}
