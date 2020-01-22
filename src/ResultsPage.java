import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @title	ResultsPage.java
 * @author 	Jack Fogerson
 * @desc	Class handles ResultsPage setup
 */

public class ResultsPage {
	JFrame mainFrame;
	Statistics s;
	
	public ResultsPage(Statistics stat){
		this.s = stat;
		launchFrame();
	}
	
	public void launchFrame(){
		// Instantiate the frame
		mainFrame = new JFrame("2016 Results: ");
		mainFrame.setLayout(new GridBagLayout());
				
		JTextField trumpResults = new JTextField("Trump: " + s.getPoll("Trump") + "%, " + s.getECV("Trump") + " ECV");
		JTextField clintonResults = new JTextField("Clinton: " + s.getPoll("Clinton") + "%, " + s.getECV("Clinton") + " ECV");
		JTextField johnsonResults = new JTextField("Johnson: " + s.getPoll("Johnson") + "%, " + s.getECV("Johnson") + " ECV");
		JTextField steinResults = new JTextField("Stein: " + s.getPoll("Stein") + "%, " + s.getECV("Stein") + " ECV");
		JTextField mcmullinResults = new JTextField("McMullin: " + s.getPoll("McMullin") + "%, " + s.getECV("McMullin") + " ECV");
		
		trumpResults.setEditable(false);
		clintonResults.setEditable(false);
		johnsonResults.setEditable(false);
		steinResults.setEditable(false);
		mcmullinResults.setEditable(false);
		
		mainFrame.add(trumpResults);
		mainFrame.add(clintonResults);
		mainFrame.add(johnsonResults);
		mainFrame.add(steinResults);
		mainFrame.add(mcmullinResults);
		
		// Finalize the frame.
		mainFrame.setSize(new Dimension(950, 500));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);	
	}
}