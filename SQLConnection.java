import java.sql.*;

public final class SQLConnection {
	private static Connection c1 = null;
	private static final String CONNECTION_URL = "jdbc:mariadb://184.58.34.232:3306/GamersInc";
	private static final String CONNECTION_USER = "root";
	private static final String CONNECTION_PASSWORD = "pV9KrKZbcM!rx6&G";
	
	private SQLConnection() {
		
	}
	
	public static Connection getConnection() {
		if(c1 != null) {
			return c1;
		}
		
		try {
			c1 = DriverManager.getConnection(CONNECTION_URL, CONNECTION_USER, CONNECTION_PASSWORD);
			return c1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}