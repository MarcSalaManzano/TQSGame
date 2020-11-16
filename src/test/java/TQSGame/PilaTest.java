package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class PilaTest {

	@Test
	public void testAddCard() { //Test de caja negra del método addCard, con valores frontera
		Pila pilaOro = new Pila("Oro");
		
		assertEquals(pilaOro.peekCard(), null); //valor frontera: 0 cartas en la pila
		
		assertEquals(pilaOro.getPalo(), "O");
		
		pilaOro.addCard(new Carta("Oro", 1));
		assertEquals(pilaOro.peekCard().getNum(), 1); //se usa peekCard para comprobar el valor,
		assertEquals(pilaOro.peekCard().getPalo(), "Oro"); //por lo tanto usando caja negra para comprobar que funciona
		
		pilaOro.addCard(new Carta("Espada", 2));
		assertEquals(pilaOro.peekCard().getNum(), 1);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro");
		
		pilaOro.addCard(new Carta("Oro", 3));
		assertEquals(pilaOro.peekCard().getNum(), 1);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro");
		
		for(int i = 2; i <= 12; i++) {
			pilaOro.addCard(new Carta("Oro", i));
		}

		assertEquals(pilaOro.peekCard().getNum(), 12);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro"); //valor de frontera: pila completa
		
		pilaOro.addCard(new Carta("Oro", 13));
		assertEquals(pilaOro.peekCard().getNum(), 12);
		assertEquals(pilaOro.peekCard().getPalo(), "Oro"); //valor fuera de límites: no hay más de 12 cartas por palo.
		
	}
	
	@Test
	public void testCartaValida() { //Test extra para más coverage de pila.cartaValida
		Pila pilaEspadas = new Pila("Espada");
		
		assertTrue(pilaEspadas.cartaValida(new Carta("Espada", 1)));
		assertFalse(pilaEspadas.cartaValida(new Carta("Espada", 2)));
		assertFalse(pilaEspadas.cartaValida(new Carta("Oro", 1)));
		assertFalse(pilaEspadas.cartaValida(new Carta("Oro", 2)));
		assertFalse(pilaEspadas.cartaValida(new Carta("Espdas", 1)));
		
	}


}
