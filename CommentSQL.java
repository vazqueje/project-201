import java.sql.*;
import java.util.ArrayList;
public class CommentSQL {
	private Entry entry;
	Connection conn = SQLConnection.getConnection();
	public CommentSQL(Entry e) {
		this.entry = e;
	}
	
	public CommentSection getCommentSection() {
		PreparedStatement p1;
		try {
			CommentSection commentList = new CommentSection();
			p1 = conn.prepareStatement("Select * from comment where game=?", Statement.RETURN_GENERATED_KEYS);
			p1.setString(1, entry.getName());
			p1.execute();
			ResultSet rs = p1.getResultSet();
			 if (rs.next() == false) {
			        return null;
			      } else {
			        do {
			         commentList.addcomment(new Comment(rs.getInt("ID"),rs.getString("title"),rs.getString("description"),rs.getString("game")));
			        } while (rs.next());
			      }
			 return commentList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public CommentSection addComment(String title, String description, String game) throws SQLException {
		PreparedStatement query = conn.prepareStatement("INSERT INTO comment (title,description,game) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
		query.setString(1, title);
		query.setString(2, description);
		query.setString(3, game);
		query.execute();
		return getCommentSection();
		
	}
	
	public CommentSection removeComment(int id) throws SQLException {
		PreparedStatement query = conn.prepareStatement("Delete from comment where id=?", Statement.RETURN_GENERATED_KEYS);
		query.setInt(1, id);
		query.execute();
		return getCommentSection();
	}
	
	
}
