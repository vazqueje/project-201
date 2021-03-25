import java.sql.*;
import java.util.ArrayList;
public class Entry {
private String name;
private String description;
private String genre;
private String developer;
private Date publishDate;
private String esrbRating;
private ArrayList<String> commentList;

public Entry(String name, String description, String genre, String developer, Date publishDate, String esrbRating, ArrayList<String> commentList) {
	this.name = name;
	this.description = description;
	this.genre = genre;
	this.developer = developer;
	this.publishDate = publishDate;
	this.esrbRating = esrbRating;
	this.commentList = commentList;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;
}

public String getDeveloper() {
	return developer;
}

public void setDeveloper(String developer) {
	this.developer = developer;
}

public Date getPublishDate() {
	return publishDate;
}

public void setPublishDate(Date publishDate) {
	this.publishDate = publishDate;
}

public String getEsrbRating() {
	return esrbRating;
}

public void setEsrbRating(String esrbRating) {
	this.esrbRating = esrbRating;
}

public ArrayList<String> getCommentList() {
	return commentList;
}

public void setCommentList(ArrayList<String> commentList) {
	this.commentList = commentList;
}

public String toString() {
	return name + "\n" + description + "\n" + genre + "\n" + developer + "\n" + publishDate + "\n" + esrbRating;
}
}
