import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JTextArea;
public class CommentPage extends JFrame implements ActionListener{
	private JPanel contentPane;
	int xx,xy;
	private int searchCount;
	private TableDisplay searchcatalog;
	private JTextArea gameDesc;
	User mainUser;
	Entry entry;
	CommentSQL commentSQL;
	CommentSection comments;
	private JButton home;
	private JButton profile;
	private JButton favorites;
	private JButton submit;
	private JButton addFavorite;
	private JTextArea commentArea;
	private JTextField commentTitle;
	
	/**
	 * Creates a new main page frame where the user can view all games in the library 
	 * @param user the type of user viewing the page
	 */
	public CommentPage(User user, Entry entry) {
		this.entry = entry;
		mainUser = user;
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1578, 1046);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/iconlogo.png")));
		
		
		
		//set main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//set up custom font: QuadUltra.ttf
		try {
		     //Returned font is of pt size 1
		     Font font = Font.createFont(Font.TRUETYPE_FONT, new File("QuadUltra.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font);
		     font = font.deriveFont(48f);
		     //titleLabel3.setFont(font);

		} catch (IOException|FontFormatException e) {
		     // Handle exception
		}
		
		
		Image image = entry.getCover().getScaledInstance(220, 284, BufferedImage.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(image.getScaledInstance(220, 284, Image.SCALE_SMOOTH) );
		
		
				     
				     
				     JPanel panel = new JPanel();
				     panel.setLayout(null);
				     panel.setBackground(new Color(25, 24, 26));
				     panel.setBounds(0, 59, 1578, 140);
				     contentPane.add(panel);
				     
				     JLabel gameName = new JLabel("Gaming Library");
				     gameName.setBounds(41, 13, 1525, 123);
				     
				     gameName.setText(entry.getName());
				     gameName.setForeground(Color.white);
				     
				     try {
							//Returned font is of pt size 1
							Font font4 = Font.createFont(Font.TRUETYPE_FONT, new File("QuadUltra.ttf"));
							GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
							genv.registerFont(font4);
							font4 = font4.deriveFont(70f);
							gameName.setFont(font4);
						} catch (IOException|FontFormatException e) {
							// Handle exception
						}
				     panel.add(gameName);
				     
				     JLabel gameCover = new JLabel("");
				     gameCover.setBounds(1342, 26, 196, 247);
				     panel.add(gameCover);
				     gameCover.setIcon(icon);
		//Set up navigation bar
		JPanel navpanel = new JPanel();
		navpanel.setBackground(new Color(25,24,26));
		navpanel.setBounds(0, 0, 1578, 63);
		navpanel.setLayout(null);
		contentPane.add(navpanel);
		
		
		
		//add close window button
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(1529, 16, 37, 27);
		navpanel.add(lbl_close);
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(58, 162, 140));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		//Create empty border for stylized buttons
		Border emptyBorder = BorderFactory.createEmptyBorder();
		
		//Add profile button to navbar
		home = new JButton("Home");
		home.setForeground(Color.WHITE);
		home.setFont(null);
		home.setFocusPainted(false);
		home.setBackground(new Color(25, 24, 26));
		home.setBounds(171, 0, 164, 63);
		navpanel.add(home);
		home.setFocusPainted(false);
		home.setForeground(Color.WHITE);
		home.setBorder(emptyBorder);
		home.setBounds(80, 0, 164, 63);
		home.setBackground(new Color(25,24,26));
		
		//Add favorites button to navbar
		favorites = new JButton("Favorites");
		favorites.setBounds(480, 0, 164, 63);
		favorites.setForeground(Color.WHITE);
		favorites.setFocusPainted(false);
		favorites.setBorder(emptyBorder);
		favorites.setBackground(new Color(25,24,26));
		
		profile = new JButton("Profile");
		profile.setForeground(Color.WHITE);
		profile.setFont(null);
		profile.setFocusPainted(false);
		profile.setBackground(new Color(25, 24, 26));
		profile.setBorder(emptyBorder);
		profile.setBounds(280, 0, 164, 63);
		navpanel.add(profile);
		
		//register main font
		try {
		     //Returned font is of pt size 1
		     Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font2);
		     font2 = font2.deriveFont(20f);
		     Font font3 = font2.deriveFont(30f);

		     profile.setFont(font2);
		     favorites.setFont(font2);
		     home.setFont(font2);

		} catch (IOException|FontFormatException e) {
		     // Handle exception
		}
		navpanel.add(profile);
		navpanel.add(favorites);
		
		   
		//Derive and return a 12 pt version:
		//Need to use float otherwise
		//it would be interpreted as style
		
		
		//add library logo to top left 
		JLabel smallIcon = new JLabel("");
		smallIcon.setBounds(12, 10, 56, 43);
		smallIcon.setIcon(new ImageIcon(LoginStyled.class.getResource("/images/iconlogo.png")));

		navpanel.add(smallIcon);
		
		
		
		
		
		//create panel to display catalog entries
		JPanel tablepanel = new JPanel();
		
		
		
		
		tablepanel.setBackground(Color.WHITE);
		tablepanel.setLayout(null);
		tablepanel.setBounds(0, 316, 1566, 730);
		contentPane.add(tablepanel);
		

	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new TableDisplay().setVisible(true);
	            }
	        });
	    
	    commentSQL = new CommentSQL(entry);
	    if(commentSQL == null) {
	    	JLabel noComment = new JLabel("There are no comments. Be the first one to comment on this game!");
	    	noComment.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    	noComment.setForeground(Color.LIGHT_GRAY);
	    	noComment.setBounds(40, 13, 294, 27);
	    	tablepanel.add(noComment);
	    }else {
	    	 CommentSection comments = commentSQL.getCommentSection();  
	 	    CommentDisplay cd = new CommentDisplay(comments);
	    	cd.setBorder(new LineBorder(new Color(255, 255, 255), 10));
			cd.setBounds(12,13,1542,492);
			tablepanel.add(cd);
	    }
	   
	    
		
		
		JLabel lblShareYourThoughts = new JLabel("Add a comment:");
		lblShareYourThoughts.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblShareYourThoughts.setBounds(40, 500, 294, 27);
		tablepanel.add(lblShareYourThoughts);
		
		if(user.getPrivileges() != -1) {
			commentTitle = new JTextField();
			commentTitle.setBorder(new LineBorder(new Color(51, 51, 51), 3));
			commentTitle.setBounds(38, 550, 695, 35);
			commentTitle.setColumns(10);
			tablepanel.add(commentTitle);
			
			commentArea = new JTextArea();
			commentArea.setBorder(new LineBorder(new Color(51, 51, 51), 3));
			commentArea.setBounds(40, 610, 693, 96);
			tablepanel.add(commentArea);
			
			submit = new JButton("Submit");
			submit.setForeground(Color.WHITE);
			submit.setFont(new Font("Dialog", Font.PLAIN, 20));
			submit.setFocusPainted(false);
			submit.setBackground(new Color(25, 24, 26));
			submit.setBounds(775, 641, 164, 63);
			tablepanel.add(submit);
			
			
			
			JLabel lblTitle = new JLabel("Title:");
			lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTitle.setBounds(40, 524, 294, 27);
			tablepanel.add(lblTitle);
			
			JLabel lblComment = new JLabel("Comment:");
			lblComment.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblComment.setBounds(40, 582, 294, 27);
			tablepanel.add(lblComment);
		}else {
			JLabel guestComment = new JLabel("You must be logged into to comment.");
			guestComment.setFont(new Font("Tahoma", Font.PLAIN, 22));
			guestComment.setBounds(40, 524, 294, 27);
			guestComment.setForeground(Color.LIGHT_GRAY);
			tablepanel.add(guestComment);
		}
		
		 gameDesc = new JTextArea();
		try {
		     //Returned font is of pt size 1
		     Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font2);
		     font2 = font2.deriveFont(20f);
		     Font font3 = font2.deriveFont(30f);
		     gameDesc.setFont(font3);
		}catch (Exception e) {
			e.printStackTrace();
		}
		    
		     gameDesc.setBounds(36, 212, 1302, 91);
		     gameDesc.setEditable(false);
		     gameDesc.setText(entry.getDescription());
		     contentPane.add(gameDesc);
		     
		     addFavorite = new JButton("Add to favorites");
		     addFavorite.setForeground(Color.WHITE);
		     addFavorite.setFont(new Font("Dialog", Font.PLAIN, 21));
		     addFavorite.setFocusPainted(false);
		     addFavorite.setBackground(new Color(25, 24, 26));
		     addFavorite.setBounds(1351, 212, 196, 91);
		     contentPane.add(addFavorite);
		     		     //titleLabel3.setFont(font);
		     		     

		
		
		
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		

		if (e.getSource() == home) {
			dispose();
			new MainPage(mainUser);
		}
		else if (e.getSource() == addFavorite) {
			//NOT WORKING //OLDCODE
			FavoriteListSQL list = new FavoriteListSQL(entry, mainUser);
			Boolean bool;
			try {
				bool = list.addFavorite();
				if (!bool) JOptionPane.showMessageDialog(null, "Game already in Favorites", "Error", JOptionPane.WARNING_MESSAGE);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if (e.getSource() == submit) {
			if (commentTitle.getText().length()==0 || commentArea.getText().length()==0) {
				return;
			}
			System.out.println("clicked");
			String title = commentTitle.getText();
			String description =  commentArea.getText();
			try {
				commentSQL.addComment(title, description, entry.getName());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Failed");
				e1.printStackTrace();
			}
			dispose();
			new CommentPage(mainUser, entry);
			//frame.setVisible(true);
		}
		else {
			System.out.println("TO-DO");
			//REMOVE COMMENT - NOT WORKING
//			for (int i = 0; i < list.size(); i++) {
//				if (e.getSource() == list.get(i)) {
//					String str = list.get(i).getText().substring(8);
//					int id = Integer.parseInt(str);
//					try {
//						commentSQL.removeComment(id);
//					} catch (SQLException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//			
//			frame.dispose();
//			new commentPage(mainUser, entry);
		}
	}
}