package TQSGame;
import Mocks.*;
public class Game {
	private static Tablero tablero = null;
	private Carta cartaMovida = null;
	
	public Game(Tablero tablero) { this.tablero = tablero; this.repartirCartas(); }
	
	private void repartirCartas() {
		
	}
	
	public void setCartaMovida(int origen) {  }
	public Pila[] getPilas() { return tablero.getPilas(); }


	public Carta getCartaFuera() { return tablero.getCartaFuera(); }

	public Columna[] getColumnas() { return tablero.getColumnas(); }

	public void addCartaDestino(int idDestino) {
	}
	
	public void mueveColumna(int colOrigen, int colDestino, int nCartas) {  }

	public boolean getBarajaStatus() { return tablero.getBaraja(); }
}
