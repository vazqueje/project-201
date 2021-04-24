import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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

public class FavoritesPageGUI implements ActionListener {
	User mainUser;
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton returnButton = new JButton("Return to Main Page");

	ArrayList<JButton> list = new ArrayList<JButton>();
	JButton button;

	public FavoritesPageGUI(User user) {
		mainUser=user;
		frame.add(mainPanel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST CATALOG Favorites Page");
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
		returnButton.addActionListener(this);
		topPanel.add(returnButton);
		if (user.getmode()) { 
			mainPanel.setBackground(Color.gray);
			topPanel.setBackground(Color.gray);
			bottomPanel.setBackground(Color.gray);
	 	} else {
	 		mainPanel.setBackground(Color.white);
			topPanel.setBackground(Color.white);
			bottomPanel.setBackground(Color.white);
	 	}
		
		FavoriteListSQL f2 = new FavoriteListSQL(mainUser);
		FavoritesPage favPage = f2.displayFavorites();
		
		//ArrayList<Entry> entries = favPage.getGameList();
		if (favPage != null) {
			for (int i = 0; i < favPage.getGameListSize(); i++) {
				JPanel panel = createEntryPanel(favPage.getGameList().get(i),user);
				bottomPanel.add(panel);
			}
		}
		else {
			//JOptionPane.showMessageDialog(null, "No Games in Favorites", "No Favorites", JOptionPane.WARNING_MESSAGE);
			JLabel noFavorite = new JLabel("No Favorites on Page");
			bottomPanel.add(noFavorite);
		}
		frame.setVisible(true);
	}
	
	public JPanel createEntryPanel(Entry entry, User user) {

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
		if (user.getmode()) { 
			retPanel.setBackground(Color.gray);
			
	 	} else {
	 		
	 		retPanel.setBackground(Color.white);
	 	}
		button = new JButton(entry.getName());
		button.addActionListener(this);
		retPanel.add(button);
		list.add(button);
		
		JLabel space = new JLabel("----------");
		retPanel.add(space);
		 
		return retPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == returnButton) {
		frame.dispose();
		new MainPage(mainUser);
		}
		else {
			for (int i = 0; i < list.size(); i++) {
				if (e.getSource() == list.get(i)) {
					String game = list.get(i).getText();
					Search newSearch = new Search(game);
					ArrayList<Entry> entries = newSearch.fetchSearch(game);
					FavoriteListSQL list = new FavoriteListSQL(entries.get(0), mainUser);
					list.removeFavorite();
					frame.dispose();
					new FavoritesPageGUI(mainUser);
				}
			}
		}
	}
	
}
