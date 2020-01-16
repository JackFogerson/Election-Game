import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @title	StartScreen.java
 * @author 	Jack Fogerson
 * @desc	Class handles Setting up Starting screen for the Game
 */

public class StartScreen {
	//Initialize Variables
	JFrame startScreenFrame;
	String candidate;
	
	//StartScreen constructor
	//Defaults variables as null and launches StartScreen frame
	public StartScreen(){
		startScreenFrame = null;
		candidate = null;
		launchStartScreenFrame();
	}
	
	//Launches StartScreen frame
	private void launchStartScreenFrame(){
		// Make the JFrame, and then make it a GridLayout.
		startScreenFrame = new JFrame("2016 Showdown: Choose your candidate!");
		startScreenFrame.setLayout(new GridLayout(4, 1));
		
		//Create all the parts necessary for the loginFrame
		JButton TrumpButton = new JButton   ("                 Trump                    ");
		JButton ClintonButton = new JButton ("                 Clinton                  ");
		JButton JohnsonButton = new JButton ("                 Johnson                  ");
		JButton SteinButton = new JButton   ("                 Stein                    ");
		JButton McMullinButton = new JButton("                 McMullin                 ");
		
		// Add all the components in order for the positioning in the frame.
		startScreenFrame.add(TrumpButton);
		startScreenFrame.add(ClintonButton);
		startScreenFrame.add(JohnsonButton);
		startScreenFrame.add(SteinButton);
		startScreenFrame.add(McMullinButton);


		//Make an action listener for candidate buttons
		TrumpButton.addActionListener(event -> candidateChoose("Trump"));
		ClintonButton.addActionListener(event -> candidateChoose("Clinton"));
		JohnsonButton.addActionListener(event -> candidateChoose("Johnson"));
		SteinButton.addActionListener(event -> candidateChoose("Stein"));
		McMullinButton.addActionListener(event -> candidateChoose("McMullin"));

		// Handle rest of the frame.
		startScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startScreenFrame.setSize(400, 100);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Sets frame to center of user's screen
		startScreenFrame.setLocation(d.width/2-startScreenFrame.getSize().width/2, d.height/2-startScreenFrame.getSize().height/2);
		startScreenFrame.pack();
		startScreenFrame.setVisible(true);
	}
	
	//Method once candidate has been chosen
	private void candidateChoose(String c) {
		candidate = c;
		if(candidate == "Trump") {
			JOptionPane.showMessageDialog(null, "Trump Message: To Be Added");
		}
		else if(candidate == "Clinton") {
			JOptionPane.showMessageDialog(null, "Clinton Message: To Be Added");
		}
		else if(candidate == "Johnson") {
			JOptionPane.showMessageDialog(null, "Johnson Message: To Be Added");
		}
		else if(candidate == "Stein") {
			JOptionPane.showMessageDialog(null, "Stein Message: To Be Added");
		}
		else if(candidate == "McMullin") {
			JOptionPane.showMessageDialog(null, "McMullin Message: To Be Added");
		}
		startScreenFrame.dispose();
		new MainPage();
	}
}
