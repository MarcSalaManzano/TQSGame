package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

import Mocks.ScannerMock;
import UI.ScannerI;
import UI.UI;

public class Automatizacion {

	@Test
	public void primeraPartida() {
		Game game = new Game();
		ScannerI sc = new ScannerMock(0);
		UI ui = new UI(game, sc);
		assertTrue(game.finished());
	}
	
	@Test
	public void segundaPartida() {
		Game game = new Game();
		ScannerI sc = new ScannerMock(0);
		UI ui = new UI(game, sc);
		assertTrue(game.finished());
	}
	
	@Test
	public void terceraPartida() {
		Game game = new Game();
		ScannerI sc = new ScannerMock(0);
		UI ui = new UI(game, sc);
		assertTrue(game.finished());
	}
	
	@Test
	public void cuartaPartida() {
		Game game = new Game();
		ScannerI sc = new ScannerMock(0);
		UI ui = new UI(game, sc);
		assertTrue(game.finished());
	}

}
