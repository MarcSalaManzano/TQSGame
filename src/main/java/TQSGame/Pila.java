package TQSGame;

import java.util.Stack;

public class Pila {
	private Stack<Carta> cartas = new Stack<>();
	private String palo;
	
	public Pila(String palo) { this.palo = palo; }
	
	public void addCard(Carta carta) {
		if(cartaValida(carta) && !pilaLlena())
			cartas.push(carta);
	}
	
	public Carta peekCard() { 
		if(!cartas.empty())
			return cartas.peek(); 
		return null;
		}
	
	public boolean cartaValida(Carta carta) {
		if((peekCard() == null) && (carta.getNum() == 1) && (carta.getPalo() == this.palo))
			return true;
		if(peekCard() != null)
			return ((carta.getPalo() == this.palo) && carta.getNum() == peekCard().getNum() + 1);
		return false;
	}
	
	public boolean pilaLlena() { return cartas.size() == 12; }
}
