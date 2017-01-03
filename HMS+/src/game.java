import classes.player;
import classes.team;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import classes.actions;

public class game {
	private static team Home = new team();
	private static team Away = new team();
	private static int possesion;
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String fileName = "HMS.db";
		String url = "jdbc:sqlite:./db/" + fileName;
		int nactions=0;
		Random rn = new Random();
		possesion = rn.nextInt(2);
		System.out.println ("El arbitro procede al sorteo del saque.");
		String SAction="";
		Home =new team("nyc");
		Away =new team("hue");
//		loadTeam(Home);
//		loadTeam(Away);
		fillTeam(Home);
		fillTeam(Away);
		/*try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
		for (int p=1; p<=2;p++){
			if (p==1){ // Printing start first time
				System.out.println ("Primera parte <=> Marcador: "+ Home.getName() + " " + Home.getGoals() +" - " + Away.getGoals() +" " +Away.getName());
				System.out.println ("Comienza el Partido");
				System.out.println ("");
			}
			else { // Printing start second time
				System.out.println ("");
				System.out.println ("Segunda parte <=> Marcador: "+ Home.getName() + " " + Home.getGoals() +" - " + Away.getGoals() +" " +Away.getName());
				System.out.println ("Comienza el Partido");
				System.out.println ("");
			}
			for (int m=0; m<30;m++){
				nactions=getActions();
				for (int i=1; i<=nactions; i++){
					SAction="Min " + m + ": " + NewAction();
					String attackTeam="";
					if (possesion==1){
						attackTeam="Away";
					} else {
						attackTeam="Home";	
					}
					System.out.println(SAction);
					ChangePosession();
				}
				updateMinutes();
			}
		}
		System.out.println ("");
		System.out.println ("Final del Partido <=> Marcador: "+ Home.getName() + " " + Home.getGoals() +" - " + Away.getGoals() +" " +Away.getName());
		//System.out.println ("Home: "+ Home.GetAVG());
		//System.out.println ("Away: "+ Away.GetAVG());
		System.out.println ("");
		FinallyReport();
		saveToFile(Home);
		saveToFile(Away);
	}
	private static int getActions(){ //Ratio for actions (55 => One Action per minute; 35 => One Action per minute;10 => One Action per minute;)
		int nactions=0;
		double randNumber = Math.random();
		int d = (int) Math.round(randNumber * 100 + 1);
		if (d<=55) {
			nactions=1;
		} else if (d>55 && d<=90) {
			nactions=2;
		} else {
			nactions=3;
		}
		return nactions;
	}
	private static void ChangePosession(){
		if (possesion==0){
			possesion=1;
		} else {
			possesion=0;
		}
	}
	private static String NewAction(){ 
		Random rn = new Random();
		Random rnAction = new Random();
		String SAction;
		int DiffValue=GetDiffValue();
		// Randomize logical of actions
		if (rnAction.nextInt(100)+1>DiffValue){
			SAction=Goal(rn.nextInt(6)+1);
		} else {
			SAction="Fallo";
		}
		return SAction; 
	}
	private static String Goal(int p){ 
		actions Action=new actions();
		String SGoal;
		String Alias;
		if (possesion==1){
			Away.Goal(p);
			Alias=Away.getAlias(p);
		} else {
			Home.Goal(p);			
			Alias=Home.getAlias(p);
		}
		switch (p){
		case 1:
		case 5:
			SGoal=Action.ExGoal(Alias);
			break;
		case 2:
		case 4:
			SGoal=Action.BkGoal(Alias);
			break;
		case 3:
			SGoal=Action.CrGoal(Alias);
			break;
		default:
			SGoal=Action.CeGoal(Alias);
			break;
		}
		return SGoal;
	}
	private static String Fail(int p){ 		
		actions Action=new actions();
		String SFail;
		switch (p){
		case 1:
		case 5:
			SFail=Action.ExFail("Jugador");
			break;
		case 2:
		case 4:
			SFail=Action.BkFail("Jugador");
			break;
		case 3:
			SFail=Action.CrFail("Jugador");
			break;
		default:
			SFail=Action.CeFail("Jugador");
			break;
		}
		return SFail;
	}
	private static String Exclution(int p){ 
		actions Action=new actions();
		String SExclution;
		switch (p){
		case 1:
		case 5:
			SExclution=Action.ExFail("Jugador");
			break;
		case 2:
		case 4:
			SExclution=Action.BkFail("Jugador");
			break;
		case 3:
			SExclution=Action.CrFail("Jugador");
			break;
		default:
			SExclution=Action.CeFail("Jugador");
			break;
		}
		return SExclution;
	}
	private static int GetDiffValue(){
		int DiffValue=0;
		int HomeAVG=Home.GetAVG();
		int AwayAVG=Away.GetAVG();
		if (HomeAVG>=AwayAVG && possesion<1){ DiffValue=HomeAVG-AwayAVG;}
		else if (HomeAVG>=AwayAVG && possesion>=1){ DiffValue=HomeAVG-(AwayAVG-((int) Math.round((HomeAVG-AwayAVG)/2)));}
		else if (HomeAVG<AwayAVG && possesion<1){ DiffValue=AwayAVG-(HomeAVG-((int) Math.round((AwayAVG-HomeAVG)/2)));}
		else { DiffValue=AwayAVG-HomeAVG;}
		return DiffValue;
	}
	private static void updateMinutes(){
		Home.UpdateMinutes();		
		Away.UpdateMinutes();
	}
	private static void loadTeam(team T){
		for (int i=0; i<12;i++){
			String A=T.getName()+ " " + (i+1);
			String N="esp";
			Random rn = new Random();
			int Y=20; 
			int G=rn.nextInt(10)+1;
			int C=rn.nextInt(10)+1;
			int W=rn.nextInt(10)+1;
			int B=rn.nextInt(10)+1;
			int R=rn.nextInt(10)+1;
			T.AddPlayer(new player(A, N, Y, G, C, W, B, R,0,0,0));
		}
	}
	
	private static void FinallyReport(){
			System.out.println (Home.Report());
			System.out.println ("");
			System.out.println (Away.Report());
	}
	
	private static void saveToFile(team T){
		FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/"+T.getName()+".txt");
            pw = new PrintWriter(fichero);
            pw.print(T.Report());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
	}
	
	public static void fillTeam(team e) throws FileNotFoundException, IOException {
		File f = new File ("C:\\" + e.getName() + ".txt");
		File f2 = new File ("C:\\" + e.getName() + ".txt");
        FileReader fr = new FileReader(f);
        FileReader fr2 = new FileReader(f2);
        BufferedReader bf = new BufferedReader(fr);
        BufferedReader bf2 = new BufferedReader(fr2);
        DefaultListModel l =new DefaultListModel();
        String STeam, sLineUp;
        String A,N;
        ArrayList<String> jAli = new ArrayList();
        int GK, CE, CR, BK, WG,i;
        int G,M,E,Y;
        for(i=0; i<2; i++){
            bf.readLine();
            bf2.readLine();
        }
        jAli.clear();
        for(i=0;i<7;i++){
        	sLineUp = bf2.readLine();
               jAli.add(sLineUp.substring(0, 13).trim());
        }
        
        while ((STeam = bf.readLine())!=null) {
            A=STeam.substring(0, 13).trim();
            N=STeam.substring(13, 17).trim();
            Y=Integer.parseInt(STeam.substring(17, 21).trim());
            GK=Integer.parseInt(STeam.substring(22, 26).trim());
            WG=Integer.parseInt(STeam.substring(26, 30).trim());
            BK=Integer.parseInt(STeam.substring(30, 34).trim());
            CR=Integer.parseInt(STeam.substring(34, 38).trim());
            CE=Integer.parseInt(STeam.substring(38, 42).trim());
            M=Integer.parseInt(STeam.substring(42, 48).trim());
            G=Integer.parseInt(STeam.substring(48, 54).trim());
            E=Integer.parseInt(STeam.substring(53, 58).trim());
            Random rn = new Random();
            if (GK<1) { GK=rn.nextInt(10)+1; }
            if (WG<1) { WG=rn.nextInt(10)+1; }
            if (BK<1) { BK=rn.nextInt(10)+1; }
            if (CR<1) { CR=rn.nextInt(10)+1; }
            if (CE<1) { CE=rn.nextInt(10)+1; }
            E=0;
            for (i=0; i<jAli.size();i++){
	            if(jAli.get(i).equals(STeam.substring(0, 13).trim())){
	            	if (i==0){
	            		if (GK<=1) { GK=rn.nextInt(10)+1; }
		                WG=1;
		                BK=1; 
		                CR=1; 
		                CE=1; 
	                }
	            	e.CreateLineUp(new player(A, N, Y, GK, CE, WG, BK, CR,G,M,E));
	            	
	            }     
            }
            e.AddPlayer(new player(A, N, Y, GK, CE, WG, BK, CR,G,M,E));
        }
     }
}
