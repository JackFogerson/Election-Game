import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @title	ResultsPage.java
 * @author 	Jack Fogerson
 * @desc	Class handles ResultsPage setup
 */

public class ResultsPage {
	JFrame mainFrame;
	Statistics s;
	JTextField results;
	int RS = 30;
    int DS = 37; 
    int LS = 0;
    int GS = 0;
    int RH = 1;
    //1 Washington
    int DH = 11; 
    //9 California
    //1 Oregon
    //1 Washington
    int LH = 0;
    int GH = 0;  
    
	public ResultsPage(Statistics stat){
		this.s = stat;
		launchFrame();
	}
	
	public void launchFrame(){
		// Instantiate the frame
		senateResults();
		mainFrame = new JFrame("2016 Results: ");
		mainFrame.setLayout(new GridLayout(4, 5));
				
		JTextField trumpResults = new JTextField("Trump: " + s.getPoll("Trump") + "%, " + s.getECV("Trump") + " ECV");
		JTextField clintonResults = new JTextField("Clinton: " + s.getPoll("Clinton") + "%, " + s.getECV("Clinton") + " ECV");
		JTextField johnsonResults = new JTextField("Johnson: " + s.getPoll("Johnson") + "%, " + s.getECV("Johnson") + " ECV");
		JTextField steinResults = new JTextField("Stein: " + s.getPoll("Stein") + "%, " + s.getECV("Stein") + " ECV");
		JTextField mcmullinResults = new JTextField("McMullin: " + s.getPoll("McMullin") + "%, " + s.getECV("McMullin") + " ECV");
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
		else {
			results = new JTextField("No one got the required votes, the race will now go to the house.");
		}
		
		String repSenExp = "" + (-54+RS);
		if(RS>54) {
			repSenExp = "+" + (-54+RS);
		}
		String demSenExp = "" + (-46+DS);
		if(RS>46) {
			demSenExp = "+" + (-46+DS);
		}
		String libSenExp = "+" + (0+LS);
		String grnSenExp = "+" + (0+GS);
		
		JTextField repSenResults = new JTextField("Republican Senators: " + RS + ", " + repSenExp);
		JTextField demSenResults = new JTextField("Democratic Senators: " + DS + ", " + demSenExp);
		JTextField libSenResults = new JTextField("Libertarian Senators: " + LS + ", " + libSenExp);
		JTextField grnSenResults = new JTextField("Green Senators: " + GS + ", " + grnSenExp);

		trumpResults.setEditable(false);
		clintonResults.setEditable(false);
		johnsonResults.setEditable(false);
		steinResults.setEditable(false);
		mcmullinResults.setEditable(false);
		results.setEditable(false);
		repSenResults.setEditable(false);
		demSenResults.setEditable(false);
		libSenResults.setEditable(false);
		grnSenResults.setEditable(false);

		mainFrame.add(trumpResults);
		mainFrame.add(clintonResults);
		mainFrame.add(johnsonResults);
		mainFrame.add(steinResults);
		mainFrame.add(mcmullinResults);
		mainFrame.add(results);
		mainFrame.add(repSenResults);
		mainFrame.add(demSenResults);
		mainFrame.add(libSenResults);
		mainFrame.add(grnSenResults);

		// Finalize the frame.
		mainFrame.setSize(new Dimension(950, 500));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		//Set JFrame to center of screen
		mainFrame.setLocation(d.width/2-mainFrame.getSize().width/2, d.height/2-mainFrame.getSize().height/2);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);	
	}
	
	public void senateResults() {
        double RHI = 22.2 * (s.Hawaii.getRep()/30.0);
        double DHI = 73.6 * (s.Hawaii.getDem()/62.2);        
        double LHI = 1.6 * (s.Hawaii.getLib()/3.7);        
        if(RHI > DHI && RHI > LHI){
            RS = RS + 1;
        }
        else if(DHI > RHI && DHI > LHI){
            DS = DS + 1;
        }
        else if(LHI > DHI && LHI > RHI){
            LS = LS + 1;
        }  
        double RAK = 44.3 * (s.Alaska.getRep()/51.3);
        double DAK = 11.1 * (s.Alaska.getDem()/36.6);        
        double LAK = 29.5 * (s.Alaska.getLib()/5.9);  
        if(RAK > DAK && RAK > LAK){
            RS = RS + 1;
        }
        else if(DAK > RAK && DAK > LAK){
            DS = DS + 1;
        }
        else if(LAK > DAK && LAK > RAK){
            LS = LS + 1;
        }
        double ROR = 33.6 * (s.Oregon.getRep()/39.1);
        double DOR = 56.7 * (s.Oregon.getDem()/50.1);        
        double LOR = 1.2  * (s.Oregon.getLib()/4.7);  
        double GOR = 2.4  * (s.Oregon.getGreen()/2.5);          
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
        double RWA = 40.9 * (s.Washington.getRep()/36.8);
        double DWA = 59.1 * (s.Washington.getDem()/52.5);                
        if(RWA > DWA){
            RS = RS + 1;
        }
        else if(DWA > RWA){
            DS = DS + 1;
        }    
        double RNV = 44.7 * (s.Nevada.getRep()/45.5);
        double DNV = 47.1 * (s.Nevada.getDem()/47.9);                
        if(RNV > DNV){
            RS = RS + 1;
        }
        else if(DNV > RNV){
            DS = DS + 1;
        }   
        double RID = 66.1 * (s.Idaho.getRep()/59.3);
        double DID = 27.8 * (s.Idaho.getDem()/27.5);                
        if(RID > DID){
            RS = RS + 1;
        }
        else if(DID > RID){
            DS = DS + 1;
        }  
        double RUT = 68.0 * (s.Utah.getRep()/45.5);
        double DUT = 27.4 * (s.Utah.getDem()/27.5);                
        if(RUT > DUT){
            RS = RS + 1;
        }
        else if(DUT > RUT){
            DS = DS + 1;
        } 
        /*
        double RAZ = 33.6 * (s.Arizona.TrumpAZ/39.1);
        double DAZ = 56.7 * (s.Arizona.ClintonAZ/50.1);        
        double GAZ = 2.4  * (s.Arizona.SteinAZ/2.5);          
        if(RAZ > DAZ && RAZ > GAZ){
            RS = RS + 1;
        }
        else if(DAZ > RAZ && DAZ > GAZ){
            DS = DS + 1;
        }
        else if(GAZ > RAZ && GAZ > DAZ){
            GS = GS + 1;
        } 
        double RCO = 45.3 * (Colorado.TrumpCO/43.3);
        double DCO = 49.2 * (Colorado.ClintonCO/48.2);        
        double LCO = 3.5  * (Colorado.JohnsonCO/5.2);  
        double GCO = 1.2  * (Colorado.SteinCO/1.4);          
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
        double RND = 78.6 * (North_Dakota.TrumpND/63.0);
        double DND = 17.0 * (North_Dakota.ClintonND/27.2);        
        double LND = 3.1  * (North_Dakota.JohnsonND/6.2);          
        if(RND > DND && RND > LND){
            RS = RS + 1;
        }
        else if(DND > RND && DND > LND){
            DS = DS + 1;
        }
        else if(LND > RND && LND > DND){
            LS = LS + 1;
        } 
        double RSD = 71.8 * (South_Dakota.TrumpSD/61.5);
        double DSD = 28.2 * (South_Dakota.ClintonSD/31.7);                
        if(RSD > DSD){
            RS = RS + 1;
        }
        else if(DSD > RSD){
            DS = DS + 1;
        }
        double RKS = 62.4 * (Kansas.TrumpKS/56.7);
        double DKS = 32.1 * (Kansas.ClintonKS/36.1);        
        double LKS = 5.5  * (Kansas.JohnsonKS/4.7);          
        if(RKS > DKS && RKS > LKS){
            RS = RS + 1;
        }
        else if(DKS > RKS && DKS > LKS){
            DS = DS + 1;
        }
        else if(LKS > RKS && LKS > DKS){
            LS = LS + 1;
        } 
        double ROK = 67.7 * (Oklahoma.TrumpOK/65.3);
        double DOK = 24.6 * (Oklahoma.ClintonOK/28.9);        
        double LOK = 3.0  * (Oklahoma.JohnsonOK/5.7);          
        if(ROK > DOK && ROK > LOK){
            RS = RS + 1;
        }
        else if(DOK > ROK && DOK > LOK){
            DS = DS + 1;
        }
        else if(LOK > ROK && LOK > DOK){
            LS = LS + 1;
        } 
        double RIA = 60.2 * (Iowa.TrumpIA/51.1);
        double DIA = 35.7 * (Iowa.ClintonIA/41.7);        
        double LIA = 2.7  * (Iowa.JohnsonIA/3.8);          
        if(RIA > DIA && RIA > LIA){
            RS = RS + 1;
        }
        else if(DIA > RIA && DIA > LIA){
            DS = DS + 1;
        }
        else if(LIA > RIA && LIA > DIA){
            LS = LS + 1;
        }   
        double RMO = 49.4 * (Missouri.TrumpMO/56.4);
        double DMO = 46.2 * (Missouri.ClintonMO/37.9);        
        double LMO = 2.4  * (Missouri.JohnsonMO/3.4);  
        double GMO = 1.1  * (Missouri.JohnsonMO/0.9);          
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
        double RAR = 59.8 * (Arkansas.TrumpAR/60.6);
        double DAR = 36.2 * (Arkansas.ClintonAR/33.7);        
        double LAR = 4.0  * (Arkansas.JohnsonAR/2.6);          
        if(RAR > DAR && RAR > LAR){
            RS = RS + 1;
        }
        else if(DAR > RAR && DAR > LAR){
            DS = DS + 1;
        }
        else if(LAR > RAR && LAR > DAR){
            LS = LS + 1;
        }    
        double RLA1 = 25*(Louisiana.TrumpLA/58.1);
        double RLA2 = 15.4*(Louisiana.TrumpLA/58.1);        
        double DLA1 = 17.5*(Louisiana.TrumpLA/38.4);        
        double DLA2 = 12.5*(Louisiana.TrumpLA/38.4);   
        if(RLA1 > RLA2 && RLA1 > DLA1 && RLA1 > DLA2){
            if(RLA2 > DLA1 && RLA2 > DLA2){
                RS = RS + 1;
            }   
            else if(DLA1 > RLA2 && DLA1 > DLA2||DLA2 > RLA2 && DLA2 > DLA1){
                double RLA = 60.7*(Louisiana.TrumpLA/58.1);
                double DLA = 39.3*(Louisiana.TrumpLA/38.4); 
                if(RLA>DLA){
                    RS = RS + 1;
                }
                else if(DLA>RLA){
                    DS = DS + 1;
                }
            } 
        }
        else if(RLA2 > RLA1 && RLA2 > DLA1 && RLA2 > DLA2){
            if(RLA1 > DLA1 && RLA1 > DLA2){
                RS = RS + 1;
            }   
            else if(DLA1 > RLA1 && DLA1 > DLA2||DLA2 > RLA1 && DLA2 > DLA1){
                double RLA = 60.7*(Louisiana.TrumpLA/58.1);
                double DLA = 39.3*(Louisiana.TrumpLA/38.4); 
                if(RLA>DLA){
                    RS = RS + 1;
                }
                else if(DLA>RLA){
                    DS = DS + 1;
                }
            } 
        }   
        else if(DLA1 > RLA2 && DLA1 > RLA1 && DLA1 > DLA2){
            if(DLA2 > RLA1 && DLA2 > RLA2){
                DS = DS + 1;
            }   
            else if(RLA1 > DLA2 && RLA1 > RLA2||RLA2 > RLA1 && RLA2 > DLA2){
                double RLA = 60.7*(Louisiana.TrumpLA/58.1);
                double DLA = 39.3*(Louisiana.TrumpLA/38.4); 
                if(RLA>DLA){
                    RS = RS + 1;
                }
                else if(DLA>RLA){
                    DS = DS + 1;
                }
            } 
        } 
        else if(DLA2 > RLA2 && DLA2 > RLA1 && DLA2 > DLA1){
            if(DLA1 > RLA1 && DLA1 > RLA2){
                DS = DS + 1;
            }   
            else if(RLA1 > DLA1 && RLA1 > RLA2||RLA2 > RLA1 && RLA2 > DLA1){
                double RLA = 60.7*(Louisiana.TrumpLA/58.1);
                double DLA = 39.3*(Louisiana.TrumpLA/38.4); 
                if(RLA>DLA){
                    RS = RS + 1;
                }
                else if(DLA>RLA){
                    DS = DS + 1;
                }
            } 
        }        
        double RAL = 64.2 * (Alabama.TrumpAL/62.1);
        double DAL = 35.8 * (Alabama.ClintonAL/34.4);                
        if(RAL > DAL){
            RS = RS + 1;
        }
        else if(DAL > RAL){
            DS = DS + 1;
        }      
        double RFL = 52.0 * (Florida.TrumpFL/48.6);
        double DFL = 44.3 * (Florida.ClintonFL/47.4);        
        double LFL = 2.1  * (Florida.JohnsonFL/2.2);          
        if(RFL > DFL && RFL > LFL){
            RS = RS + 1;
        }
        else if(DFL > RFL && DFL > LFL){
            DS = DS + 1;
        }
        else if(LFL > RFL && LFL > DFL){
            LS = LS + 1;
        } 
        double RGA = 55.0 * (Georgia.TrumpGA/50.4);
        double DGA = 40.8 * (Georgia.ClintonGA/45.3);        
        double LGA = 4.2  * (Georgia.JohnsonGA/3.0);          
        if(RGA > DGA && RGA > LGA){
            RS = RS + 1;
        }
        else if(DGA > RGA && DGA > LGA){
            DS = DS + 1;
        }
        else if(LGA > RGA && LGA > DGA){
            LS = LS + 1;
        } 
        double RSC = 60.5 * (South_Carolina.TrumpSC/54.9);
        double DSC = 37.0 * (South_Carolina.ClintonSC/40.7);                
        if(RSC > DSC){
            RS = RS + 1;
        }
        else if(DSC > RSC){
            DS = DS + 1;
        }  
        double RNC = 51.1 * (North_Carolina.TrumpNC/49.8);
        double DNC = 45.3 * (North_Carolina.ClintonNC/46.2);        
        double LNC = 3.6  * (North_Carolina.JohnsonNC/2.7);          
        if(RNC > DNC && RNC > LNC){
            RS = RS + 1;
        }
        else if(DNC > RNC && DNC > LNC){
            DS = DS + 1;
        }
        else if(LNC > RNC && LNC > DNC){
            LS = LS + 1;
        } 
        double RWI = 50.2 * (Wisconsin.TrumpWI/47.2);
        double DWI = 46.8 * (Wisconsin.ClintonWI/46.5);        
        double LWI = 3.0  * (Wisconsin.JohnsonWI/3.6);          
        if(RWI > DWI && RWI > LWI){
            RS = RS + 1;
        }
        else if(DWI > RWI && DWI > LWI){
            DS = DS + 1;
        }
        else if(LWI > RWI && LWI > DWI){
            LS = LS + 1;
        } 
        double RIL = 40.2 * (Illinois.TrumpIL/38.4);
        double DIL = 54.4 * (Illinois.ClintonIL/55.2);        
        double LIL = 3.2  * (Illinois.JohnsonIL/3.7);  
        double GIL = 2.1  * (Illinois.SteinIL/1.4);          
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
        double RKY = 57.3 * (Kentucky.TrumpKY/62.5);
        double DKY = 42.7 * (Kentucky.ClintonKY/32.7);                
        if(RKY > DKY){
            RS = RS + 1;
        }
        else if(DKY > RKY){
            DS = DS + 1;
        }     
        double RIN = 52.1 * (Indiana.TrumpIN/56.5);
        double DIN = 42.4 * (Indiana.ClintonIN/37.5);        
        double LIN = 5.5  * (Indiana.JohnsonIN/4.9);          
        if(RIN > DIN && RIN > LIN){
            RS = RS + 1;
        }
        else if(DIN > RIN && DIN > LIN){
            DS = DS + 1;
        }
        else if(LIN > RIN && LIN > DIN){
            LS = LS + 1;
        }      
        double ROH = 58.3 * (Ohio.TrumpOH/51.3);
        double DOH = 36.9 * (Ohio.ClintonOH/43.2);        
        double GOH= 1.6  * (Ohio.SteinOH/0.8);          
        if(ROH > DOH && ROH > GOH){
            RS = RS + 1;
        }
        else if(DOH > ROH && DOH > GOH){
            DS = DS + 1;
        }
        else if(GOH> ROH && GOH> DOH){
            GS = GS + 1;
        }  
        double RMD = 36.4 * (Maryland.TrumpMD/33.9);
        double DMD = 60.4 * (Maryland.ClintonMD/60.3);        
        double GMD= 3.2  * (Maryland.SteinMD/1.3);          
        if(RMD > DMD && RMD > GMD){
            RS = RS + 1;
        }
        else if(DMD > RMD && DMD > GMD){
            DS = DS + 1;
        }
        else if(GMD> RMD && GMD> DMD){
            GS = GS + 1;
        } 
        double RPA = 48.9 * (Pennsylvania.TrumpPA/48.2);
        double DPA = 47.2 * (Pennsylvania.ClintonPA/47.5);        
        double LPA= 3.9  * (Pennsylvania.JohnsonPA/2.4);          
        if(RPA > DPA && RPA > LPA){
            RS = RS + 1;
        }
        else if(DPA > RPA && DPA > LPA){
            DS = DS + 1;
        }
        else if(LPA> RPA && LPA> DPA){
            LS = LS + 1;
        } 
        double RNY = 27.4 * (New_York.TrumpNY/36.5);
        double DNY = 70.4 * (New_York.ClintonNY/59.0);        
        double LNY = 0.6  * (New_York.JohnsonNY/2.3);  
        double GNY = 1.5  * (New_York.SteinNY/1.4);          
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
        double RCT = 34.9 * (Connecticut.TrumpCT/40.9);
        double DCT = 62.9 * (Connecticut.ClintonCT/54.6);        
        double LCT = 1.1  * (Connecticut.JohnsonCT/3.0);  
        double GCT = 1.0  * (Connecticut.SteinCT/1.4);          
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
        double RVT = 33.1 * (Vermont.TrumpVT/30.3);
        double DVT = 61.3 * (Vermont.ClintonVT/56.7);                
        if(RVT > DVT){
            RS = RS + 1;
        }
        else if(DVT > RVT){
            DS = DS + 1;
        }     
        double RNH = 47.9 * (New_Hampshire.TrumpNH/46.5);
        double DNH = 48.0 * (New_Hampshire.ClintonNH/46.8);        
        double LNH= 1.8  * (New_Hampshire.JohnsonNH/4.1);          
        if(RNH > DNH && RNH > LNH){
            RS = RS + 1;
        }
        else if(DNH > RNH && DNH > LNH){
            DS = DS + 1;
        }
        else if(LNH> RNH && LNH> DNH){
            LS = LS + 1;
        }  
        */   
	}
		
}