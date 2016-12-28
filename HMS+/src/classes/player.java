package classes;

public class player {
	String Alias; //
	String Nationallity; // 
	int Age, GK, CE, WG, BK, CR; // Static values
	int Goals, Exclutions, Minutes; // Variables values
	int PGoals, PExclutions, PMinutes; // In-Game values

	public player()  {
		PGoals=0;
		PExclutions=0;
		PMinutes=0;
	}
	
	public player(String A,String N, int Y, int G, int C, int W, int B, int R)  {
		setAlias(A);
		setNationallity(N);
		setAge(Y);
		setGK(G);
		setCE(C);
		setWG(W);
		setBK(B);
		setCR(R);
		PGoals=0;
		PExclutions=0;
		PMinutes=0;
	}
	// Procedure to assign values
	private void setAlias(String x) {
		Alias = x;
	}
	
	private void setNationallity(String x) {
		Nationallity = x;
	}
	
	private void setAge(int x) {
		Age = x;
	}
	
	private void setGK(int x) {
		GK = x;
	}
	
	private void setCE(int x) {
		CE = x;
	}
	
	private void setWG(int x) {
		WG = x;
	}
	
	private void setBK(int x) {
		BK = x;
	}
	
	private void setCR(int x) {
		CR = x;
	}
	// Procedure to get values
	private String getAlias() {
		return Alias;
	}
	
	private String getNationallity() {
		return Nationallity;
	}
	
	private int getAge() {
		return Age;
	}
	
	private int getGK() {
		return GK;
	}
	
	private int getCE() {
		return CE;
	}
	
	private int getWG() {
		return WG;
	}
	
	private int getBK() {
		return BK;
	}
	
	private int getCR() {
		return CR;
	}
	// Procedures 
	public void Goal(){
		PGoals++;
	}
	public void Exclution(){
		if (PExclutions <2) {
			PExclutions++;
		}
	}
	public boolean IsExcluded (){
		boolean Excluded=false;
		if (PExclutions >=2) {
			Excluded=true;
		}
		return Excluded;
	}
	public void Minute(){
		PMinutes++;
	}
	public int GetAVG(int P){
		int Avg=0;
		switch (P) {
			case 0:
				Avg = getGK();
				break;
			case 1:
				Avg = getGK();
				break;
			case 2:
				Avg = getGK();
				break;
			case 3:
				Avg = getGK();
				break;
			case 4:
				Avg = getGK();
				break;
			default:
				break;
		}
		return Avg;
	}
	//Update finally values
	public void UpdateValues(){
		Goals=Goals+PGoals;
		Exclutions=Exclutions+PExclutions;
		Minutes=Minutes+PMinutes;
	}
}
