package TQSGame;
import Mocks.*;
public class Game {
	private Tablero tablero = null;
	private Carta cartaMovida = null;
	private int origenCartaMovida;
	
	public Game(Tablero tablero) { this.tablero = tablero; tablero.repartirCartas(); }
	
	public void setCartaMovida(int origen) { 
		if(origen == 0) {
			cartaMovida = tablero.getCartaFuera();
			tablero.setCartaNull();
			origenCartaMovida = 0;
		}
		else if(origen >= 1 && origen <= 7) {
			cartaMovida = tablero.sacaCartaColumna(origen -1);
			origenCartaMovida = origen;
		}
	}
	public Pila[] getPilas() { return tablero.getPilas(); }


	public Carta getCartaFuera() { return tablero.getCartaFuera(); }
	
	public void sacaCarta() { tablero.sacaCarta(); }

	public Columna[] getColumnas() { return tablero.getColumnas(); }

	public void addCartaDestino(int idDestino) {
		if(esValido(idDestino)) {
			if(idDestino >= 1 && idDestino <= 7) {
				tablero.addCartaColumna(idDestino - 1, cartaMovida);
				cartaMovida = null;
			}
			else if(idDestino >= 8 && idDestino <= 11) {
				switch(idDestino) {
				case 8: tablero.addAPila(cartaMovida,  "Oro");
				case 9: tablero.addAPila(cartaMovida,  "Copa");
				case 10: tablero.addAPila(cartaMovida,  "Espada");
				case 11: tablero.addAPila(cartaMovida,  "Basto");
				}
				cartaMovida = null;
			}
		} else {
			deshacerCarta();
		}
	}
	
	public boolean esValido(int idDestino) {
		if(idDestino >= 1 && idDestino <= 7)
			return cartaMovida.getNum() == tablero.getColumnas()[idDestino-1].peekCard().getNum() - 1;
		else if (idDestino >= 8 && idDestino <= 11)
			return tablero.getPilas()[idDestino % 4].cartaValida(cartaMovida);
			
		return false;
	}
	
	public void deshacerCarta() {
		if(origenCartaMovida >= 1 && origenCartaMovida <= 7) {
			tablero.addCartaColumna(origenCartaMovida - 1, cartaMovida);
			cartaMovida = null;
		} else if(origenCartaMovida == 0) {
			tablero.setCartaFuera(cartaMovida);
			cartaMovida = null;
		}
	}
	
	public void mueveColumna(int colOrigen, int colDestino, int nCartas) {  }

	public boolean getBarajaStatus() { return tablero.getBaraja(); }
	
	//TODO: comprobar cuando se termina la partida.
	
}