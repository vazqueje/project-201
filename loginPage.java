import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginPage implements ActionListener {
	//NEWUSER 
	JPasswordField password = new JPasswordField();
	JTextField username = new JTextField();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	public loginPage() {

		frame.add(panel);
		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST CATALOG LOGIN");
		panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 25, 150));
		panel.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		JLabel passwordLabel = new JLabel("Password:");
		usernameLabel.setBounds(10, 10, 100, 20);
		passwordLabel.setBounds(10, 40, 100, 20);
		username.setBounds(100, 10, 150, 20);
		password.setBounds(100, 40, 150, 20);
		
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(username);
		panel.add(password);
		
		JButton loginButton = new JButton("Log in");
		loginButton.setBounds(100, 70, 100, 20);
		loginButton.addActionListener(this);
		panel.add(loginButton);

		frame.setVisible(true);
	
	}
	
	public static void main(String[] args) {
		new MainPage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = username.getText();
		String passW = password.getText();
		User testUser;
		UserVerify newUser = new UserVerify(user, passW);
		
		try {
			 testUser = newUser.getUser();
			if (testUser == null) {
				JOptionPane.showMessageDialog(null, "User Login Information Not Found", "Error", JOptionPane.WARNING_MESSAGE);
			}
			else { 
				
				frame.dispose();
				new MainPage();
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
