import java.sql.*;
import java.util.ArrayList;
public class Driver {
	public static void main(String[] args) {
		try {
//			Connection c1 = DriverManager.getConnection("jdbc:mariadb://184.58.34.232:3306/GamersInc","root","pV9KrKZbcM!rx6&G");
			
			Connection c1 = SQLConnection.getConnection();
			
			//adding a user to the user_table
//			User me = new User("ash","123","linr5@miamioh.edu",new java.sql.Date(101,0,23));
//			PreparedStatement yes = c1.prepareStatement("Insert into user_table (username,password,email,dob) values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
//			yes.setString(1,me.getUsername());
//			yes.setString(2, me.getPassword());
//			yes.setString(3, me.getPassword());
//			yes.setDate(4, me.getDob());
//			yes.execute();
			
			//adding comment to comment table.
//			PreparedStatement comment1 = c1.prepareStatement("Insert into comment (title,description,game) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
//			comment1.setString(1,"I love this game!");
//			comment1.setString(2,"I just want to say that Donkey Kong 64 is my favorite childhood game. My father gave it to me before he disappeared to go get some milk. I wonder why he hasn't come home yet.");
//			comment1.setString(3, "Donkey Kong 64");
//			comment1.execute();
			
			//testing out retrieving comments from comment table.
//			PreparedStatement returnComment = c1.prepareStatement("Select * from comment");
//			returnComment.execute();
//			ResultSet generatedKeys = returnComment.getResultSet();
//			generatedKeys.first();
//			System.out.println(generatedKeys.getString(1));
//			System.out.println(generatedKeys.getString(2));
//			System.out.println(generatedKeys.getString(3));
			
			//entering Game_Entry into database.
//			Entry dk64 = new Entry("Donkey Kong 64","Donkey Kong 64 is a 1999 adventure platform game developed by Rare and published by Nintendo for the Nintendo 64","Adventure","Rare",new java.sql.Date(99,10,22),"E",new ArrayList<String>());
//			PreparedStatement donkeyKong64 = c1.prepareStatement("Insert into Game_Catalog(name,description,genre,developer,publishDate,esrbRating) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//			donkeyKong64.setString(1, dk64.getName());
//			donkeyKong64.setString(2, dk64.getDescription());
//			donkeyKong64.setString(3, dk64.getGenre());
//			donkeyKong64.setString(4, dk64.getDeveloper());
//			donkeyKong64.setDate(5, dk64.getPublishDate());
//			donkeyKong64.setString(6, dk64.getEsrbRating());
//			donkeyKong64.execute();
			
			Entry ssbu = new Entry("Super Smash Bros 2","Super Smash Bros. Ultimate is a 2018 crossover fighting game","Fighting","Sora Ltd.",new java.sql.Date(118,11,7),"",new ArrayList<String>());
			PreparedStatement ssbuEntry = c1.prepareStatement("Insert into Game_Catalog(name,description,genre,developer,publishDate,esrbRating) values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			ssbuEntry.setString(1, ssbu.getName());
			ssbuEntry.setString(2, ssbu.getDescription());
			ssbuEntry.setString(3, ssbu.getGenre());
			ssbuEntry.setString(4, ssbu.getDeveloper());
			ssbuEntry.setDate(5, ssbu.getPublishDate());
			ssbuEntry.setString(6, ssbu.getEsrbRating());
			ssbuEntry.execute();
			
			//Building an Entry object from the Game_Catalog.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
