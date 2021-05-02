import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
/**
 * @author Raymond Lin
 *
 */
public class Entry {
private String name;
private String description;
private String genre;
private String developer;
private Date publishDate;
private String esrbRating;
private CommentSection commentList;
BufferedImage cover;
/**
 * Constructor for an entry
 * @param name the name of the game
 * @param description the description of the game
 * @param genre the genre of the game
 * @param developer who developed the game
 * @param publishDate when the game was published
 * @param esrbRating what the esrb rating is
 * @param commentList the comment section of the game
 * @param cover the cover art of the game
 */
public Entry(String name, String description, String genre, String developer, Date publishDate, String esrbRating, CommentSection commentList, BufferedImage cover) {
	this.name = name;
	this.description = description;
	this.genre = genre;
	this.developer = developer;
	this.publishDate = publishDate;
	this.esrbRating = esrbRating;
	this.commentList = commentList;
	this.cover = cover;
}

/**
 * @return the name of the game
 */
public String getName() {
	return name;
}

/**
 * @param name the name of the game
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the description of the game
 */
public String getDescription() {
	return description;
}

/**
 * @param description the thing that describes the game in detail
 */
public void setDescription(String description) {
	this.description = description;
}

/**
 * @return the genre of the game
 */
public String getGenre() {
	return genre;
}

/**
 * @param genre the genre
 */
public void setGenre(String genre) {
	this.genre = genre;
}

/**
 * @return who developed the game
 */
public String getDeveloper() {
	return developer;
}

/**
 * @param developer the people who developed the game
 */
public void setDeveloper(String developer) {
	this.developer = developer;
}

/**
 * @return the date that the game was published
 */
public Date getPublishDate() {
	return publishDate;
}

/**
 * @param publishDate the date the game was published
 */
public void setPublishDate(Date publishDate) {
	this.publishDate = publishDate;
}

/**
 * @return the esrb rating of the game
 */
public String getEsrbRating() {
	return esrbRating;
}

/**
 * @param esrbRating the rating of the game
 */
public void setEsrbRating(String esrbRating) {
	this.esrbRating = esrbRating;
}

/**
 * @return the comment list of the game
 */
public CommentSection getCommentList() {
	return commentList;
}

/**
 * @param commentList the object that holds all the comments about the game
 */
public void setCommentList(CommentSection commentList) {
	this.commentList = commentList;
}


/**
 * @return the cover of the game
 */
public BufferedImage getCover(){
    return this.cover;
}

/**
 *Prints out a to string of the entire Entry object
 */
public String toString() {
	return name + "\n" + description + "\n" + genre + "\n" + developer + "\n" + publishDate + "\n" + esrbRating;
}
}
