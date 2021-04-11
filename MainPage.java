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
	User mainUser;
	JTextField searchBar = new JTextField(20);
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton requestPageButton = new JButton("Request New Game");
	JButton favoritesPage = new JButton("Favorites Page");
	JButton adminPage = new JButton("Admin Page");
	JButton searchButton = new JButton("Search");
	JButton commentSectionSearch = new JButton("Comment Section Page");
	JTextField commentBar = new JTextField(20);
	JButton banPageButton = new JButton("Ban Page");
	
	ArrayList<JButton> list = new ArrayList<JButton>();
	JButton button;
	int esrb = 0;
	
	public MainPage(User user) {
		mainUser = user;
		int age = mainUser.getAge();
		if (age >= 18) esrb = 4;
		else if (age >=17) esrb = 3;
		else if (age >= 13) esrb = 2;
		else if (age >= 10) esrb = 1;
		if (mainUser.getUsername().equals("Guest")) esrb = 0;
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
		
		searchButton.setSize(100, 20);
		searchButton.addActionListener(this);
		topPanel.add(searchButton);
		
		if (mainUser.getPrivileges() != -1) {
		requestPageButton.addActionListener(this);
		topPanel.add(requestPageButton);
		
		favoritesPage.addActionListener(this);
		topPanel.add(favoritesPage);
		}
		if (mainUser.getPrivileges() == 2) {
			adminPage.addActionListener(this);
			topPanel.add(adminPage);
			banPageButton.addActionListener(this);
			topPanel.add(banPageButton);
		}
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == banPageButton) {
			frame.dispose();
			new BanPage(mainUser);
		}
		else if (e.getSource() == requestPageButton) {
			frame.dispose();
			new reguestFormPage(mainUser);
		}
		else if(e.getSource() == favoritesPage) {
			frame.dispose();
			new FavoritesPageGUI(mainUser);
		}
		else if (e.getSource() == adminPage) {
			frame.dispose();
			new AdminPage(mainUser);
		}
		else if (e.getSource() == searchButton){
		String searchString = searchBar.getText();
		if (searchString.isEmpty()) return;
		Search newSearch = new Search(searchString);
		ArrayList<Entry> entries = newSearch.fetchSearch(searchString);
		if (entries == null) {
			JOptionPane.showMessageDialog(null, "Please Try Again", "Search Not Found", JOptionPane.WARNING_MESSAGE);
		}
		else {
		bottomPanel.removeAll();
		if (list != null) list.clear();
		for ( int i = 0; i < entries.size(); i++) {
			if (esrb >= ESRBtoInt(entries.get(i).getEsrbRating())) {
			JPanel panel = createEntryPanel(entries.get(i));
			bottomPanel.add(panel);
			}
		}
		}
		frame.setVisible(true);
		}
		else {
			for (int i = 0; i < list.size(); i++) {
				if (e.getSource() == list.get(i)) {
					String commentPage = list.get(i).getText();
					Search newSearch = new Search(commentPage);
					ArrayList<Entry> entries = newSearch.fetchSearch(commentPage);
					frame.dispose();
					new commentPage(mainUser, entries.get(0));
				}
			}
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
		
		button = new JButton(entry.getName());
		button.addActionListener(this);
		retPanel.add(button);
		list.add(button);
		
		JLabel space = new JLabel("----------");
		retPanel.add(space);
		
		return retPanel;
	}
	
	public int ESRBtoInt(String rating) {
		int ret = 0;
		if (rating.equalsIgnoreCase("RP")) ret = 4;
		else if (rating.equalsIgnoreCase("A")) ret = 4;
		else if (rating.equalsIgnoreCase("M")) ret = 3;
		else if (rating.equalsIgnoreCase("T")) ret = 2;
		else if (rating.equalsIgnoreCase("E10")) ret = 1;
		return ret;
	}
	
}
