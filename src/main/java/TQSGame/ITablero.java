package TQSGame;

public interface ITablero {
	public void addAPila(Carta carta, String paloPila);
	public void setColumnas(int idCol, Columna col);
	public void repartirCartas();
	public boolean getBaraja();
	public Pila[] getPilas();
	public Columna[] getColumnas();
	public Carta getCartaFuera();
	public void setCartaNull();
	public void sacaCarta();
	public void moverAColumna(int columnaOrigen, int columnaDestino, int cartasAMover);
	public Carta sacaCartaColumna(int columna);
	public void addCartaColumna(int columna, Carta carta);
	public void setCartaFuera(Carta cartaMovida);
	public void reAddCarta(int i, Carta cartaMovida);
	public boolean pilasLlenas();
}
