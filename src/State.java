
public class State {
	int ECV;
	int Pop;
	int Turnout;
	double Rep;
	double Dem;
	double Lib;
	double Green;
	double McM;
	
	public State(int ecv, int pop, int turnout, double r, double d, double l, double g, double m) {
		this.ECV = ecv;
		this.Pop = pop;
		this.Turnout = turnout;
		this.Rep = r;
		this.Dem = d;
		this.Lib = l;
		this.Green = g;
		this.McM = m;
	}
	
	public void changeRep(int r) {
		Rep += r;
	}
	
	public void changeDem(int d) {
		Dem += d;
	}
	
	public void changeLib(int l) {
		Lib += l;
	}
	
	public void changeGreen(int g) {
		Green += g;
	}
	
	public void changeMcM(int m) {
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
	
	public int getTurnout() {
		return Turnout;
	}
	
	public int getPop() {
		return Pop;
	}
}
