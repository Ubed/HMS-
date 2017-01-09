package classes;

import java.util.ArrayList;
import java.util.Random;

public class actions {
	public actions(){}
	//Goals Actions
	public String ExGoal(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " se eleva desde el extremo y bate al portero.");
		Action.add(alias + " apura y suelta una rosca baja para batir al portero.");
		Action.add(alias + " bate a su defensor y se cuela entre dos.");
		Action.add(alias + " ve la salida del portero y anota de vaselina.");
		Action.add("Increible fly de " + alias + " que recibio el balon en el aire desde el central.");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
	public String BkGoal(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " arma y lanza un potente disparo desde 8 metros para batir al portero.");
		Action.add(alias + " se eleva tras un cruce con el central.");
		Action.add(alias + " penetra entre la defensa para anorta desde 6 metros.");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
	public String CeGoal(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " recibe un pase filtrado del central y bate al portero.");
		Action.add(alias + " se abre un hueco entre la defensa para recibir un pase y batir al portero.");
		Action.add(alias + " recibe un pase picado y se da la vuelta para anotar.");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
	public String CrGoal(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " anota un impresionante gol con un disparo de cadera");
		Action.add(alias + " saca un pontente disparo sin saltar que se cuela por la escuadra.");
		Action.add(alias + " finta a su par y se coloca en 6 metros para batir el portero.");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
	//Fail Actions
	public String ExFail(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " se eleva desde el extremo y bate al portero.");
		Action.add(alias + " apura y suelta una rosca baja para batir al portero.");
		Action.add(alias + " bate a su defensor y se cuela entre dos.");
		Action.add(alias + " ve la salida del portero y anota de vaselina.");
		Action.add("Increible fly de " + alias + " que recibio el balon en el aire desde el central.");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
	public String BkFail(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " pierde el balon");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
	public String CeFail(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " pierde el balon");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
	public String CrFail(String alias){
		ArrayList<String> Action = new ArrayList<String>();
		//int 
		Action.add(alias + " pierde el balon");
		Random rn = new Random();
		return Action.get(rn.nextInt(Action.size()));
	}
}
