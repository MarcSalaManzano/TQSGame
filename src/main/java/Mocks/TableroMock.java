package Mocks;

import TQSGame.*;

/**
 * 
 * @author Adrian Delgado
 *
 * Clase que simula un tablero para testear el controlador Game
 * Contiene una pequeña baraja de 24 cartas
 * Puede simular el coger una carta de la baraja, guardar en una pila y 
 * mover cartas/columnas entre ellas
 */

public class TableroMock implements Tablero{
	RandomBaraja baraja = new RandomBaraja();
	Pila pilaOro = new Pila("Oro");
	Pila pilaBasto = new Pila("Basto");
	Carta cartaFuera = baraja.pullCard();
	Columna columnas[] = new Columna[3];
	
	public void addAPila(Carta carta, String paloPila) {
		switch(paloPila) {
		case "Oro": pilaOro.addCard(carta);
		case "Basto": pilaBasto.addCard(carta);
		}
	}
	
	public boolean getBaraja() { return true; }
	
	public Pila[] getPilas() { Pila[] pila = {pilaOro, pilaBasto}; return pila;}
	
	public Columna[] getColumnas() { return columnas; }
	
	public Carta getCartaFuera() { return cartaFuera; }
	
	public void sacaCarta() { cartaFuera = baraja.pullCard(); }
	
	public void moverAColumna(int columnaOrigen, int columnaDestino, int cartasAMover) {
		if(cartasAMover == 1) {
			columnas[columnaDestino].addCard(columnas[columnaOrigen].pullCard());
		}
		else
			columnas[columnaDestino].addColumna(columnas[columnaOrigen].pullColumna(cartasAMover));
	} //Si cartasAMover == 1, se mueve 1 carta sola de un sitio a otro.
	
	public Carta sacaCartaColumna(int columna) { return columnas[columna].pullCard(); }
	
	public void addCartaColumna(int columna, Carta carta) {columnas[columna].addCard(carta); }
}
