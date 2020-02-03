import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Events {	
	Statistics s;
	JFrame eventFrame;
	
	public Events(String c, Statistics stat) {
		this.s = stat;
		if (c=="Johnson") {
				johnsonEventChain1();
		}
	}
	
	public void johnsonEventChain1() {
		eventFrame = new JFrame("Gary Johnson");
		eventFrame.setLayout(new GridLayout(5, 1));
				
		JTextField q = new JTextField("Choose your VP:");
		JButton bw = new JButton("Bill Weld       ");
		JButton ap = new JButton("Austin Peterson ");
		JButton jm = new JButton("John Macafee    ");
		JButton vs = new JButton("Vermin Supreme  ");
		
		bw.addActionListener(event -> je1_1());
		ap.addActionListener(event -> je1_2());
		jm.addActionListener(event -> je1_3());
		vs.addActionListener(event -> je1_4());
		
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
	
	public void je1_1() {
		s.Massachusetts.changeLib(.04);
		eventFrame.dispose();
		johnsonEventChain2();
	}
	
	public void je1_2() {
		s.Missouri.changeLib(.01);
		eventFrame.dispose();
		johnsonEventChain2();
	}
	
	public void je1_3() {
		s.California.changeLib(.02);
		eventFrame.dispose();
		johnsonEventChain2();
	}
	
	public void je1_4() {
		s.Alaska.changeLib(.09);
		eventFrame.dispose();
		johnsonEventChain2();
	}
	
	public void johnsonEventChain2() {
		eventFrame = new JFrame("Gary Johnson");
		eventFrame.setLayout(new GridLayout(5, 1));
		
		JTextField q = new JTextField("Allepo!");
		JButton fu = new JButton("...And what is Allepo?");
		JButton nc = new JButton("... No Comment");
		JButton sp = new JButton("Detailed Boring answer");
		JButton aj = new JButton("Answer of the century");
		
		fu.addActionListener(event -> je2_1(s));
		nc.addActionListener(event -> je2_2(s));
		sp.addActionListener(event -> je2_3(s));
		aj.addActionListener(event -> je2_4(s));
		
		eventFrame.add(fu);
		eventFrame.add(nc);
		eventFrame.add(sp);
		eventFrame.add(aj);
		
		eventFrame.setSize(new Dimension(950, 500));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		eventFrame.setLocation(d.width/2-eventFrame.getSize().width/2, d.height/2-eventFrame.getSize().height/2);
		eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		eventFrame.setVisible(true);	
	}
	
	public void je2_1(Statistics s) {
		s.Massachusetts.changeLib(.04);
		eventFrame.dispose();
		new ResultsPage(s);
	}
	
	public void je2_2(Statistics s) {
		s.Missouri.changeLib(.01);
		eventFrame.dispose();
		new ResultsPage(s);
	}
	
	public void je2_3(Statistics s) {
		s.California.changeLib(.02);
		eventFrame.dispose();
		new ResultsPage(s);
	}
	
	public void je2_4(Statistics s) {
		s.Alaska.changeLib(.09);
		eventFrame.dispose();
		new ResultsPage(s);
	}
}
