import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//SQLConnection.java is necessary to execute a search
public class Search {
	String userSearch;
	Connection con = SQLConnection.getConnection();
	ArrayList<Entry> results = new ArrayList<Entry>();
	
	public Search(String userSearch) {
		this.userSearch = userSearch;
	}
	
	/**
	 * fetchSearch: Connects to the database and executes a user prompted query.
	 * @param userSearch - the string the user puts in the search bar
	 * @return a result set as array list of Entries 
	 * @throws IOException 
	 */
	public ArrayList<Entry> fetchSearch(String userSearch) {
		Statement stmt = null;
		ResultSet rs = null;
		BufferedImage img = null;
		try {
			 //create query statement
			 stmt = con.createStatement();
			 String query = "SELECT * FROM game_catalog WHERE name LIKE \"%"+userSearch+"%\";";
			 //execute query
			 rs = stmt.executeQuery(query);
			 
			 //if there is no next row, tell the user there were no matches
			 if (rs.next() == false) {
			        return null;
			      } else {
			 //else, add rows in result set to an ArrayList of type Entry
			        do {
			          img = ImageIO.read(rs.getBinaryStream(7));
			          results.add(new Entry(rs.getString("name"), rs.getString("description"), rs.getString("genre"), rs.getString("developer"), rs.getDate("publishDate"), rs.getString("esrbRating"), null,img));
			        } while (rs.next());
			      }
			 
			 
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
		
		
	}
	
}
