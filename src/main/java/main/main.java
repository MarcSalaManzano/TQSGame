package main;
import java.io.IOException;

import Mocks.BarajaBloqueadaMock;
import UI.ScannerR;
import TQSGame.*;
import UI.ScannerI;
import UI.UI;
public class main {
	public static void main(String[] args) {
		Game game = new Game();
		ScannerI sc = new ScannerR();
		UI ui = new UI(game, sc);
	}
}
