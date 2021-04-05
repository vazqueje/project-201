import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class commentPage implements ActionListener{
	User mainUser;
	Entry entry;
	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JButton returnButton = new JButton("Main Page");
	CommentSQL commentSQL;
	CommentSection comments;
	ArrayList<JButton> list = new ArrayList<JButton>();
	JButton button;
	JTextField commentTitle = new JTextField(30);
	JTextField commentDescription = new JTextField(25);
	JButton addComment = new JButton("Add Comment");
	
	public commentPage(User user, Entry entry) {
		mainUser = user;
		this.entry = entry;
		frame.add(topPanel);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("TEST CATALOG " + entry.getName());
		frame.add(mainPanel);
		mainPanel.setLayout(new GridLayout(2,1));
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		topPanel.setLayout(new FlowLayout());
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.PAGE_AXIS));
		if (mainUser.getPrivileges() != -1) {
		JLabel title = new JLabel("Comment Title:");
		topPanel.add(title);
		topPanel.add(commentTitle);
		
		JLabel desc = new JLabel("Description:");
		topPanel.add(desc);
		topPanel.add(commentDescription);
		
		addComment.addActionListener(this);
		topPanel.add(addComment);
		}
		returnButton.addActionListener(this);
		topPanel.add(returnButton);
		
		commentSQL = new CommentSQL(entry);
		CommentSection comments = commentSQL.getCommentSection();
		if (comments == null) {
			JLabel noComments = new JLabel("No Comments on Page");
			bottomPanel.add(noComments);
		}
		else {
		for ( int i = 0; i < comments.getmaxpid(); i++) {
			JPanel panel = createCommentPanel(comments.getComment(i));
			bottomPanel.add(panel);
		}
		}
		frame.setVisible(true);
	}
	
	public JPanel createCommentPanel(Comment comment) {
		JPanel retPanel = new JPanel();
		retPanel.setSize(100, 50);
		retPanel.setLayout(new BoxLayout(retPanel, BoxLayout.PAGE_AXIS));
		
		JLabel title = new JLabel(comment.getTitle());
		retPanel.add(title);
		
		JLabel description = new JLabel(comment.getDescription());
		retPanel.add(description);
		
		if (mainUser.getPrivileges() == 1 || mainUser.getPrivileges() == 2) { 
		button = new JButton("Remove: " + comment.getcommentid());
		button.addActionListener(this);
		retPanel.add(button);
		list.add(button);
		}
		
		JLabel space = new JLabel("----------");
		retPanel.add(space);
		return retPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == returnButton) {
			frame.dispose();
			new MainPage(mainUser);
		}
		else if (e.getSource() == addComment) {
			if (commentTitle.getText().length()==0 || commentDescription.getText().length()==0) {
				return;
			}
			String title = commentTitle.getText();
			String description =  commentDescription.getText();
			try {
				commentSQL.addComment(title, description, entry.getName());
				frame.dispose();
				new commentPage(mainUser, entry);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else {
			for (int i = 0; i < list.size(); i++) {
				if (e.getSource() == list.get(i)) {
					String str = list.get(i).getText().substring(8);
					int id = Integer.parseInt(str);
					try {
						commentSQL.removeComment(id);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			frame.dispose();
			new commentPage(mainUser, entry);
		}
	}
}
