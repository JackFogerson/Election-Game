import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	State id;
	Statistics s = new Statistics();
	
	public MainPage(String c){
		candidate = c;
		launchFrame();
	}
	
	public void launchFrame(){
		// Instantiate the frame
		mainFrame = new JFrame("2016 - " + candidate + " Portal");
		mainFrame.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		JButton pollButton = new JButton("Current Polls");
		JButton campaignButton = new JButton("Start campaigning!");
		JButton restartButton = new JButton("Restart");
		
		pollButton.addActionListener(event -> pollFrame());
		campaignButton.addActionListener(event -> campaign(s));
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
	
	public void pollFrame(){
		// Instantiate the frame
		JFrame pollFrame = new JFrame("Polls");
		pollFrame.setLayout(new GridBagLayout());
		String[] StateList = new String[s.accounts.size()];
		for(int i=0; i<s.accounts.size(); i++) {
			StateList[i] = ("" + s.accounts.get(i).getName());
		}

		
		GridBagConstraints c = new GridBagConstraints();
		
		JButton pollButton = new JButton("National Polls");
		JButton HomeButton = new JButton("Home");
		JComboBox statesPoll = new JComboBox(StateList);
				
		pollButton.addActionListener(event -> JOptionPane.showMessageDialog(null, 
				"Trump: " + s.getPoll("Trump") + "%" + "\n" + "Clinton: " + s.getPoll("Clinton") + "%"
				+ "\n" + "Johnson: " + s.getPoll("Johnson") + "%" + "\n" + "Stein: " 
				+ s.getPoll("Stein") + "%" + "\n" + "McMullin: " + s.getPoll("McMullin") + "%" + "\n"));
		statesPoll.addActionListener(event -> statePoll((String) statesPoll.getSelectedItem(),s));
		HomeButton.addActionListener(event -> pollFrame.dispose());
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		pollFrame.add(pollButton, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		pollFrame.add(statesPoll, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 2;
		c.gridy = 0;
		c.ipady = 50;
		c.weighty = 1;
		pollFrame.add(HomeButton, c);
		
		// Finalize the frame.
		pollFrame.setSize(new Dimension(650, 500));
		pollFrame.setResizable(false);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		pollFrame.setLocation(d.width/2-pollFrame.getSize().width/2, d.height/2-pollFrame.getSize().height/2);
		pollFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pollFrame.setVisible(true);	
	}
	
	public void statePoll(String state, Statistics s){
		for(int i=0;i<s.accounts.size();i++) {
			if(state.equals(s.accounts.get(i).getName())) {
					id = s.accounts.get(i);
					JOptionPane.showMessageDialog(null, 
							"Trump: " + id.getRep() + "%" + "\n" + "Clinton: " + id.getDem() + "%"
							+ "\n" + "Johnson: " + id.getLib() + "%" + "\n" + "Stein: " 
							+ id.getGreen() + "%" + "\n" + "McMullin: " + id.getMcM() + "%" + "\n", state, JOptionPane.INFORMATION_MESSAGE, null);
					break;
			}
		}		
	}
	
	public int logOut(){
		JOptionPane.showMessageDialog(null, "Oof!");
		mainFrame.dispose();
		new StartScreen();
		return 1;
	}
	
	public void campaign(Statistics s) {
		mainFrame.dispose();
		new Events(candidate,s);
	}	
}