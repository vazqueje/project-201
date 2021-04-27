import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class newProfilePage extends JFrame implements ActionListener{
	private JButton returnMainPage;
	private JButton changeEmail;
	private JButton changePass;
	private JTextField newEmail;
	private JTextField newPass;
	private JPanel contentPane;
	private User mainUser;

	int xx,xy;
	private JTextField searchfield;
	private int searchCount;
	private TableDisplay searchcatalog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User me = new User("ash","123","123",new java.sql.Date(101,0,23),3);
					newProfilePage frame = new newProfilePage(me);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newProfilePage(User user) {
		mainUser = user;
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1578, 1046);
		setLocationRelativeTo(null);
		
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
		
//		//Add profile button to navbar
//		JButton profile = new JButton("Profile");
//		profile.setFocusPainted(false);
//		profile.setForeground(Color.WHITE);
//		profile.setBorder(emptyBorder);
//		profile.setBounds(262, 0, 164, 63);
//		profile.setBackground(new Color(25,24,26));
		
		//Add favorites button to navbar
		JButton favorites = new JButton("Favorites");
		favorites.setBounds(70, 0, 164, 63);
		favorites.setForeground(Color.WHITE);
		favorites.setFocusPainted(false);
		favorites.setBorder(emptyBorder);
		favorites.setBackground(new Color(25,24,26));
		
//		//add search box with 
//		searchfield = new JTextField();
//		searchfield.setBorder(new LineBorder(new Color(255, 255, 255), 10));
//		JButton searchbutton = new JButton("SEARCH");
//		searchbutton.setForeground(Color.WHITE);	
//		searchbutton.setFocusPainted(false);
//		searchbutton.setBackground(new Color(25, 24, 26));
//		searchbutton.setBounds(1086, 171, 169, 54);
//		searchbutton.setBorder(emptyBorder);
//		JLabel presearch = new JLabel("Search for a game");
		//register main font
		try {
		     //Returned font is of pt size 1
		     Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font2);
		     font2 = font2.deriveFont(20f);
		     Font font3 = font2.deriveFont(30f);

//		     profile.setFont(font2);
		     favorites.setFont(font2);
//		     searchfield.setFont(font3);
//		     searchbutton.setFont(font3);
//		     presearch.setFont(font3);

		} catch (IOException|FontFormatException e) {
		     // Handle exception
		}
//		contentPane.add(searchbutton);
//		navpanel.add(profile);
		navpanel.add(favorites);
		searchfield.setBackground(Color.WHITE);
		searchfield.setBounds(330, 171, 758, 54);
//		//Remove tooltip text when user types in search box
//		searchfield.addMouseListener(new MouseAdapter() {
//	        public void mouseClicked(MouseEvent e) {
//	            if (presearch.getText().equals("Text")) // User has not entered text yet
//	            	presearch.setText("");
//	        }
//	    });
//		
//		presearch.setForeground(Color.LIGHT_GRAY);
//		presearch.setBounds(347, 181, 359, 35);
		
//		contentPane.add(presearch);
		
//		contentPane.add(searchfield);
		
		//add library logo to top left 
		JLabel smallIcon = new JLabel("");
		smallIcon.setBounds(12, 10, 56, 43);
		smallIcon.setIcon(new ImageIcon(LoginStyled2.class.getResource("/images/iconlogo.png")));

		navpanel.add(smallIcon);
		
		//background image
				JLabel cover = new JLabel("");
				cover.setBounds(0, 59, 1578, 356);
				contentPane.add(cover);
				cover.setIcon(new ImageIcon(LoginStyled2.class.getResource("/images/cyberpunk.jpg")));
		
		//create panel to display catalog entries
		JPanel profilePanel = new JPanel();
		
		profilePanel.setBackground(Color.WHITE);
		profilePanel.setLayout(null);
		profilePanel.setBounds(0, 325, 1566, 730);
		contentPane.add(profilePanel);
		JLabel username = new JLabel("Username: " + user.getUsername());
		username.setBounds(10, 100, 430, 107);
		JLabel password = new JLabel ("Password: " + user.getPassword());
		password.setBounds(10, 208, 430, 107);
		try {
		     //Returned font is of pt size 1
		     Font font2 = Font.createFont(Font.TRUETYPE_FONT, new File("Aileron-Thin-webfont.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font2);
		     font2 = font2.deriveFont(20f);
		     Font font3 = font2.deriveFont(30f);
		     Font font4 = new Font(font3.getFontName(), Font.BOLD, 20);
		     username.setFont(font4);
		     password.setFont(font4);     
		} catch (IOException|FontFormatException e) {
		     // Handle exception
		}
		changePass = new JButton("Change Password");
		changePass.setBounds(10, 384, 164, 63);
		changePass.setForeground(Color.DARK_GRAY);
		changePass.setFocusPainted(false);
		changePass.setBorder(emptyBorder);
		changePass.setBackground(new Color(25,24,26));
		changePass.addActionListener(this);
		profilePanel.add(changePass);
		
		changeEmail = new JButton("Change Email");
		changeEmail.setBounds(10, 500, 164, 63);
		changeEmail.setForeground(Color.DARK_GRAY);
		changeEmail.setFocusPainted(false);
		changeEmail.setBorder(emptyBorder);
		changeEmail.setBackground(new Color(25,24,26));
		changeEmail.addActionListener(this);
		profilePanel.add(changeEmail);
		
		newEmail = new JTextField("new email", 100);
		newEmail.setBounds(250, 384, 255, 63);
		profilePanel.add(newEmail);
		
		newPass = new JTextField("new password", 100);
		newPass.setBounds(250, 500, 255, 63);
		profilePanel.add(newPass);
		
		
		
		
		
		
		profilePanel.add(username);
		profilePanel.add(password);
//	        java.awt.EventQueue.invokeLater(new Runnable() {
//	            public void run() {
//	                new TableDisplay().setVisible(true);
//	            }
//	        });
//	    EntryRenderer er = new EntryRenderer();
//		TableDisplay catalog = new TableDisplay();
//		catalog.setBorder(new LineBorder(new Color(255, 255, 255), 10));
//		catalog.setBounds(0,81,1557,666);
//		tablepanel.add(catalog);
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == changePass) {
			if (newPass.getText().isEmpty()) return;
			else {
			EditInformation editPass = new EditInformation(mainUser);
			boolean ret = editPass.editPassword(newPass.getText());
			if (!ret) JOptionPane.showMessageDialog(null, "Invalid Password", "Invalid Password", JOptionPane.WARNING_MESSAGE);
			else {
				JOptionPane.showMessageDialog(null, "Password Changed", "Password Changed", JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new newProfilePage(mainUser);
			}
			}
		}
		else if (e.getSource() == changeEmail) {
			if(newEmail.getText().isEmpty()) return;
			else {
				EditInformation editEmail = new EditInformation(mainUser);
				boolean ret = editEmail.editEmail(newEmail.getText());
				if (!ret) JOptionPane.showMessageDialog(null, "Invalid Email", "Invalid Email", JOptionPane.WARNING_MESSAGE);
				else {
					JOptionPane.showMessageDialog(null, "Email Changed", "Email Changed", JOptionPane.WARNING_MESSAGE);
					this.dispose();
					new newProfilePage(mainUser);
				}
			}
		}
	}

}
