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
import java.sql.Date;

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

/**
 * @author Raymond Lin
 *
 */
public class HelpPage extends JFrame implements ActionListener{
	private JButton returnMainPage;
	private JPanel contentPane;
	private JButton btnNewButton;
	private User mainUser;

	int xx,xy;

	/**
	 * Create the frame.
	 */
	public HelpPage(User user) {
		mainUser = user;
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1400, 1000);
		setLocationRelativeTo(null);
		
		//set main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		//Set up navigation bar
		JPanel navpanel = new JPanel();
		navpanel.setBackground(new Color(25,24,26));
		navpanel.setBounds(0, 0, 1400, 63);
		navpanel.setLayout(null);
		contentPane.add(navpanel);
		
		//add close window button
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(1353, 15, 37, 27);
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
		

		
		returnMainPage = new JButton("Main Page");
		returnMainPage.setBounds(70, 0, 164, 63);
		returnMainPage.setForeground(Color.WHITE);
		returnMainPage.setFocusPainted(false);
		returnMainPage.setBorder(emptyBorder);
		returnMainPage.setBackground(new Color(25,24,26));
		returnMainPage.addActionListener(this);
		
		navpanel.add(returnMainPage);

		
		//add library logo to top left 
		JLabel smallIcon = new JLabel("");
		smallIcon.setBounds(12, 10, 56, 43);
		smallIcon.setIcon(new ImageIcon(loginPage.class.getResource("/images/iconlogo.png")));

		navpanel.add(smallIcon);
		
		//background image
				JLabel cover = new JLabel("");
				cover.setBounds(0, 59, 1400, 356);
				contentPane.add(cover);
				cover.setIcon(new ImageIcon(loginPage.class.getResource("/images/cyberpunk.jpg")));
		
		//create panel to display catalog entries
		JPanel profilePanel = new JPanel();
		
		profilePanel.setBackground(Color.WHITE);
		profilePanel.setLayout(null);
		profilePanel.setBounds(0, 325, 1400, 622);
		contentPane.add(profilePanel);
		//displays the General Help page
		JLabel username = new JLabel("");
		username.setIcon(new ImageIcon(HelpPage.class.getResource("/images/GeneralHelp.JPG")));
		username.setFont(new Font("Tahoma", Font.PLAIN, 24));
		username.setBounds(10, 100, 970, 553);
		
		profilePanel.add(username);
		
		//displays the admin and moderator help page
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(HelpPage.class.getResource("/images/AdminModeratorHelp.JPG")));
		lblNewLabel_1.setBounds(722, 100, 697, 401);
		profilePanel.add(lblNewLabel_1);
		
		//a button that allows the user to move to the next page
		btnNewButton = new JButton("Next Page");
		btnNewButton.setBounds(1206, 556, 184, 55);
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(emptyBorder);
		btnNewButton.setBackground(new Color(25,24,26));
		btnNewButton.addActionListener(this);
		profilePanel.add(btnNewButton);
		
}

	/**
	 *Performs the actions of returning to the main page and moving to next help page
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//Returns the user to the main page
		if(e.getSource() == returnMainPage) {
			new MainPage(this.mainUser);
			this.dispose();
		}
		//moves onto the next help page
		if(e.getSource() == btnNewButton) {
			new HelpPage2(this.mainUser);
			this.dispose();
		}
		
	}
}
