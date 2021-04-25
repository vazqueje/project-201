import java.sql.*;
public class BanSQL {
private String username;
Connection conn = SQLConnection.getConnection();
/**
 * @param username the username provided to ban the user
 */
public BanSQL(String username) {
	this.username = username;
}

/**
 * @return true if the user is successfully banned and false if not.
 */
public boolean ban() {
	try {
		//gets the username from the user_table
		PreparedStatement p1 = conn.prepareStatement("Select * from user_table where username=?",Statement.RETURN_GENERATED_KEYS);
		p1.setString(1,this.username);
		p1.execute();
		ResultSet generatedKeys = p1.getResultSet();
		if (!generatedKeys.next()) {
			return false;
		}
		generatedKeys.beforeFirst();
		generatedKeys.first();

		//sets the username into banned_table
		PreparedStatement p2 = conn.prepareStatement("INSERT INTO banned_table(username,password,email,dob,privileges) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		p2.setString(1, generatedKeys.getString(1));
		p2.setString(2, generatedKeys.getString(2));
		p2.setString(3, generatedKeys.getString(3));
		p2.setDate(4, generatedKeys.getDate(4));
		p2.setInt(5, generatedKeys.getInt(5));
		p2.execute();
		
		//Drop them from the user_table
		PreparedStatement p3 = conn.prepareStatement("Delete from user_table where username=?", Statement.RETURN_GENERATED_KEYS);
		p3.setString(1, this.username);
		p3.execute();
		
	} catch (SQLException e) {
		return false;
	}
	return true;
}
}
