import classes.player;
import classes.team;

import java.util.Random;

import classes.actions;

public class game {
	private static team Home = new team();
	private static team Away = new team();
	private static int possesion;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nactions=0;
		Random rn = new Random();
		possesion = rn.nextInt(2);
		System.out.println ("El arbitro procede al sorteo del saque.");
		String SAction="";
		Home =new team("Barcelona");
		Away =new team("Huesca");
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
					System.out.println(SAction+" => "+attackTeam);
					ChangePosession();
				}
			}
		}
		System.out.println ("");
		System.out.println ("Final del Partido <=> Marcador: "+ Home.getName() + " " + Home.getGoals() +" - " + Away.getGoals() +" " +Away.getName());
		System.out.println ("");
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
		int DiffValue;
		int HomeAVG=55;
		int AwayAVG=80;
		if (possesion > 1) { DiffValue=HomeAVG-AwayAVG;}
		else {DiffValue=HomeAVG-(AwayAVG-((int) Math.round((HomeAVG-AwayAVG)/2)));}
		if (DiffValue<0) {DiffValue=DiffValue*(-1);}
		if (rnAction.nextInt(100)+1>DiffValue){
			SAction=Goal(rn.nextInt(6)+1) + " " + DiffValue;
		} else {
			SAction="Fallo"  + " " + DiffValue;
		}
		return SAction; 
	}
	private static String Goal(int p){ 
		actions Action=new actions();
		String SGoal;
		if (possesion==1){
			Away.Goal();
		} else {
			Home.Goal();			
		}
		switch (p){
		case 1:
		case 5:
			SGoal=Action.ExGoal("Jugador");
			break;
		case 2:
		case 4:
			SGoal=Action.BrGoal("Jugador");
			break;
		case 3:
			SGoal=Action.CrGoal("Jugador");
			break;
		default:
			SGoal=Action.CeGoal("Jugador");
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
			SFail=Action.BrFail("Jugador");
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
			SExclution=Action.BrFail("Jugador");
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
	
	
}
