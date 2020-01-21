import java.text.DecimalFormat;
import java.util.ArrayList;

public class Statistics {
	State Alabama = new State(9, 3741806, .6, .526, .389, .067, .014, 0);
	State Alaska = new State(3, 550189, .57, .463, .372, .147, .045, 0);
	State Arizona = new State(11, 5109792, .71, .453, .448, .085, .027, .014);
	State Arkansas = new State(6, 2259350, .61, .509, .388, .084, .027, .037);
	State California = new State(55, 29649348, .72, .362, .563, .059, .034, .005);
	State Colorado = new State(9, 4109494, .69, .44, .479, .069, .018, .014);
	State Connecticut = new State(7, 2821247, .73, .4, .513, .072, .034, .003);
	State Delaware = new State(3, 731367, .62, .363, .544, .078, .032, .004);
	State Florida = new State(29, 15839713, .72, .441, .49, .056, .017, 0);
	State Georgia = new State(16, 7604061, .73, .475, .452, .072, .004, .008);
	
	State Hawaii = new State(4, 1111117, .55, .274, .634, .072, .057, 0);
	State Idaho = new State(4, 1203384, .72, .527, .346, .108, .032, .177);
	State Illinois = new State(20, 9892106, .67, .373, .542, .07, .026, .004);
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
	State Washington_D_C = new State(3, 543588, .62, .093, .825, .052, .045, 0);
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
	
	public String getPoll(String c) {
		double poll = 0;
		double totVoters = 0;
		double voters = 0;
		double j = 0;
		for(int i=0;i<accounts.size();i++) {
			if(c == "Trump") { j = accounts.get(i).getRep(); }
			if(c == "Clinton") { j = accounts.get(i).getDem(); }
			if(c == "Johnson") { j = accounts.get(i).getLib(); }
			if(c == "Stein") { j = accounts.get(i).getGreen(); }
			if(c == "McMullin") { j = accounts.get(i).getMcM(); }
			totVoters += accounts.get(i).getTurnout() * accounts.get(i).getPop();
			voters = accounts.get(i).getTurnout() * accounts.get(i).getPop();
			poll += j * voters;
		}
		poll = (poll/totVoters)*100;
	    DecimalFormat df2 = new DecimalFormat("#.##");
		return df2.format(poll);
	}
	
	public int getECV(String c) {
		int ecv = 0;
		for(int i=0;i<accounts.size();i++) {
			if(c == "Trump") {
				if(accounts.get(i).getRep() > accounts.get(i).getDem() && accounts.get(i).getRep() > accounts.get(i).getLib() && accounts.get(i).getRep() > accounts.get(i).getGreen() && accounts.get(i).getRep() > accounts.get(i).getMcM()){ 
					ecv += accounts.get(i).getECV();
				}
			}
			if(c == "Clinton") {
				if(accounts.get(i).getDem() > accounts.get(i).getRep() && accounts.get(i).getDem() > accounts.get(i).getLib() && accounts.get(i).getDem() > accounts.get(i).getGreen() && accounts.get(i).getDem() > accounts.get(i).getMcM()){ 
					ecv += accounts.get(i).getECV();
				}
			}
			if(c == "Johnson") {
				if(accounts.get(i).getLib() > accounts.get(i).getRep() && accounts.get(i).getLib() > accounts.get(i).getDem() && accounts.get(i).getLib() > accounts.get(i).getGreen() && accounts.get(i).getLib() > accounts.get(i).getMcM()){ 
					ecv += accounts.get(i).getECV();
				}
			}
			if(c == "Stein") {
				if(accounts.get(i).getGreen() > accounts.get(i).getRep() && accounts.get(i).getGreen() > accounts.get(i).getLib() && accounts.get(i).getGreen() > accounts.get(i).getDem() && accounts.get(i).getGreen() > accounts.get(i).getMcM()){ 
					ecv += accounts.get(i).getECV();
				}
			}
			if(c == "McMullin") {
				if(accounts.get(i).getMcM() > accounts.get(i).getRep() && accounts.get(i).getMcM() > accounts.get(i).getLib() && accounts.get(i).getMcM() > accounts.get(i).getGreen() && accounts.get(i).getMcM() > accounts.get(i).getDem()){ 
					ecv += accounts.get(i).getECV();
				}
			}
		}
		return ecv;
	}
	
	public ArrayList<State> getStates(){
		return accounts;
	}
}
