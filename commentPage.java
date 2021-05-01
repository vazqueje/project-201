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
public class CommentPage extends JFrame {
	private JPanel contentPane;
	int xx,xy;
	private int searchCount;
	private TableDisplay searchcatalog;
	private JTextArea gameDesc;
	User mainUser;
	Entry entry;
	CommentSQL commentSQL;
	CommentSection comments;

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
				     
				     JLabel gameCover = new JLabel("");
				     gameCover.setBounds(1293, -18, 220, 284);
				     panel.add(gameCover);
				     gameCover.setIcon(icon);
				     
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
		JButton profile = new JButton("Profile");
		profile.setFocusPainted(false);
		profile.setForeground(Color.WHITE);
		profile.setBorder(emptyBorder);
		profile.setBounds(262, 0, 164, 63);
		profile.setBackground(new Color(25,24,26));
		
		//Add favorites button to navbar
		JButton favorites = new JButton("Favorites");
		favorites.setBounds(70, 0, 164, 63);
		favorites.setForeground(Color.WHITE);
		favorites.setFocusPainted(false);
		favorites.setBorder(emptyBorder);
		favorites.setBackground(new Color(25,24,26));
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
		tablepanel.setBounds(0, 325, 1566, 730);
		contentPane.add(tablepanel);
		

	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new TableDisplay().setVisible(true);
	            }
	        });
	        
	    commentSQL = new CommentSQL(entry);
	    CommentSection comments = commentSQL.getCommentSection();  
	    CommentDisplay cd = new CommentDisplay(comments);
	    
		cd.setBorder(new LineBorder(new Color(255, 255, 255), 10));
		cd.setBounds(12,13,1542,492);
		tablepanel.add(cd);
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
		    
		     gameDesc.setBounds(36, 212, 1503, 91);
		     gameDesc.setEditable(false);
		     gameDesc.setText(entry.getDescription());
		     contentPane.add(gameDesc);
		     		     //titleLabel3.setFont(font);
		     		     

		
		
		/**
		 * Event handler for favorites button. Disposes the current page and opens up the favorites page.
		 */
		favorites.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				System.out.println(mainUser.getUsername());
				if(mainUser == null) {
					System.out.println("Null");
				}
				new FavoritesPageGUI(mainUser);
			}
		});
		
	
		
	}
}