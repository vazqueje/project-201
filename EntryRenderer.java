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
				 img = ImageIO.read(rs.getBinaryStream(7));
				 e = new Entry(rs.getString("name"),rs.getString("description"),rs.getString("genre"), rs.getString("developer"), rs.getDate("publishDate"), rs.getString("esrbRating"),null,img);
				 System.out.println(e.toString());
				 list.add(e);
				 
			 }
			 
			 
    	}catch(Exception e) {
    		
    	}
    	
    	return list;
		 
     
    }
     
}