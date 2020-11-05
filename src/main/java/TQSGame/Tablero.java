package TQSGame;

import java.util.ArrayList;
import java.util.List;

public interface Tablero {
	public void addAPila(Carta carta, String paloPila);
	public Carta getCartaFuera();
	public void sacaCarta();
	public void moverAColumna(int columnaOrigen, int columnaDestino, int cartasAMover);
	public Carta sacaCartaColumna(int columna);
	public Pila[] getPilas();
	
}
