import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Events {	
	Statistics s;
	String candidate;
	JFrame eventFrame;
	
	public Events(String c, int n, Statistics stat) {
		this.candidate = c;
		this.s = stat;
        Random rand = new Random(); 
		
		if (c.equals("Trump")) {
			int randInt = rand.nextInt(4) + 1;
			je1(randInt);			
		}
		
		else if (c.equals("Trump1")) {
			int randInt = rand.nextInt(4) + 1;
			je2(randInt);			
		}
		
		else if (c.equals("Clinton")) {
			int randInt = rand.nextInt(4) + 1;
			je1(randInt);
		}
		
		else if (c.equals("Clinton1")) {
			int randInt = rand.nextInt(4) + 1;
			je2(randInt);
		}
		
		else if (c.equals("Johnson")&& n==0) {
			eventFrame = new JFrame("Gary Johnson");
			eventFrame.setLayout(new GridLayout(5, 1));
					
			JTextField q = new JTextField("Choose your VP:");
			JButton bw = new JButton("Bill Weld       ");
			JButton ap = new JButton("Austin Peterson ");
			JButton jm = new JButton("John Macafee    ");
			JButton vs = new JButton("Vermin Supreme  ");
			
			bw.addActionListener(event -> je1(1));
			ap.addActionListener(event -> je1(2));
			jm.addActionListener(event -> je1(3));
			vs.addActionListener(event -> je1(4));
			
			q.setEditable(false);
			ImageIcon bwp = new ImageIcon("BW_Photo.jpg");
			ImageIcon app = new ImageIcon("AP_Photo.jpg");
			ImageIcon jmp = new ImageIcon("JM_Photo.jpg");

			bw.setIcon(bwp);
			ap.setIcon(app);
			jm.setIcon(jmp);

			eventFrame.add(q);
			eventFrame.add(bw);
			eventFrame.add(ap);
			eventFrame.add(jm);
			eventFrame.add(vs);
			
			eventFrame.setSize(new Dimension(1000, 500));
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			//Set JFrame to center of screen
			eventFrame.setLocation(d.width/2-eventFrame.getSize().width/2, d.height/2-eventFrame.getSize().height/2);
			eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			eventFrame.setVisible(true);
		}
		
		else if (c.equals("Johnson")&&n==1) {
			eventFrame = new JFrame("Gary Johnson");
			eventFrame.setLayout(new GridLayout(5, 1));
			
			JTextField q = new JTextField("Allepo!");
			JButton fu = new JButton("...And what is Allepo?");
			JButton nc = new JButton("... No Comment");
			JButton sp = new JButton("Detailed Boring answer");
			JButton aj = new JButton("Answer of the century");
			
			fu.addActionListener(event -> je2(1));
			nc.addActionListener(event -> je2(2));
			sp.addActionListener(event -> je2(3));
			aj.addActionListener(event -> je2(4));
			
			eventFrame.add(q);
			eventFrame.add(fu);
			eventFrame.add(nc);
			eventFrame.add(sp);
			eventFrame.add(aj);
			
			q.setEditable(false);
			eventFrame.setSize(new Dimension(950, 500));
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			//Set JFrame to center of screen
			eventFrame.setLocation(d.width/2-eventFrame.getSize().width/2, d.height/2-eventFrame.getSize().height/2);
			eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			eventFrame.setVisible(true);	
		}
		
		else if (c=="Stein") {
		}
		
		else if (c=="McMullin") {
		}
		
		else {
			System.out.println("Candidate DNE");
		}
	}

	public void je1(int i) {
		System.out.println("Johnson1");
		if(candidate.equals("Johnson")) {
			if(i == 1) {
				s.Massachusetts.changeLib(.04);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
			if(i == 2) {
				s.Missouri.changeLib(.01);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
			if(i == 3) {
				s.New_York.changeLib(.7);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
			if(i == 4) {
				s.changeCon(candidate, .2);
				s.changeCon("Clinton", -.13);
				s.changeCon("Trump", -.07);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
		}
		else {
			if(i == 1) {
				s.Massachusetts.changeLib(.04);
			}
			if(i == 2) {
				s.Missouri.changeLib(.01);
			}
			if(i == 3) {
				s.California.changeLib(.02);
			}
			if(i == 4) {
				s.changeCon(candidate, .1);
				s.changeCon("Clinton", -.1);
			}
		}
	}

	
	public void je2(int i) {
		if(candidate.equals("Johnson")) {
			if(i == 1) {
				s.Massachusetts.changeLib(.04);
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 2) {
				s.Missouri.changeLib(.01);
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 3) {
				s.California.changeLib(.7);
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 4) {
				s.changeCon(candidate, .2);
				s.changeMod("Clinton", -.15);
				s.changeMod("Trump", -.05);
				eventFrame.dispose();
				new ResultsPage(s);
			}
		}
		else {
			if(i == 1) {
				s.Massachusetts.changeLib(.04);
			}
			if(i == 2) {
				s.Missouri.changeLib(.01);
			}
			if(i == 3) {
				s.California.changeLib(.02);
			}
			if(i == 4) {
				s.Alaska.changeLib(.09);
			}
		}
	}
}
