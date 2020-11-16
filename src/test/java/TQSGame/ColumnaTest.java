package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColumnaTest {

	@Test
	public void testAddCard() {
		Columna columna = new Columna();
		
		assertEquals(null, columna.peekCard()); //Columna vacía
		assertTrue(columna.isVacia()); 
		
		assertEquals(0, columna.getNumCartasReveladas()); //Valor de frontera: columna vacia (0 cartas)
		assertEquals(0, columna.getNumCartasTotal());
		
		columna.addCartaOculta(new Carta("Oro", 12));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(1, columna.getNumCartasTotal());
		
		assertEquals(null, columna.peekCard()); //una columna sin cartas reveladas no debe devolver las ocultas
		assertFalse(columna.isVacia()); //pero si que se sabe que no está vacía
		
		columna.addCartaOculta(new Carta("Copa", 12));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(2, columna.getNumCartasTotal());		
		
		columna.addCartaOculta(new Carta("Basto", 12));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(3, columna.getNumCartasTotal());		
		
		columna.addCartaOculta(new Carta("Basto", 11));
		assertEquals(0, columna.getNumCartasReveladas());
		assertEquals(4, columna.getNumCartasTotal());		
		
		columna.addCard(new Carta("Basto", 10));
		assertEquals(1, columna.getNumCartasReveladas());
		assertEquals(5, columna.getNumCartasTotal());		
		
		assertEquals("B10", columna.peekCard().toString()); //Columna con cartas reveladas
		
		columna.addCartaOculta(new Carta("Basto", 9));
		assertEquals(1, columna.getNumCartasReveladas());
		assertEquals(5, columna.getNumCartasTotal());		
		
		columna.addCard(new Carta("Espada", 7));
		assertEquals(1, columna.getNumCartasReveladas());
		assertEquals(5, columna.getNumCartasTotal());		
		
		columna.addCard(new Carta("Copa", 9));
		assertEquals(2, columna.getNumCartasReveladas());
		assertEquals(6, columna.getNumCartasTotal());		
		
		columna = new Columna();
		
		columna.addCard(new Carta("Basto", 5));
		assertEquals(1, columna.getNumCartasReveladas());
		assertEquals(1, columna.getNumCartasTotal());		
		
	}

	@Test
	public void testPullCard() { //Test de columna.pullCard
		Columna columna = new Columna();
		
		
		for(int i = 12; i > 6; i--) 
			columna.addCartaOculta(new Carta("Oro", i));
		
		for(int i = 6; i > 1; i--) 
			columna.addCartaOculta(new Carta("Espada", i));
		
		
		
		assertNull(columna.pullCard());
		
		columna.addCard(new Carta("Basto", 1));
		
		Carta carta = columna.pullCard();
		assertEquals("Basto", carta.getPalo());
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
		Columna col = new Columna();
		
		assertNull(col.pullColumna(2)); //columna vacia
		
		col.addCartaOculta(new Carta("Oro", 12));
		col.addCartaOculta(new Carta("Oro", 11));
		
		col.addCard(new Carta("Espada", 12));
		col.addCard(new Carta("Basto", 11));
		
		assertNull(col.pullColumna(1)); //No se puede sacar una carta con pullCol
		assertNull(col.pullColumna(3)); //No se puede sacar de una carta oculta
		assertNull(col.pullColumna(0)); //No se saca ninguna carta.
		Columna col2 = new Columna();

		col2.addCard(new Carta("Oro", 10));
		col2.addCard(new Carta("Oro", 9));
		
		col.addCard(new Carta("Oro", 10));
		col.addCard(new Carta("Oro", 9));
		
		Columna newCol = col.pullColumna(2);
		
		assertEquals(col2.pullCard().getNum(), newCol.pullCard().getNum());
		assertEquals(col2.pullCard().getNum(), newCol.pullCard().getNum());
		
		newCol = col.pullColumna(2);
	}
	
	@Test
	public void testAddColumna() {
		
		Columna col = new Columna();
		Columna col2 = new Columna();
		
		col.addCartaOculta(new Carta("Copa", 12)); //test sobre columna normal
		
		col.addCard(new Carta("Oro", 12)); 
		col2.addCard(new Carta("Basto", 11));
		col2.addCard(new Carta("Espada", 10));
		
		col.addColumna(col2);
		
		assertEquals(col.pullCard().getPalo(), "Espada");
		assertEquals(col.pullCard().getPalo(), "Basto");
		assertEquals(col.pullCard().getPalo(), "Oro");
		assertEquals(col.pullCard().getPalo(), "Copa");

		col2 = new Columna();
		
		col2.addCard(new Carta("Basto", 11));
		col2.addCard(new Carta("Espada", 10));
		
		col.addColumna(col2); //test sobre columna vacia

		assertEquals(col.pullCard().getPalo(), "Espada");
		assertEquals(col.pullCard().getPalo(), "Basto");
		
	}
	
	@Test
	public void testReAdd() {
		Columna col1 = new Columna();
		Columna col2 = new Columna();
		
		col1.addCard(new Carta("Oro", 3));
		col1.addCard(new Carta("Oro", 2));
		col1.addCard(new Carta("Oro", 1));
		
		col1.reAddColumna(col2); //añadir columna vacia
		assertEquals("O1", col1.peekCard().toString());
		
		col1.reAddColumna(col1); //añadirse a si misma
		assertEquals("O1", col1.peekCard().toString());
		
		col2 = col1.pullColumna(3);
		assertNull(col1.peekCard());
		
		col1.reAddColumna(col2);
		assertEquals("O1", col1.peekCard().toString());
		
		
		col1.pullColumna(3);
		
		col1.addCartaOculta(new Carta("Basto", 5));
		col1.addCard(new Carta("Oro", 2));
		col1.addCard(new Carta("Oro", 1));
		col2 = col1.pullColumna(2);
		
		col1.reAddColumna(col2);
		
		assertEquals("O1", col1.peekCard().toString());
		
		col1 = new Columna();
		
		col1.addCard(new Carta("Oro", 2));
		
		Carta carta = col1.pullCard();
		assertNull(col1.peekCard());
		
		col1.reAddCarta(carta);
		
		assertEquals("O2", col1.peekCard().toString());
		
		col1 = new Columna();
		col1.addCartaOculta(new Carta ("Basto", 5));
		col1.addCard(new Carta("Oro", 3));
		carta = col1.pullCard();
		assertEquals("B5", col1.peekCard().toString());
		
		col1.reAddCarta(carta);

		assertEquals("O3", col1.peekCard().toString());
	}
	
	@Test
	public void testPeek() {
		
		Columna col = new Columna();
		
		assertEquals(" ", col.peekCard(2));
		
		col.addCartaOculta(new Carta("Oro", 9));
		col.addCartaOculta(new Carta("Oro", 8));
		col.addCard(new Carta("Oro", 7));
		col.addCard(new Carta("Oro", 6));
		
		assertEquals(" ", col.peekCard(-1));
		assertEquals(" ", col.peekCard(4));
		assertEquals("*", col.peekCard(0));
		assertEquals("*", col.peekCard(1));
		assertEquals("O7", col.peekCard(2));
		assertEquals("O6", col.peekCard(3));
		
	}
	
}
