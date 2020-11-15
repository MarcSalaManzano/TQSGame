package TQSGame;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BarajaTest {
	


	@Test
	public void test() {
		Baraja baraja = new Baraja();
		
		Carta carta = baraja.pullCard();
		
		assertEquals(47, baraja.getNumCartas());
		assertEquals("Oro", carta.getPalo());
		assertEquals(1, carta.getNum());
		baraja.addCard(carta);
		assertEquals(48, baraja.getNumCartas());
		carta = baraja.pullCard();
		assertEquals("Oro", carta.getPalo());
		assertEquals(2, carta.getNum());
		
		for(int i = 0; i < 45; i++)
			carta = baraja.pullCard();
		
		assertEquals(2, baraja.getNumCartas());
		
		baraja.pullCard();
		carta = baraja.pullCard(); //Última carta de la baraja, valor límite
		
		assertEquals(0, baraja.getNumCartas());
		assertEquals(null, baraja.pullCard()); //Una baraja sin cartas
		
		
	}

}
