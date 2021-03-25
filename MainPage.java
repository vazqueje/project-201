import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainPage implements ActionListener{
	
	JTextField searchBar = new JTextField();
	
	public MainPage() {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.add(panel);
		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST CATALOG MainPage");
		panel.setBorder(BorderFactory.createEmptyBorder(150, 150, 25, 150));
		panel.setLayout(null);
		
		JLabel searchLabel = new JLabel("Search: ");
		searchLabel.setBounds(10, 10, 100, 20);
		searchBar.setBounds(100, 10, 150, 20);
		
		panel.add(searchLabel);
		panel.add(searchBar);
		
		JButton searchButton = new JButton("Search");
		searchButton.setBounds(100, 50, 100, 20);
		searchButton.addActionListener(this);
		panel.add(searchButton);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String searchString = searchBar.getText();
		Search newSearch = new Search(searchString);
		ArrayList<Entry> entries = newSearch.fetchSearch(searchString);
		for ( int i = 0; i < entries.size(); i++) {
			System.out.println(entries.get(i));
		}
		
	}
}
