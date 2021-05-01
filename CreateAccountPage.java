import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class CreateAccountPage extends JFrame implements ActionListener {
	private JButton returnMainPage;
	private JTextField username;
	private JTextField password;
	private JPanel contentPane;

	int xx,xy;
	private JTextField email;
	private JTextField txtjanurary;
	private JButton btnCreateAccount;

	/**
	 * Create the frame.
	 */
	public CreateAccountPage() {
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 800);
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
		navpanel.setBounds(0, 0, 893, 63);
		navpanel.setLayout(null);
		contentPane.add(navpanel);
		
		//add close window button
		JLabel lbl_close = new JLabel("X");
		lbl_close.setBounds(830, 15, 37, 27);
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
		smallIcon.setIcon(new ImageIcon(loginPage.class.getResource("/images/iconlogo.png")));

		navpanel.add(smallIcon);
		
		//background image
				JLabel cover = new JLabel("");
				cover.setBounds(0, 59, 893, 356);
				contentPane.add(cover);
				cover.setIcon(new ImageIcon(loginPage.class.getResource("/images/cyberpunk.jpg")));
		
		//create panel to display catalog entries
		JPanel profilePanel = new JPanel();
		
		profilePanel.setBackground(Color.WHITE);
		profilePanel.setLayout(null);
		profilePanel.setBounds(0, 325, 893, 484);
		contentPane.add(profilePanel);
		
		username = new JTextField("Enter Username", 100);
		username.setBounds(170, 145, 255, 63);
		profilePanel.add(username);
		
		
		password = new JTextField("Enter Password", 100);
		password.setBounds(170, 277, 255, 63);
		profilePanel.add(password);
		
		btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(this);
		btnCreateAccount.setForeground(Color.DARK_GRAY);
		btnCreateAccount.setFocusPainted(false);
		btnCreateAccount.setBackground(new Color(25, 24, 26));
		btnCreateAccount.setBounds(504, 396, 164, 63);
		profilePanel.add(btnCreateAccount);
		
		email = new JTextField("Enter Email", 100);
		email.setBounds(170, 396, 255, 65);
		profilePanel.add(email);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 139, 181, 63);
		profilePanel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPassword.setBounds(10, 271, 181, 63);
		profilePanel.add(lblPassword);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblEmail.setBounds(10, 396, 181, 63);
		profilePanel.add(lblEmail);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblDateOfBirth.setBounds(450, 271, 148, 63);
		profilePanel.add(lblDateOfBirth);
		
		JLabel lblNewLabel_1 = new JLabel("Enter mm/dd/yyyy");
		lblNewLabel_1.setBounds(460, 316, 123, 40);
		profilePanel.add(lblNewLabel_1);
		
		txtjanurary = new JTextField();
		txtjanurary.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtjanurary.setText("mm/dd/yyyy");
		txtjanurary.setBounds(622, 277, 255, 63);
		profilePanel.add(txtjanurary);
		txtjanurary.setColumns(10);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCreateAccount) {
			
			if(txtjanurary.getText().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") && !(username.getText().equals("Enter Username")) && !(password.getText().equals("Enter Password")) && !(email.getText().equals("Enter Email"))) {

				int month = Integer.parseInt(txtjanurary.getText().substring(0,2))-1;
				int day = Integer.parseInt(txtjanurary.getText().substring(3,5));
				int year = Integer.parseInt(txtjanurary.getText().substring(6,10))-1900;
				UserVerify v1 = new UserVerify(username.getText(),password.getText(),email.getText(),new java.sql.Date(year,month,day));
				if(!(v1.createAccount())) {
					JOptionPane.showMessageDialog(null, "Login already exists or it is a banned account", "Error", JOptionPane.WARNING_MESSAGE);
					this.dispose();
				} else {
				JOptionPane.showMessageDialog(null,"Account Created Successfully", "Success", JOptionPane.WARNING_MESSAGE);
				this.dispose();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Invalid Information", "Error", JOptionPane.WARNING_MESSAGE);
				this.dispose();
			}
		}
	}
}
