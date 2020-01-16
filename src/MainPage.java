import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @title	MainPage.java
 * @author 	Jack Fogerson
 * @desc	Class handles Mainpage setup
 */

public class MainPage {
	JFrame mainFrame;
	String candidate;
	
	public MainPage(String c){
		candidate = c;
		launchFrame();
	}
	
	public void launchFrame(){
		// Instantiate the frame
		mainFrame = new JFrame("JackPass - " + candidate);
		mainFrame.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JButton pollButton = new JButton("Look at Polls");
		JButton campaignButton = new JButton("Start campaigning!");
		JButton restartButton = new JButton("Restart");
		
		//pollButton.addActionListener(event -> logOut());
		//removeAccountButton.addActionListener(event -> logOut());
		restartButton.addActionListener(event -> logOut());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		mainFrame.add(pollButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		mainFrame.add(campaignButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		mainFrame.add(restartButton, c);
		
		// Finalize the frame.
		mainFrame.setSize(new Dimension(650, 500));
		mainFrame.setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);	
	}
	
	public int logOut(){
		JOptionPane.showMessageDialog(null, "Oof");
		mainFrame.dispose();
		new StartScreen();
		return 1;
	}
	
}
