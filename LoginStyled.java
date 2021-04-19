import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Button;
import java.awt.SystemColor;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.*;
public class LoginStyled extends JFrame implements ActionListener {
	User mainUser;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	Button guestUser;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStyled frame = new LoginStyled();
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
	 * Create the frame.
	 */
	public LoginStyled() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 490);
		setLocationRelativeTo(null);
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
		lblCatalog.setForeground(new Color(240, 248, 255));
		lblCatalog.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCatalog.setBounds(68, 312, 227, 70);
		panel.add(lblCatalog);
		
		JLabel lblWeGotYou = new JLabel("Powered by GamersInc.");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeGotYou.setBounds(114, 410, 141, 27);
		panel.add(lblWeGotYou);
		
		JLabel lblNewLabel = new JLabel("Game");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(91, 254, 181, 83);
		panel.add(lblNewLabel);
		
		JLabel lblWelcome = new JLabel("Welcome");
		try {
		     //Returned font is of pt size 1
		     Font font = Font.createFont(Font.TRUETYPE_FONT, new File("QuadUltra.ttf"));
		     GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     genv.registerFont(font);
		     font = font.deriveFont(48f);
		     //Derive and return a 12 pt version:
		     //Need to use float otherwise
		     //it would be interpreted as style

		     lblCatalog.setFont(font);
		     lblNewLabel.setFont(font);
		     lblWelcome.setFont(font);
		     //titleLabel3.setFont(font);

		} catch (IOException|FontFormatException e) {
		     // Handle exception
		}
		
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
	            LoginStyled.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(-74, -101, 420, 591);
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setIcon(new ImageIcon(LoginStyled.class.getResource("/images/main.png")));
		panel.add(label);
		
		Button button = new Button("Login");
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(153, 50, 204));
		button.setBounds(395, 295, 283, 36);
		contentPane.add(button);
		
		username = new JTextField();
		username.setBounds(395, 150, 283, 36);
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
		lbl_close.setForeground(new Color(153, 50, 204));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		guestUser = new Button("Login as Guest");
		guestUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		guestUser.setForeground(Color.WHITE);
		guestUser.setBackground(new Color(153, 50, 204));
		guestUser.setBounds(395, 348, 283, 36);
		contentPane.add(guestUser);
		
		
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setForeground(new Color(153, 50, 204));
		//lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblWelcome.setBounds(395, 16, 283, 83);
		contentPane.add(lblWelcome);
		
		JLabel lblCreateAccount = new JLabel("<HTML><U>Create Account</U></HTML>");
		lblCreateAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setForeground(new Color(153, 50, 204));
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCreateAccount.setBounds(395, 391, 283, 27);
		contentPane.add(lblCreateAccount);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String user = username.getText();
		@SuppressWarnings("deprecation")
		String passW=String.valueOf(password.getPassword());
		if (e.getSource() == guestUser) {
			mainUser = new User("Guest","Guest","Guest",new java.sql.Date(111,0,23),-1,false);
			this.dispose(); 
			new MainPage(mainUser);
		}
		else {
		User testUser;
		UserVerify newUser = new UserVerify(user, passW);
		
		try {
			 testUser = newUser.getUser();
			if (testUser == null) {
				JOptionPane.showMessageDialog(null, "User Login Information Not Found", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else { 
				mainUser = testUser;
				this.dispose();
				new MainPage(mainUser);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}

}