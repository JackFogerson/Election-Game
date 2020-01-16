
public class State {
	int ECV;
	int Pop;
	int turnout;
	int Rep;
	int Dem;
	int Lib;
	int Green;
	int McM;
	
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
	
	public int getRep() {
		return Rep;
	}
	
	public int getDem() {
		return Dem;
	}
	
	public int getLib() {
		return Lib;
	}

	public int getGreen() {
		return Green;
	}
	
	public int getMcM() {
		return McM;
	}
	
	public int getECV() {
		return ECV;
	}
	
	public int getTurnout() {
		return turnout;
	}
	
	public int getPop() {
		return Pop;
	}
}
