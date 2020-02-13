import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
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
		startScreenFrame.setLayout(new GridLayout(3, 2));
		
		//plays TitleMusic
		audio();     
		
		//Create all candidate buttons for the loginFrame
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
		TrumpButton.addActionListener   (event -> candidateChoose("Trump"));
		ClintonButton.addActionListener (event -> candidateChoose("Clinton"));
		JohnsonButton.addActionListener (event -> candidateChoose("Johnson"));
		SteinButton.addActionListener   (event -> candidateChoose("Stein"));
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
	//gives rundown for each candidate
	private void candidateChoose(String c) {
		candidate = c;
		if(candidate == "Trump") {
			ImageIcon rp = new ImageIcon("RP_Photo.jpg");
			JOptionPane.showMessageDialog(null, 
					         "Donald Trump: To the surprise of most pundits, you were able to outlast and outfight 15 other candidates to accept the Republican nomination. A"
					+ "\n" + "controversial candidate, to say the least, now you must either move to a more unifying message for the general election or continue as you had during"
					+ "\n" + "the nomination in hopes of using your motivated base to carry you to victory. While you may seem like the underdog, Hillary Clinton is a candidate"
					+ "\n" + "with many exploitable flaws. Pulling off a win would be a great upset and allow you to change politics forever. The Republican Party is at your service. Good luck.", "Message from Reince Priebus", JOptionPane.INFORMATION_MESSAGE, rp);
		}
		else if(candidate == "Clinton") {
			ImageIcon dws = new ImageIcon("DWS_Photo.jpg");
			JOptionPane.showMessageDialog(null,
							 "Hillary Clinton: As a former first lady, congresswoman, and secretary of state, you have emerged as the democratic candidate for president"
					+ "\n" + "despite a unexpectedly brutal primary fight with previously unknown Senator Bernie Sanders. At first seen as the presumptive Democratic nominee,"
					+ "\n" + "you now must repair the fractured party and bring Democratic unity to the general election. You must now pivot towards the general election"
					+ "\n" + "against Donald Trump, who seems like a weak candidate but was able to outlast more conventional candidates during the republican primary."
					+ "\n" + "Hopefully, you can unify the fractured Democratic party and continue on with Obama's legacy, or forge your own visionfor the country. If you"
					+ "\n" + "can manage to keep a steady course, you will finally have the opportunity to hold the office you have desired for so long. The Democratic Party"
					+ "\n" + " is at your service. Good luck.", "Message from Debbie Wasserman Schultz", JOptionPane.INFORMATION_MESSAGE, dws);
		}
		else if(candidate == "Johnson") {
			ImageIcon ns = new ImageIcon("NS_Photo.jpg");
			JOptionPane.showMessageDialog(null, 
							 "Gary Johnson: As the former governor of New Mexico and the 2012 Libertarian nominee, you are now undertaking your 2nd long-shot run at the presidency."
					+ "\n" + "With both the Republican and Democratic parties producing weak nominees, this could be a once-in-a-generation chance to build a coalition"
					+ "\n" + "of moderates and dissatisfied voters to thrust the Libertarian party into the national spotlight and give the American people a true"
					+ "\n" + "alternative. This election gives us the chance to challenge the establishment political parties. Although there is a very low chance of outright" 
					+ "\n" + "winning the election, picking off a few states can force the election to the house, where you can influence who becomes president, or even become" 
					+ "\n" + "president yourself. The Libertarian party is at your service. Good luck.", "Message from Nicholas Sarwark", JOptionPane.INFORMATION_MESSAGE, ns);
		}
		else if(candidate == "Stein") {
			ImageIcon js = new ImageIcon("JS_Photo.jpg");
			JOptionPane.showMessageDialog(null, 
							 "Jill Stein: As the former green party candidate in 2012 and career physician/activist, you have once again recieved the nomination of the Green Party. With the unexpected"
					+ "\n" + "success of the progressive Bernie Sanders in the Democratic Party and the nomination of the unpopular Hillary Clinton, you hope to"
					+ "\n" + "gather those dissatisfied Bernie supporters and bring them into your fold and give the American people a true progressive alternative."
					+ "\n" + "Use the Green Party's resources to change America forever.", "Jill Stein", JOptionPane.INFORMATION_MESSAGE, js);
		}
		else if(candidate == "McMullin") {
			ImageIcon emm = new ImageIcon("EMM_Photo.jpg");
			JOptionPane.showMessageDialog(null, 
							 "Evan McMullin: As a former CIA operative and conservative Mormon, you are running as an independent on the behalf of never-Trump Republicans"
					+ "\n" + "in order to present a more traditional conservative alternative to Trump and represent a better version of the Republican Party."
					+ "\n" + "Most of your hopes rest in Utah, and potentially Idaho, where a combination of the unpopularity of Trump and your background"
					+ "\n" + "represents a chance to win the state. Hopefully you can harness Mormon hatred of Trump to your advantage. Good luck.", "Evan McMullin", JOptionPane.INFORMATION_MESSAGE, emm);
		}
		//after candidate message, dispose and begin game
		startScreenFrame.dispose();
		new MainPage(candidate);
	}
	
	//method for playing titlemusic
    public static void audio() {
    	//get music
        File file = new File("C:\\Users\\Jack\\git\\Election-Game\\TitleMusic.wav");
        //if found, play music in a loop
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } 
        //error: no file found
        catch (Exception e) {
            System.err.println("No Music File Found");
        }
    }    
}