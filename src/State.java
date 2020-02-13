//Generic State Class, used to define states for election mechanic
public class State {
	//create variables used for state
	//State Name
	String Name;
	//Electoral College Value
	int ECV;
	//Voting Age Population
	int Pop;
	//Turnout percent(starting value: 2016 votes/pop - 3%)
	double Turnout;
	//Rep % (Starts as of July 1)
	double Rep;
	//Dem % (Starts as of July 1)
	double Dem;
	//Lib % (Starts as of July 1)
	double Lib;
	//Green % (Starts as of July 1, if on ballot, based on lib %)
	double Green;
	//McMullin % (Starts as of July 1, if on ballot, based on lib % except Utah)
	double McM;
	//Rep House Seats
	int RH = 0;
	//Dem House Seats
	int DH = 0;
	//Lib House Seats
	int LH = 0;
	//Green House Seats
	int GH = 0;
	
	//basic constructor, sets given variables
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
	
	//methods to change state voting percent for each candidate
	public void changeRep(double r) { Rep += r; }	
	public void changeDem(double d) { Dem += d; }	
	public void changeLib(double l) { Lib += l; }	
	public void changeGreen(double g) { Green += g; }	
	public void changeMcM(double m) { McM += m; }
	
	//add candidate of party to house delegates
	public void addMember(String c) {
		if(c == "r") { RH ++; }
		if(c == "d") { DH ++; }
		if(c == "l") { LH ++; }
		if(c == "g") { GH ++; }
	}
	
	//get methods for states
	//get vote percentages
	public double getRep() { return Rep; }	
	public double getDem() { return Dem; }	
	public double getLib() { return Lib; }
	public double getGreen() { return Green; }	
	public double getMcM() { return McM; }
	//get other variables from state
	public String getName() { return Name; }
	public int getECV() { return ECV; }	
	public double getTurnout() { return Turnout; }	
	public int getPop() { return Pop; }
}