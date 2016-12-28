import classes.player;
import classes.team;

public class game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		team Home=new team();
		team Away=new team();
		for (int p=1; p<=2;p++){
			if (p==1){
				System.out.println ("Primera parte <=> Marcador: " + Home.getGoals() +" - " + Away.getGoals());
				System.out.println ("Comienza el Partido");
				System.out.println ("");
			}
			else {
				System.out.println ("");
				System.out.println ("Segunda parte <=> Marcador: " + Home.getGoals() +" - " + Away.getGoals());
				System.out.println ("Comienza el Partido");
				System.out.println ("");
			}
			for (int m=0; m<30;m++){
				System.out.println ("Min " + m + ": ");
			}
		}
		System.out.println ("");
		System.out.println ("Final del Partido <=> Marcador: " + Home.getGoals() +" - " + Away.getGoals());
		System.out.println ("");
	}
}
