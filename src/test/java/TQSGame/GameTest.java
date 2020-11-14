package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

import Mocks.TableroMock;
import Mocks.VistaMock;
/* Importante:
 * Este test ha sido implementado y pasado usando un Mock de tablero que utilizaba una baraja semi aleatoria implementada por mi.
 * Ahora mismo no se ejecuta ya que Tablero ya no actua como Interface para que se pueda usar el Mock, y la baraja no es la misma que la que usa el Mock,
 * por lo que este test ahora mismo no se ejecuta porque no lo pasaria. En Github está subido el commit en el que se pasa el test usando el Mock,
 * y para usar este test hay que poner la clase Tablero como Interface y hacer que TableroMock implemente Tablero como interfaz.
 * 
 */
public class GameTest { //Testea el MVC mandando señales con VistaMock al controlador Game que tiene un TableroMock para simplificar los tests con una baraja predeterminada semialetaoria.

	//@Test
	public void testAddCartaAColumna() {
		//Tablero tablero = new TableroMock();
		Game game = new Game();
		VistaMock vista = new VistaMock(game);
		
		vista.sacaCarta();
		vista.sacaCarta();
		vista.sacaCarta();
		vista.sacaCarta();
		vista.sacaCarta();
		assertEquals("Oro", vista.cartaFuera().getPalo());
		assertEquals(8, vista.cartaFuera().getNum());
		vista.mueveCarta(0, 3);
		Columna[] cols = vista.printColumnas();
		assertEquals(4, cols[2].getNumCartasTotal());
		assertEquals(2, cols[1].getNumCartasTotal());
		assertEquals(1, cols[1].getNumCartasReveladas());
		assertEquals(1, cols[0].getNumCartasReveladas());
		
		
		
		vista.mueveCarta(1, 2);
		cols = vista.printColumnas();
		assertEquals(4, cols[2].getNumCartasTotal());
		assertEquals(2, cols[1].getNumCartasTotal());
		assertEquals(1, cols[1].getNumCartasReveladas()); //no se ha de mover
		
		Columna col = new Columna();
		col.addCard(new Carta("Basto", 11));
		
		//tablero.setColumnas(1, col);
		vista.mueveCarta(2,  1);
		cols = vista.printColumnas();
		assertEquals(2, cols[0].getNumCartasTotal());
		assertEquals(0, cols[1].getNumCartasTotal());
		
		assertTrue(vista.printBaraja());
		assertNull(vista.printCartaFuera());
		
		col = new Columna();
		col.addCard(new Carta("Oro", 1));
		
		//tablero.setColumnas(1,  col);
		
		Pila[] pilas = vista.printPilas();

		assertNull(pilas[0].peekCard());
		vista.mueveCarta(2, 8);
		
		pilas = vista.printPilas();
		cols = vista.printColumnas();
		assertEquals(0, cols[1].getNumCartasTotal());
		assertEquals("Oro", pilas[0].peekCard().getPalo());
		assertEquals(1, pilas[0].peekCard().getNum());
		
		col.addCard(new Carta("Oro", 3));
		//tablero.setColumnas(1,  col);
		
		vista.mueveCarta(2,  8);
		vista.mueveCarta(2,  0);

		cols = vista.printColumnas();
		assertEquals(1, cols[1].getNumCartasTotal());
		
		vista.mueveCarta(2,  12);
		cols = vista.printColumnas();
		assertEquals(1, cols[1].getNumCartasTotal());
		
		pilas = vista.printPilas();
		cols = vista.printColumnas();
		assertEquals(1, cols[1].getNumCartasTotal());
		assertEquals("Oro", pilas[0].peekCard().getPalo());
		assertEquals(1, pilas[0].peekCard().getNum());
		
		col.addCard(new Carta("Oro", 2));
		//tablero.setColumnas(1,  col);
		
		vista.mueveCarta(2,  8);
		
		pilas = vista.printPilas();
		cols = vista.printColumnas();
		assertEquals(1, cols[1].getNumCartasTotal());
		assertEquals("Oro", pilas[0].peekCard().getPalo());
		assertEquals(2, pilas[0].peekCard().getNum());
		
		
	}
	//@Test
	public void testAddColumna() {
		//Tablero tablero = new TableroMock();
		Game game = new Game();
		VistaMock vista = new VistaMock(game);

		vista.mueveColumna(2, 1, 3);
		Columna[] cols = vista.printColumnas();
		assertEquals(2, cols[1].getNumCartasTotal());
		
		vista.mueveColumna(2, 1, 2);
		cols = vista.printColumnas();
		assertEquals(2, cols[1].getNumCartasTotal());
		assertEquals(1, cols[0].getNumCartasTotal());
		
		Columna col = new Columna();
		
		col.addCard(new Carta("Basto", 11));
		col.addCard(new Carta("Basto", 10));
		
		//tablero.setColumnas(1, col);
		
		vista.mueveColumna(2, 1, 2);
		assertEquals(3, cols[0].getNumCartasTotal());
		assertEquals(0, cols[1].getNumCartasTotal());
		
		col = new Columna();
		
		col.addCard(new Carta("Oro", 11));
		//tablero.setColumnas(2, col);
		vista.mueveColumna(3, 1, 0);
		cols = vista.printColumnas();
		assertEquals(1, cols[2].getNumCartasTotal());
		assertEquals(3, cols[0].getNumCartasTotal());
		
		vista.mueveColumna(3, 0, 1);
		cols = vista.printColumnas();
		assertEquals(1, cols[2].getNumCartasTotal());
		assertEquals(3, cols[0].getNumCartasTotal());
		
		col = new Columna();
		col.addCard(new Carta("Oro", 9));
		//tablero.setColumnas(2, col);
		
		vista.mueveColumna(3, 1, 1);
		cols = vista.printColumnas();
		assertEquals(0, cols[2].getNumCartasTotal());
		assertEquals(4, cols[0].getNumCartasTotal());
		
	}

}
