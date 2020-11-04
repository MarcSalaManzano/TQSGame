package TQSGame;

public class Carta implements Comparable<Carta>{
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
	public int compareTo(Carta card) {

		if(this.num > card.num) return 0;
		return 1;
	}
	
	
	
}
