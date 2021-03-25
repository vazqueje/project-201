import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SQLConnection.java is necessary to execute a search
public class Search {
	String userSearch;
	Connection con = SQLConnection.getConnection();
	
	public Search(String userSearch) {
		this.userSearch = userSearch;
	}
	
	public String fetchSearch(String userSearch) {
		Statement stmt = null;
		ResultSet rs = null;
		String result = "";
		try {
			 stmt = con.createStatement();
			 String query = "SELECT * FROM game_catalog WHERE name=\""+userSearch+"\";";
			 rs = stmt.executeQuery(query);
			 while(rs.next()){
				   String name = rs.getString("name");
				   result += name;
				   if(rs.isBeforeFirst()) {
					   result += "\n";
				   }
				   
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
		
	}
	
}
