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
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
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

	User user;

	/**
	 * Creates a new main page frame where the user can view all games in the library 
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
			profile = new JButton("Profile");
			profile.setFocusPainted(false);
			profile.setForeground(Color.WHITE);
			profile.setBorder(emptyBorder);
			profile.setBounds(262, 0, 164, 63);
			profile.setBackground(new Color(25,24,26));
			profile.addActionListener(this);

		
		//Add favorites button to navbar
		favorites = new JButton("Favorites");
		favorites.setBounds(70, 0, 164, 63);
		favorites.setForeground(Color.WHITE);
		favorites.setFocusPainted(false);
		favorites.setBorder(emptyBorder);
		favorites.setBackground(new Color(25,24,26));
		
		//Add request button to navbar
		request = new JButton("Request Game");
		request.setBounds(454, 0, 164, 63);
		request.setForeground(Color.WHITE);
		request.setFocusPainted(false);
		request.setBorder(emptyBorder);
		request.setBackground(new Color(25,24,26));
		
		//Add admin page button to navbar
		admin = new JButton("Admin Page");
		admin.setBounds(646, 0, 164, 63);
		admin.setForeground(Color.WHITE);
		admin.setFocusPainted(false);
		admin.setBorder(emptyBorder);
		admin.setBackground(new Color(25,24,26));
		
		//add search box with 
		searchfield = new JTextField();
		searchfield.setBorder(new LineBorder(new Color(255, 255, 255), 10));
		JButton searchbutton = new JButton("SEARCH");
		searchbutton.setForeground(Color.WHITE);	
		searchbutton.setFocusPainted(false);
		searchbutton.setBackground(new Color(25, 24, 26));
		searchbutton.setBounds(1086, 234, 169, 54);
		searchbutton.setBorder(emptyBorder);
		JLabel presearch = new JLabel("Search for a game");
		
		contentPane.add(searchbutton);
		if (user.getPrivileges() != -1) {
			navpanel.add(profile);
			navpanel.add(favorites);
			navpanel.add(request);
		}
		if(user.getPrivileges()==2) {
			navpanel.add(admin);
		}
		
		searchfield.setBackground(Color.WHITE);
		searchfield.setBounds(334, 234, 758, 54);
		//Remove tooltip text when user types in search box
		searchfield.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            if (presearch.getText().equals("Text")) // User has not entered text yet
	            	presearch.setText("");
	        }
	    });
		
		presearch.setForeground(Color.LIGHT_GRAY);
		presearch.setBounds(344, 244, 359, 35);
		
		contentPane.add(presearch);
		
		JLabel lblGamingLibrary = new JLabel("The Gaming Library");
		lblGamingLibrary.setFont(new Font("Tahoma", Font.PLAIN, 48));
		lblGamingLibrary.setBounds(533, 128, 423, 95);
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
				//System.out.println(entries.get(0).toString());
				if (entries == null) {
					JOptionPane.showMessageDialog(null, "Please Try Again", "Search Not Found", JOptionPane.WARNING_MESSAGE);
				} else {
					System.out.println("searched");
					if(searchCount > 0) {
						System.out.println("search count greater than 0");
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == profile) {
			this.dispose();
			new newProfilePage(user);
		}
	}
}