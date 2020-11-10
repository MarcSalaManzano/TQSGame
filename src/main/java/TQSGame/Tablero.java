package TQSGame;

import java.util.ArrayList;
import java.util.List;

public interface Tablero { //De momento es una interficie para poder implementar el mock
	public void addAPila(Carta carta, String paloPila);
	public Carta getCartaFuera();
	public void sacaCarta();
	public void moverAColumna(int columnaOrigen, int columnaDestino, int cartasAMover);
	public Carta sacaCartaColumna(int columna);
	public Pila[] getPilas();
	public Columna[] getColumnas();
	public void addCartaColumna(int idDestino, Carta cartaMovida);
	public boolean getBaraja();
	
}
