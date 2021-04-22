import java.awt.image.BufferedImage;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.ImageIcon;
public class Entry {
private String name;
private String description;
private String genre;
private String developer;
private Date publishDate;
private String esrbRating;
private CommentSection commentList;
BufferedImage cover;
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

public CommentSection getCommentList() {
	return commentList;
}

public void setCommentList(CommentSection commentList) {
	this.commentList = commentList;
}


public BufferedImage getCover(){
    return this.cover;
}

public String toString() {
	return name + "\n" + description + "\n" + genre + "\n" + developer + "\n" + publishDate + "\n" + esrbRating;
}
}
