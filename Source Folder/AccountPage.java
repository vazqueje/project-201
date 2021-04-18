import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AccountPage implements ActionListener{

	User mainUser;
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton backButton = new JButton("Main Menu");
	
	
	public AccountPage(User user) {
		mainUser = user;
		frame.add(topPanel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST CATALOG Profile Page");
		frame.add(mainPanel);
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
		
		backButton.addActionListener(this);
		topPanel.add(backButton);
		
		JLabel Username = new JLabel("Username: " + mainUser.getUsername());
		JLabel Password = new JLabel("Password: " + mainUser.getPassword());
		JLabel dob = new JLabel("Date of Birth: " + mainUser.getDob());
		
		bottomPanel.add(Username);
		bottomPanel.add(Password);
		bottomPanel.add(dob);
		
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == backButton) {
			frame.dispose();
			new MainPage(mainUser);
		}
	}
	
}
