import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminPage extends JFrame {

	User user;
	Statement stmt;
	ResultSet rs;
	JButton approveButton;
	JButton denyButton;
	JTextArea requestTA;
	String currentRequest;
	JButton back;
	public AdminPage(User user) { 
			super("Admin page");
			setTitle("Admin Page");
	        setSize(600, 500);
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.user = user;
			
			//Jframe items
			Container container = getContentPane();
			container.setLayout(new BorderLayout());
			approveButton = new JButton("Approve");
			denyButton = new JButton("Deny");
			back = new JButton("Back");
			//current request panel
			requestTA = new JTextArea(10, 50);
			requestTA.setEditable(false);
			// create a scrollPane object
			JScrollPane scrollPane = new JScrollPane(requestTA);
			JPanel displayRequestPanel = new JPanel();
			displayRequestPanel.setBorder(new TitledBorder("Pending Request"));
			
			displayRequestPanel.add(scrollPane);
			//back
			JPanel backPanel = new JPanel();
			backPanel.setBorder(new TitledBorder("Back to Main Page"));
			backPanel.add(back);
			back.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					new MainPage(user);
				}
				
			});
			//button panel
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBorder(new TitledBorder("Approve or Deny the Pending Request"));
			
			buttonPanel.add(approveButton);
			
			
			buttonPanel.add(denyButton);
			
			
			//add to container
			container.add(backPanel, BorderLayout.NORTH);
			container.add(buttonPanel, BorderLayout.CENTER);
			container.add(displayRequestPanel, BorderLayout.SOUTH);
			
			
			


			try {
				 //create query statement
				Connection con = SQLConnection.getConnection();
				 stmt = con.createStatement();
				 String query = "SELECT * FROM request;";
				 //execute query
				 rs = stmt.executeQuery(query);
				 
				 //if there is no next row, tell the user there were no matches
				 if (rs.next() == false) {
				        System.out.println("There are currently no pending requests.");
				      } else {
				 //else, add rows in result set to an ArrayList of type Entry
				        
				          currentRequest = "Name: "+(rs.getString("name")+"\nDesc:"+ rs.getString("description")+"\nUsername: "+rs.getString("username"));
				          int currentID = rs.getInt("id");
				          requestTA.setText(currentRequest);
				          approveButton.addActionListener(new ActionListener() {

				  			@Override
				  			public void actionPerformed(ActionEvent e) {
				  				try {
				  					Statement add = con.createStatement();
				  					add.execute("INSERT INTO accepted_request(name, description, username, id) VALUES(\""+rs.getString("name")+"\", \""+rs.getString("description")+"\", \""+rs.getString("username")+"\", \""+rs.getInt("id")+"\");");
									Statement delete = con.createStatement();
									delete.executeQuery("DELETE FROM request WHERE id=\""+currentID+"\";");
									//eventually prompts admin user to add a new entry
									rs.next();
									currentRequest = "Name: "+(rs.getString("name")+"\nDesc:"+ rs.getString("description")+"\nUsername: "+rs.getString("username"));
							          int currentID = rs.getInt("id");
							          requestTA.setText(currentRequest);
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				  				
				  				
				  			}
				  			
				  		});
				          
				          denyButton.addActionListener(new ActionListener() {

					  			@Override
					  			public void actionPerformed(ActionEvent e) {
					  				try {
										Statement delete = con.createStatement();
										delete.executeQuery("DELETE FROM request WHERE id=\""+currentID+"\";");
										currentRequest = "Name: "+(rs.getString("name")+"\nDesc:"+ rs.getString("description")+"\nUsername: "+rs.getString("username"));
								        int currentID = rs.getInt("id");
								        requestTA.setText(currentRequest);
					  				} catch (SQLException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					  			}
					  			
					  		});
				        
				      }
	}catch (Exception e) {
		e.printStackTrace();
	}
}
	

	

	
	

	

}
