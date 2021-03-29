import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
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

public class MainPage implements ActionListener{
	JTextField searchBar = new JTextField(20);
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton requestPageButton = new JButton("Request New Game");
	
	public MainPage() {
	
		frame.add(topPanel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST CATALOG MainPage");
		frame.add(mainPanel);
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
		
		JLabel searchLabel = new JLabel("Search: ");
		searchLabel.setSize(100, 20);

		
		topPanel.add(searchLabel);
		topPanel.add(searchBar);
		
		JButton searchButton = new JButton("Search");
		searchButton.setSize(100, 20);
		searchButton.addActionListener(this);
		topPanel.add(searchButton);
		
		
		requestPageButton.addActionListener(this);
		topPanel.add(requestPageButton);
		
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == requestPageButton) {
			frame.dispose();
			new reguestFormPage();
		}
		else {
		String searchString = searchBar.getText();
		Search newSearch = new Search(searchString);
		ArrayList<Entry> entries = newSearch.fetchSearch(searchString);
		if (entries == null) {
			JOptionPane.showMessageDialog(null, "Please Try Again", "Search Not Found", JOptionPane.WARNING_MESSAGE);
		}
		else {
		bottomPanel.removeAll();
		for ( int i = 0; i < entries.size(); i++) {
			JPanel panel = createEntryPanel(entries.get(i));
			bottomPanel.add(panel);
			System.out.println(entries.get(i).toString());
		}
		}
		frame.setVisible(true);
		}
	}
	public JPanel createEntryPanel(Entry entry) {
		JPanel retPanel = new JPanel();
		retPanel.setSize(100, 50);
		retPanel.setLayout(new BoxLayout(retPanel, BoxLayout.PAGE_AXIS));
		
		JLabel nameLabel = new JLabel("Title: " + entry.getName());
		retPanel.add(nameLabel);
		
		JLabel genreLabel = new JLabel("Genre: " + entry.getGenre());
		retPanel.add(genreLabel);
		
		JLabel developerLabel = new JLabel("Developer: " + entry.getDeveloper());
		retPanel.add(developerLabel);
		
		JLabel publishDate = new JLabel("Publish Date: " + entry.getPublishDate().toString());
		retPanel.add(publishDate);

		JLabel descriptionLabel = new JLabel("Description: " + entry.getDescription());
		retPanel.add(descriptionLabel);
		
		JLabel space = new JLabel("----------");
		retPanel.add(space);
		
		return retPanel;
	}
}
