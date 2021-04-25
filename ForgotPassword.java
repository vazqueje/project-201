import java.sql.*;

/**
 * @author Raymond Lin
 *
 */
public class ForgotPassword {
	private String username;
	Connection conn = SQLConnection.getConnection();

	
	/**
	 * @param username takes in the username of the user.
	 */
	public ForgotPassword(String username) {
		this.username = username;
	}

	/**
	 * @return The username that was inputted into the constructor
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username sets the username for forgotten password
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	public User returnUser() {
		try {
			//if someone tries to find the guest account's information it will just return null
			if(this.getUsername().equals("Guest")) {
				return null;
			}
			PreparedStatement p1 = conn.prepareStatement("Select * from user_table WHERE username=?", Statement.RETURN_GENERATED_KEYS);
			p1.setString(1, this.getUsername());
			p1.execute();
			ResultSet generatedKeys = p1.getResultSet();
			if (!generatedKeys.next()) {
				return null;
			}
			generatedKeys.beforeFirst();
			generatedKeys.first();
			return new User(generatedKeys.getString(1),generatedKeys.getString(2),generatedKeys.getString(3),generatedKeys.getDate(4),generatedKeys.getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	

}
