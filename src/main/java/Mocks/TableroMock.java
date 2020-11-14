package Mocks;

import TQSGame.*;

/**
 * 
 * @author Adrian Delgado
 *
 * Clase que simula un tablero para testear el controlador Game
 * Contiene una pequeña baraja de 24 cartas
 * Puede coger una carta de la baraja, guardar en una pila y 
 * mover cartas/columnas entre ellas
 */

public class TableroMock /*implements Tablero*/{ //Es
	RandomBaraja baraja = new RandomBaraja();
	Pila pilaOro = new Pila("Oro");
	Pila pilaBasto = new Pila("Basto");
	Carta cartaFuera = null;
	Columna[] columnas = { new Columna(), new Columna(), new Columna() };
	
	public void setColumnas(int idCol, Columna col) { columnas[idCol] = col; }
	
	public void addAPila(Carta carta, String paloPila) {
		switch(paloPila) {
		case "Oro": pilaOro.addCard(carta);
		case "Basto": pilaBasto.addCard(carta);
		}
	}
	public void repartirCartas() {

		for(int i = 1; i <= 3; i++) {
			for(int j = 0; j < i; j++) {
				sacaCarta();
				if(j == (i - 1))
					columnas[i-1].addCard(cartaFuera);
				else
					columnas[i-1].addCartaOculta(cartaFuera);
			}
		}
		sacaCarta();
	}
	public boolean getBaraja() { return true; }
	
	public Pila[] getPilas() { Pila[] pila = {pilaOro, pilaBasto}; return pila;}
	
	public Columna[] getColumnas() { return columnas; }
	
	public Carta getCartaFuera() { return cartaFuera; }
	public void setCartaNull() { cartaFuera = null; }
	public void sacaCarta() { cartaFuera = baraja.pullCard(); }
	
	public void moverAColumna(int columnaOrigen, int columnaDestino, int cartasAMover) {
		if((columnaOrigen >= 0 && columnaOrigen <= 7) && (columnaDestino >= 0 && columnaOrigen <= 7))
		if(cartasAMover == 1) {
			columnas[columnaDestino].addCard(columnas[columnaOrigen].pullCard());
		}
		else if( cartasAMover > 1 && cartasAMover <= columnas[columnaOrigen].getNumCartasReveladas() ) 
			columnas[columnaDestino].addColumna(columnas[columnaOrigen].pullColumna(cartasAMover));
	} //Si cartasAMover == 1, se mueve 1 carta sola de un sitio a otro.
	
	public Carta sacaCartaColumna(int columna) { return columnas[columna].pullCard(); }
	
	public void addCartaColumna(int columna, Carta carta) { columnas[columna].addCard(carta); }

	public void setCartaFuera(Carta cartaMovida) { cartaFuera = cartaMovida;}
}
