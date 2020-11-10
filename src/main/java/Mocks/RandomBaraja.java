package Mocks;

import java.util.LinkedList;
import java.util.Queue;

import TQSGame.Carta;

/**
 * 
 * @author Adrian Delgado
 * Mock de una baraja aleatoria para testear Game a través de TableroMock 
 * como el Tablero del juego real.
 * Contiene 24 cartas en un orden que simula ser aleatorio y usa 2 palos distintos.
 *
 */

public class RandomBaraja {

	private Queue<Carta> cartas = new LinkedList<Carta>();
	private int numCartas = 24;
	
	public int getNumCartas() {
		return numCartas;
	}

	public RandomBaraja() {
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
		for(int i = 12; i > 10; i--) {
			cartas.add(new Carta("Basto", i));
		}
		for(int i = 12; i > 8; i--) {
			cartas.add(new Carta("Oro", i));
		}
		for(int i = 10; i > 5; i--) {
			cartas.add(new Carta("Basto", i));
		}
		for(int i = 8; i > 6; i--) {
			cartas.add(new Carta("Oro", i));
		}
		for(int i = 5; i > 3; i--) {
			cartas.add(new Carta("Basto", i));
		}
		
		cartas.add(new Carta("Oro", 6));
		
		for(int i = 3; i > 0; i--) {
			cartas.add(new Carta("Basto", i));
		}
		for(int i = 5; i > 0; i--) {
			cartas.add(new Carta("Oro", i));
		}
		


	}
}
