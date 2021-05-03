import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

public class newAdminPage extends JFrame implements ActionListener{
	private JButton approveButton;
	private JButton denyButton;
	private JTextArea requestTA;
	private JButton returnMainPage;
	private JPanel contentPane;
	private JButton banUserButton;
	private JTextArea banField;
	private User mainUser;
	private String currentRequest;
	private Statement stmt;
	private ResultSet rs;
	Connection con = SQLConnection.getConnection();
	int currentID = 0;
	int xx,xy;

	/**
	 * Constructor for new Admin Page GUI
	 */
	public newAdminPage(User user) {
		mainUser = user;
		setUndecorated(true);
		setVisible(true);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 800);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/iconlogo.png")));

		
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
		

		
		returnMainPage = new JButton("Home");
		returnMainPage.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
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
		
		//approve button for requests
		approveButton = new JButton("Approve");
		approveButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		approveButton.setBounds(10, 321, 164, 63);
		approveButton.setForeground(new Color(255, 255, 255));
		approveButton.setFocusPainted(false);
		approveButton.setBorder(emptyBorder);
		approveButton.setBackground(new Color(25,24,26));
		approveButton.addActionListener(this);
		profilePanel.add(approveButton);
		
		//displays the request
		requestTA = new JTextArea();
		requestTA.setBorder(new LineBorder(new Color(51, 51, 51), 3));
		requestTA.setBounds(10, 125, 453, 172);
		profilePanel.add(requestTA);
		
		//deny button for requests
		denyButton = new JButton("Deny");
		denyButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		denyButton.setForeground(new Color(255, 255, 255));
		denyButton.setFocusPainted(false);
		denyButton.setBackground(new Color(25, 24, 26));
		denyButton.setBounds(299, 321, 164, 63);
		denyButton.addActionListener(this);
		profilePanel.add(denyButton);
		
		JLabel lblNewLabel = new JLabel("Current Request:");
		lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 100, 164, 23);
		profilePanel.add(lblNewLabel);
		
		JLabel banUserLabel = new JLabel("Ban User:");
		banUserLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 16));
		banUserLabel.setBounds(483, 100, 164, 23);
		profilePanel.add(banUserLabel);
		
		//field to type in the username of the person you want banned
		banField = new JTextArea();
		banField.setBorder(new LineBorder(new Color(51, 51, 51), 3));
		banField.setBounds(483, 125, 321, 36);
		profilePanel.add(banField);
		
		//button for banning users
		banUserButton = new JButton("Ban");
		banUserButton.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		banUserButton.setForeground(new Color(255, 255, 255));
		banUserButton.setFocusPainted(false);
		banUserButton.setBackground(new Color(25, 24, 26));
		banUserButton.setBounds(568, 172, 164, 63);
		banUserButton.addActionListener(this);
		profilePanel.add(banUserButton);
		
		try {
			 //create query statement
			 stmt = con.createStatement();
			 String query = "SELECT * FROM request;";
			 //execute query
			 rs = stmt.executeQuery(query);
			 
			 //if there is no next row, tell the user there were no matches
			 if (!(rs.next())) {
				 System.out.println("yes");
			        currentRequest = "There are currently no pending requests.";
			        requestTA.setText(currentRequest);
			      } else {
			 //else, add rows in result set to an ArrayList of type Entry
			        
			          currentRequest = "Name: "+(rs.getString("name")+"\nDesc:"+ rs.getString("description")+"\nUsername: "+rs.getString("username"));
			          currentID = rs.getInt("id");
			          requestTA.setText(currentRequest);
			      }
}catch (Exception e) {
	e.printStackTrace();
}
}

	@Override
	/**
	 * actionperformed method takes into account for approval button, denial button, banUser button, and return to mainpage button
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == approveButton) {
			try {
				    System.out.println("Current ID: "+ currentID);
					Statement add = con.createStatement();
					add.execute("INSERT INTO accepted_request(name, description, username, id) VALUES(\""+rs.getString("name")+"\", \""+rs.getString("description")+"\", \""+rs.getString("username")+"\", \""+rs.getInt("id")+"\");");
				Statement delete = con.createStatement();
				delete.executeQuery("DELETE FROM request WHERE id=\""+currentID+"\";");
				//eventually prompts admin user to add a new entry
				if(!(rs.next())) {
					currentRequest = "There are no more pending requests";
					requestTA.setText(currentRequest);
				}
				currentRequest = "Name: "+(rs.getString("name")+"\nDesc:"+ rs.getString("description")+"\nUsername: "+rs.getString("username"));
		          currentID = rs.getInt("id");
		          requestTA.setText(currentRequest);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == denyButton) {
			try {
					System.out.println("Current ID: "+ currentID);
				Statement delete = con.createStatement();
				delete.executeQuery("DELETE FROM request WHERE id=\""+currentID+"\";");
				if(!(rs.next())) {
					currentRequest = "There are no more pending requests";
					requestTA.setText(currentRequest);
				}
				currentRequest = "Name: "+(rs.getString("name")+"\nDesc:"+ rs.getString("description")+"\nUsername: "+rs.getString("username"));
		        currentID = rs.getInt("id");
		        requestTA.setText(currentRequest);
				} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource() == banUserButton) {
			String bannedUser = banField.getText();
			BanSQL banDB = new BanSQL(bannedUser);
			
			if(banDB.ban()) {
				JOptionPane.showMessageDialog(null, "User has been banned", "Ban operation was Successful", JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new newAdminPage(this.mainUser);
			}else {
				JOptionPane.showMessageDialog(null, "User was not found", "Ban operation failed", JOptionPane.WARNING_MESSAGE);
				this.dispose();
				new newAdminPage(this.mainUser);
			}
		}
		
		if(e.getSource() == returnMainPage) {
			this.dispose();
			new MainPage(this.mainUser);
		}
		
	}
	
}
