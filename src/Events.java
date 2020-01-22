import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Events {
	
	Statistics s;
	
	public Events(String c, Statistics stat) {
		this.s = stat;
		if (c=="Johnson") {
				johnsonEventChain();
		}
	}
	
	public void johnsonEventChain() {
		JFrame johnsonFrame = new JFrame("Gary Johnson - Choose your VP");
		johnsonFrame.setLayout(new GridLayout(4, 1));
		
		JButton bw = new JButton("Bill Weld       ");
		JButton ap = new JButton("Austin Peterson ");
		JButton jm = new JButton("John Macafee    ");
		JButton vs = new JButton("Vermin Supreme  ");
		
		bw.addActionListener(event -> s.Massachusetts.changeLib(.2));
		bw.addActionListener(event -> new ResultsPage(s));
		ap.addActionListener(event -> s.Missouri.changeLib(.2));
		ap.addActionListener(event -> new ResultsPage(s));
		jm.addActionListener(event -> s.California.changeLib(.001));
		jm.addActionListener(event -> new ResultsPage(s));
		vs.addActionListener(event -> test(s));
		
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
	public void test(Statistics s) {
		s.Texas.changeLib(.8);
		new ResultsPage(s);
	}
}
