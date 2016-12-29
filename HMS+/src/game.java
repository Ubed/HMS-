import classes.player;
import classes.team;

public class game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		team Home=new team();
		team Away=new team();
		int HomeAVG=80;
		int AwayAVG=55;
		int nactions=0;
		for (int p=1; p<=2;p++){
			if (p==1){ // Printing start first time
				System.out.println ("Primera parte <=> Marcador: " + Home.getGoals() +" - " + Away.getGoals());
				System.out.println ("Comienza el Partido");
				System.out.println ("");
			}
			else { // Printing start second time
				System.out.println ("");
				System.out.println ("Segunda parte <=> Marcador: " + Home.getGoals() +" - " + Away.getGoals());
				System.out.println ("Comienza el Partido");
				System.out.println ("");
			}
			for (int m=0; m<30;m++){
				//System.out.println ("Min " + m + ": ");
				nactions=getActions();
				for (int i=1; i<=nactions; i++){
					System.out.println ("Actions " + i + ": " );
				}
			}
		}
		System.out.println ("");
		System.out.println ("Final del Partido <=> Marcador: " + Home.getGoals() +" - " + Away.getGoals());
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
}
