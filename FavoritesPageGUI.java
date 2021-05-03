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
public class FavoritesPageGUI extends JFrame implements ActionListener {
	private JPanel contentPane;
	int xx,xy;
	private JButton home;
	private JButton profile;
	private JButton request;
	private JButton favorites;
	private JButton admin;
	private TableDisplay favTable;
	User user;

	/**
	 * Creates a new main page frame where the user can view all games in the library 
	 * @param user the type of user viewing the page
	 */
	public FavoritesPageGUI(User user) {
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
		
		//Add favorites button to navbar
		home = new JButton("Home");
		home.setBounds(70, 0, 164, 63);
		home.setForeground(Color.WHITE);
		home.setBorder(emptyBorder);
		home.addActionListener(this);
		home.setBackground(new Color(25,24,26));
		home.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
		
		//Add profile button to navbar
		profile = new JButton("Profile");
		profile.setForeground(Color.WHITE);
		profile.setBorder(emptyBorder);
		profile.addActionListener(this);
		profile.setBounds(262, 0, 164, 63);
		profile.setBackground(new Color(25,24,26));
		profile.addActionListener(this);
		profile.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
		
		//Add favorites button to navbar
		favorites = new JButton("Favorites");
		favorites.setBounds(900, 0, 164, 63);
		favorites.setForeground(Color.WHITE);
		favorites.addActionListener(this);
		favorites.setBorder(emptyBorder);
		favorites.setBackground(new Color(25,24,26));
		favorites.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
		
		//Add request button to navbar
		request = new JButton("Request Game");
		request.setBounds(454, 0, 164, 63);
		request.setForeground(Color.WHITE);
		request.setBorder(emptyBorder);
		request.setBackground(new Color(25,24,26));
		request.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
		
		//Add admin page button to navbar
		admin = new JButton("Admin Page");
		admin.setBounds(676, 0, 164, 63);
		admin.setForeground(Color.WHITE);
		admin.addActionListener(this);
		admin.setBorder(emptyBorder);
		admin.setBackground(new Color(25,24,26));
		admin.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 20));
		
		
		if (user.getPrivileges() != -1) {
			navpanel.add(profile);
			navpanel.add(favorites);
			navpanel.add(request);
			navpanel.add(home);
		}
		if(user.getPrivileges()==2) {
			navpanel.add(admin);
		}
		
		
		
		
		
		JLabel lblGamingLibrary = new JLabel("The Gaming Library");
		lblGamingLibrary.setHorizontalAlignment(SwingConstants.CENTER);
		lblGamingLibrary.setFont(new Font("ROG Fonts", Font.BOLD, 56));
		lblGamingLibrary.setBounds(360, 108, 853, 95);
		lblGamingLibrary.setForeground(Color.white);
	
		contentPane.add(lblGamingLibrary);
		
		
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
		
		JLabel noGamesHeading = new JLabel("You currently have no favorites.");
		noGamesHeading.setVisible(false);
		noGamesHeading.setForeground(new Color(51, 204, 153));
		noGamesHeading.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 54));
		noGamesHeading.setBounds(57, 133, 1290, 83);
		tablepanel.add(noGamesHeading);
		
		JLabel noGamesSub = new JLabel("Add games to your favorites to see them here!");
		noGamesSub.setVisible(false);
		noGamesSub.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 30));
		noGamesSub.setBounds(57, 211, 1290, 83);
		tablepanel.add(noGamesSub);
		

	    FavoriteListSQL favsql = new FavoriteListSQL(user);
	    if(favsql.displayFavorites() != null) {
	    	FavoritesPage fp = favsql.displayFavorites();
	    	ArrayList<Entry> favlist = fp.getGameList();
			favTable = new TableDisplay(favlist);
			favTable.setBorder(new LineBorder(new Color(255, 255, 255), 10));
			favTable.setBounds(12,85,1557,666);
			favTable.setVisible(true);
			favTable.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent evt) {
	                JTable source = (JTable)evt.getSource();
	                int row = source.rowAtPoint( evt.getPoint());
	                String selected = source.getModel().getValueAt(row, 1).toString();
	                try {
	                	
						Search newSearch = new Search(selected,user);
						ArrayList<Entry> entries = newSearch.fetchSearch(selected);
						Entry e = entries.get(0);
						
						Boolean bool;
						try {
							FavoriteListSQL list = new FavoriteListSQL(e, user);
							bool = list.removeFavorite();
							if (!bool) JOptionPane.showMessageDialog(null, "Game not found", "Error", JOptionPane.WARNING_MESSAGE);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						new FavoritesPageGUI(user);
	                }catch (Exception e) {
	                	e.printStackTrace();
	                }
	            }
			});
			tablepanel.add(favTable);
	    }else {
	    	noGamesHeading.setVisible(true);
	    	noGamesSub.setVisible(true);
	    }
	    
		
		
		
		
		
		
	}
	
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
		if(e.getSource() == home) {
			this.dispose();
			new MainPage(user);
		}

	}
}