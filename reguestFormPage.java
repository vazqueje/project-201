import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class reguestFormPage implements ActionListener{
	User mainUser;
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JTextField title = new JTextField(20);
	JTextField reason = new JTextField(20);
	JButton exitPage = new JButton("Main Menu");
	
	public reguestFormPage(User user) {
		mainUser = user;
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST CATALOG RequestPage");
		frame.add(mainPanel);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/iconlogo.png")));

		mainPanel.setLayout(new GridLayout(3,2));
		
		JLabel name = new JLabel("Title:");
		JLabel description = new JLabel("Reason:");
		JButton request = new JButton("Request");
		request.addActionListener(this);
		exitPage.addActionListener(this);
		
		mainPanel.add(name);
		mainPanel.add(title);
		mainPanel.add(description);
		mainPanel.add(reason);
		mainPanel.add(request);
		mainPanel.add(exitPage);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitPage) {
			frame.dispose();
			new MainPage(mainUser);
		}
		else {
		String name = title.getText();
		String description = reason.getText();
		if (name == null || name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Title is unfilled", "Please Submit a Game Title", JOptionPane.WARNING_MESSAGE);
			return;
		};
		RequestFormFiller requestForm = new RequestFormFiller(name, description, "TestUser");
		try {
			if(requestForm.fillForm()) {
				JOptionPane.showMessageDialog(null, "Request Added", "Game request Successful", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Request not Added", "Game request Failed", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	}
}
