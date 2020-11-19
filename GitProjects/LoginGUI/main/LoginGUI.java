package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI implements ActionListener {

	private static JButton button = new JButton();
	private static JLabel userLabel = new JLabel();
	private static JTextField userText = new JTextField();
	private static JLabel passLabel = new JLabel();
	private static JPasswordField passwordText = new JPasswordField();
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel success = new JLabel();
	private static JLabel fail = new JLabel();
	private static JLabel welcome = new JLabel();
	private static JLabel attempt = new JLabel();
	private static JLabel background = new JLabel();
	private static int counter = 3;
	private static JButton exit = new JButton();

	public static void main(String[] args) {
		//Frame creation
		frame = new JFrame();
		frame.setTitle("Login");
		frame.setSize(1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel background = new JLabel(new ImageIcon("C:\\Users\\savva\\Documents\\eclipse-ide-for-java-developers\\GitProjects\\LoginGUI\\main\\javabackground.jpg"));
		background.setSize(1280, 720);
		background.setBounds(0, 0, 1280, 720);
		//Creating the panel
		panel = new JPanel();
		panel.add(background);
		frame.add(panel);
		panel.setLayout(null);
		frame.setLocationRelativeTo(null);  
		//Username label
		userLabel = new JLabel("Username");
		userLabel.setBounds(400, 250, 400, 25);
		userLabel.setForeground(Color.white);
		userLabel.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(userLabel);
		//Username textbox
		userText = new JTextField(20);
		userText.setBounds(530, 250 , 300, 25);
		userText.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(userText);
		//Password label
		passLabel = new JLabel("Password");
		passLabel.setBounds(400, 300, 400, 25);
		passLabel.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(passLabel);
		passLabel.setForeground(Color.white);
		//Password textbox
		passwordText = new JPasswordField();
		passwordText.setBounds(530,300,300,25);
		passwordText.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(passwordText);
		//Login Button
		button = new JButton();
		button.setText("Login");
		button.setBounds(610, 360, 120, 50);
		button.setFont(new Font("Arial", Font.BOLD, 22));
		button.addActionListener(new LoginGUI());
		background.add(button);
		//Access granted or wrong info
		success = new JLabel("");
		success.setBounds(587, 425, 250, 25);
		success.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(success);
		fail = new JLabel("");
		fail.setBounds (540, 425, 300, 25);
		fail.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(fail);
		//Welcome message
		welcome = new JLabel();
		welcome.setBounds(563, 450, 250, 25);
		welcome.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(welcome);
		attempt = new JLabel();
		attempt.setBounds(563, 450, 250, 25);
		attempt.setFont(new Font("Arial", Font.BOLD, 22));
		background.add(attempt);
		//Exit button
		exit = new JButton("Exit"); 
		exit.setBounds(610, 485, 120, 50);
		exit.setFont(new Font("Arial", Font.BOLD, 22));
		exit.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				}
				); 
		background.add(exit);
		frame.getRootPane().setDefaultButton(button); //Press enter key to execute the login button
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String user = userText.getText();
		String pass = passwordText.getText();
		if(user.equals("Savvas") && pass.equals("Polydorou"))
		{
			success.setText("Access Granted");
			success.setForeground(Color.white);
			welcome.setText("Welcome Mr Savvas");
			welcome.setForeground(Color.white);
			fail.setText(null);
			attempt.setText(null);
			userText.setEditable(false);
			passwordText.setEditable(false);
			button.setEnabled(false);
		}
		else
		{
			fail.setText("Wrong Username/Password");
			fail.setForeground(Color.white);
			counter--;

			attempt.setForeground(Color.white);
			attempt.setText("You have " + counter + " attempts left");

			success.setText(null);
			welcome.setText(null);
			if(counter <= 0) 
			{
				button.setEnabled(false);
				userText.setEditable(false);
				passwordText.setEditable(false);
				Executors.newSingleThreadScheduledExecutor().schedule(() -> System.exit(0), 3, TimeUnit.SECONDS);
			}
		}
	}
}