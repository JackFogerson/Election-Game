import java.text.DecimalFormat;
import java.util.ArrayList;

//set all the statistics for each state
//Name, Electoral College votes, voting age pop, Rep%, Dem%, Lib%, Green%, McMullin%, con%, mod%, lib%
public class Statistics {
	State Alabama = new State("Alabama", 9, 3741806, .6, .526, .389, .067, .014, 0, .41, .32, .27);
	State Alaska = new State("Alaska", 3, 550189, .57, .463, .372, .147, .045, 0, .37, .41, .22);
	State Arizona = new State("Arizona", 11, 5109792, .71, .453, .448, .085, .027, .014, .39, .42, .19);
	State Arkansas = new State("Arkansas", 6, 2259350, .61, .509, .388, .084, .027, .037, .48, .37, .15);
	State California = new State("California", 55, 29649348, .72, .362, .563, .059, .034, .005, .28, .35, .37);
	State Colorado = new State("Colorado", 9, 4109494, .69, .44, .479, .069, .018, .014, .35, .37, .28);
	State Connecticut = new State("Connecticut", 7, 2821247, .73, .4, .513, .072, .034, .003, .24, .47, .28);
	State Delaware = new State("Delaware", 3, 731367, .62, .363, .544, .078, .032, .004, .29, .43, .28);
	State Florida = new State("Florida", 29, 15839713, .72, .441, .49, .056, .017, 0, .36, .38, .25);
	State Georgia = new State("Georgia", 16, 7604061, .73, .475, .452, .072, .004, .008, .42, .36, .22);
	
	State Hawaii = new State("Hawaii", 4, 1111117, .55, .274, .634, .072, .057, 0, .32, .44, .23);
	State Idaho = new State("Idaho", 4, 1203384, .72, .527, .346, .108, .032, .177, .44, .34, .22);
	State Illinois = new State("Illinois", 20, 9892106, .67, .373, .542, .07, .026, .004, .28, .45, .27);
	State Indiana = new State("Indiana", 11, 5014928, .55, .479, .423, .099, .005, 0, .38, .4, .22);
	State Iowa = new State("Iowa", 6, 2310467, .69, .417, .477, .094, .018, .02, .4, .37, .23);
	State Kansas = new State("Kansas", 6, 2181355, .64, .465, .411, .108, .046, .013, .39, .44, .17);
	State Kentucky = new State("Kentucky", 8, 3400843, .56, .511, .394, .078, .02, .033, .43, .38, .18);
	State Louisiana = new State("Louisiana", 8, 3536183, .64, .519, .39, .073, .027, .016, .44, .42, .15);
	//StateWide Maine Vote
	State Maine = new State("Maine", 2, 1071112, .69, .391, .491, .105, .039, .005, .29, .4, .31);
	//create states for Maine's 2 districts for CD voting, same ideology as state-wide
	State Maine1 = new State("Maine1", 1, 5035556, .69, .363, .522, .1, .041, .004, .29, .4, .31);
	State Maine2 = new State("Maine2", 1, 5035556, .69, .422, .457, .11, .038, .006, .29, .4, .31);
	State Maryland = new State("Maryland", 10, 4625863, .68, .306, .604, .073, .033, .009, .26 , .44, .3);
	
	State Massachusetts = new State("Massachusetts", 11, 5354940, .72, .322, .573, .088, .03, .002, .21, .47, .32);
	State Michigan = new State("Michigan", 16, 7686087, .6, .384, .498, .104, .031, .005, .36, .37, .27);
	State Minnesota = new State("Minnesota", 10, 4175347, .71, .399, .494, .095, .031, .045, .32, .40, .28);
	State Mississippi = new State("Mississippi", 6, 2262810, .5, .485, .436, .063, .016, 0, .51, .34, .15);
	State Missouri = new State("Missouri", 10, 4670966, .63, .455, .44, .092, .024, .007, .41, .38, .2);
	State Montana = new State("Montana", 3, 798555, .71, .465, .385, .15, .043, .012, .4, .41, .19);
	//StateWide Vote for Nebraska
	State Nebraska = new State("Nebraska", 2, 1414894, .68, .503, .38, .101, .023, 0, .44, .32, .24);
	//create states for Nebraska's 3 districts for CD voting, same ideology as state-wide
	State Nebraska1 = new State("Nebraska1", 1, 471631, .68, .484, .4, .1, .024, 0, .44, .32, .24);
	State Nebraska2 = new State("Nebraska2", 1, 471631, .68, .449, .443, .093, .024, 0, .44, .32, .24);
	State Nebraska3 = new State("Nebraska3", 1, 471631, .68, .575, .295, .109, .019, 0, .44, .32, .24);
	State Nevada = new State("Nevada", 6, 2175874, .73, .428, .477, .081, 0, 0, .36, .4, .25);
	State New_Hampshire = new State("New_Hampshire", 4, 1035684, .72, .419, .479, .09, .019, .003, .31, .42, .27);
	State New_Jersey = new State("New_Jersey", 14, 6926094, .65, .398, .521, .068, .035, 0, .23, .49, .28);
	
	State New_Mexico = new State("New_Mexico", 5, 1583623, .59, .37, .475, .142, .019, .011, .34, .38, .29);
	State New_York = new State("New_York", 29, 15517321, .65, .354, .561, .069, .042, .004, .26, .4, .35);
	State North_Carolina = new State("North_Carolina", 15, 7656415, .65, .46, .479, .061, .006, 0, .43, .35, .22);
	State North_Dakota = new State("North_Dakota", 3, 570955, .58, .482, .396, .107, .019, 0, .43, .39, .18);
	State Ohio = new State("Ohio", 18, 8955859, .68, .428, .464, .096, .025, .007, .39, .41, .2);
	State Oklahoma = new State("Oklahoma", 7, 2925352, .46, .566, .352, .082, 0, 0, .4, .39, .21);
	State Oregon = new State("Oregon", 7, 3112217, .67, .401, .493, .093, .049, 0, .3, .36, .34);
	State Pennsylvania = new State("Pennsylvania", 20, 10086316, .57, .417, .482, .089, .03, .004, .33, .4, .27);
	State Rhode_Island = new State("Rhode_Island", 4, 842321, .57, .341, .553, .09, .038, .003, .28, .38, .33);
	State South_Carolina = new State("South_Carolina", 9, 3747734, .64, .474, .442, .069, .018, .029, .44, .38, .18);

	State South_Dakota = new State("South_Dakota", 3, 642768, .66, .481, .403, .1, 0, 0, .42, .44, .15);
	State Tennessee = new State("Tennessee", 11, 5054826, .58, .505, .411, .068, .015, .012, .44, .40, .17);
	State Texas = new State("Texas", 38, 19841344, .56, .489, .431, .065, .016, .01, .44, .36, .2);
	State Utah = new State("Utah", 6, 2038787, .79, .379, .299, .112, .027, .189, .46, .36, .19);
	State Vermont = new State("Vermont", 3, 504976, .64, .306, .582, .094, .063, .006, .25, .36, .38);
	State Virginia = new State("Virginia", 13, 6457174, .69, .426, .49, .073, .017, .033, .33, .4, .26);
	State Washington = new State("Washington", 12, 5458809, .75, .383, .512, .091, .033, 0, .31, .37, .32);
	State Washington_D_C = new State("Washington_D_C", 3, 543588, .62, .093, .825, .052, .045, 0, .26, .42, .32);
	State West_Virginia = new State("West_Virginia", 5, 1470179, .54, .553, .348, .083, .029, .004, .4, .4, .21);
	State Wisconsin = new State("Wisconsin", 10, 4457375, .64, .407, .503, .077, .022, .009, .34, .4, .25);
	
	State Wyoming = new State("Wyoming", 3, 445830, .54, .549, .304, .126, .024, 0, .44, .36, .2);

	//create array of states
	ArrayList<State> accounts = new ArrayList<State>();
	
	//add states to array of states
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
		accounts.add(Pennsylvania);
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
	
	//gets voting % total from all states
	public String getPoll(String c){
		//initialize variables
		double poll = 0;
		double totVoters = 0;
		double voters = 0;
		double j = 0;
		
		//take voting percent for candidate for state
		for(int i=0;i<accounts.size();i++) {
			if(c == "Trump")    { j = accounts.get(i).getRep(); }
			if(c == "Clinton")  { j = accounts.get(i).getDem(); }
			if(c == "Johnson")  { j = accounts.get(i).getLib(); }
			if(c == "Stein")    { j = accounts.get(i).getGreen(); }
			if(c == "McMullin") { j = accounts.get(i).getMcM(); }
			//add voters of state to total
			totVoters += accounts.get(i).getTurnout() * accounts.get(i).getPop();
			//multiply candidate % by turnout
			voters = accounts.get(i).getTurnout() * accounts.get(i).getPop();
			poll += j * voters;
		}
		//divide candidate votes by total voters and making a percent
		poll = (poll/totVoters)*100;
		//limit to 2 decimal places
	    DecimalFormat df2 = new DecimalFormat("#.##");	    
		return df2.format(poll);
	}
	
	//gets winners from each state and assigns electoral college votes to winners
	public int getECV(String c){
		//add CD votes from non-winner-takes-all-states
		accounts.add(Maine1);
		accounts.add(Maine2);
		accounts.add(Nebraska1);
		accounts.add(Nebraska2);
		accounts.add(Nebraska3);
		
		//starts process for counting ecvs
		int ecv = 0;
		for(int i=0;i<accounts.size();i++){
			//assign ecvs for winer of state
			if(c == "Trump"){
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
		//remove CD from states arraylist
		accounts.remove(Maine1);
		accounts.remove(Maine2);
		accounts.remove(Nebraska1);
		accounts.remove(Nebraska2);
		accounts.remove(Nebraska3);
		
		//return electoral college votes
		return ecv;
	}
	
	//gets state array
	public ArrayList<State> getStates(){
		return accounts;
	}
}