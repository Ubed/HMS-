package classes;

import java.util.ArrayList;

public class actions {
	public actions(){}
	//Goals Actions
	public String ExGoal(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " se eleva desde el extremo y bate al portero.");
		return Action.get(0);
	}
	public String BrGoal(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " se eleva desde el extremo y bate al portero.");
		return Action.get(0);
	}
}
