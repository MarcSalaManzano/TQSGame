package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	@Test
	public void testAddPila() { //Test sobre añadir cartas a las diferentes pilas
		Tablero tablero = new Tablero();
		
		Carta carta = new Carta("Oro", 1);
		
		assertNull(tablero.getPilas()[0].peekCard()); //La pila esta vacia
		
		tablero.addAPila(carta, "Basto"); //No se añadira, palo incorrecto
		tablero.addAPila(carta, "Oro"); //ahora sí se añadira
		
		assertEquals("O1", tablero.getPilas()[0].peekCard().toString()); //comprueba que se ha añadido
		
		tablero.addAPila(carta, "Oro");
		
		assertEquals("O1", tablero.getPilas()[0].peekCard().toString()); //no se añade dos veces la misma carta
		
		carta = new Carta("Oro", 2);

		assertEquals("O1", tablero.getPilas()[0].peekCard().toString());
		
		tablero.addAPila(carta, "Oro");
		
		assertEquals("O2", tablero.getPilas()[0].peekCard().toString()); //la carta correcta si se añade
		
		for(int i = 3; i <= 12; i++)
			tablero.addAPila(new Carta("Oro", i), "Oro");
		
		assertEquals("O12", tablero.getPilas()[0].peekCard().toString()); //la pila esta llena pero no se ha añadido la carta 13
		
		
		
		assertFalse(tablero.pilasLlenas());
		
		for(int i = 1; i <= 12; i++)
			tablero.addAPila(new Carta("Basto", i), "Basto"); //llena todas las pilas para probar pilasLlenas()
		for(int i = 1; i <= 12; i++)
			tablero.addAPila(new Carta("Copa", i), "Copa");
		for(int i = 1; i <= 12; i++)
			tablero.addAPila(new Carta("Espada", i), "Espada");
		
		assertTrue(tablero.pilasLlenas());
		
	}
	
	@Test
	public void testSacaCarta() { //Testea con caja negra el sacar una carta de la baraja
		
		Tablero tablero = new Tablero();
		
		assertNull(tablero.getCartaFuera());
		
		tablero.sacaCarta();
		assertEquals(tablero.getCartaFuera().toString(), "O1"); //comprueba que la carta es correcta 
		tablero.sacaCarta();
		assertEquals(tablero.getCartaFuera().toString(), "O2");
		assertTrue(tablero.getBaraja());
		for(int i = 2; i <= 48; i++)
			tablero.sacaCarta();
		
		assertEquals(tablero.getCartaFuera().toString(), "O1"); //comprueba que las cartas se añaden de vuelta a la baraja si no se mueven
		tablero.setCartaNull();
		assertNull(tablero.getCartaFuera());
		tablero.setCartaFuera(new Carta("Oro", 1));
		assertNotNull(tablero.getCartaFuera());
		assertTrue(tablero.getBaraja());
	}
	@Test
	public void testSacarCartaColumna() { //Testea con particiones equivalentes sacar cartas de una columna
		Tablero tablero = new Tablero();
		
		assertNull(tablero.sacaCartaColumna(0)); //Valores limites y frontera con columna vacia
		assertNull(tablero.sacaCartaColumna(-1));
		assertNull(tablero.sacaCartaColumna(4)); //particion equivalente
		assertNull(tablero.sacaCartaColumna(7)); 
		assertNull(tablero.sacaCartaColumna(8));
		
		tablero.repartirCartas();
		
		assertEquals("O1", tablero.sacaCartaColumna(0).toString()); //Valores limites y frontera
		assertNull(tablero.sacaCartaColumna(-1));
		assertEquals("E3", tablero.sacaCartaColumna(4).toString()); //particion equivalente
		assertEquals("B4", tablero.sacaCartaColumna(6).toString());
		assertNull(tablero.sacaCartaColumna(7));
		
		
	}
	
	@Test
	public void testMoverAColumna() { //Testea el mover de una columna a otra, principalmente con caja negra
		Tablero tablero = new Tablero();
		
		tablero.moverAColumna(0, 1, 1); //pairwise testing
		assertNull(tablero.getColumnas()[0].peekCard());
		assertNull(tablero.getColumnas()[1].peekCard());
		tablero.moverAColumna(1, 1, 0);
		assertNull(tablero.getColumnas()[0].peekCard());
		assertNull(tablero.getColumnas()[1].peekCard());
		tablero.moverAColumna(1, 0, 1);
		assertNull(tablero.getColumnas()[0].peekCard());
		assertNull(tablero.getColumnas()[1].peekCard());
		tablero.repartirCartas();
		
		tablero.moverAColumna(0, 8, 1); //intenta mover a una pila
		assertNull(tablero.getPilas()[0].peekCard());
		
		tablero.moverAColumna(0, 0, 1); //intenta mover a si misma
		assertEquals("O1", tablero.getColumnas()[0].peekCard().toString());
		
		tablero.moverAColumna(1, 0, 2); 
		assertEquals("O1", tablero.getColumnas()[0].peekCard().toString());
		assertEquals("O3", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.sacaCartaColumna(0);
		
		tablero.moverAColumna(1, 0, 1);
		assertEquals("O3", tablero.getColumnas()[0].peekCard().toString());
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.moverAColumna(1, 0, 1); //quedan como O3->O2  en la primera columna
		assertEquals("O2", tablero.getColumnas()[0].peekCard().toString());
		assertEquals(null, tablero.getColumnas()[1].peekCard());
		
		tablero.moverAColumna(0, 1, 2);  // //mueve ambas cartas a una columna vacia
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		assertEquals(null, tablero.getColumnas()[0].peekCard());
		
		tablero.moverAColumna(1, 0, 1);
		tablero.moverAColumna(1, 0, 1); //intenta mover O3 debajo de O2, cosa que no se puede
		assertEquals("O2", tablero.getColumnas()[0].peekCard().toString());
		assertEquals("O3", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.moverAColumna(0, 1, 1);
		tablero.moverAColumna(1, 2, 3); //intenta hacer movimiento ilegal
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.moverAColumna(1, 2, 2);
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		
		
		//casos más extremos (en fronteras)
		tablero.moverAColumna(1, 0, 0);
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.moverAColumna(1, 0, -1);
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		

		tablero.moverAColumna(-1, 1, 1);
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());

		tablero.moverAColumna(1, -1, 2);
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.moverAColumna(1, 7, 2);
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.moverAColumna(7, 1, 2);
		assertEquals("O2", tablero.getColumnas()[1].peekCard().toString());
		
		tablero.sacaCartaColumna(5);
		tablero.sacaCartaColumna(5);
		tablero.sacaCartaColumna(5);
		tablero.sacaCartaColumna(5);
		
		tablero.moverAColumna(6, 5, 1);
		assertEquals("B4", tablero.getColumnas()[5].peekCard().toString());
	}
	
	@Test
	public void testAddCartaColumna() { //Testea añadir cartas a una columna con valores limite y frontera
		
		Tablero tablero = new Tablero();
		
		Carta carta = new Carta("Oro", 12);
		
		tablero.addCartaColumna(0, carta);
		assertEquals(tablero.getColumnas()[0].peekCard(), carta);
		tablero.addCartaColumna(-1, carta);
		tablero.addCartaColumna(3, carta);
		assertEquals(tablero.getColumnas()[3].peekCard(), carta);
		tablero.addCartaColumna(6, carta);
		assertEquals(tablero.getColumnas()[6].peekCard(), carta);
		tablero.addCartaColumna(7, carta);
		
		
	}
	
	@Test
	public void testReAdd() { //Testea el reañadir carta y columna
		Tablero tablero = new Tablero();
		tablero.repartirCartas();
		Carta carta = tablero.sacaCartaColumna(0);
		tablero.setColumnas(0, new Columna());
		assertNull(tablero.getColumnas()[0].peekCard());
		
		tablero.reAddCarta(-1, carta); //testea valores por particiones equivalentes
		assertNull(tablero.getColumnas()[0].peekCard());
		tablero.reAddCarta(0, carta);
		assertEquals(carta, tablero.getColumnas()[0].peekCard());

		assertEquals(1, tablero.getColumnas()[1].getNumCartasReveladas());
		assertEquals(2, tablero.getColumnas()[1].getNumCartasTotal());
		
		carta = tablero.sacaCartaColumna(1);
		
		assertEquals(1, tablero.getColumnas()[1].getNumCartasReveladas()); //comprueba que se ha reañadido correctamente: el numero de cartas reveladas y totales aumenta como debe
		assertEquals(1, tablero.getColumnas()[1].getNumCartasTotal());
		tablero.reAddCarta(1, carta);
		assertEquals(1, tablero.getColumnas()[1].getNumCartasReveladas());
		assertEquals(2, tablero.getColumnas()[1].getNumCartasTotal());
		
		
		carta = tablero.sacaCartaColumna(6);
		
		tablero.reAddCarta(7, carta); //comprueba un valor fuera del tablero
		
		assertEquals(1, tablero.getColumnas()[6].getNumCartasReveladas());
		assertEquals(6, tablero.getColumnas()[6].getNumCartasTotal());
		
		tablero.reAddCarta(6, carta); //este valor si que esta dentro del tablero 
		assertEquals(1, tablero.getColumnas()[6].getNumCartasReveladas());
		assertEquals(7, tablero.getColumnas()[6].getNumCartasTotal());
		
	}
}
