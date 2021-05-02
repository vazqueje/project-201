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
public class commentPage extends JFrame implements ActionListener{
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
	public commentPage(User user, Entry entry) {
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

		//Game cover image icon
		Image image = entry.getCover().getScaledInstance(220, 284, BufferedImage.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(image.getScaledInstance(220, 284, Image.SCALE_SMOOTH) );
		
		//Initialize title panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(58, 162, 140));
		panel.setBounds(0, 59, 1578, 140);
		contentPane.add(panel);

		JLabel gameName = new JLabel("Gaming Library");
		gameName.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 29));
		gameName.setBounds(41, 13, 1525, 123);

		gameName.setText(entry.getName());
		gameName.setForeground(Color.white);


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
		
		//Event handler to close window
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
		home.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		home.setFocusPainted(false);
		home.setBackground(new Color(25, 24, 26));
		home.setBounds(171, 0, 164, 63);
		home.addActionListener(this);
		navpanel.add(home);
		home.setFocusPainted(false);
		home.setForeground(Color.WHITE);
		home.setBorder(emptyBorder);
		home.setBounds(80, 0, 164, 63);
		home.setBackground(new Color(25,24,26));

		//add library logo to top left 
		JLabel smallIcon = new JLabel("");
		smallIcon.setBounds(12, 10, 56, 43);
		smallIcon.setIcon(new ImageIcon(loginPage.class.getResource("/images/iconlogo.png")));
		navpanel.add(smallIcon);

		//create panel to display catalog entries
		JPanel tablepanel = new JPanel();
		tablepanel.setBackground(Color.WHITE);
		tablepanel.setLayout(null);
		tablepanel.setBounds(0, 316, 1566, 730);
		contentPane.add(tablepanel);
		
		//Create comment query
		commentSQL = new CommentSQL(entry);
		
		//If there are no comments, add label to say there are no comments
		if(commentSQL.getCommentSection() == null) {
			JLabel noComment = new JLabel("There are no comments. Be the first one to comment on this game!");
			noComment.setFont(new Font("Tahoma", Font.PLAIN, 22));
			noComment.setForeground(Color.LIGHT_GRAY);
			noComment.setBounds(40, 13, 294, 27);
			tablepanel.add(noComment);
		//Otherwise, display table of comments
		}else {
			CommentSection comments = commentSQL.getCommentSection();  
			CommentDisplay cd = new CommentDisplay(comments);
			cd.setBorder(new LineBorder(new Color(255, 255, 255), 10));
			cd.setBounds(12,13,1542,492);
			if(user.getPrivileges()==2 || user.getPrivileges()==1) {
				cd.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseClicked(java.awt.event.MouseEvent evt) {
						JTable source = (JTable)evt.getSource();
						int row = source.rowAtPoint( evt.getPoint());
						String selected = source.getModel().getValueAt(row, 0).toString();
						for(int i = 0; i<comments.getSize(); i++) {
							if(comments.getComment(i).getTitle().equals(selected)) {
								try {
									commentSQL.removeComment(comments.getComment(i).getcommentid());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
						dispose();
						new commentPage(mainUser, entry);
					}
				});
			}
			tablepanel.add(cd);
		}

		//label to prompt user to add coment
		JLabel lblAdd = new JLabel("Add a comment:");
		lblAdd.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 22));
		lblAdd.setBounds(40, 500, 294, 27);
		tablepanel.add(lblAdd);

		//If the user is not a guest, allow them to add comments
		if(user.getPrivileges() != -1) {
			commentTitle = new JTextField();
			commentTitle.setBorder(new LineBorder(new Color(51, 51, 51), 3));
			commentTitle.setBounds(38, 550, 695, 35);
			commentTitle.setColumns(10);
			commentTitle.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
			tablepanel.add(commentTitle);

			commentArea = new JTextArea();
			commentArea.setBorder(new LineBorder(new Color(51, 51, 51), 3));
			commentArea.setBounds(40, 610, 693, 96);
			commentArea.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
			tablepanel.add(commentArea);

			submit = new JButton("Submit");
			submit.setForeground(Color.WHITE);
			submit.setFont(new Font("Dialog", Font.PLAIN, 20));
			submit.setFocusPainted(false);
			submit.setBackground(new Color(25, 24, 26));
			submit.setBounds(775, 641, 164, 63);
			submit.addActionListener(this);
			submit.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 25));
			tablepanel.add(submit);

			JLabel lblTitle = new JLabel("Title:");
			lblTitle.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 15));
			lblTitle.setBounds(40, 524, 294, 27);
			tablepanel.add(lblTitle);

			JLabel lblComment = new JLabel("Comment:");
			lblComment.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 15));
			lblComment.setBounds(40, 582, 294, 27);
			tablepanel.add(lblComment);
		//Otherwise, inform them they need to log in
		} else {
			JLabel guestComment = new JLabel("You must be logged into to comment.");
			guestComment.setFont(new Font("Tahoma", Font.PLAIN, 22));
			guestComment.setBounds(40, 524, 400, 27);
			guestComment.setForeground(Color.LIGHT_GRAY);
			tablepanel.add(guestComment);
		}

		//add text area for game description-line
		gameDesc = new JTextArea();
		gameDesc.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		gameDesc.setBounds(36, 212, 1302, 91);
		gameDesc.setEditable(false);
		gameDesc.setText(entry.getDescription());
		contentPane.add(gameDesc);

		//if the user is a guest they cannot add to favorites.
		if(user.getPrivileges() != -1) {
		//add "Add to Favorites" button
		addFavorite = new JButton("Add to favorites");
		addFavorite.setForeground(Color.WHITE);
		addFavorite.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 15));
		addFavorite.setFocusPainted(false);
		addFavorite.setBackground(new Color(25, 24, 26));
		addFavorite.setBounds(1351, 212, 196, 91);
		addFavorite.addActionListener(this);
		contentPane.add(addFavorite);
		}
	}

	@Override
	/**
	 * Inherited from ActionListener interface. Adds event handler for buttons.
	 */
	public void actionPerformed(ActionEvent e) {
		//Event handler for home button
		if (e.getSource() == home) {
			dispose();
			new MainPage(mainUser);
		}
		//Event handler for adding the game to favorites
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
		//Event handler for submitting a comment
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
				e1.printStackTrace();
			}
			dispose();
			new commentPage(mainUser, entry);
		}

	}
}