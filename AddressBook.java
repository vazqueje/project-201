/**
 * A Simple Address Book Application
 * File: AddressBook.java
 * @author Jessica Vazquez-Estrada
 * 17 March 2020
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class AddressBook extends JFrame implements ActionListener {
	//attributes
	private JLabel name, address, phone, email;
	private JTextField namef, addressf, phonef, emailf;
	private JButton add,save;
	private JTextArea contactsTextArea;
	private JPanel panel;
	private static final int WIDTH = 670;
	private static final int HEIGHT = 550;
			
	//constructor
	public AddressBook() {
		//initialize components
		name = new JLabel("Name:   ");
		namef = new JTextField(50);
		
		address = new JLabel("Address: ");
		addressf = new JTextField(50);
		
		phone = new JLabel("Phone:  ");
		phonef = new JTextField(50);
		
		email = new JLabel("Email:   ");
		emailf = new JTextField(50);
		
		add = new JButton("Add Contact");
		save = new JButton("Save to File");
		
		contactsTextArea = new JTextArea(20,50);
		contactsTextArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(contactsTextArea);
		//add ActionListener to buttons
		add.addActionListener(this);
		save.addActionListener(this);
		
		//initialize panel
		panel = new JPanel();
		//add components to the panel
		panel.add(name);
		panel.add(namef);
		panel.add(address);
		panel.add(addressf);
		panel.add(phone);
		panel.add(phonef);
		panel.add(email);
		panel.add(emailf);
		panel.add(add);
		panel.add(save);
		panel.add(contactsTextArea);
		panel.setBorder(new TitledBorder("Border Title"));
		//add panel to JFrame
		add(panel);
		
		readContactsFromFile();
	}
	

	
	/**
	 * readContactsFromFile
	 * Reads all the contacts from the file contacts.txt
	 * and constructs a String object 
	 */
	public void readContactsFromFile() {
		File input = null;
		Scanner reader = null;
		String contactsList = null;
		try {
			input = new File("contacts.txt");
			reader = new Scanner(input);
			
			while(reader.hasNextLine()) {
				contactsList = contactsList + "\n"+reader.nextLine();
			}
		}catch(FileNotFoundException e) {
			System.out.println("There was an error in reading the file.");
		}finally {
			reader.close();
		}
		contactsTextArea.setText(contactsList);
	}
	
	/**
	 * writeContactsToFile
	 * gets the text from the contactsAreaText text area and
	 * writes it to the file contacts.txt
	 */
	public void writeContactsToFile() {
		File output = null;
		PrintWriter fileWriter = null;
		try {
			output = new File("contacts.txt");
			fileWriter = new PrintWriter(output);
			fileWriter.println(contactsTextArea.getText());
		}catch(FileNotFoundException e) {
			System.out.println("Something went wrong in writing to the file.");
		}finally {
			fileWriter.close();
		}
	}
	
	@Override
	/**
	 * If the add button is pressed, the text in the text fields is added
	 * to the text area.
	 * If the save button is pressed, the text in the text area gets
	 * written to the file. 
	 */
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals("Add Contact")) {
			contactsTextArea.append("\n"+namef.getText()+", "+addressf.getText()+", "+phonef.getText()+", "+emailf.getText());
		}else if(event.getActionCommand().contentEquals("Save to File")) {
			writeContactsToFile();
		}
	}
	
	public static void main(String[]args) {
		//create address book object
		AddressBook ad = new AddressBook();
		ad.setSize(WIDTH,HEIGHT);
		ad.setTitle("Address Book Application");
		ad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ad.setVisible(true);
	}
}
