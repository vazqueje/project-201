import java.sql.*;
public class UserVerify {
	private String username;
	private String password;
	Connection conn = SQLConnection.getConnection();
	
	public UserVerify(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
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
//		if (rs.next() == false) {
//			System.out.println("ResultSet in empty in Java");
//		} else { 
//			do {
//				String data = rs.getString();
//				System.out.println(data);
//			} while (rs.next)
//		}
		
//		if(generatedKeys.getFetchSize() == 0) {
//			return null;
//		}
		generatedKeys.first();
		
		return new User(generatedKeys.getString(1),generatedKeys.getString(2),generatedKeys.getString(3),generatedKeys.getDate(4),generatedKeys.getInt(5));
		
	}
	
}
