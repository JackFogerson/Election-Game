import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Events {	
	Statistics s;
	String candidate;
	JFrame eventFrame;
	
	//event chain
	public Events(String c, int n, Statistics stat) {
		this.candidate = c;
		this.s = stat;
        Random rand = new Random(); 
		
        //trump event chain
		if (c.equals("Trump") && n == 0) {
			int randInt = rand.nextInt(4) + 1;
			je1(randInt);
			randInt = rand.nextInt(4) + 1;
			me1(randInt);	
			randInt = rand.nextInt(4) + 1;
			se1(randInt);
		}
		
		else if (c.equals("Trump") && n == 1) {
			int randInt = rand.nextInt(4) + 1;
			je2(randInt);			
		}
		
		//clinton event chain
		else if (c.equals("Clinton") && n == 0) {
			int randInt = rand.nextInt(4) + 1;
			je1(randInt);
			randInt = rand.nextInt(4) + 1;
			me1(randInt);
			randInt = rand.nextInt(4) + 1;
			se1(randInt);
		}
		
		else if (c.equals("Clinton") && n == 1) {
			int randInt = rand.nextInt(4) + 1;
			je2(randInt);
		}
		
		//Johnson event chain
		else if (c.equals("Johnson")&& n==0) {
			int randInt = rand.nextInt(4) + 1;
			me1(randInt);
			randInt = rand.nextInt(4) + 1;
			se1(randInt);
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
		
		//stein event chain
		else if (c.equals("Stein") && n == 0) {
			int randInt = rand.nextInt(4) + 1;
			je1(randInt);
			randInt = rand.nextInt(4) + 1;
			me1(randInt);	
			eventFrame = new JFrame("Jill Stein");
			eventFrame.setLayout(new GridLayout(5, 1));
					
			JTextField q = new JTextField("Choose your VP:");
			JButton ab = new JButton("Ajamu Baraka     ");
			JButton hh = new JButton("Howie Hawkins    ");
			JButton jv = new JButton("Jessee Ventura   ");
			JButton ck = new JButton("Cynthia McKinney ");
			
			ab.addActionListener(event -> se1(1));
			hh.addActionListener(event -> se1(2));
			jv.addActionListener(event -> se1(3));
			ck.addActionListener(event -> se1(4));
			
			q.setEditable(false);
			//ImageIcon bwp = new ImageIcon("BW_Photo.jpg");
			//ImageIcon app = new ImageIcon("AP_Photo.jpg");
			//ImageIcon jmp = new ImageIcon("JM_Photo.jpg");

			//bw.setIcon(bwp);
			//ap.setIcon(app); 
			//jm.setIcon(jmp);

			eventFrame.add(q);
			eventFrame.add(ab);
			eventFrame.add(hh);
			eventFrame.add(jv);
			eventFrame.add(ck);
			
			eventFrame.setSize(new Dimension(1000, 500));
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			//Set JFrame to center of screen
			eventFrame.setLocation(d.width/2-eventFrame.getSize().width/2, d.height/2-eventFrame.getSize().height/2);
			eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			eventFrame.setVisible(true);
		}
		
		else if (c.equals("Stein") && n == 1) {
			int randInt = rand.nextInt(4) + 1;
			je2(randInt);
		}
		
		//mcmullin event chain
		else if (c.equals("McMullin") && n == 0) {
			int randInt = rand.nextInt(4) + 1;
			je1(randInt);
			randInt = rand.nextInt(4) + 1;
			se1(randInt);
			eventFrame = new JFrame("Evan McMullin");
			eventFrame.setLayout(new GridLayout(5, 1));
					
			JTextField q = new JTextField("Choose your VP:");
			JButton mf = new JButton("Mindy Finn     ");
			JButton nj = new JButton("Nathan Johnson ");
			JButton gb = new JButton("Greg Bell      ");
			JButton lg = new JButton("Lindsey Graham ");
			
			mf.addActionListener(event -> me1(1));
			nj.addActionListener(event -> me1(2));
			gb.addActionListener(event -> me1(3));
			lg.addActionListener(event -> me1(4));
			
			q.setEditable(false);
			//ImageIcon bwp = new ImageIcon("BW_Photo.jpg");
			//ImageIcon app = new ImageIcon("AP_Photo.jpg");
			//ImageIcon jmp = new ImageIcon("JM_Photo.jpg");

			//bw.setIcon(bwp);
			//ap.setIcon(app); 
			//jm.setIcon(jmp);

			eventFrame.add(q);
			eventFrame.add(mf);
			eventFrame.add(nj);
			eventFrame.add(gb);
			eventFrame.add(lg);
			
			eventFrame.setSize(new Dimension(1000, 500));
			Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
			//Set JFrame to center of screen
			eventFrame.setLocation(d.width/2-eventFrame.getSize().width/2, d.height/2-eventFrame.getSize().height/2);
			eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			eventFrame.setVisible(true);
		}
		
		else if (c.equals("McMullin") && n == 1) {
			int randInt = rand.nextInt(4) + 1;
			je2(randInt);
		}
		
		else {
			System.out.println("Candidate DNE");
		}
	}

	//outcome for johnson event 1
	public void je1(int i) {
		if(candidate.equals("Johnson")) {
			if(i == 1) {
				s.changeLib("Johnson", .03);
				s.changeLib("Stein", -.01);
				s.changeLib("Clinton", -.005);
				s.changeLib("Trump", -.015);
				s.changeMod("Johnson", .01);
				s.changeMod("Trump", -.01);
				s.changeCon("Johnson", -.05);
				s.changeCon("McMullin", .03);
				s.changeCon("Trump", .02);
				s.Massachusetts.changeLib(.02);
				s.Massachusetts.changeRep(-.01);
				s.Massachusetts.changeDem(-.01);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
			if(i == 2) {
				s.changeLib("Johnson", -.04);
				s.changeLib("Trump", .01);
				s.changeLib("Clinton", .02);
				s.changeLib("Stein", .01);
				s.changeMod("Johnson", -.01);
				s.changeMod("Clinton", .01);
				s.changeCon("Johnson", .04);
				s.changeCon("Trump", -.03);
				s.changeCon("McMullin", -.01);
				s.Missouri.changeLib(.02);
				s.Missouri.changeRep(-.02);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
			if(i == 3) {
				s.changeLib("Johnson", -.05);
				s.changeLib("Trump", .01);
				s.changeLib("Clinton", .03);
				s.changeLib("Stein", .01);
				s.changeMod("Johnson", -.03);
				s.changeMod("Clinton", .02);
				s.changeMod("McMullin", .01);
				s.changeCon("Johnson", .01);
				s.changeCon("Trump", -.01);
				s.California.changeLib(.02);
				s.California.changeGreen(-.01);
				s.California.changeRep(-.01);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
			if(i == 4) {
				s.changeLib("Johnson", -.07);
				s.changeLib("Trump", .02);
				s.changeLib("Clinton", .03);
				s.changeLib("Stein", .01);
				s.changeLib("McMullin", .01);
				s.changeMod("Johnson", -.05);
				s.changeMod("Clinton", .02);
				s.changeCon("Trump", .01);
				s.changeMod("McMullin", .02);
				s.changeCon("Johnson", .02);
				s.changeCon("Trump", -.02);				
				s.New_Hampshire.changeLib(.03);
				s.New_Hampshire.changeGreen(-.01);
				s.New_Hampshire.changeRep(-.01);
				s.New_Hampshire.changeDem(-.01);
				eventFrame.dispose();
				new Events(candidate, 1, s);
			}
		}
		else {
			if(i == 1) {
				s.changeLib("Johnson", .03);
				s.changeLib("Stein", -.01);
				s.changeLib("Clinton", -.005);
				s.changeLib("Trump", -.015);
				s.changeMod("Johnson", .01);
				s.changeMod("Trump", -.01);
				s.changeCon("Johnson", -.05);
				s.changeCon("McMullin", .03);
				s.changeCon("Trump", .02);
				s.Massachusetts.changeLib(.02);
				s.Massachusetts.changeRep(-.01);
				s.Massachusetts.changeDem(-.01);
				JOptionPane.showMessageDialog(null, "Johnson chooses Bill Weld as his VP");
			}
			if(i == 2) {
				s.changeLib("Johnson", -.04);
				s.changeLib("Trump", .01);
				s.changeLib("Clinton", .02);
				s.changeLib("Stein", .01);
				s.changeMod("Johnson", -.01);
				s.changeMod("Clinton", .01);
				s.changeCon("Johnson", .04);
				s.changeCon("Trump", -.03);
				s.changeCon("McMullin", -.01);
				s.Missouri.changeLib(.02);
				s.Missouri.changeRep(-.02);
				JOptionPane.showMessageDialog(null, "Johnson chooses Austin Petersen as his VP");
			}
			if(i == 3) {
				s.changeLib("Johnson", -.05);
				s.changeLib("Trump", .01);
				s.changeLib("Clinton", .03);
				s.changeLib("Stein", .01);
				s.changeMod("Johnson", -.03);
				s.changeMod("Clinton", .02);
				s.changeMod("McMullin", .01);
				s.changeCon("Johnson", .01);
				s.changeCon("Trump", -.01);
				s.California.changeLib(.02);
				s.California.changeGreen(-.01);
				s.California.changeRep(-.01);
				JOptionPane.showMessageDialog(null, "Johnson chooses John MacAfee as his VP");
			}
			if(i == 4) {
				s.changeLib("Johnson", -.07);
				s.changeLib("Trump", .02);
				s.changeLib("Clinton", .03);
				s.changeLib("Stein", .01);
				s.changeLib("McMullin", .01);
				s.changeMod("Johnson", -.05);
				s.changeMod("Clinton", .02);
				s.changeCon("Trump", .01);
				s.changeMod("McMullin", .02);
				s.changeCon("Johnson", .02);
				s.changeCon("Trump", -.02);				
				s.New_Hampshire.changeLib(.03);
				s.New_Hampshire.changeGreen(-.01);
				s.New_Hampshire.changeRep(-.01);
				s.New_Hampshire.changeDem(-.01);
				JOptionPane.showMessageDialog(null, "Johnson chooses Vermin Supreme as his VP");
			}
		}
	}

	
	public void je2(int i) {
		if(candidate.equals("Johnson")) {
			if(i == 1) {
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 2) {
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 3) {
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 4) {
				eventFrame.dispose();
				new ResultsPage(s);
			}
		}
		else {
			if(i == 1) {
				new ResultsPage(s);
			}
			if(i == 2) {
				new ResultsPage(s);
			}
			if(i == 3) {
				new ResultsPage(s);
			}
			if(i == 4) {
				new ResultsPage(s);
			}
		}
	}
	
	public void me1(int i) {
		if(candidate.equals("McMullin")) {
			if(i == 1) {
				s.changeCon("McMullin", .03);
				s.changeCon("Trump", -.02);
				s.changeCon("Johnson", -.01);
				s.changeMod("McMullin", .01);
				s.changeMod("Trump", -.01);
				s.Texas.changeMcM(.02);
				s.Texas.changeRep(-.01);
				s.Texas.changeLib(-.01);
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 2) {
				s.changeCon("McMullin", -.02);
				s.changeCon("Johnson", .02);
				s.changeMod("McMullin", -.01);
				s.changeMod("Johnson", .01);
				s.changeLib("McMullin", -.01);
				s.changeLib("Johnson", .01);
				s.California.changeMcM(.01);
				s.California.changeRep(-.01);
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 3) {
				s.changeCon("McMullin", .04);
				s.changeCon("Trump", -.02);
				s.changeCon("Johnson", -.02);
				s.changeMod("McMullin", .02);
				s.changeMod("Trump", -.01);
				s.changeMod("Johnson", -.01);
				s.changeLib("McMullin", .01);
				s.changeLib("Trump", -.01);
				s.Utah.changeMcM(.07);
				s.Utah.changeLib(-.02);
				s.Utah.changeRep(-.03);
				s.Utah.changeDem(-.02);
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 4) {
				s.changeCon("McMullin", .08);
				s.changeCon("Trump", -.07);
				s.changeCon("Johnson", -.01);
				s.changeMod("McMullin", .02);
				s.changeMod("Trump", -.01);
				s.changeMod("Johnson", -.01);
				s.changeLib("McMullin", -.04);
				s.changeLib("Johnson", .04);
				s.South_Carolina.changeMcM(.09);
				s.South_Carolina.changeRep(-.07);
				s.South_Carolina.changeLib(-.01);
				s.South_Carolina.changeDem(-.01);
				eventFrame.dispose();
				new ResultsPage(s);
			}
		}
		else {
			if(i == 1) {
				s.changeCon("McMullin", .03);
				s.changeCon("Trump", -.02);
				s.changeCon("Johnson", -.01);
				s.changeMod("McMullin", .01);
				s.changeMod("Trump", -.01);
				s.Texas.changeMcM(.02);
				s.Texas.changeRep(-.01);
				s.Texas.changeLib(-.01);
				JOptionPane.showMessageDialog(null, "McMullin chooses Mindy Finn as his VP");
			}
			if(i == 2) {
				s.changeCon("McMullin", -.02);
				s.changeCon("Johnson", .02);
				s.changeMod("McMullin", -.01);
				s.changeMod("Johnson", .01);
				s.changeLib("McMullin", -.01);
				s.changeLib("Johnson", .01);
				s.California.changeMcM(.01);
				s.California.changeRep(-.01);
				JOptionPane.showMessageDialog(null, "McMullin chooses Nathan Johnson as his VP");								
			}
			if(i == 3) {
				s.changeCon("McMullin", .04);
				s.changeCon("Trump", -.02);
				s.changeCon("Johnson", -.02);
				s.changeMod("McMullin", .02);
				s.changeMod("Trump", -.01);
				s.changeMod("Johnson", -.01);
				s.changeLib("McMullin", .01);
				s.changeLib("Trump", -.01);
				s.Utah.changeMcM(.07);
				s.Utah.changeLib(-.02);
				s.Utah.changeRep(-.03);
				s.Utah.changeDem(-.02);
				JOptionPane.showMessageDialog(null, "McMullin chooses Greg Bell as his VP");
			}
			if(i == 4) {
				s.changeCon("McMullin", .08);
				s.changeCon("Trump", -.07);
				s.changeCon("Johnson", -.01);
				s.changeMod("McMullin", .02);
				s.changeMod("Trump", -.01);
				s.changeMod("Johnson", -.01);
				s.changeLib("McMullin", -.04);
				s.changeLib("Johnson", .04);
				s.South_Carolina.changeMcM(.09);
				s.South_Carolina.changeRep(-.07);
				s.South_Carolina.changeLib(-.01);
				s.South_Carolina.changeDem(-.01);
				JOptionPane.showMessageDialog(null, "McMullin chooses Lindsey Graham as his VP");
			}
		}
	}
	
	public void se1(int i) {
		if(candidate.equals("Stein")) {
			if(i == 1) {
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 2) {
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 3) {
				eventFrame.dispose();
				new ResultsPage(s);
			}
			if(i == 4) {
				s.changeLib("Clinton", -.3);
				s.changeLib("Stein", .1);
				s.changeLib("Johnson", .2);
				eventFrame.dispose();
				new ResultsPage(s);
			}
		}
		else {
			if(i == 1) {
				JOptionPane.showMessageDialog(null, "Stein chooses Ajamu Baraka as her VP");
			}
			if(i == 2) {
				JOptionPane.showMessageDialog(null, "Stein chooses Howie Hawkins as her VP");								
			}
			if(i == 3) {
				JOptionPane.showMessageDialog(null, "Stein chooses Jesse Ventura as her VP");
			}
			if(i == 4) {
				JOptionPane.showMessageDialog(null, "Stein chooses Cynthia McKinney as her VP");
			}
		}
	}
	
}
