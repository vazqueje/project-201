import java.awt.Component;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class EntryRenderer {
	Statement stmt;
	ResultSet rs;
	User user;
	int esrb=0;
	
	public EntryRenderer() {
		
	}
	public EntryRenderer(User user) {
		this.user = user;
		int age = user.getAge();
		if (age >= 18) esrb = 4;
		else if (age >=17) esrb = 3;
		else if (age >= 13) esrb = 2;
		else if (age >= 10) esrb = 1;
		if (user.getUsername().equals("Guest")) esrb = 1;
	}
    
    public ArrayList<Entry> fillTable() {
    	
    	ArrayList<Entry> list = new ArrayList<Entry>();
    	try {
			 //create query statement
			Connection con = SQLConnection.getConnection();
			 stmt = con.createStatement();
			 String query = "SELECT name, description, genre, developer, publishDate, esrbRating, cover FROM game_catalog";
			 //execute query
			 rs = stmt.executeQuery(query);
			 Entry e;
			 BufferedImage img = null;
			 while(rs.next()) {
				 if(esrb >= ESRBtoInt(rs.getString("esrbRating"))) {
				 img = ImageIO.read(rs.getBinaryStream(7));
				 e = new Entry(rs.getString("name"),rs.getString("description"),rs.getString("genre"), rs.getString("developer"), rs.getDate("publishDate"), rs.getString("esrbRating"),null,img);
				 System.out.println(e.toString());
				 list.add(e);
				 }
			 }
			 
			 
    	}catch(Exception e) {
    		
    	}
    	
    	return list;
		 
     
    }
    private int ESRBtoInt(String rating) {
		int ret = 0;
		if (rating.equalsIgnoreCase("RP")) ret = 4;
		else if (rating.equalsIgnoreCase("A")) ret = 4;
		else if (rating.equalsIgnoreCase("M")) ret = 3;
		else if (rating.equalsIgnoreCase("T")) ret = 2;
		else if (rating.equalsIgnoreCase("E10")) ret = 1;
		return ret;
	}
     
}