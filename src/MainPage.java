import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.text.DecimalFormat;
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
	//initialize variables
	JFrame mainFrame;
	String candidate;
	State id;
	Statistics s = new Statistics();
	
	//sets candidate, launches frame
	public MainPage(String c){
		candidate = c;
		launchFrame();
	}
	
	//create main page frame
	public void launchFrame(){
		// Instantiate the frame
		mainFrame = new JFrame("2016 - " + candidate + " Portal");
		mainFrame.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		//layout for frame
		JButton pollButton = new JButton("Current Polls");
		JButton campaignButton = new JButton("Start campaigning!");
		JButton restartButton = new JButton("Restart");
		
		//events for button press
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
	
	//frame for getting poll results
	public void pollFrame(){
		// Instantiate the frame
		JFrame pollFrame = new JFrame("Polls");
		pollFrame.setLayout(new GridBagLayout());
		//list of states for drop down menu
		String[] StateList = new String[s.accounts.size()];
		for(int i=0; i<s.accounts.size(); i++) {
			StateList[i] = ("" + s.accounts.get(i).getName());
		}

		
		GridBagConstraints c = new GridBagConstraints();
		
		JButton pollButton = new JButton("National Polls");
		JButton HomeButton = new JButton("Home");
		JComboBox statesPoll = new JComboBox(StateList);
		
		//events for button presses
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
	
	//based on state selected, gets polling for that state
	public void statePoll(String state, Statistics s){
		//limit to 2 decimal places
	    DecimalFormat df2 = new DecimalFormat("#.##");
	    //iterate through states, if found get info and break loop
		for(int i=0;i<s.accounts.size();i++) {
			if(state.equals(s.accounts.get(i).getName())) {
					id = s.accounts.get(i);
					JOptionPane.showMessageDialog(null, 
							"Trump: " + df2.format(id.getRep()*100) + "%" + "\n" + "Clinton: " + df2.format(id.getDem()*100) + "%"
							+ "\n" + "Johnson: " + df2.format(id.getLib()*100) + "%" + "\n" + "Stein: " 
							+ df2.format(id.getGreen()*100) + "%" + "\n" + "McMullin: " + df2.format(id.getMcM()*100) + "%" + "\n", state, JOptionPane.INFORMATION_MESSAGE, null);
					break;
			}
		}		
	}
	
	//dispose frame and restart sim,
	//bug: music will play another iteration
	public void logOut(){
		mainFrame.dispose();
		new StartScreen();
	}
	
	//starts game process, leads to event frames
	public void campaign(Statistics s) {
		//removes frame, launches events
		mainFrame.dispose();
		new Events(candidate,s);
	}	
}