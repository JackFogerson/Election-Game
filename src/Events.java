import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Events {	
	Statistics s;
	
	public Events(String c, Statistics stat) {
		this.s = stat;
		if (c=="Johnson") {
				johnsonEventChain1();
		}
	}
	
	public void johnsonEventChain1() {
		JFrame johnsonFrame = new JFrame("Gary Johnson");
		johnsonFrame.setLayout(new GridLayout(5, 1));
		
		JTextField q = new JTextField("Choose your VP");
		JButton bw = new JButton("Bill Weld       ");
		JButton ap = new JButton("Austin Peterson ");
		JButton jm = new JButton("John Macafee    ");
		JButton vs = new JButton("Vermin Supreme  ");
		
		bw.addActionListener(event -> je1_1());
		ap.addActionListener(event -> je1_2());
		jm.addActionListener(event -> je1_3());
		vs.addActionListener(event -> je1_4());
		
		johnsonFrame.add(bw);
		johnsonFrame.add(ap);
		johnsonFrame.add(jm);
		johnsonFrame.add(vs);
		
		johnsonFrame.setSize(new Dimension(950, 500));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		johnsonFrame.setLocation(d.width/2-johnsonFrame.getSize().width/2, d.height/2-johnsonFrame.getSize().height/2);
		johnsonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		johnsonFrame.setVisible(true);	
	}
	
	public void je1_1() {
		s.Massachusetts.changeLib(.04);
		johnsonEventChain2();
	}
	
	public void je1_2() {
		s.Missouri.changeLib(.01);
		johnsonEventChain2();
	}
	
	public void je1_3() {
		s.California.changeLib(.02);
		johnsonEventChain2();
	}
	
	public void je1_4() {
		s.Alaska.changeLib(.09);
		johnsonEventChain2();
	}
	
	public void johnsonEventChain2() {
		JFrame johnsonFrame = new JFrame("Gary Johnson");
		johnsonFrame.setLayout(new GridLayout(5, 1));
		
		JTextField q = new JTextField("Allepo!");
		JButton fu = new JButton("...And what is Allepo?");
		JButton nc = new JButton("... No Comment");
		JButton sp = new JButton("Detailed Boring answer");
		JButton aj = new JButton("Answer of the century");
		
		fu.addActionListener(event -> je2_1(s));
		nc.addActionListener(event -> je2_2(s));
		sp.addActionListener(event -> je2_3(s));
		aj.addActionListener(event -> je2_4(s));
		
		johnsonFrame.add(fu);
		johnsonFrame.add(nc);
		johnsonFrame.add(sp);
		johnsonFrame.add(aj);
		
		johnsonFrame.setSize(new Dimension(950, 500));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		johnsonFrame.setLocation(d.width/2-johnsonFrame.getSize().width/2, d.height/2-johnsonFrame.getSize().height/2);
		johnsonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		johnsonFrame.setVisible(true);	
	}
	
	public void je2_1(Statistics s) {
		s.Massachusetts.changeLib(.04);
		new ResultsPage(s);
	}
	
	public void je2_2(Statistics s) {
		s.Missouri.changeLib(.01);
		new ResultsPage(s);
	}
	
	public void je2_3(Statistics s) {
		s.California.changeLib(.02);
		new ResultsPage(s);
	}
	
	public void je2_4(Statistics s) {
		s.Alaska.changeLib(.09);
		new ResultsPage(s);
	}
}
