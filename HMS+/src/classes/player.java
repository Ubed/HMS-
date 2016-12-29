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
	
	public player(String A,String N, int Y, int G, int C, int W, int B, int R, int Gl, int M, int E)  {
		setAlias(A);
		setNationallity(N);
		setAge(Y);
		setGK(G);
		setCE(C);
		setWG(W);
		setBK(B);
		setCR(R);
		setGoals(Gl);
		setMinutes(M);
		setExclutions(E);
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
	
	private void setGoals(int x) {
		Goals = x;
	}
	
	private void setMinutes(int x) {
		Minutes = x;
	}
	
	private void setExclutions(int x) {
		Exclutions = x;
	}
	// Procedure to get values
	public String getAlias() {
		return Alias;
	}
	
	public String getNationallity() {
		return Nationallity;
	}
	
	public int getAge() {
		return Age;
	}
	
	public int getGK() {
		return GK;
	}
	
	public int getCE() {
		return CE;
	}
	
	public int getWG() {
		return WG;
	}
	
	public int getBK() {
		return BK;
	}
	
	public int getCR() {
		return CR;
	}
	
	public int getGoals() {
		return Goals;
	}
	
	public int getMinutes() {
		return Minutes;
	}
	
	public int getExclutions() {
		return Exclutions;
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
			case 5:
				Avg = getWG();
				break;
			case 2:
			case 4:
				Avg = getBK();
				break;
			case 3:
				Avg = getCR();
				break;
			default :
				Avg = getCE();
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
