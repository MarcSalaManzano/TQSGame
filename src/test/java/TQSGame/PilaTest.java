package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilaTest {

	@Test
	public void testAddCard() {
		Pila pilaOro = new Pila("Oro");
		Pila pilaEspada = new Pila("Espada");
		Pila pilaBasto = new Pila("Basto");
		Pila pilaCopa = new Pila("Copa");
		
		assertEquals(pilaOro.peekCard(), null);
		
		pilaOro.addCard(new Carta("Oro", 1));
		assertEquals(pilaOro.peekCard(), new Carta("Oro", 1));
		
		pilaOro.addCard(new Carta("Espada", 2));
		assertEquals(pilaOro.peekCard(), new Carta("Oro", 1));
		
		pilaOro.addCard(new Carta("Oro", 3));
		assertEquals(pilaOro.peekCard(), new Carta("Oro", 1));
		
		for(int i = 2; i <= 12; i++) {
			pilaOro.addCard(new Carta("Oro", i));
		}
		
		assertEquals(pilaOro.peekCard(), new Carta("Oro", 12));
	}

}
