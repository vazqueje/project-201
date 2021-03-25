import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SQLConnection.java is necessary to execute a search
//Usage example:
//Search newSearch = new Search("Donkey Kong 64");
//newSearch.fetchSearch(newSearch.userSearch);
//^^will cleanup to eliminate redundancy
public class Search {
	String userSearch; //The string that the user will enter to find a game, only works for the exact name of the game right now
	Connection con = SQLConnection.getConnection(); // The connection to the game_catalog database
	
	
	public Search(String userSearch) {
		this.userSearch = userSearch;
	}
	
	/**
	* Uses the user's search demands to query the database and returns all results as a string.
	**/
	public String fetchSearch(String userSearch) {
		Statement stmt = null;
		ResultSet rs = null;
		String result = "";
		try {
			 stmt = con.createStatement();
			 //create SQL query
			 String query = "SELECT * FROM game_catalog WHERE name=\""+userSearch+"\";";
			 //execute the SQL query
			 rs = stmt.executeQuery(query);
			 //iterates through each line of the result table
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
