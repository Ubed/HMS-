package classes;

import java.util.ArrayList;
import java.util.List;

public class team {
	private int Goals;
	private String Name;
	private ArrayList<player> players = new ArrayList<player>();
	public team(){
		Goals=0;	
	}
	public team(String N){
		Name=N;
		Goals=0;	
	}
	// Procedure to assign values
	// Procedure to get values
	public String getName(){
		return Name;
	}
	public int getGoals(){
		return Goals;
	}
	// Procedures
	public void AddPlayer(player p){
		players.add(p);
	}
	public void Goal(int P){
		players.get(P).Goal();
		Goals++;
	}
	public void Goal(){
		Goals++;
	}
	public int GetAVG(){
		int AVG=0;
		for(int P=0; P<7; P++){
			AVG=AVG+players.get(P).GetAVG(P);
		}
		return (int) Math.round(AVG/7);
	}	
}
