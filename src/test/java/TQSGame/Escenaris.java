package TQSGame;

import static org.junit.Assert.*;

import org.junit.Test;

import Mocks.BarajaBloqueadaMock;
import UI.ScannerI;
import UI.ScannerR;
import UI.UI;

public class Escenaris {

	@Test
	public void escenarioBloquearPartida() {
		Game game = new Game(new BarajaBloqueadaMock());
		ScannerI sc = new ScannerR();
		UI ui = new UI(game, sc);
	}

}
