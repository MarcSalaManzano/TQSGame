package TQSGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Columna {
	private List<Carta> cartas = new ArrayList<>();
	private int numCartasReveladas = 0;
	private int numCartasTotal = 0;
	
	public void addCartaOculta(Carta carta) {
		if(numCartasReveladas == 0) {
			numCartasTotal++;
			cartas.add(carta);
		}
	}
	
	public void addCard(Carta carta) {
		if(numCartasReveladas == 0) {
			cartas.add(carta);
			numCartasReveladas++;
			numCartasTotal++;
		}
		else {
			if(cartas.get(cartas.size()-1).getNum() - 1 == carta.getNum()) {
				cartas.add(carta);
				numCartasReveladas++;
				numCartasTotal++;
			}
		}
	}
	
	public void addColumna(Columna col) {
		if(numCartasTotal > 0) {
			if(numCartasReveladas == 0 || (numCartasReveladas > 0 && (col.cartas.get(0).getNum() == this.cartas.get(cartas.size() - 1).getNum() - 1))) {
				int j = col.numCartasTotal;
				for(int i = 0; i < j; i++) {
					Carta card = col.cartas.get(0);
					col.cartas.remove(0);
					cartas.add(card);
					numCartasTotal++;
					numCartasReveladas++;
				}
				
			}
	} else {
		int j = col.numCartasTotal;
		for(int i = 0; i < j; i++) {
			Carta card = col.pullCard();
			cartas.add(0, card);
			numCartasTotal++;
			numCartasReveladas++;
		}
	}
		
	}
	
	public Carta pullCard() {
		numCartasTotal--;
		if(numCartasReveladas > 0) {
			numCartasReveladas--;
			Carta card = cartas.get(cartas.size()-1);
			cartas.remove(cartas.size()-1);
			if(numCartasReveladas == 0 && numCartasTotal > 0) {	numCartasReveladas++; }
			return card;
			
		}
		return null;
	}
	
	public Columna pullColumna(int pos) {
		if(pos <= numCartasReveladas && pos > 1) {
			Columna col = new Columna();
			for(int i = 0; i < pos; i++) {
				Carta card = this.pullCard();
				col.cartas.add(0, card);
				col.numCartasTotal++;
				col.numCartasReveladas++;
			}
			
			return col;
			
		}
		return null;
	}

	public int getNumCartasReveladas() { return numCartasReveladas;	}

	public int getNumCartasTotal() { return numCartasTotal;	}
	
	
}
