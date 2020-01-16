import javax.swing.JFrame;

/**
 * @title	StartScreen.java
 * @author 	Jack Fogerson
 * @desc	Class handles Setting up Starting screen for the Game
 */

public class StartScreen {
	//Initialize Variables
	JFrame startScreenFrame;
	String candidate;
	
	//LoginScreen constructor
	//Defaults variables as null/false, gets user database, and launches login frame
	public StartScreen(){
		startScreenFrame = null;
		candidate = null;
		//launchLoginFrame();
	}
}
