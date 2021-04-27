import java.sql.*;
import java.util.ArrayList;
public class FavoriteListSQL {
	Connection conn = SQLConnection.getConnection();
	private Entry entry;
	private User user;
	
	//constructor to use if you want to add or remove from favorites
	public FavoriteListSQL(Entry entry, User user) {
		this.entry = entry;
		this.user = user;
	}
	
	//constructor to use if you want to just pull up a list of favorites
	public FavoriteListSQL(User user) {
		this.entry = null;
		this.user = user;
	}
	
	//specific add method if the table doesn't exist
	public boolean addFavorite() throws SQLException {
		//check if the user's favorite table is in the database.
		String userFormatted = user.getUsername() +"_favorite";
		PreparedStatement p1 = conn.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = N?", Statement.RETURN_GENERATED_KEYS);
		p1.setString(1, userFormatted);
		p1.execute();
		ResultSet generatedKeys = p1.getResultSet();
		//if the table doesn't exist it will create a table and then add into it
		if(!generatedKeys.next()) {
			//creates the table
			PreparedStatement createTable = conn.prepareStatement("Create Table "+ userFormatted+"(name varchar(255) NOT NULL, description text, genre varchar(255), developer varchar(255), publishDate date, esrbRating varchar(255), Primary Key(name))", Statement.RETURN_GENERATED_KEYS);
			createTable.execute();
			
			//adds into it
			return add(userFormatted);
		} else {
			//adds into it
			return add(userFormatted);
		}
	}
	
	//the general add method
	private boolean add(String userFormatted) {
		PreparedStatement add;
		try {
			add = conn.prepareStatement("Insert INTO "+ userFormatted+"(name,description,genre,developer,publishDate,esrbRating) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			add.setString(1, entry.getName());
			add.setString(2, entry.getDescription());
			add.setString(3, entry.getGenre());
			add.setString(4, entry.getDeveloper());
			add.setDate(5, entry.getPublishDate());
			add.setString(6, entry.getEsrbRating());
			add.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	//removes from the favorite list
	public boolean removeFavorite() {
		String userFormatted = user.getUsername() +"_favorite";
		PreparedStatement remove;
		try {
			remove = conn.prepareStatement("Delete From "+userFormatted+" WHERE name=?", Statement.RETURN_GENERATED_KEYS);
			remove.setString(1, entry.getName());
			remove.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	//returns an FavoritesPage of all the favorites from the user_favorites
	public FavoritesPage displayFavorites() {
		String userFormatted = user.getUsername()+"_favorite";

		try {
			ArrayList<Entry> results = new ArrayList<Entry>();
			PreparedStatement query = conn.prepareStatement("Select * from "+userFormatted, Statement.RETURN_GENERATED_KEYS);
			query.execute();
			ResultSet rs = query.getResultSet();
			 //if there is no next row, tell the user there were no matches
			 if (rs.next() == false) {
			        return null;
			      } else {
			 //else, add rows in result set to an ArrayList of type Entry
			        do {
			          results.add(new Entry(rs.getString("name"), rs.getString("description"), rs.getString("genre"), rs.getString("developer"), rs.getDate("publishDate"), rs.getString("esrbRating"), null,null));
			        } while (rs.next());
			      }
			 return new FavoritesPage(results,new ArrayList<Entry>());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
	}
}
