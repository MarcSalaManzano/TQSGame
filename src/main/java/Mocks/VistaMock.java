package Mocks;

import TQSGame.*;

/**
 * 
 * @author Adrian Delgado Lopez
 * 
 * Este mock simula una vista para el controlador del juego Game. Envia señales para modificar el estado del Tablero a través de Game i
 * "imprime" (devuelve el estado de) los elementos del tablero para poder hacer tests sobre Game.
 * 
 */

public class VistaMock {
	Game game = null;
	
	public VistaMock(Game game) {
		this.game = game;
	}
	
	public void mostraTablero() {
		this.printBaraja();
		this.printCartaFuera();
		this.printColumnas();
		this.printPilas();
	}
	
	public Baraja printBaraja() { return Game.getBarajaStatus(); } //En este mock usare los print para devolver el estado del Game para los tests
	public Carta printCartaFuera() { return Game.getCartaFuera(); }
	public Columna[] printColumnas() { return Game.getColumnas(); }
	public Pila[] printPilas() { return Game.getPilas(); }
	
	public void sacaCarta() { Game.sacaCartaFuera(); }
	public void mueveCarta(int idOrigen, int idDestino) { Game.setCartaMovida(idOrigen); Game.addCartaDestino(idDestino); } //el ID identificará de donde se coge la carta y a donde se mueve: 0 es de la carta de la baraja, 1-7 seran las columnas, 8-11 seran las pilas.
	public void mueveColumna(int colOrigen, int colDestino, int nCartas) { Game.mueveColumna(colOrigen, colDestino, nCartas); }
	
	
}
