package TQSGame;
import Mocks.*;
public class Game {
	private Tablero tablero = null;
	private Carta cartaMovida = null;
	
	public Game(Tablero tablero) { this.tablero = tablero; }
	
	public void setCartaMovida(Carta carta) { cartaMovida = carta; }
	public Pila[] getPilas() { return tablero.getPilas(); }
	
}
