
public class State {
	int ECV;
	int Pop;
	double Turnout;
	double Rep;
	double Dem;
	double Lib;
	double Green;
	double McM;
	
	public State(int ecv, int pop, double turnout, double r, double d, double l, double g, double m) {
		this.ECV = ecv;
		this.Pop = pop;
		this.Turnout = turnout;
		this.Rep = r;
		this.Dem = d;
		this.Lib = l;
		this.Green = g;
		this.McM = m;
	}
	
	public void changeRep(double r) {
		Rep += r;
	}
	
	public void changeDem(double d) {
		Dem += d;
	}
	
	public void changeLib(double l) {
		this.Lib += l;
	}
	
	public void changeGreen(double g) {
		Green += g;
	}
	
	public void changeMcM(double m) {
		McM += m;
	}
	
	public double getRep() {
		return Rep;
	}
	
	public double getDem() {
		return Dem;
	}
	
	public double getLib() {
		return Lib;
	}

	public double getGreen() {
		return Green;
	}
	
	public double getMcM() {
		return McM;
	}
	
	public int getECV() {
		return ECV;
	}
	
	public double getTurnout() {
		return Turnout;
	}
	
	public int getPop() {
		return Pop;
	}
}
