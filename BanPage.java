import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BanPage extends JFrame implements ActionListener{
	User user;
	JLabel userLabel;
	JPanel banPanel;
	JTextField userField;
	JButton banButton;
	JButton back;	
	JLabel banStatus;	

	public BanPage(User user) {
		
		super("Ban page");
		this.user = user;
		
		setSize(600, 500);
        setLocationRelativeTo(null);
    
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
	
		banPanel = new JPanel();
		userLabel = new JLabel("Enter the username of the user you want to ban: ");
		userField = new JTextField(10);
		banButton = new JButton("Ban user");
		banButton.addActionListener(this);
		banStatus = new JLabel("");
		banStatus.setForeground(Color.red);

		back = new JButton("Back to main");
		back.addActionListener(this);
		banPanel.add(userLabel);
		banPanel.add(userField);
		banPanel.add(banButton);
		banPanel.add(banStatus);
		banPanel.add(back);
	
	
		add(banPanel);
	if (user.getmode()) { 
			banPanel.setBackground(Color.gray);
		
	} else {
			banPanel.setBackground(Color.white);
			
	 	}
	
	}
	
	 
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == banButton) {
			String bannedUser = userField.getText();
			BanSQL banDB = new BanSQL(bannedUser);
			
			if(banDB.ban()) {
				banStatus.setText("User has been banned");
				
			}else {
				banStatus.setText("User not found");
				
			}
		}
		
		else if (e.getSource()==back) {
			this.dispose();
			new MainPage(user);
		}
	}

	


}
