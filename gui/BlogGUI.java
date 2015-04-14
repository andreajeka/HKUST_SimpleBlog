package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;

import base.Post;
import base.User;
import blog.Blog;



public class BlogGUI {
	private JFrame mainFrame;
	private JPanel panel;
	private JLabel label;
	private JTextArea postTextArea;
	private JPanel southPanel;
	private JTextArea postContent;
	private JButton refresh;
	private JButton post;
	private User user;
	private Blog myBlog;
	private String savefilepath="A:/lab.blog";
	
	public BlogGUI() {
		user = new User(1, "andreajeka", "ajk@stu.ust.hk");
		myBlog = new Blog(user);
	}
	
	class postListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String content = postTextArea.getText();
			if (content.isEmpty()) {
				return;
			}
			if (content.length() > 140) {
				return;
			}
			
			Post newPost = new Post();
			newPost.setContent(postTextArea.getText());
			myBlog.post(newPost);
			myBlog.save(savefilepath);
			
			postTextArea.setText("");
			postContent.append(newPost.getContent() + "\n");
			label.setText("You can still input 140 Characters");
		}
		
	}
	
	class refreshListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			myBlog.load(savefilepath);
			ArrayList<Post> postList= myBlog.getList();
			postContent.setText("");
			for (Post p : postList) {
				postContent.append(p.getContent() + "\n");
			}
		}
		
	}
	
	class lengthListener implements KeyListener {
		
		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			int length = postTextArea.getText().length();
			if (length == 0) {
				post.setEnabled(false);
				label.setText("You can still input 140 Characters");
			}
			else if (length > 140) {
				label.setText("Your post length has exceeded 140!");
				post.setEnabled(false);
			} else {
				label.setText("You can still input " + (140 - length) + " Characters");
				post.setEnabled(true);
			}
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void setWindow() {
		
		// Set up the main frame
		mainFrame = new JFrame("Micro Blog Demo");
		Container pane = mainFrame.getContentPane();
		mainFrame.setSize(500, 500);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(new GridLayout(2,0));
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the first panel to hold label, text area, and 2 buttons
		panel = new JPanel();
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10,10,0,10),
				BorderFactory.createEtchedBorder()));
		panel.setLayout(new BorderLayout(10, 10));
		
		// Create the text area to post your text. Editable.
		postTextArea = new JTextArea(200,500);
		postTextArea.setBackground(new Color(255,255,180));
		String intro = "What's on your mind?";
		int introLength = intro.length();
		postTextArea.setText(intro);
		postTextArea.setFont(new Font("Segoe WP",Font.PLAIN,14));
		postTextArea.setLineWrap(true);
		postTextArea.setWrapStyleWord(true);
		postTextArea.addKeyListener(new lengthListener());
		
		// Create the label
		label = new JLabel("You can still input " + (140 - introLength) + " Characters");
		label.setFont(new Font("Segoe WP",Font.BOLD,18));
		
		// Create the second panel, will be nested inside the first panel
		southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(0,2));
		
		// Create the refresh button
		refresh = new JButton("Refresh");
		refresh.addActionListener(new refreshListener());
		refresh.setBackground(new Color(239, 86, 86));
		
		// Create the post button
		post = new JButton("Post");
		post.addActionListener(new postListener());
		post.setBackground(new Color(135, 206, 250));
		
		// Add the refresh and post buttons into the second panel
		southPanel.add(refresh, BorderLayout.WEST);
		southPanel.add(post, BorderLayout.EAST);
		
		// Add items into the panel
		panel.add(label, BorderLayout.NORTH);
		panel.add(postTextArea, BorderLayout.CENTER);
		panel.add(southPanel, BorderLayout.SOUTH);

		// Create a text field to post the content
		postContent = new JTextArea();
		postContent.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(10,10,10,10),
				BorderFactory.createEtchedBorder()));
		postContent.setEditable(false);
		postContent.setFont(new Font("Segoe WP",Font.BOLD,12));
		postContent.setWrapStyleWord(true);
		postContent.setBackground(Color.lightGray);
		
		
		// Add the created items into the content pane of the frame
		pane.add(panel);
		pane.add(postContent);
		
		// Make them visible
		mainFrame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		BlogGUI blogGUI = new BlogGUI();
		blogGUI.setWindow();
	}
}
