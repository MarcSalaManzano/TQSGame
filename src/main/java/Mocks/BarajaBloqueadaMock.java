package Mocks;
import java.util.LinkedList;
import java.util.Queue;

import TQSGame.BarajaI;
import TQSGame.Carta;

public class BarajaBloqueadaMock implements BarajaI{
	
	private Queue<Carta> cartas = new LinkedList<Carta>();
	private int numCartas = 48;
	
	public BarajaBloqueadaMock() { this.creaBaraja(); }
	
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
		cartas.add(new Carta("Basto", 12));
		cartas.add(new Carta("Oro", 9));
		cartas.add(new Carta("Oro", 10));
		cartas.add(new Carta("Basto", 7));
		cartas.add(new Carta("Basto", 11));
		cartas.add(new Carta("Oro", 8));
		cartas.add(new Carta("Copa", 2));
		cartas.add(new Carta("Oro", 7));
		cartas.add(new Carta("Oro", 11));
		cartas.add(new Carta("Espada", 6));
		cartas.add(new Carta("Copa", 5));
		cartas.add(new Carta("Copa", 7));
		cartas.add(new Carta("Copa", 11));
		cartas.add(new Carta("Espada", 5));
		cartas.add(new Carta("Copa", 4));
		cartas.add(new Carta("Copa", 6));
		cartas.add(new Carta("Copa", 8));
		cartas.add(new Carta("Espada", 7));
		cartas.add(new Carta("Espada", 3));
		cartas.add(new Carta("Espada", 1));
		cartas.add(new Carta("Espada", 2));
		cartas.add(new Carta("Copa", 9));
		cartas.add(new Carta("Espada", 9));
		cartas.add(new Carta("Espada", 11));
		cartas.add(new Carta("Oro", 6));
		cartas.add(new Carta("Basto", 9));
		cartas.add(new Carta("Copa", 3));
		cartas.add(new Carta("Oro", 12));
		cartas.add(new Carta("Espada", 12));
		cartas.add(new Carta("Copa", 12));
		cartas.add(new Carta("Basto", 10));
		cartas.add(new Carta("Oro", 1));
		cartas.add(new Carta("Oro", 4));
		cartas.add(new Carta("Oro", 5));
		cartas.add(new Carta("Espada", 8));
		cartas.add(new Carta("Espada", 10));
		cartas.add(new Carta("Copa", 10));
		cartas.add(new Carta("Espada", 4));
		cartas.add(new Carta("Basto", 2));
		cartas.add(new Carta("Basto", 6));
		cartas.add(new Carta("Basto", 5));
		cartas.add(new Carta("Basto", 1));
		cartas.add(new Carta("Basto", 3));
		cartas.add(new Carta("Basto", 4));
		cartas.add(new Carta("Basto", 8));
		cartas.add(new Carta("Oro",3));
		cartas.add(new Carta("Oro", 2));
		cartas.add(new Carta("Copa", 1));
	}

	@Override
	public int getNumCartas() {
		return numCartas;
	}

}
