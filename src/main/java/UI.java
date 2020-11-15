

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import TQSGame.*;
/*
 * Esta clase será la Vista que se comunica con el usuario. Se encarga de formatar toda la información que imprimir en pantalla
 * y recoger el input del usuario.
 * 
 */
public class UI {
	private Game game;
	int lastInput = 0;
	Scanner sc = new Scanner(System.in);
	
	public UI(Game game) { this.game = game; main(); }
	
	public void imprimirTutorial() {
		System.out.println("Bienvenido al juego de Solitario! \n");
		System.out.println("Lo que ves arriba izquierda es la baraja de cartas. Si ves el asterisco es que aún tienes cartas en la baraja. \n"
				+ "Puedes sacar una carta introduciendo el comando 1-Sacar carta de la baraja. \n");
		System.out.println("A su derecha verás la carta que has sacado y que puedes mover introduciendo 2- Mover carta. Después de introducir el 2, introduce el \n"
				+ "lugar de donde quieres sacar la carta (0 - baraja, 1-7 - cada columna) y el destino (1-7 - cada columna, 8-11 - cada pila). \n");
		System.out.println("Más a la derecha verás las pilas de cartas. El objetivo es llenar las 4 pilas con su respectivo palo de la baraja española \n"
				+ "(Oro, Copas, Espadas y Bastos). Las cartas se representan con la inicial de su palo y el número de la carta. Las cartas que no puedes ver \n"
				+  "se representan con un asterisco. \n");
		System.out.println("Debajo de las pilas y la baraja encontrarás las 7 columnas. Es muy sencillo, en las columnas sólo se pueden poner cartas en orden \n"
				+ "descendente, pero sin importar el palo del que sean. También puedes mover varias cartas de una columna de golpe, siempre y cuando \n"
				+ "sean cartas ya reveladas, introduciendo un 3- Mover columna, y luego la columna de origen, la de destino, y el número de cartas \n"
				+ "que estás moviendo (1-7 - las columnas, y cualquier número de cartas siempre y cuando sea posible hacer el movimiento). \n"
				+ "¡Úsalas para ordenar cartas y poder llenar las pilas! \n");
		System.out.println("Con esto estás listo para empezar a jugar. Diviértete! \n");
		
	}
	
	public void getUserInput() {
		int input = sc.nextInt();

		switch(input) {
		case 1: int[] in = {input};
				game.processInput(in);
				clear();
				break;
		case 2: int[] inputs = {sc.nextInt(), sc.nextInt() };
				game.processInput(inputs);
				clear();
				break;
		case 3: int[] inputs2 = {sc.nextInt(), sc.nextInt(), sc.nextInt() };
				game.processInput(inputs2);
				clear();
				break;
		default: 
				System.out.println("Valor no reconocido, introduce una entrada válida");
				break;
		}
	}
	
	public void imprimirTablero() {
		imprimirPrimeraLinea();
		System.out.println();
		imprimirColumnas();
	}
	
	private void imprimirColumnas() {
		Columna[] cols = game.getColumnas();
		int maxCol = game.getColsMaxCartas();
		String str = new String();
		for(int i = 0; i < maxCol; i++) {
			str = "    ";
			for(int j = 0; j < cols.length; j++) {
				Columna col = cols[j];
				str += col.peekCard(i) + " 	";
			} 
			System.out.println(str);
		}
	}

	private void imprimirPrimeraLinea() {
		if(game.getBarajaStatus())
			System.out.print("    *");
		else 
			System.out.print("	 ");
		
		System.out.print(" " + game.getCartaFuera() + "	");
		
		for(int i = 0; i < game.getPilas().length; i++) {
			if(game.getPilas()[i].peekCard() == null)
				System.out.print(game.getPilas()[i].getPalo() + "	");
			else
				System.out.print(game.getPilas()[i].peekCard() + "	");
		}
		System.out.print("\n");
	}

	public void clear() { System.out.println(new String(new char[50]).replace("\0", "\r\n")); }
	
	public void main() {
		imprimirTutorial();
		while(!game.finished()) {
			imprimirTablero();
			getUserInput();
			
		}
		sc.close();
	}
	
}
