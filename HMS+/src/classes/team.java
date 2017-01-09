package classes;

import java.util.ArrayList;
import java.util.List;

public class team {
	private int Goals;
	private String Name, Short_name;
	private ArrayList<player> players = new ArrayList<player>();
	private ArrayList<player> lineup = new ArrayList<player>();
	public team(){
		Goals=0;
		lineup = new ArrayList<player>();
	}
	public team(String N){
		Short_name=N;
		setName(N);
		Goals=0;
		lineup = new ArrayList<player>();
	}
	// Procedure to assign values
	// Procedure to get values
	public void setName(String N){Name=N;}
	public String getName(){
		return Name;
	}
	public String getShortName(){
		return Short_name;
	}
	public String getAlias(int P){
		return players.get(P).getAlias();
	}
	public int getGoals(){
		return Goals;
	}
	// Procedures
	public void AddPlayer(player p){
		players.add(p);
	}
	public void CreateLineUp(player p){
		lineup.add(p);
	}
	public void Goal(int P){
		for (int i=0;i<players.size()-1;i++){
			if (lineup.get(P).getAlias().equals(players.get(i).getAlias())){
				players.get(i).Goal();
			}
		}
		Goals++;
	}
	public void UpdateMinutes(){
		for(int P=0; P<7; P++){
			for (int i=0;i<players.size()-1;i++){
				if (lineup.get(P).getAlias().equals(players.get(i).getAlias())){
					players.get(i).Minute();
				}
			}
		}
	}
	public int GetAVG(){
		int AVG=0;
		for(int P=0; P<7; P++){
			AVG=AVG+lineup.get(P).GetAVG(P);
		}
		return (int) Math.round(AVG*2);
	}
	public String Report(){
		String report = String.format("%1$-14s","Name");
		report=report +String.format("%1$-4s","Nat");
		report=report +String.format("%1$-4s","Age");
		report=report +String.format("%1$4s","GK");
		report=report +String.format("%1$4s","WG");
		report=report +String.format("%1$4s","BK");
		report=report +String.format("%1$4s","CR");
		report=report +String.format("%1$4s","CE");
		report=report +String.format("%1$5s","Mins");
		report=report +String.format("%1$6s","Goals");
		report=report +String.format("%1$5s","Excl");
		report=report+"\n";
		report=report+String.format("%1$-58s","").replace(" ", "-");
		report=report+"\n";
		for (int i=0; i<players.size(); i++){
			players.get(i).UpdateValues();
			report=report +String.format("%1$-14s",players.get(i).getAlias());
			report=report +String.format("%1$-4s",players.get(i).getNationallity());
			report=report +String.format("%1$3s",(players.get(i).getAge()));
			report=report +String.format("%1$5s",(players.get(i).getGK()));
			report=report +String.format("%1$4s",(players.get(i).getWG()));
			report=report +String.format("%1$4s",(players.get(i).getBK()));
			report=report +String.format("%1$4s",(players.get(i).getCR()));
			report=report +String.format("%1$4s",(players.get(i).getCE()));
			report=report +String.format("%1$5s",(players.get(i).getMinutes()));
			report=report +String.format("%1$6s",(players.get(i).getGoals()));
			report=report +String.format("%1$5s",(players.get(i).getExclutions()));
			if (i<players.size()-1) {report=report+"\n";}
		}
		return report;
	}
}
