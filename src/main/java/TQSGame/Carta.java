package TQSGame;

public class Carta {
	private String palo;
	private int num;
	
	public Carta(String palo, int num) {
		this.palo = palo;
		this.num = num;
	}
	
	//Getters
	public String getPalo() { return palo; }
	public int getNum() { return num; }
	
	@Override
	public String toString() {
		return palo.substring(0, 1) + num;
	}
	
	
}
