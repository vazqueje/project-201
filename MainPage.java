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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
/**
 * MainPage.java
 * Date created: 4/4/21
 * @author Jessica Vazquez vazqueje@miamioh.edu
 */

public class MainPage extends JFrame implements ActionListener {
	private JPanel contentPane;
	int xx,xy;
	private JTextField searchfield;
	private int searchCount;
	private TableDisplay searchcatalog;
	private JButton profile;
	private JButton request;
	private JButton favorites;
	private JButton admin;
	private JButton home;
	private JLabel lbl_help;
	User user;

	/**
	 * Class constructor: creates a new main page frame where the user can view all games in the library 
	 * @param user the type of user viewing the page
	 */
	public MainPage(User user) {
		this.user = user;
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
		
		//Set up navigation bar
		JPanel navpanel = new JPanel();
		navpanel.setBackground(new Color(25,24,26));
		navpanel.setBounds(0, 0, 1578, 63);
		navpanel.setLayout(null);
		contentPane.add(navpanel);
		
		//add a help page button
		lbl_help = new JLabel("?");
		lbl_help.setBounds(1490, 16, 37, 27);
		lbl_help.setForeground(new Color(58, 162, 140));
		lbl_help.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
		lbl_help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
					dispose();
					new HelpPage(user);
				
			}
		});
		navpanel.add(lbl_help);
		
		
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
		
		//Add favorites button to navbar
				home = new JButton("Home");
				home.setBounds(70, 0, 164, 63);
				home.setForeground(Color.WHITE);
				home.setBorder(emptyBorder);
				home.setFocusPainted(false);
				home.setBackground(new Color(25,24,26));
				home.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
				
				//Add profile button to navbar
				profile = new JButton("Profile");
				profile.setForeground(Color.WHITE);
				profile.setBorder(emptyBorder);
				profile.setFocusPainted(false);
				profile.setBounds(262, 0, 164, 63);
				profile.setBackground(new Color(25,24,26));
				profile.addActionListener(this);
				profile.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
				
				//Add favorites button to navbar
				favorites = new JButton("Favorites");
				favorites.setBounds(676, 0, 164, 63);
				favorites.setForeground(Color.WHITE);
				favorites.setBorder(emptyBorder);
				favorites.setBackground(new Color(25,24,26));
				favorites.addActionListener(this);
				favorites.setFocusPainted(false);
				favorites.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
				
				//Add request button to navbar
				request = new JButton("Request Game");
				request.setBounds(454, 0, 164, 63);
				request.setFocusPainted(false);
				request.setForeground(Color.WHITE);
				request.setBorder(emptyBorder);
				request.setBackground(new Color(25,24,26));
				request.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
				request.addActionListener(this);
				
				//Add admin page button to navbar
				admin = new JButton("Admin Page");
				admin.setBounds(900, 0, 164, 63);
				admin.setForeground(Color.WHITE);
				admin.setFocusPainted(false);
				admin.setBorder(emptyBorder);
				admin.setBackground(new Color(25,24,26));
				admin.addActionListener(this);
				admin.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
		
		//add search box with 
		searchfield = new JTextField();
		searchfield.setBorder(new LineBorder(new Color(255, 255, 255), 10));
		JButton searchbutton = new JButton("SEARCH");
		searchbutton.setForeground(Color.WHITE);	
		searchbutton.setFocusPainted(false);
		searchbutton.setBackground(new Color(25, 24, 26));
		searchbutton.setBounds(1086, 234, 169, 54);
		searchbutton.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 25));
		searchbutton.setBorder(emptyBorder);
		JLabel presearch = new JLabel("Search for a game");
		presearch.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		
		contentPane.add(searchbutton);
		if (user.getPrivileges() != -1) {
			navpanel.add(profile);
			navpanel.add(favorites);
			navpanel.add(request);
			navpanel.add(home);
		}
		if(user.getPrivileges()==2) {
			navpanel.add(admin);
		}
		
		searchfield.setBackground(Color.WHITE);
		searchfield.setBounds(334, 234, 758, 54);
		searchfield.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
		//Remove tooltip text when user types in search box
		searchfield.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            if (presearch.getText().equals("Text")) // User has not entered text yet
	            	presearch.setText("");
	        }
	    });
		
		presearch.setForeground(Color.LIGHT_GRAY);
		presearch.setBounds(354, 244, 359, 35);
		
		contentPane.add(presearch);
		
		JLabel lblGamingLibrary = new JLabel("The Gaming Library");
		lblGamingLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamingLibrary.setFont(new Font("ROG Fonts", Font.BOLD, 56));
		lblGamingLibrary.setBounds(360, 108, 853, 95);
		lblGamingLibrary.setForeground(Color.white);
	
		contentPane.add(lblGamingLibrary);
		
		contentPane.add(searchfield);
		
		//add library logo to top left 
		JLabel smallIcon = new JLabel("");
		smallIcon.setBounds(12, 10, 56, 43);
		smallIcon.setIcon(new ImageIcon(loginPage.class.getResource("/images/iconlogo.png")));

		navpanel.add(smallIcon);
		
		//background image
				JLabel cover = new JLabel("");
				cover.setBounds(0, 59, 1578, 356);
				contentPane.add(cover);
				cover.setIcon(new ImageIcon(loginPage.class.getResource("/images/cyberpunk.jpg")));
		
		//create panel to display catalog entries
		JPanel tablepanel = new JPanel();
		
		
		
		
		tablepanel.setBackground(Color.WHITE);
		tablepanel.setLayout(null);
		tablepanel.setBounds(0, 325, 1566, 730);
		contentPane.add(tablepanel);
		

	    EntryRenderer er = new EntryRenderer();
		TableDisplay catalog = new TableDisplay(this.user);
		catalog.setBorder(new LineBorder(new Color(255, 255, 255), 10));
		catalog.setBounds(12,85,1557,666);
		tablepanel.add(catalog);
		
		
		
		searchbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String searchString = searchfield.getText();
				if (searchString.isEmpty()) return;
				Search newSearch = new Search(searchString,user);
				
				ArrayList<Entry> entries = newSearch.fetchSearch(searchString);
				if (entries == null) {
					JOptionPane.showMessageDialog(null, "Please Try Again", "Search Not Found", JOptionPane.WARNING_MESSAGE);
				} else {
					if(searchCount > 0) {
						searchcatalog.setVisible(false);
						tablepanel.remove(searchcatalog);
						searchcatalog =  new TableDisplay(entries);
						searchcatalog.setBorder(new LineBorder(new Color(255, 255, 255), 10));
						//searchcatalog.setBounds(12,13,1358,704);
						searchcatalog.setBounds(12,85,1557,666);
						searchcatalog.repaint();
						searchcatalog.setVisible(true);
						
						tablepanel.add(searchcatalog);
						
						
					}else {
						catalog.setVisible(false);
						tablepanel.remove(catalog);
						searchcatalog = new TableDisplay(entries);
						searchcatalog.setBorder(new LineBorder(new Color(255, 255, 255), 10));
						searchcatalog.setBounds(12,85,1557,666);
						searchcatalog.setVisible(true);
						tablepanel.add(searchcatalog);
					}
					//panel_1.remove(catalog);
					
					
				}
				searchCount++;
				
			}
			
		});
		
		
		
		catalog.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTable source = (JTable)evt.getSource();
                int row = source.rowAtPoint( evt.getPoint());
                String selected = source.getModel().getValueAt(row, 1).toString();
                try {
                	
					Search newSearch = new Search(selected,user);
					ArrayList<Entry> entries = newSearch.fetchSearch(selected);
					dispose();
					new commentPage(user, entries.get(0));
                }catch (Exception e) {
                	e.printStackTrace();
                }
            }
		});
		
	}
	
	/**
	 * Event listener for navbar buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == profile) {
			this.dispose();
			new newProfilePage(user);
		}
		if(e.getSource() == admin) {
			this.dispose();
			new newAdminPage(user);
		}
		if(e.getSource() == request) {
			this.dispose();
			new newRequestPage(user);
		}
		if(e.getSource() == favorites) {
			this.dispose();
			new FavoritesPageGUI(user);
		}

	}
	
	


}