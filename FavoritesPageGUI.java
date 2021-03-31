import java.awt.event.ActionListener;
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

public class FavoritesPageGUI implements ActionListener {
	User mainUser;
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton returnButton = new JButton("Return to Main Page");
	
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
		
		FavoriteListSQL f2 = new FavoriteListSQL(mainUser);
		FavoritesPage favPage = f2.displayFavorites();
		
		ArrayList<Entry> entries = favPage.getGameList();
		if (entries != null) {
			for (int i = 0; i < entries.size(); i++) {
				JPanel panel = createEntryPanel(entries.get(i));
				bottomPanel.add(panel);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "No Games in Favorites", "No Favorites", JOptionPane.WARNING_MESSAGE);
		}
		frame.setVisible(true);
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
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new MainPage(mainUser);
	}

}
