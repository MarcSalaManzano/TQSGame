package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

import Mocks.TableroMock;
import Mocks.VistaMock;
public class GameTest { //Testea el MVC mandando señales con VistaMock al controlador Game que tiene un TableroMock para simplificar los tests con una baraja predeterminada semialetaoria.

	@Test
	public void testAddCartaDestino() {
		Tablero tablero = new TableroMock();
		Game game = new Game(tablero);
		VistaMock vista = new VistaMock(game);
		
		vista.mueveCarta(0, 1);
		vista.printColumnas();
		vista.mueveCarta(1, 2);
		vista.printColumnas();
		vista.mueveCarta(2, 11);
		
		assertTrue(vista.printBaraja());
		
		assertNull(vista.printCartaFuera());
		vista.printColumnas();
		vista.printPilas();
		
	}
	@Test
	public void testAddColumna() {
		Tablero tablero = new TableroMock();
		Game game = new Game(tablero);
		VistaMock vista = new VistaMock(game);
		
		vista.mueveColumna(0, 1, 1);
		vista.mueveCarta(0, 1);
		vista.mueveColumna(0, 1, 3); //No podrá hacer esto ya que pide mas cartas de las que hay
		
		vista.printColumnas();
		
		
	}

}
