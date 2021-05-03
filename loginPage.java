import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
public class loginPage extends JFrame implements MouseListener{
	User mainUser;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private JLabel lblCreateAccount;
	private JLabel lblForgotPassword;
	Button guestUser;
	Button button;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginPage frame = new loginPage();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	// going to borrow code from a gist to move frame.


	/**
	 * Constructor to create the first page of the software, the login page
	 */
	public loginPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 490);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/iconlogo.png")));
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblCatalog = new JLabel("Catalog");
		lblCatalog.setHorizontalAlignment(SwingConstants.CENTER);
		lblCatalog.setForeground(new Color(38, 162, 140));
		lblCatalog.setFont(new Font("ROG Fonts", Font.BOLD, 36));
		lblCatalog.setBounds(68, 355, 227, 70);
		panel.add(lblCatalog);

		JLabel lblSubtitle = new JLabel("Powered by GamersInc.");
		lblSubtitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtitle.setForeground(new Color(58, 162, 140));
		lblSubtitle.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 13));
		lblSubtitle.setBounds(114, 415, 141, 27);
		panel.add(lblSubtitle);

		JLabel lblGame = new JLabel("Game");
		lblGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblGame.setFont(new Font("ROG Fonts", Font.BOLD, 36));
		lblGame.setForeground(new Color(58, 162, 140));
		lblGame.setBounds(91, 300, 181, 83);
		panel.add(lblGame);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("ROG Fonts", Font.BOLD, 36));
		JLabel label = new JLabel("");

		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				xx = e.getX();
				xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {

				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				loginPage.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(-74, -101, 420, 591);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(loginPage.class.getResource("/images/maingreen2.png")));
		panel.add(label);

		button = new Button("Login");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(58, 162, 140));
		button.setBounds(395, 295, 283, 36);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				String passW=String.valueOf(password.getPassword());
				User testUser;
				UserVerify newUser = new UserVerify(user, passW);
				try {
					testUser = newUser.getUser();
					if (testUser == null) {
						JOptionPane.showMessageDialog(null, "User Login Information Not Found", "Error", JOptionPane.WARNING_MESSAGE);
					}
					else { 
						mainUser = testUser;
						dispose();
						new MainPage(mainUser);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});
		contentPane.add(button);

		username = new JTextField();
		username.setBounds(395, 150, 283, 36);
		username.setForeground(Color.BLACK);

		contentPane.add(username);
		username.setColumns(10);

		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(395, 126, 114, 14);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(395, 212, 96, 14);
		contentPane.add(lblPassword);

		password = new JPasswordField();
		password.setBounds(395, 232, 283, 36);
		contentPane.add(password);

		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(58, 162, 140));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);

		guestUser = new Button("Login as Guest");
		guestUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		guestUser.setForeground(Color.WHITE);
		guestUser.setBackground(new Color(58, 162, 140));
		guestUser.setBounds(395, 348, 283, 36);
		guestUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mainUser = new User("Guest","Guest","Guest",new java.sql.Date(111,0,23),-1);
				dispose();
				new MainPage(mainUser);
			}
			
		});
		contentPane.add(guestUser);


		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(58, 162, 140));
		//lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcome.setBounds(395, 16, 283, 83);
		contentPane.add(lblWelcome);

		lblCreateAccount = new JLabel("<HTML><U>Create Account</U></HTML>");
		lblCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setForeground(new Color(58, 162, 140));
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCreateAccount.setBounds(395, 391, 283, 27);
		contentPane.add(lblCreateAccount);
		lblCreateAccount.addMouseListener(this);
		
		lblForgotPassword = new JLabel("<HTML><U>Forgot Password?</U></HTML>");
		lblForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotPassword.setForeground(new Color(58, 162, 140));
		lblForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblForgotPassword.setBounds(395, 410, 283, 27);
		contentPane.add(lblForgotPassword);
		lblForgotPassword.addMouseListener(this);
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == lblCreateAccount) {
			this.dispose();
			new CreateAccountPage();
		}
		if(e.getSource() == lblForgotPassword) {
			this.dispose();
			new ForgotPasswordPage();
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}