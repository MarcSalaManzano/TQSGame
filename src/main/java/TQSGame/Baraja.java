package TQSGame;

import java.util.LinkedList;
import java.util.Queue;

public class Baraja {
	
	private Queue<Carta> cartas = new LinkedList<Carta>();
	private int numCartas = 48;
	
	public int getNumCartas() {
		return numCartas;
	}

	public Baraja() {
		this.creaBaraja();
	}
	
	public void addCard(Carta carta) {
		numCartas++;
		cartas.add(carta);
	}
	
	public Carta pullCard() {
		if(numCartas > 0)
		{
			Carta returnCarta = cartas.peek();
			cartas.poll();
			numCartas--;
			return returnCarta;
		}
		
		return null;
	}
	
	private void creaBaraja() {
		String palo = "Oro";
		for(int i = 0; i < 12; i++)
			cartas.add(new Carta(palo, i + 1));
		palo = "Espada";
		for(int i = 0; i < 12; i++)
			cartas.add(new Carta(palo, i + 1));
		palo = "Basto";
		for(int i = 0; i < 12; i++)
			cartas.add(new Carta(palo, i + 1));
		palo = "Copa";
		for(int i = 0; i < 12; i++)
			cartas.add(new Carta(palo, i + 1));
	}
	
}
