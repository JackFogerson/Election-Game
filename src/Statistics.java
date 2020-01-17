import java.util.ArrayList;

public class Statistics {
	State Alabama = new State(9, 100, 1, .8, .01, .17, .01, .01);
	State Alaska = new State(3, 0, 0, 0, 0, 0, 0, 0);
	State Arizona = new State(11, 0, 0, 0, 0, 0, 0, 0);
	State Arkansas = new State(6, 0, 0, 0, 0, 0, 0, 0);
	State California = new State(55, 0, 0, 0, 0, 0, 0, 0);
	State Colorado = new State(9, 0, 0, 0, 0, 0, 0, 0);
	State Connecticut = new State(7, 0, 0, 0, 0, 0, 0, 0);
	State Delaware = new State(3, 0, 0, 0, 0, 0, 0, 0);
	State Florida = new State(29, 0, 0, 0, 0, 0, 0, 0);
	State Georgia = new State(16, 0, 0, 0, 0, 0, 0, 0);
	
	State Hawaii = new State(4, 0, 0, 0, 0, 0, 0, 0);
	State Idaho = new State(4, 0, 0, 0, 0, 0, 0, 0);
	State Illinois = new State(20, 0, 0, 0, 0, 0, 0, 0);
	State Indiana = new State(11, 0, 0, 0, 0, 0, 0, 0);
	State Iowa = new State(6, 0, 0, 0, 0, 0, 0, 0);
	State Kansas = new State(6, 0, 0, 0, 0, 0, 0, 0);
	State Kentucky = new State(8, 0, 0, 0, 0, 0, 0, 0);
	State Louisiana = new State(8, 0, 0, 0, 0, 0, 0, 0);
	State Maine = new State(4, 0, 0, 0, 0, 0, 0, 0);
	State Maryland = new State(10, 0, 0, 0, 0, 0, 0, 0);
	
	State Massachusetts = new State(11, 0, 0, 0, 0, 0, 0, 0);
	State Michigan = new State(16, 0, 0, 0, 0, 0, 0, 0);
	State Minnesota = new State(10, 0, 0, 0, 0, 0, 0, 0);
	State Mississippi = new State(6, 0, 0, 0, 0, 0, 0, 0);
	State Missouri = new State(10, 0, 0, 0, 0, 0, 0, 0);
	State Montana = new State(3, 0, 0, 0, 0, 0, 0, 0);
	State Nebraska = new State(5, 0, 0, 0, 0, 0, 0, 0);
	State Nevada = new State(6, 0, 0, 0, 0, 0, 0, 0);
	State New_Hampshire = new State(4, 0, 0, 0, 0, 0, 0, 0);
	State New_Jersey = new State(14, 0, 0, 0, 0, 0, 0, 0);
	
	State New_Mexico = new State(5, 0, 0, 0, 0, 0, 0, 0);
	State New_York = new State(29, 0, 0, 0, 0, 0, 0, 0);
	State North_Carolina = new State(15, 0, 0, 0, 0, 0, 0, 0);
	State North_Dakota = new State(3, 0, 0, 0, 0, 0, 0, 0);
	State Ohio = new State(18, 0, 0, 0, 0, 0, 0, 0);
	State Oklahoma = new State(7, 0, 0, 0, 0, 0, 0, 0);
	State Oregon = new State(7, 0, 0, 0, 0, 0, 0, 0);
	State Pennsylvannia = new State(20, 0, 0, 0, 0, 0, 0, 0);
	State Rhode_Island = new State(4, 0, 0, 0, 0, 0, 0, 0);
	State South_Carolina = new State(9, 0, 0, 0, 0, 0, 0, 0);
	
	State South_Dakota = new State(3, 0, 0, 0, 0, 0, 0, 0);
	State Tennessee = new State(11, 0, 0, 0, 0, 0, 0, 0);
	State Texas = new State(38, 0, 0, 0, 0, 0, 0, 0);
	State Utah = new State(6, 0, 0, 0, 0, 0, 0, 0);
	State Vermont = new State(3, 0, 0, 0, 0, 0, 0, 0);
	State Virginia = new State(13, 0, 0, 0, 0, 0, 0, 0);
	State Washington = new State(12, 0, 0, 0, 0, 0, 0, 0);
	State Washington_D_C = new State(3, 0, 0, 0, 0, 0, 0, 0);
	State West_Virginia = new State(5, 0, 0, 0, 0, 0, 0, 0);
	State Wisconsin = new State(10, 0, 0, 0, 0, 0, 0, 0);
	
	State Wyoming = new State(3, 0, 0, 0, 0, 0, 0, 0);

	ArrayList<State> accounts = new ArrayList<State>();
	
	public Statistics() {
		accounts.add(Alabama);
		accounts.add(Alaska);
		accounts.add(Arizona);
		accounts.add(Arkansas);
		accounts.add(California);
		accounts.add(Colorado);
		accounts.add(Connecticut);
		accounts.add(Delaware);
		accounts.add(Florida);
		accounts.add(Georgia);
		
		accounts.add(Hawaii);
		accounts.add(Idaho);
		accounts.add(Illinois);
		accounts.add(Indiana);
		accounts.add(Iowa);
		accounts.add(Kansas);
		accounts.add(Kentucky);
		accounts.add(Louisiana);
		accounts.add(Maine);
		accounts.add(Maryland);
		
		accounts.add(Massachusetts);
		accounts.add(Michigan);
		accounts.add(Minnesota);
		accounts.add(Mississippi);
		accounts.add(Missouri);
		accounts.add(Montana);
		accounts.add(Nebraska);
		accounts.add(Nevada);
		accounts.add(New_Hampshire);
		accounts.add(New_Jersey);
		
		accounts.add(New_Mexico);
		accounts.add(New_York);
		accounts.add(North_Carolina);
		accounts.add(North_Dakota);
		accounts.add(Ohio);
		accounts.add(Oklahoma);
		accounts.add(Oregon);
		accounts.add(Pennsylvannia);
		accounts.add(Rhode_Island);
		accounts.add(South_Carolina);
		
		accounts.add(South_Dakota);
		accounts.add(Tennessee);
		accounts.add(Texas);
		accounts.add(Utah);
		accounts.add(Vermont);
		accounts.add(Virginia);
		accounts.add(Washington);
		accounts.add(Washington_D_C);
		accounts.add(West_Virginia);
		accounts.add(Wisconsin);
		
		accounts.add(Wyoming);
	}
	
	public double getPoll(String c) {
		double p = 0;
		for(int i=0;i<accounts.size();i++) {
			double j = 0;
			if(c == "Trump") { j = accounts.get(i).getRep(); }
			if(c == "Clinton") { j = accounts.get(i).getDem(); }
			if(c == "Johnson") { j = accounts.get(i).getLib(); }
			if(c == "Stein") { j = accounts.get(i).getGreen(); }
			if(c == "McMullin") { j = accounts.get(i).getMcM(); }
			p += (j*(accounts.get(i).getTurnout() * accounts.get(i).getPop()));
		}
		return p;
	}
	
	public ArrayList<State> getStates(){
		return accounts;
	}
}
