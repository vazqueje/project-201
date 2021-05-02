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
	 * Create the frame.
	 */
	public newProfilePage(User user) {
		mainUser = user;
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 900);
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
		navpanel.setBounds(0, 0, 835, 63);
		navpanel.setLayout(null);
		contentPane.add(navpanel);
		
		//add close window button
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(788, 15, 37, 27);
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
		JButton favorites = new JButton("Favorites");
		favorites.setBounds(70, 0, 164, 63);
		favorites.setForeground(Color.WHITE);
		favorites.setFocusPainted(false);
		favorites.setBorder(emptyBorder);
		favorites.setBackground(new Color(25,24,26));
		
		returnMainPage = new JButton("Main Page");
		returnMainPage.setBounds(230, 0, 164, 63);
		returnMainPage.setForeground(Color.WHITE);
		returnMainPage.setFocusPainted(false);
		returnMainPage.setBorder(emptyBorder);
		returnMainPage.setBackground(new Color(25,24,26));
		returnMainPage.addActionListener(this);
		


		navpanel.add(favorites);
		navpanel.add(returnMainPage);

		
		//add library logo to top left 
		JLabel smallIcon = new JLabel("");
		smallIcon.setBounds(12, 10, 56, 43);
		smallIcon.setIcon(new ImageIcon(loginPage.class.getResource("/images/iconlogo.png")));

		navpanel.add(smallIcon);
		
		//background image
				JLabel cover = new JLabel("");
				cover.setBounds(0, 59, 835, 356);
				contentPane.add(cover);
				cover.setIcon(new ImageIcon(loginPage.class.getResource("/images/cyberpunk.jpg")));
		
		//create panel to display catalog entries
		JPanel profilePanel = new JPanel();
		
		profilePanel.setBackground(Color.WHITE);
		profilePanel.setLayout(null);
		profilePanel.setBounds(0, 325, 835, 572);
		contentPane.add(profilePanel);
		JLabel username = new JLabel("Username: " + user.getUsername());
		username.setFont(new Font("Tahoma", Font.PLAIN, 24));
		username.setBounds(10, 100, 430, 107);
		JLabel password = new JLabel ("Password: " + user.getPassword());
		password.setFont(new Font("Tahoma", Font.PLAIN, 24));
		password.setBounds(10, 208, 430, 107);
		
		profilePanel.add(username);
		profilePanel.add(password);
		
		changePass = new JButton("Change Password");
		changePass.setBounds(10, 384, 164, 63);
		changePass.setForeground(Color.DARK_GRAY);
		changePass.setFocusPainted(false);
		changePass.setBorder(emptyBorder);
		changePass.setBackground(new Color(25,24,26));
		changePass.addActionListener(this);
		profilePanel.add(changePass);
		
		newPass = new JTextField("new password", 100);
		newPass.setBounds(250, 384, 255, 63);
		profilePanel.add(newPass);
		
		changeEmail = new JButton("Change Email");
		changeEmail.setBounds(10, 500, 164, 63);
		changeEmail.setForeground(Color.DARK_GRAY);
		changeEmail.setFocusPainted(false);
		changeEmail.setBorder(emptyBorder);
		changeEmail.setBackground(new Color(25,24,26));
		changeEmail.addActionListener(this);
		profilePanel.add(changeEmail);
		
		
		newEmail = new JTextField("new email", 100);
		newEmail.setBounds(250, 500, 255, 63);
		profilePanel.add(newEmail);
		
		
JLabel lblNewLabel = new JLabel("Edit Information:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 344, 187, 29);
		profilePanel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email: " +user.getEmail());
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(405, 100, 430, 107);
		profilePanel.add(lblEmail);
		
		JLabel lblDob = new JLabel("DoB: "+user.getDob().toString());
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDob.setBounds(405, 218, 430, 107);
		profilePanel.add(lblDob);
		
}
	public void actionPerformed(ActionEvent e) {
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
		else if(e.getSource() == returnMainPage) {
			this.dispose();
			new MainPage(mainUser);
		}
	}
}


