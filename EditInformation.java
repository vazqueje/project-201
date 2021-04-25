import java.sql.*;
/**
 * @author Raymond Lin
 *
 */
public class EditInformation {
	private User username;
	Connection conn = SQLConnection.getConnection();
	
	/**
	 * @param username the user that needs their information edited
	 */
	public EditInformation(User username) {
		this.username = username;
	}
	
	/**
	 * @param newPassword the new password that is going to replace the old one.
	 * @return true if the password was changed successfully and false if not.
	 */
	public boolean editPassword(String newPassword) {
		try {
			PreparedStatement p1 = conn.prepareStatement("UPDATE user_table SET password=? WHERE username=?", Statement.RETURN_GENERATED_KEYS);
			p1.setString(1,newPassword);
			p1.setString(2, this.username.getUsername());
			p1.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	/**
	 * @param newEmail the new email that is going to replace the old one.
	 * @return true if the email was changed successfully and false if it was not.
	 */
	public boolean editEmail(String newEmail) {
		try {
			PreparedStatement p1 = conn.prepareStatement("UPDATE user_table SET email=? WHERE username=?", Statement.RETURN_GENERATED_KEYS);
			p1.setString(1,newEmail);
			p1.setString(2, this.username.getUsername());
			p1.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}

}
