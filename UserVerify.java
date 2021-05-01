import java.sql.*;
/**
 * @author Raymond Lin
 *
 */
public class UserVerify {
	private String username;
	private String password;
	private String email;
	private Date dob;
	Connection conn = SQLConnection.getConnection();
	
	/**
	 * Use this constructor for getUser method
	 * @param username the username of the person trying to login
	 * @param password the password of the person trying to login
	 */
	public UserVerify(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Use this constructor for createAccount method
	 * @param username the username of the person trying to create an account
	 * @param password the password of the person trying to create an account
	 * @param email the email of the person trying to create an account
	 * @param dob the date of birth of the person trying to create an account
	 */
	public UserVerify(String username, String password, String email, Date dob ) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return gets the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return if the user is found it will return the user's account if not it will return a null.
	 * @throws SQLException 
	 */
	public User getUser() throws SQLException {
		PreparedStatement p1 = conn.prepareStatement("Select * From user_table WHERE username=? AND password=?",Statement.RETURN_GENERATED_KEYS);
		p1.setString(1, this.getUsername());
		p1.setString(2, this.getPassword());
		p1.execute();
		ResultSet generatedKeys = p1.getResultSet();
		if (!generatedKeys.next()) {
			return null;
		}
		generatedKeys.beforeFirst();
		
		generatedKeys.first();
		
		return new User(generatedKeys.getString(1),generatedKeys.getString(2),generatedKeys.getString(3),generatedKeys.getDate(4),generatedKeys.getInt(5));
		
	}
	
	/**
	 * @return true if the account was added into the database and false if the account was unable to be added.
	 */
	public boolean createAccount() {
		try {
			PreparedStatement p3 = conn.prepareStatement("Select * from banned_table where username=?", Statement.RETURN_GENERATED_KEYS);
			p3.setString(1, this.username);
			p3.execute();
			ResultSet rs = p3.getResultSet();
			if(rs.first()) {
				return false;
			}
		} catch (SQLException e) {
			
		}
		try {
			PreparedStatement p2 = conn.prepareStatement("Insert INTO user_table(username, password, email, dob, privileges) VALUES (?,?,?,?,0)", Statement.RETURN_GENERATED_KEYS);
			p2.setString(1, this.username);
			p2.setString(2, this.password);
			p2.setString(3, this.email);
			p2.setDate(4, this.dob);
			p2.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	
	
}
