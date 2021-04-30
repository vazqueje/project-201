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

public class ForgotPasswordPage extends JFrame implements ActionListener {
	private JButton returnMainPage;
	private JTextField username;
	private JPanel contentPane;

	int xx,xy;
	private JButton btnRetrievePassword;
	

	/**
	 * Create the frame.
	 */
	public ForgotPasswordPage() {
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 500);
		setLocationRelativeTo(null);
		
		//set main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//set up custom font: QuadUltra.ttf
		
		//Set up navigation bar
		JPanel navpanel = new JPanel();
		navpanel.setBackground(new Color(25,24,26));
		navpanel.setBounds(0, 0, 647, 63);
		navpanel.setLayout(null);
		contentPane.add(navpanel);
		
		//add close window button
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(600, 25, 37, 27);
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
		
		


		
		//add library logo to top left 
		JLabel smallIcon = new JLabel("");
		smallIcon.setBounds(12, 10, 56, 43);
		smallIcon.setIcon(new ImageIcon(LoginStyled2.class.getResource("/images/iconlogo.png")));

		navpanel.add(smallIcon);
		
		//background image
				JLabel cover = new JLabel("");
				cover.setBounds(0, 59, 647, 356);
				contentPane.add(cover);
				cover.setIcon(new ImageIcon(LoginStyled2.class.getResource("/images/cyberpunk.jpg")));
		
		//create panel to display catalog entries
		JPanel profilePanel = new JPanel();
		
		profilePanel.setBackground(Color.WHITE);
		profilePanel.setLayout(null);
		profilePanel.setBounds(0, 291, 647, 218);
		contentPane.add(profilePanel);

		
		//Where the user will enter their username in order to retrieve password
		username = new JTextField("Enter Username", 100);
		username.setBounds(170, 145, 255, 63);
		profilePanel.add(username);
		
		//Hit the button to execute the SQL Query
		btnRetrievePassword = new JButton("Retrieve Password");
		btnRetrievePassword.addActionListener(this);
		btnRetrievePassword.setForeground(Color.DARK_GRAY);
		btnRetrievePassword.setFocusPainted(false);
		btnRetrievePassword.setBackground(new Color(25, 24, 26));
		btnRetrievePassword.setBounds(473, 145, 164, 63);
		profilePanel.add(btnRetrievePassword);
		
		//Just a label to tell users where to put in their username
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 139, 181, 63);
		profilePanel.add(lblNewLabel);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnRetrievePassword) {
			if(username.getText().equals("Enter Username")) {
				JOptionPane.showMessageDialog(null, "Nothing was entered", "Failed to retrieve password", JOptionPane.WARNING_MESSAGE);
				this.dispose();
				return;
			}
			ForgotPassword f1 = new ForgotPassword(username.getText());
			User u1 = f1.returnUser();
			if(u1 == null) {
				JOptionPane.showMessageDialog(null, "User does not exist", "Failed to retrieve password", JOptionPane.WARNING_MESSAGE);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Your password: "+u1.getPassword(), "Successfully retrieved Password", JOptionPane.WARNING_MESSAGE);
				this.dispose();
			}
		}
	}
}
