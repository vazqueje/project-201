import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

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
import javax.swing.JTextArea;

public class newRequestPage extends JFrame implements ActionListener{
	private JTextField gameEntry;
	private JButton gameSubmit;
	private JTextArea textArea;
	private JButton returnMainPage;
	private JPanel contentPane;
	private User mainUser;
	int xx,xy;

	/**
	 * Create the frame.
	 */
	public newRequestPage(User user) {
		mainUser = user;
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 800);
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
				cover.setBounds(0, 59, 835, 356);
				contentPane.add(cover);
				cover.setIcon(new ImageIcon(loginPage.class.getResource("/images/cyberpunk.jpg")));
		
		//create panel to display catalog entries
		JPanel profilePanel = new JPanel();
		
		profilePanel.setBackground(Color.WHITE);
		profilePanel.setLayout(null);
		profilePanel.setBounds(0, 317, 835, 490);
		contentPane.add(profilePanel);
		
		gameSubmit = new JButton("Submit Request");
		gameSubmit.setBounds(514, 414, 164, 63);
		gameSubmit.setForeground(Color.DARK_GRAY);
		gameSubmit.setFocusPainted(false);
		gameSubmit.setBorder(emptyBorder);
		gameSubmit.setBackground(new Color(25,24,26));
		gameSubmit.addActionListener(this);
		profilePanel.add(gameSubmit);
		
		JLabel gameTitle = new JLabel("Video Game:");
		gameTitle.setBounds(10, 150, 192, 70);
		gameTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		JLabel reasonTitle = new JLabel("Reason:");
		reasonTitle.setBounds(10, 231, 192, 70);
		reasonTitle.setFont(new Font("Tahoma", Font.PLAIN, 24));
		profilePanel.add(gameTitle);
		profilePanel.add(reasonTitle);
		
		gameEntry = new JTextField(100);
		gameEntry.setBorder(new LineBorder(new Color(51, 51, 51), 3));
		gameEntry.setBounds(225, 166, 453, 51);
		profilePanel.add(gameEntry);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(51, 51, 51), 3));
		textArea.setBounds(225, 231, 453, 172);
		profilePanel.add(textArea);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == returnMainPage) {
			this.dispose();
			new MainPage(mainUser);
		}
		else if (e.getSource() == gameSubmit) {
			if (gameEntry.getText().isEmpty()) return;
			else {
				RequestFormFiller request = new RequestFormFiller(gameEntry.getText(), textArea.getText(), mainUser.getUsername());
				try {
					if(request.fillForm()) {
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
			this.dispose();
			new newRequestPage(this.mainUser);
		}
	}
}
