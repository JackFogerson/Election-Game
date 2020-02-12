public class State {
	String Name;
	int ECV;
	int Pop;
	double Turnout;
	double Rep;
	double Dem;
	double Lib;
	double Green;
	double McM;
	int RH = 0;
	int DH = 0;
	int LH = 0;
	int GH = 0;
	
	public State(String n, int ecv, int pop, double turnout, double r, double d, double l, double g, double m){
		this.Name = n;
		this.ECV = ecv;
		this.Pop = pop;
		this.Turnout = turnout;
		this.Rep = r;
		this.Dem = d;
		this.Lib = l;
		this.Green = g;
		this.McM = m;
	}
	
	public void changeRep(double r) { Rep += r; }	
	public void changeDem(double d) { Dem += d; }	
	public void changeLib(double l) { Lib += l; }	
	public void changeGreen(double g) { Green += g; }	
	public void changeMcM(double m) { McM += m; }
	
	public void addMember(String c) {
		if(c == "r") { RH ++; }
		if(c == "d") { DH ++; }
		if(c == "l") { LH ++; }
		if(c == "g") { GH ++; }
	}
	
	public double getRep() { return Rep; }	
	public double getDem() { return Dem; }	
	public double getLib() { return Lib; }
	public double getGreen() { return Green; }	
	public double getMcM() { return McM; }
	
	public String getName() { return Name; }
	public int getECV() { return ECV; }	
	public double getTurnout() { return Turnout; }	
	public int getPop() { return Pop; }
}