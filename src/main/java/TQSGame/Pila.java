package TQSGame;

import java.util.Stack;

public class Pila {
	private Stack<Carta> cartas = null;
	private String palo;
	
	public Pila(String palo) { this.palo = palo; }
	
	public void addCard(Carta carta) {
		cartas.add(carta);
	}
	
	public Carta peekCard() { return cartas.peek(); }
}
