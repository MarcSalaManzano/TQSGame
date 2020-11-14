package TQSGame;
/*
 * Esta clase será la Vista que se comunica con el usuario. Se encarga de formatar toda la información que imprimir en pantalla
 * y recoger el input del usuario.
 * 
 */
public class UI {
	private Game game;
	
	public UI(Game game) { this.game = game; }
	
	public void imprimirTutorial() {
		
	}
	
	public int getUserInput() {
		return 2;
	}
	
	public void imprimirTablero() {
		
	}
	
	public void clear() { System.out.println(new String(new char[50]).replace("\0", "\r\n")); }
	
	public void main() {
		while(!game.finished()) {
			imprimirTutorial();
			imprimirTablero();
			getUserInput();
			clear();
			
		}
	}
	
}
