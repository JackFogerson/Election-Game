import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @title	ResultsPage.java
 * @author 	Jack Fogerson
 * @desc	Class handles ResultsPage setup
 */
//handles ResultsPage setup and gives election results
public class ResultsPage {
	//initialize variables
	JFrame mainFrame;
	Statistics s;
	JTextField results;
	JTextArea tresults;
	//senate seats that will not change party
	int RS = 30;
    int DS = 37; 
    int LS = 0;
    int GS = 0;
    //house seats that will not change party
    int RH = 3;
    //1 R Washington
    //1 R Nebraska
    //1 R Oklahoma
    int DH = 11; 
    //9 D California
    //1 D Oregon
    //1 D Washington
    int LH = 0;
    int GH = 0;  
    
    //launchs resultspage
	public ResultsPage(Statistics stat){
		this.s = stat;
		launchFrame();
	}
	
	public void launchFrame(){	
		//culling process for third party
		for(int i=0;i<s.accounts.size();i++) {
			if(s.accounts.get(i).getLib()<.1) {
				double temp1 = (s.accounts.get(i).getLib()/2);
				s.accounts.get(i).changeLib(-temp1);
				s.accounts.get(i).changeRep(temp1/6);
				s.accounts.get(i).changeDem(temp1/2);
				s.accounts.get(i).changeMcM(temp1/3);
			}
			if(s.accounts.get(i).getMcM()<.1) {
				double temp2 = (s.accounts.get(i).getMcM()/2);
				s.accounts.get(i).changeMcM(-temp2);
				s.accounts.get(i).changeRep(temp2/3);
				s.accounts.get(i).changeDem(temp2/6);
				s.accounts.get(i).changeMcM(temp2/2);
			}
			if(s.accounts.get(i).getGreen()<.1) {
				double temp3 = (s.accounts.get(i).getGreen()/2);
				s.accounts.get(i).changeGreen(-temp3);
				s.accounts.get(i).changeRep(temp3/6);
				s.accounts.get(i).changeDem(2*temp3/6);
				s.accounts.get(i).changeLib(temp3/6);
			}
			//no neg numbers
			if(s.accounts.get(i).getRep()<0) {
				s.accounts.get(i).Rep = 0;
			}	
			if(s.accounts.get(i).getDem()<0) {
				s.accounts.get(i).Dem = 0;
			}	
			if(s.accounts.get(i).getLib()<0) {
				s.accounts.get(i).Lib = 0;
			}
			if(s.accounts.get(i).getGreen()<0) {
				s.accounts.get(i).Green = 0;
			}
			if(s.accounts.get(i).getMcM()<0) {
				s.accounts.get(i).McM = 0;
			}
		}
		// Instantiate the frame
		//get results from senate elections
		senateResults();
		//get results from house elections
		houseResults();
		//establish layout for frame
		mainFrame = new JFrame("2016 Results: ");
		mainFrame.setLayout(new GridLayout(3, 7));
				
		//show presidential results, get vote% and electoral college votes for each candidate
		JTextField trumpResults = new JTextField("Trump: " + s.getPoll("Trump") + "%, " + s.getECV("Trump") + " ECV");
		JTextField clintonResults = new JTextField("Clinton: " + s.getPoll("Clinton") + "%, " + s.getECV("Clinton") + " ECV");
		JTextField johnsonResults = new JTextField("Johnson: " + s.getPoll("Johnson") + "%, " + s.getECV("Johnson") + " ECV");
		JTextField steinResults = new JTextField("Stein: " + s.getPoll("Stein") + "%, " + s.getECV("Stein") + " ECV");
		JTextField mcmullinResults = new JTextField("McMullin: " + s.getPoll("McMullin") + "%, " + s.getECV("McMullin") + " ECV");
		
		//results section: displays winner or tie
		if(s.getECV("Trump")>270){
			results = new JTextField("Results: Trump Wins!");
		}
		else if(s.getECV("Clinton")>270){
			results = new JTextField("Results: Clinton Wins!");
		}
		else if(s.getECV("Johnson")>270){
			results = new JTextField("Results: Johnson Wins!");
		}
		else if(s.getECV("Stein")>270){
			results = new JTextField("Results: Stein Wins!");
		}
		else if(s.getECV("McMullin")>270){
			results = new JTextField("Results: McMullin Wins!");
		}
		//textarea for tie results for newline properties
		else {
			String resultText = "\n \n \n \n \n No one got to 270 EC votes, the \n race goes to the house. The Results: \n";
			tresults = new JTextArea(resultText + houseVote("Trump", "Clinton", "Johnson"));
		}
		
		//shows gain or loses for senate
		String repSenExp = "" + (-54+RS);
		if(RS>54) {
			repSenExp = "+" + (-54+RS);
		}
		String demSenExp = "" + (-46+DS);
		if(DS>46) {
			demSenExp = "+" + (-46+DS);
		}
		String libSenExp = "+" + (0+LS);
		String grnSenExp = "+" + (0+GS);
		
		//display senate results
		JTextField repSenResults = new JTextField("Republican Senators: " + RS + ", " + repSenExp);
		JTextField demSenResults = new JTextField("Democratic Senators: " + DS + ", " + demSenExp);
		JTextField libSenResults = new JTextField("Libertarian Senators: " + LS + ", " + libSenExp);
		JTextField grnSenResults = new JTextField("Green Senators: " + GS + ", " + grnSenExp);		
		JTextField senResults;
		//mcm wont affect these, placeholder values
		JTextField filler = new JTextField("Independent Senators: 0");
		JTextField filler2 = new JTextField("Independent Representatives: 0");

		//different results based on election, take into account vp tiebreaker
		if(RS>50 || (RS==50 && s.getECV("Trump")>270)){
			senResults = new JTextField("Republicans retain control of the Senate");
		}
		else if(DS>50 || (DS==50 && s.getECV("Clinton")>270)){
			senResults = new JTextField("Democrats gain control of the Senate");
		}
		else if(LS>50 || (LS==50 && s.getECV("Johnson")>270)){
			senResults = new JTextField("Libertarians gain control of the Senate");
		}
		else if(GS>50 || (GS==50 && s.getECV("Stein")>270)){
			senResults = new JTextField("Greens gain control of the Senate");
		}
		else {
			senResults = new JTextField("The Senate is divided.");
		}
		
		//shows gains or losses for house
		String repHouseExp = "" + (-247+RH);
		if(RH>247) {
			repHouseExp = "+" + (-247+RH);
		}
		String demHouseExp = "" + (-188+DH);
		if(DH>188) {
			demHouseExp = "+" + (-188+DH);
		}
		String libHouseExp = "+" + (0+LH);
		String grnHouseExp = "+" + (0+GH);
		
		//show results for house election
		JTextField repHouseResults = new JTextField("Republican Representatives: " + RH + ", " + repHouseExp);
		JTextField demHouseResults = new JTextField("Democratic Representatives: " + DH + ", " + demHouseExp);
		JTextField libHouseResults = new JTextField("Libertarian Representatives: " + LH + ", " + libHouseExp);
		JTextField grnHouseResults = new JTextField("Green Representatives: " + GH + ", " + grnHouseExp);
		
		JTextField houseResults;
		
		//display results for house elections
		if(RH>=218){
			houseResults = new JTextField("Republicans retain control of the House");
		}
		else if(DH>=218){
			houseResults = new JTextField("Democrats gain control of the House");
		}
		else if(LH>=218){
			houseResults = new JTextField("Libertarians gain control of the House");
		}
		else if(GH>=218){
			houseResults = new JTextField("Greens gain control of the House");
		}
		else {
			houseResults = new JTextField("The House is divided against itself.");
		}
		
		trumpResults.setEditable(false);
		clintonResults.setEditable(false);
		johnsonResults.setEditable(false);
		steinResults.setEditable(false);
		mcmullinResults.setEditable(false);
		if(s.getECV("Trump")>270||s.getECV("Clinton")>270||s.getECV("Johnson")>270||s.getECV("Stein")>270||s.getECV("McMullin")>270){
			results.setEditable(false);
		}
		else {
			tresults.setEditable(false);
		}
		repSenResults.setEditable(false);
		demSenResults.setEditable(false);
		libSenResults.setEditable(false);
		grnSenResults.setEditable(false);
		senResults.setEditable(false);
		repHouseResults.setEditable(false);
		demHouseResults.setEditable(false);
		libHouseResults.setEditable(false);
		grnHouseResults.setEditable(false);
		houseResults.setEditable(false);
		filler.setEditable(false);
		filler2.setEditable(false);

		//add JText to frame
		mainFrame.add(trumpResults);
		mainFrame.add(clintonResults);
		mainFrame.add(johnsonResults);
		mainFrame.add(steinResults);
		mainFrame.add(mcmullinResults);
		if(s.getECV("Trump")>270||s.getECV("Clinton")>270||s.getECV("Johnson")>270||s.getECV("Stein")>270||s.getECV("McMullin")>270){
			mainFrame.add(results);
		}
		else {
			mainFrame.add(tresults);
		}
		mainFrame.add(repSenResults);
		mainFrame.add(demSenResults);
		mainFrame.add(libSenResults);
		mainFrame.add(grnSenResults);
		mainFrame.add(filler);
		mainFrame.add(senResults);
		mainFrame.add(repHouseResults);
		mainFrame.add(demHouseResults);
		mainFrame.add(libHouseResults);
		mainFrame.add(grnHouseResults);
		mainFrame.add(filler2);
		mainFrame.add(houseResults);

		// Finalize the frame.
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);	
	}
	
	//go through senate results for each state and calculate winner
	//based off of candidates result for each state
	public void senateResults() {
        double RHI = 22.2 * ((s.Hawaii.getRep()/30.0)/2);
        double DHI = 73.6 * ((s.Hawaii.getDem()/62.2)/2);        
        double LHI = 1.6 * ((s.Hawaii.getLib()/3.7)/2);        
        if(RHI > DHI && RHI > LHI){
            RS = RS + 1;
        }
        else if(DHI > RHI && DHI > LHI){
            DS = DS + 1;
        }
        else if(LHI > DHI && LHI > RHI){
            LS = LS + 1;
        }  
        double RAK = 44.3 * ((s.Alaska.getRep()/51.3)/2);
        double DAK = 11.1 * ((s.Alaska.getDem()/36.6)/2);        
        double LAK = 29.5 * ((s.Alaska.getLib()/5.9)/2);  
        if(RAK > DAK && RAK > LAK){
            RS = RS + 1;
        }
        else if(DAK > RAK && DAK > LAK){
            DS = DS + 1;
        }
        else if(LAK > DAK && LAK > RAK){
            LS = LS + 1;
        }
        double ROR = 33.6 * ((s.Oregon.getRep()/39.1)/2);
        double DOR = 56.7 * ((s.Oregon.getDem()/50.1)/2);        
        double LOR = 1.2  * ((s.Oregon.getLib()/4.7)/2);  
        double GOR = 2.4  * ((s.Oregon.getGreen()/2.5)/2);          
        if(ROR > DOR && ROR > LOR && ROR > GOR){
            RS = RS + 1;
        }
        else if(DOR > ROR && DOR > LOR && DOR > GOR){
            DS = DS + 1;
        }
        else if(LOR > DOR && LOR > ROR && LOR > GOR){
            LS = LS + 1;
        } 
        else if(GOR > DOR && GOR > ROR && GOR > LOR){
            GS = GS + 1;
        }  
        double RWA = 40.9 * ((s.Washington.getRep()/36.8)/2);
        double DWA = 59.1 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA > DWA){
            RS = RS + 1;
        }
        else if(DWA > RWA){
            DS = DS + 1;
        }    
        double RNV = 44.7 * ((s.Nevada.getRep()/45.5)/2);
        double DNV = 47.1 * ((s.Nevada.getDem()/47.9)/2);                
        if(RNV > DNV){
            RS = RS + 1;
        }
        else if(DNV > RNV){
            DS = DS + 1;
        }   
        double RID = 66.1 * ((s.Idaho.getRep()/59.3)/2);
        double DID = 27.8 * ((s.Idaho.getDem()/27.5)/2);                
        if(RID > DID){
            RS = RS + 1;
        }
        else if(DID > RID){
            DS = DS + 1;
        }  
        double RUT = 68.0 * ((s.Utah.getRep()/45.5)/2);
        double DUT = 27.4 * ((s.Utah.getDem()/27.5)/2);                
        if(RUT > DUT){
            RS = RS + 1;
        }
        else if(DUT > RUT){
            DS = DS + 1;
        } 
        double RAZ = 33.6 * ((s.Arizona.getRep()/39.1)/2);
        double DAZ = 56.7 * ((s.Arizona.getDem()/50.1)/2);        
        double GAZ = 2.4  * ((s.Arizona.getGreen()/2.5)/2);          
        if(RAZ > DAZ && RAZ > GAZ){
            RS = RS + 1;
        }
        else if(DAZ > RAZ && DAZ > GAZ){
            DS = DS + 1;
        }
        else if(GAZ > RAZ && GAZ > DAZ){
            GS = GS + 1;
        } 
        double RCO = 45.3 * ((s.Colorado.getRep()/43.3)/2);
        double DCO = 49.2 * ((s.Colorado.getDem()/48.2)/2);        
        double LCO = 3.5  * ((s.Colorado.getLib()/5.2)/2);  
        double GCO = 1.2  * ((s.Colorado.getGreen()/1.4)/2);          
        if(RCO > DCO && RCO > LCO && RCO > GCO){
            RS = RS + 1;
        }
        else if(DCO > RCO && DCO > LCO && DCO > GCO){
            DS = DS + 1;
        }
        else if(LCO > DCO && LCO > RCO && LCO > GCO){
            LS = LS + 1;
        } 
        else if(GCO > DCO && GCO > RCO && GCO > LCO){
            GS = GS + 1;
        }
        double RND = 78.6 * ((s.North_Dakota.getRep()/63.0)/2);
        double DND = 17.0 * ((s.North_Dakota.getDem()/27.2)/2);        
        double LND = 3.1  * ((s.North_Dakota.getLib()/6.2)/2);          
        if(RND > DND && RND > LND){
            RS = RS + 1;
        }
        else if(DND > RND && DND > LND){
            DS = DS + 1;
        }
        else if(LND > RND && LND > DND){
            LS = LS + 1;
        } 
        double RSD = 71.8 * ((s.South_Dakota.getRep()/61.5)/2);
        double DSD = 28.2 * ((s.South_Dakota.getDem()/31.7)/2);                
        if(RSD > DSD){
            RS = RS + 1;
        }
        else if(DSD > RSD){
            DS = DS + 1;
        }
        double RKS = 62.4 * ((s.Kansas.getRep()/56.7)/2);
        double DKS = 32.1 * ((s.Kansas.getDem()/36.1)/2);        
        double LKS = 5.5  * ((s.Kansas.getLib()/4.7)/2);          
        if(RKS > DKS && RKS > LKS){
            RS = RS + 1;
        }
        else if(DKS > RKS && DKS > LKS){
            DS = DS + 1;
        }
        else if(LKS > RKS && LKS > DKS){
            LS = LS + 1;
        } 
        double ROK = 67.7 * ((s.Oklahoma.getRep()/65.3)/2);
        double DOK = 24.6 * ((s.Oklahoma.getDem()/28.9)/2);        
        double LOK = 3.0  * ((s.Oklahoma.getLib()/5.7)/2);          
        if(ROK > DOK && ROK > LOK){
            RS = RS + 1;
        }
        else if(DOK > ROK && DOK > LOK){
            DS = DS + 1;
        }
        else if(LOK > ROK && LOK > DOK){
            LS = LS + 1;
        } 
        double RIA = 60.2 * ((s.Iowa.getRep()/51.1)/2);
        double DIA = 35.7 * ((s.Iowa.getDem()/41.7)/2);        
        double LIA = 2.7  * ((s.Iowa.getLib()/3.8)/2);          
        if(RIA > DIA && RIA > LIA){
            RS = RS + 1;
        }
        else if(DIA > RIA && DIA > LIA){
            DS = DS + 1;
        }
        else if(LIA > RIA && LIA > DIA){
            LS = LS + 1;
        }   
        double RMO = 49.4 * ((s.Missouri.getRep()/56.4)/2);
        double DMO = 46.2 * ((s.Missouri.getDem()/37.9)/2);        
        double LMO = 2.4  * ((s.Missouri.getLib()/3.4)/2);  
        double GMO = 1.1  * ((s.Missouri.getGreen()/0.9)/2);          
        if(RMO > DMO && RMO > LMO && RMO > GMO){
            RS = RS + 1;
        }
        else if(DMO > RMO && DMO > LMO && DMO > GMO){
            DS = DS + 1;
        }
        else if(LMO > DMO && LMO > RMO && LMO > GMO){
            LS = LS + 1;
        } 
        else if(GMO > DMO && GMO > RMO && GMO > LMO){
            GS = GS + 1;
        }         
        double RAR = 59.8 * ((s.Arkansas.getRep()/60.6)/2);
        double DAR = 36.2 * ((s.Arkansas.getDem()/33.7)/2);        
        double LAR = 4.0  * ((s.Arkansas.getLib()/2.6)/2);          
        if(RAR > DAR && RAR > LAR){
            RS = RS + 1;
        }
        else if(DAR > RAR && DAR > LAR){
            DS = DS + 1;
        }
        else if(LAR > RAR && LAR > DAR){
            LS = LS + 1;
        }    
        double RLA1 = 25*((s.Louisiana.getRep()/58.1)/2);
        double RLA2 = 15.4*((s.Louisiana.getRep()/58.1)/2);        
        double DLA1 = 17.5*((s.Louisiana.getDem()/38.4)/2);        
        double DLA2 = 12.5*((s.Louisiana.getDem()/38.4)/2);   
        if(RLA1 > 50 && RLA1 > DLA1){
        	RS = RS + 1;
        }  
        else if(DLA1 > 50 && DLA1 > RLA1){
        	DS = DS + 1;
        }     
        else if(RLA1 > DLA1 && RLA2 > DLA1) {
        	RS = RS + 1;
        }
        else if(DLA1 > RLA1 && DLA2 > RLA1) {
        	DS = DS + 1;
        }
        else{
                double RLA = 60.7*((s.Louisiana.getRep()/58.1)/2);
                double DLA = 39.3*((s.Louisiana.getDem()/38.4)/2); 
                if(RLA>DLA){
                    RS = RS + 1;
                }
                else if(DLA>RLA){
                    DS = DS + 1;
                }
            }
        double RAL = 64.2 * ((s.Alabama.getRep()/62.1)/2);
        double DAL = 35.8 * ((s.Alabama.getDem()/34.4)/2);                
        if(RAL > DAL){
            RS = RS + 1;
        }
        else if(DAL > RAL){
            DS = DS + 1;
        }      
        double RFL = 52.0 * ((s.Florida.getRep()/48.6)/2);
        double DFL = 44.3 * ((s.Florida.getDem()/47.4)/2);        
        double LFL = 2.1  * ((s.Florida.getLib()/2.2)/2);          
        if(RFL > DFL && RFL > LFL){
            RS = RS + 1;
        }
        else if(DFL > RFL && DFL > LFL){
            DS = DS + 1;
        }
        else if(LFL > RFL && LFL > DFL){
            LS = LS + 1;
        } 
        double RGA = 55.0 * ((s.Georgia.getRep()/50.4)/2);
        double DGA = 40.8 * ((s.Georgia.getDem()/45.3)/2);        
        double LGA = 4.2  * ((s.Georgia.getLib()/3.0)/2);          
        if(RGA > DGA && RGA > LGA){
            RS = RS + 1;
        }
        else if(DGA > RGA && DGA > LGA){
            DS = DS + 1;
        }
        else if(LGA > RGA && LGA > DGA){
            LS = LS + 1;
        } 
        double RSC = 60.5 * ((s.South_Carolina.getRep()/54.9)/2);
        double DSC = 37.0 * ((s.South_Carolina.getDem()/40.7)/2);                
        if(RSC > DSC){
            RS = RS + 1;
        }
        else if(DSC > RSC){
            DS = DS + 1;
        }  
        double RNC = 51.1 * ((s.North_Carolina.getRep()/49.8)/2);
        double DNC = 45.3 * ((s.North_Carolina.getDem()/46.2)/2);        
        double LNC = 3.6  * ((s.North_Carolina.getLib()/2.7)/2);          
        if(RNC > DNC && RNC > LNC){
            RS = RS + 1;
        }
        else if(DNC > RNC && DNC > LNC){
            DS = DS + 1;
        }
        else if(LNC > RNC && LNC > DNC){
            LS = LS + 1;
        } 
        double RWI = 50.2 * ((s.Wisconsin.getRep()/47.2)/2);
        double DWI = 46.8 * ((s.Wisconsin.getDem()/46.5)/2);        
        double LWI = 3.0  * ((s.Wisconsin.getLib()/3.6)/2);          
        if(RWI > DWI && RWI > LWI){
            RS = RS + 1;
        }
        else if(DWI > RWI && DWI > LWI){
            DS = DS + 1;
        }
        else if(LWI > RWI && LWI > DWI){
            LS = LS + 1;
        } 
        double RIL = 40.2 * ((s.Illinois.getRep()/38.4)/2);
        double DIL = 54.4 * ((s.Illinois.getDem()/55.2)/2);        
        double LIL = 3.2  * ((s.Illinois.getLib()/3.7)/2);  
        double GIL = 2.1  * ((s.Illinois.getGreen()/1.4)/2);          
        if(RIL > DIL && RIL > LIL && RIL > GIL){
            RS = RS + 1;
        }
        else if(DIL > RIL && DIL > LIL && DIL > GIL){
            DS = DS + 1;
        }
        else if(LIL > DIL && LIL > RIL && LIL > GIL){
            LS = LS + 1;
        } 
        else if(GIL > DIL && GIL > RIL && GIL > LIL){
            GS = GS + 1;
        }      
        double RKY = 57.3 * ((s.Kentucky.getRep()/62.5)/2);
        double DKY = 42.7 * ((s.Kentucky.getDem()/32.7)/2);                
        if(RKY > DKY){
            RS = RS + 1;
        }
        else if(DKY > RKY){
            DS = DS + 1;
        }     
        double RIN = 52.1 * ((s.Indiana.getRep()/56.5)/2);
        double DIN = 42.4 * ((s.Indiana.getDem()/37.5)/2);        
        double LIN = 5.5  * ((s.Indiana.getLib()/4.9)/2);          
        if(RIN > DIN && RIN > LIN){
            RS = RS + 1;
        }
        else if(DIN > RIN && DIN > LIN){
            DS = DS + 1;
        }
        else if(LIN > RIN && LIN > DIN){
            LS = LS + 1;
        }      
        double ROH = 58.3 * ((s.Ohio.getRep()/51.3)/2);
        double DOH = 36.9 * ((s.Ohio.getDem()/43.2)/2);        
        double GOH = 1.6  * ((s.Ohio.getGreen()/0.8)/2);          
        if(ROH > DOH && ROH > GOH){
            RS = RS + 1;
        }
        else if(DOH > ROH && DOH > GOH){
            DS = DS + 1;
        }
        else if(GOH> ROH && GOH> DOH){
            GS = GS + 1;
        }  
        double RMD = 36.4 * ((s.Maryland.getRep()/33.9)/2);
        double DMD = 60.4 * ((s.Maryland.getDem()/60.3)/2);        
        double GMD = 3.2  * ((s.Maryland.getGreen()/1.3)/2);          
        if(RMD > DMD && RMD > GMD){
            RS = RS + 1;
        }
        else if(DMD > RMD && DMD > GMD){
            DS = DS + 1;
        }
        else if(GMD> RMD && GMD> DMD){
            GS = GS + 1;
        } 
        double RPA = 48.9 * ((s.Pennsylvania.getRep()/48.2)/2);
        double DPA = 47.2 * ((s.Pennsylvania.getDem()/47.5)/2);        
        double LPA = 3.9  * ((s.Pennsylvania.getLib()/2.4)/2);          
        if(RPA > DPA && RPA > LPA){
            RS = RS + 1;
        }
        else if(DPA > RPA && DPA > LPA){
            DS = DS + 1;
        }
        else if(LPA> RPA && LPA> DPA){
            LS = LS + 1;
        }
        double RNY = 27.4 * ((s.New_York.getRep()/36.5)/2);
        double DNY = 70.4 * ((s.New_York.getDem()/59.0)/2);        
        double LNY = 0.6  * ((s.New_York.getLib()/2.3)/2);  
        double GNY = 1.5  * ((s.New_York.getGreen()/1.4)/2);          
        if(RNY > DNY && RNY > LNY && RNY > GNY){
            RS = RS + 1;
        }
        else if(DNY > RNY && DNY > LNY && DNY > GNY){
            DS = DS + 1;
        }
        else if(LNY > DNY && LNY > RNY && LNY > GNY){
            LS = LS + 1;
        } 
        else if(GNY > DNY && GNY > RNY && GNY > LNY){
            GS = GS + 1;
        }       
        double RCT = 34.9 * ((s.Connecticut.getRep()/40.9)/2);
        double DCT = 62.9 * ((s.Connecticut.getDem()/54.6)/2);        
        double LCT = 1.1  * ((s.Connecticut.getLib()/3.0)/2);  
        double GCT = 1.0  * ((s.Connecticut.getGreen()/1.4)/2);          
        if(RCT > DCT && RCT > LCT && RCT > GCT){
            RS = RS + 1;
        }
        else if(DCT > RCT && DCT > LCT && DCT > GCT){
            DS = DS + 1;
        }
        else if(LCT > DCT && LCT > RCT && LCT > GCT){
            LS = LS + 1;
        } 
        else if(GCT > DCT && GCT > RCT && GCT > LCT){
            GS = GS + 1;
        }         
        double RVT = 33.1 * ((s.Vermont.getRep()/30.3)/2);
        double DVT = 61.3 * ((s.Vermont.getDem()/56.7)/2);                
        if(RVT > DVT){
            RS = RS + 1;
        }
        else if(DVT > RVT){
            DS = DS + 1;
        }     
        double RNH = 47.9 * ((s.New_Hampshire.getRep()/46.5)/2);
        double DNH = 48.0 * ((s.New_Hampshire.getDem()/46.8)/2);        
        double LNH = 1.8  * ((s.New_Hampshire.getLib()/4.1)/2);          
        if(RNH > DNH && RNH > LNH){
            RS = RS + 1;
        }
        else if(DNH > RNH && DNH > LNH){
            DS = DS + 1;
        }
        else if(LNH> RNH && LNH> DNH){
            LS = LS + 1;
        }  
	}

	//go through house results for each state and calculate winner
	//based off of candidates result for each state
	public void houseResults(){
        double RAK1 = 50.5 * ((s.Alaska.getRep()/51.3)/2);
        double DAK1 = 36.5 * ((s.Alaska.getDem()/36.6)/2);       
        double LAK1 = 10.1 * ((s.Alaska.getLib()/5.9)/2);
        if(RAK1 > DAK1 && RAK1 > LAK1){
            RH = RH + 1;
            s.Alaska.addMember("r");
        }   
        else if(DAK1 > RAK1 && DAK1 > LAK1){
            DH = DH + 1;
            s.Alaska.addMember("d");
        }        
        else if(LAK1 > RAK1 && LAK1 > DAK1){
            LH = LH + 1;
            s.Alaska.addMember("l");
        }
        
        double RHI1 = 22.7 * ((s.Hawaii.getRep()/30.0)/2);
        double DHI1 = 71.9 * ((s.Hawaii.getDem()/62.2)/2);       
        double LHI1 = 3.3 * ((s.Hawaii.getLib()/3.7)/2);
        if(RHI1 > DHI1 && RHI1 > LHI1){
            RH = RH + 1;
            s.Hawaii.addMember("r");
        }   
        else if(DHI1 > RHI1 && DHI1 > LHI1){
            DH = DH + 1;
            s.Hawaii.addMember("d");
        }        
        else if(LHI1 > RHI1 && LHI1 > DHI1){
            LH = LH + 1;
            s.Hawaii.addMember("l");
        }  
        double RHI2 = 18.8 * ((s.Hawaii.getRep()/30.0)/2);
        double DHI2 = 81.2 * ((s.Hawaii.getDem()/62.2)/2);       
        if(RHI2 > DHI2){
            RH = RH + 1;
            s.Hawaii.addMember("r");
        }   
        else if(DHI2 > RHI2){
            DH = DH + 1;
            s.Hawaii.addMember("d");
        }    
               
        s.California.DH = 9;        
        double RCA1 = 59.5 * ((s.California.getRep()/31.5)/2);
        double DCA1 = 40.5 * ((s.California.getDem()/61.5)/2);
        if(RCA1 > DCA1){
            RH = RH + 1;
            s.California.addMember("r");
        }   
        else if(DCA1 > RCA1){
            DH = DH + 1;
            s.California.addMember("d");
        }    
        double RCA2 = 22.9 * ((s.California.getRep()/31.5)/2);
        double DCA2 = 77.1 * ((s.California.getDem()/61.5)/2);                
        if(RCA2 > DCA2){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA2 > RCA2){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        double RCA3 = 41.8 * ((s.California.getRep()/31.5)/2);
        double DCA3 = 58.2 * ((s.California.getDem()/61.5)/2);                
        if(RCA3 > DCA3){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA3 > RCA3){
            DH = DH + 1;
            s.California.addMember("d");
        }      
        double RCA4 = 62.8 * ((s.California.getRep()/31.5)/2);
        double DCA4 = 37.2 * ((s.California.getDem()/61.5)/2);                
        if(RCA4 > DCA4){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA4 > RCA4){
            DH = DH + 1;
            s.California.addMember("d");
        }        
        double RCA5 = 22.8 * ((s.California.getRep()/31.5)/2);
        double DCA5 = 77.2 * ((s.California.getDem()/61.5)/2);                
        if(RCA5 > DCA5){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA5 > RCA5){
            DH = DH + 1;
            s.California.addMember("d");
        }      
        double RCA6 = 24.8 * ((s.California.getRep()/31.5)/2);
        double DCA6 = 75.2 * ((s.California.getDem()/61.5)/2);              
        if(RCA6 > DCA6){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA6 > RCA6){
            DH = DH + 1;
            s.California.addMember("d");
        }       
        double RCA7 = 48.8 * ((s.California.getRep()/31.5)/2);
        double DCA7 = 51.2 * ((s.California.getDem()/61.5)/2);               
        if(RCA7 > DCA7){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA7 > RCA7){
            DH = DH + 1;
            s.California.addMember("d");
        }   
        double RCA8 = 62.7 * ((s.California.getRep()/31.5)/2);
        double DCA8 = 37.3 * ((s.California.getDem()/61.5)/2);               
        if(RCA8 > DCA8){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA8 > RCA8){
            DH = DH + 1;
            s.California.addMember("d");
        }    
        double RCA9 = 42.4 * ((s.California.getRep()/31.5)/2);
        double DCA9 = 57.6 * ((s.California.getDem()/61.5)/2);               
        if(RCA9 > DCA9){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA9 > RCA9){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        double RCA10 = 52.4 * ((s.California.getRep()/31.5)/2);
        double DCA10 = 47.6 * ((s.California.getDem()/61.5)/2);                
        if(RCA10 > DCA10){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA10 > RCA10){
            DH = DH + 1;
            s.California.addMember("d");
        }            
        double RCA11 = 28.2 * ((s.California.getRep()/31.5)/2);
        double DCA11 = 71.8 * ((s.California.getDem()/61.5)/2);                
        if(RCA11 > DCA11){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA11 > RCA11){
            DH = DH + 1;
            s.California.addMember("d");
        }     
        //NO NUMBER 12
        double RCA13 = 9.3 * ((s.California.getRep()/31.5)/2);
        double DCA13 = 90.7 * ((s.California.getDem()/61.5)/2);                
        if(RCA13 > DCA13){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA13 > RCA13){
            DH = DH + 1;
            s.California.addMember("d");
        }             
        double RCA14 = 19.1 * ((s.California.getRep()/31.5)/2);
        double DCA14 = 80.9 * ((s.California.getDem()/61.5)/2);               
        if(RCA14 > DCA14){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA14 > RCA14){
            DH = DH + 1;
            s.California.addMember("d");
        }   
        double RCA15 = 26.2 * ((s.California.getRep()/31.5)/2);
        double DCA15 = 73.8 * ((s.California.getDem()/61.5)/2);                
        if(RCA15 > DCA15){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA15 > RCA15){
            DH = DH + 1;
            s.California.addMember("d");
        }                  
        double RCA16 = 42.2 * ((s.California.getRep()/31.5)/2);
        double DCA16 = 57.8 * ((s.California.getDem()/61.5)/2);                
        if(RCA16 > DCA16){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA16 > RCA16){
            DH = DH + 1;
            s.California.addMember("d");
        }                  
        //NO NUMBER 17
        double RCA18 = 28.8 * ((s.California.getRep()/31.5)/2);
        double DCA18 = 71.2 * ((s.California.getDem()/61.5)/2);               
        if(RCA18 > DCA18){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA18 > RCA18){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        double RCA19 = 26.0 * ((s.California.getRep()/31.5)/2);
        double DCA19 = 74.0 * ((s.California.getDem()/61.5)/2);                
        if(RCA19 > DCA19){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA19 > RCA19){
            DH = DH + 1;
            s.California.addMember("d");
        }
        double RCA20 = 29.4 * ((s.California.getRep()/31.5)/2);
        double DCA20 = 70.6 * ((s.California.getDem()/61.5)/2);                
        if(RCA20 > DCA20){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA20 > RCA20){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        double RCA21 = 58.0 * ((s.California.getRep()/31.5)/2);
        double DCA21 = 42.0 * ((s.California.getDem()/61.5)/2);                
        if(RCA21 > DCA21){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA21 > RCA21){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        double RCA22 = 68.2 * ((s.California.getRep()/31.5)/2);
        double DCA22 = 31.8 * ((s.California.getDem()/61.5)/2);                
        if(RCA22 > DCA22){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA22 > RCA22){
            DH = DH + 1;
            s.California.addMember("d");
        }     
        double RCA23 = 70.0 * ((s.California.getRep()/31.5)/2);
        double DCA23 = 30.0 * ((s.California.getDem()/61.5)/2);                
        if(RCA23 > DCA23){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA23 > RCA23){
            DH = DH + 1;
            s.California.addMember("d");
        }   
        double RCA24 = 46.8 * ((s.California.getRep()/31.5)/2);
        double DCA24 = 53.2 * ((s.California.getDem()/61.5)/2);             
        if(RCA24 > DCA24){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA24 > RCA24){
            DH = DH + 1;
            s.California.addMember("d");
        }     
        double RCA25 = 54.2 * ((s.California.getRep()/31.5)/2);
        double DCA25 = 45.8 * ((s.California.getDem()/61.5)/2);                
        if(RCA25 > DCA25){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA25 > RCA25){
            DH = DH + 1;
            s.California.addMember("d");
        }   
        double RCA26 = 40.1 * ((s.California.getRep()/31.5)/2);
        double DCA26 = 59.9 * ((s.California.getDem()/61.5)/2);               
        if(RCA26 > DCA26){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA26 > RCA26){
            DH = DH + 1;
            s.California.addMember("d");
        }   
        double RCA27 = 33.5 * ((s.California.getRep()/31.5)/2);
        double DCA27 = 66.5 * ((s.California.getDem()/61.5)/2);                
        if(RCA27 > DCA27){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA27 > RCA27){
            DH = DH + 1;
            s.California.addMember("d");
        }    
        double RCA28 = 22.1 * ((s.California.getRep()/31.5)/2);
        double DCA28 = 77.9 * ((s.California.getDem()/61.5)/2);               
        if(RCA28 > DCA28){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA28 > RCA28){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        //NO NUMBER 29
        double RCA30 = 27.6 * ((s.California.getRep()/31.5)/2);
        double DCA30 = 72.4 * ((s.California.getDem()/61.5)/2);                
        if(RCA30 > DCA30){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA30 > RCA30){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        double RCA31 = 44.3 * ((s.California.getRep()/31.5)/2);
        double DCA31 = 55.7 * ((s.California.getDem()/61.5)/2);                
        if(RCA31 > DCA31){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA31 > RCA31){
            DH = DH + 1;
            s.California.addMember("d");
        } 
        //NO NUMBER 32
        double RCA33 = 33.7 * ((s.California.getRep()/31.5)/2);
        double DCA33 = 66.3 * ((s.California.getDem()/61.5)/2);                
        if(RCA33 > DCA33){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA33 > RCA33){
            DH = DH + 1;
            s.California.addMember("d");
        } 
        //NO NUMBER 34
        double RCA35 = 28.2 * ((s.California.getRep()/31.5)/2);
        double DCA35 = 71.8 * ((s.California.getDem()/61.5)/2);                
        if(RCA35 > DCA35){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA35 > RCA35){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        double RCA36 = 38.6 * ((s.California.getRep()/31.5)/2);
        double DCA36 = 61.4 * ((s.California.getDem()/61.5)/2);                
        if(RCA36 > DCA36){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA36 > RCA36){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        //NO NUMBER 37
        double RCA38 = 30.3 * ((s.California.getRep()/31.5)/2);
        double DCA38 = 69.7 * ((s.California.getDem()/61.5)/2);               
        if(RCA38 > DCA38){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA38 > RCA38){
            DH = DH + 1;
            s.California.addMember("d");
        } 
        double RCA39 = 57.7 * ((s.California.getRep()/31.5)/2);
        double DCA39 = 42.3 * ((s.California.getDem()/61.5)/2);                
        if(RCA39 > DCA39){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA39 > RCA39){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        //NO NUMBER 40
        double RCA41 = 35.6 * ((s.California.getRep()/31.5)/2);
        double DCA41 = 64.4 * ((s.California.getDem()/61.5)/2);                
        if(RCA41 > DCA41){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA41 > RCA41){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        double RCA42 = 59.0 * ((s.California.getRep()/31.5)/2);
        double DCA42 = 41.0 * ((s.California.getDem()/61.5)/2);                
        if(RCA42 > DCA42){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA42 > RCA42){
            DH = DH + 1;
            s.California.addMember("d");
        }   
        double RCA43 = 24.4 * ((s.California.getRep()/31.5)/2);
        double DCA43 = 75.6 * ((s.California.getDem()/61.5)/2);               
        if(RCA43 > DCA43){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA43 > RCA43){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        //NO NUMBER 44
        double RCA45 = 59.0 * ((s.California.getRep()/31.5)/2);
        double DCA45 = 41.0 * ((s.California.getDem()/61.5)/2);               
        if(RCA45 > DCA45){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA45 > RCA45){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        //NO NUMBER 46
        double RCA47 = 37.5 * ((s.California.getRep()/31.5)/2);
        double DCA47 = 62.5 * ((s.California.getDem()/61.5)/2);              
        if(RCA47 > DCA47){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA47 > RCA47){
            DH = DH + 1;
            s.California.addMember("d");
        }          
        double RCA48 = 58.5 * ((s.California.getRep()/31.5)/2);
        double DCA48 = 41.5 * ((s.California.getDem()/61.5)/2);                
        if(RCA48 > DCA48){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA48 > RCA48){
            DH = DH + 1;
            s.California.addMember("d");
        }       
        double RCA49 = 51.0 * ((s.California.getRep()/31.5)/2);
        double DCA49 = 49.0 * ((s.California.getDem()/61.5)/2);               
        if(RCA49 > DCA49){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA49 > RCA49){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        double RCA50 = 63.9 * ((s.California.getRep()/31.5)/2);
        double DCA50 = 36.1 * ((s.California.getDem()/61.5)/2);              
        if(RCA50 > DCA50){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA50 > RCA50){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        double RCA51 = 28.1 * ((s.California.getRep()/31.5/2));
        double DCA51 = 71.9 * ((s.California.getDem()/61.5)/2);             
        if(RCA51 > DCA51){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA51 > RCA51){
            DH = DH + 1;
            s.California.addMember("d");
        }           
        double RCA52 = 43.6 * ((s.California.getRep()/31.5)/2);
        double DCA52 = 56.4 * ((s.California.getDem()/61.5)/2);             
        if(RCA52 > DCA52){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA52 > RCA52){
            DH = DH + 1;
            s.California.addMember("d");
        }  
        double RCA53 = 33.9 * ((s.California.getRep()/31.5)/2);
        double DCA53 = 66.1 * ((s.California.getDem()/61.5)/2);               
        if(RCA53 > DCA53){
            RH = RH + 1;
            s.California.addMember("r");
        }
        else if(DCA53 > RCA53){
            DH = DH + 1;
            s.California.addMember("d");
        }           

        s.Oregon.DH = 1; 
        double ROR1 = 37.3 * ((s.Oregon.getRep()/39.1)/2);
        double DOR1 = 59.6 * ((s.Oregon.getDem()/50.1)/2);       
        double LOR1 = 3.1 * ((s.Oregon.getLib()/4.7)/2);
        if(ROR1 > DOR1 && ROR1 > LOR1){
            RH = RH + 1;
            s.Oregon.addMember("r");
        }   
        else if(DOR1 > ROR1 && DOR1 > LOR1){
            DH = DH + 1;
            s.Oregon.addMember("d");
        }        
        else if(LOR1 > ROR1 && LOR1 > DOR1){
            LH = LH + 1;
            s.Oregon.addMember("l");
        }          
        double ROR2 = 72.1 * ((s.Oregon.getRep()/30.0)/2);
        double DOR2 = 27.9 * ((s.Oregon.getDem()/62.2)/2);       
        if(ROR2 > DOR2){
            RH = RH + 1;
            s.Oregon.addMember("r");
        }   
        else if(DOR2 > ROR2){
            DH = DH + 1;
            s.Oregon.addMember("d");
        }        
        //NO NUMBER 3
        double ROR4 = 39.8 * ((s.Oregon.getRep()/39.1)/2);
        double DOR4 = 55.5 * ((s.Oregon.getDem()/50.1)/2);       
        double LOR4 = 1.6 * ((s.Oregon.getLib()/4.7)/2);
        double GOR4 = 3.0 * ((s.Oregon.getGreen()/2.5)/2);
        if(ROR4 > DOR4 && ROR4 > LOR4 && ROR4 > GOR4){
            RH = RH + 1;
            s.Oregon.addMember("r");
        }   
        else if(DOR4 > ROR4 && DOR4 > LOR4 && DOR4 > GOR4){
            DH = DH + 1;
            s.Oregon.addMember("d");
        }        
        else if(LOR4 > ROR4 && LOR4 > DOR4 && LOR4 > GOR4){
            LH = LH + 1;
            s.Oregon.addMember("l");
        }    
        else if(GOR4 > ROR4 && GOR4 > DOR4 && GOR4 > LOR4){
            GH = GH + 1;
            s.Oregon.addMember("g");
        }              
        double ROR5 = 43.2 * ((s.Oregon.getRep()/39.1)/2);
        double DOR5 = 53.6 * ((s.Oregon.getDem()/50.1)/2);       
        double GOR5 = 3.2 * ((s.Oregon.getGreen()/2.5)/2);
        if(ROR5 > DOR5 && ROR5 > GOR5){
            RH = RH + 1;
            s.Oregon.addMember("r");
        }   
        else if(DOR5 > ROR5 && DOR5 > GOR5){
            DH = DH + 1;
            s.Oregon.addMember("d");
        }        
        else if(GOR5 > ROR5 && GOR5 > DOR5){
            GH = GH + 1;
            s.Oregon.addMember("g");
        }       
        s.Washington.RH = 1;
        s.Washington.DH = 1;
        double RWA1 = 44.5 * ((s.Washington.getRep()/36.8)/2);
        double DWA1 = 55.5 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA1 > DWA1){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA1 > RWA1){
            DH = DH + 1;
            s.Washington.addMember("d");
        }          
        double RWA2 = 36.0 * ((s.Washington.getRep()/36.8)/2);
        double DWA2 = 64.0 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA2 > DWA2){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA2 > RWA2){
            DH = DH + 1;
            s.Washington.addMember("d");
        }       
        double RWA3 = 61.4 * ((s.Washington.getRep()/36.8)/2);
        double DWA3 = 38.6 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA3 > DWA3){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA3 > RWA3){
            DH = DH + 1;
            s.Washington.addMember("d");
        }       
        //NO NUMBER 4
        double RWA5 = 59.5 * ((s.Washington.getRep()/36.8));
        double DWA5 = 40.5 * ((s.Washington.getDem()/52.5));                
        if(RWA5 > DWA5){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA5 > RWA5){
            DH = DH + 1;
            s.Washington.addMember("d");
        }       
        double RWA6 = 38.3 * ((s.Washington.getRep()/36.8)/2);
        double DWA6 = 61.7 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA6 > DWA6){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA6 > RWA6){
            DH = DH + 1;
            s.Washington.addMember("d");
        }       
        //NO NUMBER 7
        double RWA8 = 60.0 * ((s.Washington.getRep()/36.8)/2);
        double DWA8 = 40.0 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA8 > DWA8){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA8 > RWA8){
            DH = DH + 1;
            s.Washington.addMember("d");
        }       
        double RWA9 = 27.0 * ((s.Washington.getRep()/36.8)/2);
        double DWA9 = 73.0 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA9 > DWA9){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA9 > RWA9){
            DH = DH + 1;
            s.Washington.addMember("d");
        }       
        double RWA10 = 41.3 * ((s.Washington.getRep()/36.8)/2);
        double DWA10 = 58.7 * ((s.Washington.getDem()/52.5)/2);                
        if(RWA10 > DWA10){
            RH = RH + 1;
            s.Washington.addMember("r");
        }   
        else if(DWA10 > RWA10){
            DH = DH + 1;
            s.Washington.addMember("d");
        }     
        
        double RNV1 = 28.8 * ((s.Nevada.getRep()/45.5)/2);
        double DNV1 = 61.8 * ((s.Nevada.getDem()/47.9)/2);                
        if(RNV1 > DNV1){
            RH = RH + 1;
            s.Nevada.addMember("r");
        }   
        else if(DNV1 > RNV1){
            DH = DH + 1;
            s.Nevada.addMember("d");
        } 
        double RNV2 = 58.3 * ((s.Nevada.getRep()/45.5)/2);
        double DNV2 = 36.9 * ((s.Nevada.getDem()/47.9)/2);                
        if(RNV2 > DNV2){
            RH = RH + 1;
            s.Nevada.addMember("r");
        }   
        else if(DNV2 > RNV2){
            DH = DH + 1;
            s.Nevada.addMember("d");
        }   
        double RNV3 = 46.0 * ((s.Nevada.getRep()/45.5)/2);
        double DNV3 = 47.2 * ((s.Nevada.getDem()/47.9)/2);                
        if(RNV3 > DNV3){
            RH = RH + 1;
            s.Nevada.addMember("r");
        }   
        else if(DNV3 > RNV3){
            DH = DH + 1;
            s.Nevada.addMember("d");
        }  
        double RNV4 = 45.5 * ((s.Nevada.getRep()/45.5)/2);
        double DNV4 = 48.5 * ((s.Nevada.getDem()/47.9)/2);         
        double LNV4 = 3.8 * ((s.Nevada.getLib()/3.3)/2);                
       
        if(RNV4 > DNV4 && RNV4 > LNV4){
            RH = RH + 1;
            s.Nevada.addMember("r");
        }   
        else if(DNV4 > RNV4 && DNV4 > LNV4){
            DH = DH + 1;
            s.Nevada.addMember("d");
        }  
        else if(LNV4 > RNV4 && LNV4 > DNV4){
            LH = LH + 1;
            s.Nevada.addMember("l");
        }  
        
        double RID1 = 68.2 * ((s.Idaho.getRep()/59.2)/2);
        double DID1 = 31.8 * ((s.Idaho.getDem()/27.5)/2);                
        if(RID1 > DID1){
            RH = RH + 1;
            s.Idaho.addMember("r");
        }   
        else if(DID1 > RID1){
            DH = DH + 1;
            s.Idaho.addMember("d");
        }
        double RID2 = 62.9 * ((s.Idaho.getRep()/59.2)/2);
        double DID2 = 29.4 * ((s.Idaho.getDem()/27.5)/2);                
        if(RID2 > DID2){
            RH = RH + 1;
            s.Idaho.addMember("r");
        }   
        else if(DID2 > RID2){
            DH = DH + 1;
            s.Idaho.addMember("d");
        }
        
        double RUT1 = 65.9 * ((s.Utah.getRep()/45.1)/2);
        double DUT1 = 26.4 * ((s.Utah.getDem()/27.2)/2);   
        double LUT1 = 5.9 * ((s.Utah.getLib()/3.5)/2);             
        if(RUT1 > DUT1 && RUT1 > LUT1){
            RH = RH + 1;
            s.Utah.addMember("r");
        }   
        else if(DUT1 > RUT1 && DUT1 > LUT1){
            DH = DH + 1;
            s.Utah.addMember("d");
        }
        else if(LUT1 > RUT1 && LUT1 > DUT1){
            LH = LH + 1;
            s.Utah.addMember("l");
        }
        double RUT2 = 61.6 * ((s.Utah.getRep()/45.1)/2);
        double DUT2 = 33.9 * ((s.Utah.getDem()/27.2)/2);   
        if(RUT2 > DUT2){
            RH = RH + 1;
            s.Utah.addMember("r");
        }   
        else if(DUT2 > RUT2){
            DH = DH + 1;
            s.Utah.addMember("d");
        }
        double RUT3 = 73.5 * ((s.Utah.getRep()/45.1)/2);
        double DUT3 = 26.5 * ((s.Utah.getDem()/27.2)/2);   
        if(RUT3 > DUT3){
            RH = RH + 1;
            s.Utah.addMember("r");
        }   
        else if(DUT3 > RUT3){
            DH = DH + 1;
            s.Utah.addMember("d");
        }
        double RUT4 = 53.8 * ((s.Utah.getRep()/45.1)/2);
        double DUT4 = 41.3 * ((s.Utah.getDem()/27.2)/2);   
        if(RUT4 > DUT4){
            RH = RH + 1;
            s.Utah.addMember("r");
        }   
        else if(DUT4 > RUT4){
            DH = DH + 1;
            s.Utah.addMember("d");
        }

        double RAZ1 = 43.4 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ1 = 50.7 * ((s.Arizona.getDem()/45.1)/2);    
        double GAZ1 = 5.9 * ((s.Arizona.getGreen()/1.3)/2);
        if(RAZ1 > DAZ1 && RAZ1 > GAZ1){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ1 > RAZ1 && DAZ1 > GAZ1){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }  
        else if(GAZ1 > RAZ1 && GAZ1 > DAZ1){
            GH = GH + 1;
            s.Arizona.addMember("g");
        }    
        double RAZ2 = 57 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ2 = 43 * ((s.Arizona.getDem()/45.1)/2);                
        if(RAZ2 > DAZ2){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ2 > RAZ2){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }       
        double RAZ3 = 0.9 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ3 = 98.6 * ((s.Arizona.getDem()/45.1)/2);                
        if(RAZ3 > DAZ3){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ3 > RAZ3){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }        
        double RAZ4 = 71.4 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ4 = 28.6 * ((s.Arizona.getDem()/45.1)/2);                
        if(RAZ4 > DAZ4){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ4 > RAZ4){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }        
        double RAZ5 = 64.1 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ5 = 35.9 * ((s.Arizona.getDem()/45.1)/2);                
        if(RAZ5 > DAZ5){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ5 > RAZ5){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }        
        double RAZ6 = 62.1 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ6 = 37.9 * ((s.Arizona.getDem()/45.1)/2);                
        if(RAZ6 > DAZ6){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ6 > RAZ6){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }      
        double RAZ7 = 24.7 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ7 = 75.3 * ((s.Arizona.getDem()/45.1)/2); 
        double GAZ7 = 0.0004 * ((s.Arizona.getGreen()/1.3)/2);                
        if(RAZ7 > DAZ7 && RAZ7 > GAZ7){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ7 > RAZ7 && DAZ7 > GAZ7){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }        
        else if(GAZ7 > RAZ7 && GAZ7 > DAZ7){
            GH = GH + 1;
            s.Arizona.addMember("g");
        }          
        double RAZ8 = 68.5 * ((s.Arizona.getRep()/48.7)/2);
        double GAZ8 = 31.5 * (((s.Arizona.getGreen()+s.Arizona.getDem())/46.4)/2);                
        if(RAZ8 > GAZ8){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(GAZ8 > RAZ8){
            GH = GH + 1;
            s.Arizona.addMember("g");
        }   
        double RAZ9 = 39.1 * ((s.Arizona.getRep()/48.7)/2);
        double DAZ9 = 60.9 * ((s.Arizona.getDem()/45.1)/2);    
        double GAZ9 = 0.0002 * ((s.Arizona.getGreen()/1.3)/2);                
        if(RAZ9 > DAZ9 && RAZ9 > GAZ9){
            RH = RH + 1;
            s.Arizona.addMember("r");
        }   
        else if(DAZ9 > RAZ9 && DAZ9 > GAZ9){
            DH = DH + 1;
            s.Arizona.addMember("d");
        }   
        else if(GAZ9 > RAZ9 && GAZ9 > DAZ9){
            GH = GH + 1;
            s.Arizona.addMember("g");
        }  

        double RMT1 = 56.2 * ((s.Montana.getRep()/56.2)/2);
        double DMT1 = 40.6 * ((s.Montana.getDem()/35.8)/2);       
        double LMT1 = 3.3 * ((s.Montana.getLib()/5.6)/2);
        if(RMT1 > DMT1 && RMT1 > LMT1){
            RH = RH + 1;
            s.Montana.addMember("r");
        }   
        else if(DMT1 > RMT1 && DMT1 > LMT1){
            DH = DH + 1;
            s.Montana.addMember("d");
        }        
        else if(LMT1 > RMT1 && LMT1 > DMT1){
            LH = LH + 1;
            s.Montana.addMember("l");
        }

        double RWY1 = 62 * ((s.Wyoming.getRep()/67.4)/2);
        double DWY1 = 30 * ((s.Wyoming.getDem()/21.6)/2);       
        double LWY1 = 3.6 * ((s.Wyoming.getLib()/5.1)/2);
        if(RWY1 > DWY1 && RWY1 > LWY1){
            RH = RH + 1;
            s.Wyoming.addMember("r");
        }   
        else if(DWY1 > RWY1 && DWY1 > LWY1){
            DH = DH + 1;
            s.Wyoming.addMember("d");
        }        
        else if(LWY1 > RWY1 && LWY1 > DWY1){
            LH = LH + 1;
            s.Wyoming.addMember("l");
        } 
        
        double RCO1 = 27.7 * ((s.Colorado.getRep()/43.3)/2);
        double DCO1 = 67.9 * ((s.Colorado.getDem()/48.2)/2);       
        double LCO1 = 4.4 * ((s.Colorado.getLib()/5.2)/2);
        if(RCO1 > DCO1 && RCO1 > LCO1){
            RH = RH + 1;
            s.Colorado.addMember("r");
        }   
        else if(DCO1 > RCO1 && DCO1 > LCO1){
            DH = DH + 1;
            s.Colorado.addMember("d");
        }        
        else if(LCO1 > RCO1 && LCO1 > DCO1){
            LH = LH + 1;
            s.Colorado.addMember("l");
        } 
        double RCO2 = 37.2 * ((s.Colorado.getRep()/43.3)/2);
        double DCO2 = 56.9 * ((s.Colorado.getDem()/48.2)/2);       
        double LCO2 = 5.9 * ((s.Colorado.getLib()/5.2)/2);
        if(RCO2 > DCO2 && RCO2 > LCO2){
            RH = RH + 1;
            s.Colorado.addMember("r");
        }   
        else if(DCO2 > RCO2 && DCO2 > LCO2){
            DH = DH + 1;
            s.Colorado.addMember("d");
        }        
        else if(LCO2 > RCO2 && LCO2 > DCO2){
            LH = LH + 1;
            s.Colorado.addMember("l");
        } 
        double RCO3 = 54.6 * ((s.Colorado.getRep()/43.3)/2);
        double DCO3 = 40.4 * ((s.Colorado.getDem()/48.2)/2);       
        double LCO3 = 5 * ((s.Colorado.getLib()/5.2)/2);
        if(RCO3 > DCO3 && RCO3 > LCO3){
            RH = RH + 1;
            s.Colorado.addMember("r");
        }   
        else if(DCO3 > RCO3 && DCO3 > LCO3){
            DH = DH + 1;
            s.Colorado.addMember("d");
        }        
        else if(LCO3 > RCO3 && LCO3 > DCO3){
            LH = LH + 1;
            s.Colorado.addMember("l");
        } 
        double RCO4 = 63.5 * ((s.Colorado.getRep()/43.3)/2);
        double DCO4 = 31.7 * ((s.Colorado.getDem()/48.2)/2);       
        double LCO4 = 4.8 * ((s.Colorado.getLib()/5.2)/2);
        if(RCO4 > DCO4 && RCO4 > LCO4){
            RH = RH + 1;
            s.Colorado.addMember("r");
        }   
        else if(DCO4 > RCO4 && DCO4 > LCO4){
            DH = DH + 1;
            s.Colorado.addMember("d");
        }        
        else if(LCO4 > RCO4 && LCO4 > DCO4){
            LH = LH + 1;
            s.Colorado.addMember("l");
        } 
        double RCO5 = 62.3 * ((s.Colorado.getRep()/43.3)/2);
        double DCO5 = 30.8 * ((s.Colorado.getDem()/48.2)/2);       
        double LCO5 = 6.9 * ((s.Colorado.getLib()/5.2)/2);
        if(RCO5 > DCO5 && RCO5 > LCO5){
            RH = RH + 1;
            s.Colorado.addMember("r");
        }   
        else if(DCO5 > RCO5 && DCO5 > LCO5){
            DH = DH + 1;
            s.Colorado.addMember("d");
        }        
        else if(LCO5 > RCO5 && LCO5 > DCO5){
            LH = LH + 1;
            s.Colorado.addMember("l");
        } 
        double RCO6 = 50.9 * ((s.Colorado.getRep()/43.3)/2);
        double DCO6 = 42.6 * ((s.Colorado.getDem()/48.2)/2);       
        double LCO6 = 5 * ((s.Colorado.getLib()/5.2)/2);
        double GCO6 = 1.5 * ((s.Colorado.getGreen()/1.4)/2);
        if(RCO6 > DCO6 && RCO6 > LCO6 && RCO6 > GCO6){
            RH = RH + 1;
            s.Colorado.addMember("r");
        }   
        else if(DCO6 > RCO6 && DCO6 > LCO6 && DCO6 > GCO6){
            DH = DH + 1;
            s.Colorado.addMember("d");
        }        
        else if(LCO6 > RCO6 && LCO6 > DCO6 && LCO6 > GCO6){
            LH = LH + 1;
            s.Colorado.addMember("l");
        } 
        else if(GCO6 > RCO6 && GCO6 > DCO6 && GCO6 > LCO6){
            GH = GH + 1;
            s.Colorado.addMember("g");
        } 
        double RCO7 = 39.8 * ((s.Colorado.getRep()/43.3)/2);
        double DCO7 = 55.2 * ((s.Colorado.getDem()/48.2)/2);       
        double LCO7 = 5 * ((s.Colorado.getLib()/5.2)/2);
        if(RCO7 > DCO7 && RCO7 > LCO7){
            RH = RH + 1;
            s.Colorado.addMember("r");
        }   
        else if(DCO7 > RCO7 && DCO7 > LCO7){
            DH = DH + 1;
            s.Colorado.addMember("d");
        }        
        else if(LCO7 > RCO7 && LCO7 > DCO7){
            LH = LH + 1;
            s.Colorado.addMember("l");
        } 
        
        double RNM1 = 34.8 * ((s.New_Mexico.getRep()/40)/2);
        double DNM1 = 65.2 * ((s.New_Mexico.getDem()/48.3)/2);                
        if(RNM1 > DNM1){
            RH = RH + 1;
            s.New_Mexico.addMember("r");
        }   
        else if(DNM1 > RNM1){
            DH = DH + 1;
            s.New_Mexico.addMember("d");
        }  
        double RNM2 = 62.7 * ((s.New_Mexico.getRep()/40)/2);
        double DNM2 = 37.3 * ((s.New_Mexico.getDem()/48.3)/2);                
        if(RNM2 > DNM2){
            RH = RH + 1;
            s.New_Mexico.addMember("r");
        }   
        else if(DNM2 > RNM2){
            DH = DH + 1;
            s.New_Mexico.addMember("d");
        } 
        double RNM3 = 37.6 * ((s.New_Mexico.getRep()/40)/2);
        double DNM3 = 62.4 * ((s.New_Mexico.getDem()/48.3)/2);                
        if(RNM3 > DNM3){
            RH = RH + 1;
            s.New_Mexico.addMember("r");
        }   
        else if(DNM3 > RNM3){
            DH = DH + 1;
            s.New_Mexico.addMember("d");
        }  
        
        double RND1 = 69.1 * ((s.North_Dakota.getRep()/63)/2);
        double DND1 = 23.8 * ((s.North_Dakota.getDem()/27.2)/2);       
        double LND1 = 7 * ((s.North_Dakota.getLib()/6.2)/2);
        if(RND1 > DND1 && RND1 > LND1){
            RH = RH + 1;
            s.North_Dakota.addMember("r");
        }   
        else if(DND1 > RND1 && DND1 > LND1){
            DH = DH + 1;
            s.North_Dakota.addMember("d");
        }        
        else if(LND1 > RND1 && LND1 > DND1){
            LH = LH + 1;
            s.North_Dakota.addMember("l");
        } 
        
        double RSD1 = 64.1 * ((s.South_Dakota.getRep()/61.5)/2);
        double DSD1 = 35.9 * ((s.South_Dakota.getDem()/31.7)/2);                
        if(RSD1 > DSD1){
            RH = RH + 1;
            s.South_Dakota.addMember("r");
        }   
        else if(DSD1 > RSD1){
            DH = DH + 1;
            s.South_Dakota.addMember("d");
        } 
        
        s.Nebraska.RH = 1;
        double RNE1 = 69.4 * ((s.Nebraska1.getRep()/56.2)/2);
        double DNE1 = 30.6 * ((s.Nebraska1.getDem()/35.5)/2);                
        if(RNE1 > DNE1){
            RH = RH + 1;
            s.Nebraska.addMember("r");
        }   
        else if(DNE1 > RNE1){
            DH = DH + 1;
            s.Nebraska.addMember("d");
        } 
        double RNE2 = 48.9 * ((s.Nebraska2.getRep()/47.2)/2);
        double DNE2 = 47.7 * ((s.Nebraska2.getDem()/44.9)/2);  
        double LNE2 = 3.4 * ((s.Nebraska2.getLib()/4.5)/2);                
        if(RNE2 > DNE2 && RNE2 > LNE2){
            RH = RH + 1;
            s.Nebraska.addMember("r");
        }   
        else if(DNE2 > RNE2 && DNE2 > LNE2){
            DH = DH + 1;
            s.Nebraska.addMember("d");
        } 
        else if(LNE2 > RNE2 && LNE2 > DNE2){
            LH = LH + 1;
            s.Nebraska.addMember("l");
        }
        //No Number 3
        
        double RKS1 = 65.9 * ((s.Kansas.getRep()/56.7)/2);
        double LKS1 = 7.5 * ((s.Kansas.getLib()/4.7)/2);                
        if(RKS1 > LKS1){
            RH = RH + 1;
            s.Kansas.addMember("r");
        }   
        else if(LKS1 > RKS1){
            DH = DH + 1;
            s.Kansas.addMember("l");
        } 
        double RKS2 = 60.9 * ((s.Kansas.getRep()/56.7)/2);
        double DKS2 = 32.6 * ((s.Kansas.getDem()/36.1)/2);  
        double LKS2 = 6.5 * ((s.Kansas.getLib()/4.7)/2);                
        if(RKS2 > DKS2 && RKS2 > LKS2){
            RH = RH + 1;
            s.Kansas.addMember("r");
        }   
        else if(DKS2 > RKS2 && DKS2 > LKS2){
            DH = DH + 1;
            s.Kansas.addMember("d");
        } 
        else if(LKS2 > RKS2 && LKS2 > DKS2){
            LH = LH + 1;
            s.Kansas.addMember("l");
        }
        double RKS3 = 51.3 * ((s.Kansas.getRep()/56.7)/2);
        double DKS3 = 40.6 * ((s.Kansas.getDem()/36.1)/2);  
        double LKS3 = 8.1 * ((s.Kansas.getLib()/4.7)/2);                
        if(RKS3 > DKS3 && RKS3 > LKS3){
            RH = RH + 1;
            s.Kansas.addMember("r");
        }   
        else if(DKS3 > RKS3 && DKS3 > LKS3){
            DH = DH + 1;
            s.Kansas.addMember("d");
        } 
        else if(LKS3 > RKS3 && LKS3 > DKS3){
            LH = LH + 1;
            s.Kansas.addMember("l");
        }
        double RKS4 = 60.7 * ((s.Kansas.getRep()/56.7)/2);
        double DKS4 = 29.6 * ((s.Kansas.getDem()/36.1)/2);  
        double LKS4 = 2.8 * ((s.Kansas.getLib()/4.7)/2);                
        if(RKS4 > DKS4 && RKS4 > LKS4){
            RH = RH + 1;
            s.Kansas.addMember("r");
        }   
        else if(DKS4 > RKS4 && DKS4 > LKS4){
            DH = DH + 1;
            s.Kansas.addMember("d");
        } 
        else if(LKS4 > RKS4 && LKS4 > DKS4){
            LH = LH + 1;
            s.Kansas.addMember("l");
        }
        
        s.Oklahoma.RH = 1;
        double ROK2 = 70.6 * ((s.Oklahoma.getRep()/65.3)/2);
        double DOK2 = 23.2 * ((s.Oklahoma.getDem()/28.9)/2);    
        if(ROK2 > DOK2){
            RH = RH + 1;
            s.Oklahoma.addMember("r");
        }   
        else if(DOK2 > ROK2){
            DH = DH + 1;
            s.Oklahoma.addMember("d");
        } 
        double ROK3 = 78.3 * ((s.Oklahoma.getRep()/65.3)/2);
        double DOK3 = 21.7 * ((s.Oklahoma.getDem()/28.9)/2);    
        if(ROK3 > DOK3){
            RH = RH + 1;
            s.Oklahoma.addMember("r");
        }   
        else if(DOK3 > ROK3){
            DH = DH + 1;
            s.Oklahoma.addMember("d");
        } 
        double ROK4 = 69.6 * ((s.Oklahoma.getRep()/65.3)/2);
        double DOK4 = 26.1 * ((s.Oklahoma.getDem()/28.9)/2);  
        double LOK4 = 4.3 * ((s.Oklahoma.getLib()/5.8)/2);                
        if(ROK4 > DOK4 && ROK4 > LOK4){
            RH = RH + 1;
            s.Oklahoma.addMember("r");
        }   
        else if(DOK4 > ROK4 && DOK4 > LOK4){
            DH = DH + 1;
            s.Oklahoma.addMember("d");
        } 
        else if(LOK4 > ROK4 && LOK4 > DOK4){
            LH = LH + 1;
            s.Oklahoma.addMember("l");
        }
        double ROK5 = 57.1 * ((s.Oklahoma.getRep()/65.3)/2);
        double DOK5 = 36.8 * ((s.Oklahoma.getDem()/28.9)/2);  
        double LOK5 = 6.1 * ((s.Oklahoma.getLib()/5.8)/2);                
        if(ROK5 > DOK5 && ROK5 > LOK5){
            RH = RH + 1;
            s.Oklahoma.addMember("r");
        }   
        else if(DOK5 > ROK5 && DOK5 > LOK5){
            DH = DH + 1;
            s.Oklahoma.addMember("d");
        } 
        else if(LOK5 > ROK5 && LOK5 > DOK5){
            LH = LH + 1;
            s.Oklahoma.addMember("l");
        }
        
        double RTX1 = 73.9 * ((s.Texas.getRep()/52.2)/2);
        double DTX1 = 24.1 * ((s.Texas.getDem()/43.2)/2);  
        double LTX1 = 2 * ((s.Texas.getLib()/3.2)/2);                
        if(RTX1 > DTX1 && RTX1 > LTX1){
            RH = RH + 1;
            s.Texas.addMember("r");
        }   
        else if(DTX1 > RTX1 && DTX1 > LTX1){
            DH = DH + 1;
            s.Texas.addMember("d");
        } 
        else if(LTX1 > RTX1 && LTX1 > DTX1){
            LH = LH + 1;
            s.Texas.addMember("l");
        }
        double RTX2 = 60.6 * ((s.Texas.getRep()/52.2)/2);
        double DTX2 = 36 * ((s.Texas.getDem()/43.2)/2);       
        double LTX2 = 2.3 * ((s.Texas.getLib()/3.2)/2);
        double GTX2 = 1.1 * ((s.Texas.getGreen()/0.8)/2);
        if(RTX2 > DTX2 && RTX2 > LTX2 && RTX2 > GTX2){
            RH = RH + 1;
            s.Texas.addMember("r");
        }   
        else if(DTX2 > RTX2 && DTX2 > LTX2 && DTX2 > GTX2){
            DH = DH + 1;
            s.Texas.addMember("d");
        }        
        else if(LTX2 > RTX2 && LTX2 > DTX2 && LTX2 > GTX2){
            LH = LH + 1;
            s.Texas.addMember("l");
        }    
        else if(GTX2 > RTX2 && GTX2 > DTX2 && GTX2 > LTX2){
            GH = GH + 1;
            s.Texas.addMember("g");
        }              
        //next to add: texas
	}
	
	//baseline method for house vote to elect president
	public String houseVote(String C1, String C2, String C3) {
		//starting vote total for each candidate
		int V1 = 0;
		int V2 = 0;
		int V3 = 0;
		//-1 to remove washington dc
		int tie = -1;
		//party with most house seats wins state
		for(int i=0; i<s.accounts.size();i++) {
			if(s.accounts.get(i).RH>(s.accounts.get(i).DH + s.accounts.get(i).LH)) {
				V1 ++;
				System.out.println("Rep: " + s.accounts.get(i).getName() + ": " + s.accounts.get(i).RH + "/" + (s.accounts.get(i).RH+s.accounts.get(i).DH+s.accounts.get(i).LH+s.accounts.get(i).GH));
			}
			else if(s.accounts.get(i).DH>(s.accounts.get(i).RH + s.accounts.get(i).LH)) {
				V2 ++;
				System.out.println("Dem: " + s.accounts.get(i).getName() + ": " + s.accounts.get(i).DH + "/" + (s.accounts.get(i).RH+s.accounts.get(i).DH+s.accounts.get(i).LH+s.accounts.get(i).GH));
			}
			else if(s.accounts.get(i).LH>(s.accounts.get(i).DH + s.accounts.get(i).RH)) {
				V3 ++;
				System.out.println("Lib: " + s.accounts.get(i).getName() + ": " + s.accounts.get(i).LH + "/" + (s.accounts.get(i).RH+s.accounts.get(i).DH+s.accounts.get(i).LH+s.accounts.get(i).GH));
			}
			else {
				tie ++;
				System.out.println("Tie: " + s.accounts.get(i).getName());
			}
		}
		return (" " + C1 + ": " + V1 + ", " + C2 + ": " + V2 + ", " + C3 + ": " + V3 + ", " + tie);
	}
}