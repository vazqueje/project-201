import java.sql.*;

public class RequestFormFiller {
	Connection conn = SQLConnection.getConnection();
	private String name;
	private String description;
	private String username;
	
	public RequestFormFiller(String name, String description, String username) {
		this.name = name;
		this.description = description;
		this.username = username;
	}
	
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
