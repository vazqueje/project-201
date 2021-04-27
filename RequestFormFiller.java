import java.sql.*;

/**
 * @author Raymond Lin
 *
 */
public class RequestFormFiller {
	Connection conn = SQLConnection.getConnection();
	private String name;
	private String description;
	private String username;
	
	/**
	 * @param name The name of the game that they want to request
	 * @param description a description of why they want this game to be added
	 * @param username The user that wants to add the game.
	 */
	public RequestFormFiller(String name, String description, String username) {
		this.name = name;
		this.description = description;
		this.username = username;
	}
	
	/**
	 * @return True if the form was filled successfully and false if it was empty.
	 * @throws SQLException
	 */
	public boolean fillForm() throws SQLException {
		if(name.isEmpty() || username.isEmpty()) {
			return false;
		}
		PreparedStatement p1 = conn.prepareStatement("INSERT INTO request (name,description,username) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
		p1.setString(1, this.name);
		p1.setString(2, this.description);
		p1.setString(3, this.username);
		p1.execute();
		
		return true;
		
	}

}
