import java.sql.Date;

public class User {
	private String username;
	private String password;
	private String email;
	private Date dob;
	private int privileges;
	
	/**
	 * User Constructor creates a user object which stores a "users" information for passing and holding the information
	 * from the database and the actual software.
	 * @param username username object is a string object that stores the user's username
	 * @param password password object is a string object that stores the user's password
	 * @param email email object is a string object that stores the user's email address
	 * @param dob dob object is a date objec that stores the user's date of birth
	 * @param privileges priviledges is an integer object that is used for storing a users level of access on the software.
	 */
	public User(String username, String password, String email, Date dob, int privileges) {
		this.username = username;
		this.password =password;
		this.email =email;
		this.dob= dob;
		this.privileges = privileges;

	}
	/**
	 * Getter method for User's privileges
	 * @return privileges
	 */
	public int getPrivileges() {
		return privileges;
	}
	/**
	 * Setter method for User's privileges with inputed privileges
	 * @param privileges new privileges object for user
	 */
	public void setPrivileges(int privileges) {
		this.privileges = privileges;
	}
	/**
	 * Getter method for User's username
	 * @return username of user
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Setter method for User's username
	 * @param username new username of user
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Getter Method for user's password
	 * @return Users password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Setter Method for user's password
	 * @param password new user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Getter method for user's email address
	 * @return User's email address
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter method for user's email address
	 * @param email new Email Address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Getter method for user's date of birth object
	 * @return User's dat for date of birth
	 */
	public Date getDob() {
		return dob;
	}
	/**
	 * Setter method for user's date of birth
	 * @param dob new date of birth object
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}
	/**
	 * Method to calculate current age of user from the Users date of birth
	 * @return The users current age in a date object
	 */
	public int getAge() {
		return (java.time.LocalDate.now().getYear() - (1900+this.getDob().getYear()));
	}
	
}
