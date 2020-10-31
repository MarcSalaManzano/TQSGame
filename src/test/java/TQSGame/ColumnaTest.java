package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColumnaTest {

	@Test
	public void testAddCard() {
		Columna columna = new Columna();
		
		assertEquals(0, columna.getNumCartasReveladas()); //Valor de frontera: columna vacia (0 cartas)
		assertEquals(0, columna.getNumCartasTotal());
		
		columna.addCartaOculta(new Carta("Oro", 12));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(1, columna.getNumCartasTotal());
			
		columna.addCartaOculta(new Carta("Oro", 12));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(1, columna.getNumCartasTotal());		
		
		columna.addCartaOculta(new Carta("Basto", 12));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(1, columna.getNumCartasTotal());		
		
		columna.addCartaOculta(new Carta("Basto", 11));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(2, columna.getNumCartasTotal());		
		
		columna.addCard(new Carta("Basto", 10));
		assertEquals(1, columna.getNumCartasReveladas());
		assertEquals(3, columna.getNumCartasTotal());		
		
		columna.addCartaOculta(new Carta("Basto", 10));
		assertEquals(1, columna.getNumCartasReveladas());
		assertEquals(3, columna.getNumCartasTotal());		
		
		columna.addCartaOculta(new Carta("Espada", 8));
		assertEquals(1, columna.getNumCartasReveladas());
		assertEquals(3, columna.getNumCartasTotal());		
		
		columna.addCartaOculta(new Carta("Copa", 9));
		assertEquals(2, columna.getNumCartasReveladas());
		assertEquals(4, columna.getNumCartasTotal());		
		
	}

	@Test
	public void testPullCard() { //Test de columna.pullCard
		Columna columna = new Columna();
		
		
		for(int i = 12; i > 6; i--) 
			columna.addCartaOculta(new Carta("Oro", i));
		
		for(int i = 6; i > 0; i--) 
			columna.addCartaOculta(new Carta("Espada", i));
		
		
		Carta carta = columna.pullCard();
		assertEquals("Espada", carta.getPalo());
		assertEquals(1, carta.getNum());
		
		carta = columna.pullCard();
		assertEquals("Espada", carta.getPalo());
		assertEquals(2, carta.getNum());
		
		carta = columna.pullCard();
		assertEquals("Espada", carta.getPalo());
		assertEquals(3, carta.getNum());
		
		columna.pullCard();
		columna.pullCard();
		columna.pullCard();
		
		carta = columna.pullCard(); //cambio de palo dentro de la columna
		assertEquals("Oro", carta.getPalo());
		assertEquals(7, carta.getNum());
		
		carta = columna.pullCard();
		assertEquals("Oro", carta.getPalo());
		assertEquals(8, carta.getNum());
		
		columna.pullCard();
		columna.pullCard();
		columna.pullCard();
		columna.pullCard();
		
		assertNull(columna.pullCard()); //Valor de frontera: columna vacia
	}
	
	
	@Test
	public void testPullColumna() {
		
	}
	
	@Test
	public void testAddColumna() {
		
	}
}
