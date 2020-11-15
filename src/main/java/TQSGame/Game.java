package TQSGame;
import Mocks.*;
public class Game {
	private ITablero tablero = null;
	private Carta cartaMovida = null;
	private int origenCartaMovida;
	
	public Pila getPila(int i) { return tablero.getPilas()[i]; }
	
	public Columna getColumna(int i) { return tablero.getColumnas()[i]; }
	
	public Game(ITablero tab) { tablero = tab; }
	
	public Game() { this.tablero = new Tablero(); tablero.repartirCartas(); }
	
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
		if(cartaMovida != null)
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
		if(idDestino >= 1 && idDestino <= 7) {
			if(tablero.getColumnas()[idDestino-1].isVacia())
				return true;
			else if( cartaMovida.getNum() == tablero.getColumnas()[idDestino-1].peekCard().getNum() - 1)
				return true;
			return false;
		}
		else if (idDestino >= 8 && idDestino <= 11)
			return tablero.getPilas()[idDestino % 4].cartaValida(cartaMovida);
			
		return false;
	}
	
	public void deshacerCarta() {
		if(cartaMovida != null)
			if(origenCartaMovida >= 1 && origenCartaMovida <= 7) {
				tablero.reAddCarta(origenCartaMovida - 1, cartaMovida);
				cartaMovida = null;
			} else if(origenCartaMovida == 0) {
				tablero.setCartaFuera(cartaMovida);
				cartaMovida = null;
			}
	}
	
	public void mueveColumna(int colOrigen, int colDestino, int nCartas) { 
		if(!tablero.getColumnas()[colOrigen-1].isVacia())
		
			tablero.moverAColumna(colOrigen-1, colDestino-1, nCartas); 
		}

	public boolean getBarajaStatus() { return tablero.getBaraja(); }
	
	public boolean finished() { return tablero.pilasLlenas(); }

	public int getColsMaxCartas() {
		Columna[] cols = tablero.getColumnas();
		int maxCartas = cols[0].getNumCartasTotal();
		
		for(int i = 1; i < cols.length; i++)
			if(maxCartas < cols[i].getNumCartasTotal())
				maxCartas = cols[i].getNumCartasTotal();
			
			
		return maxCartas;
	}

	public void processInput(int[] args) { //Este método solo se llama desde la vista.
		switch(args.length) {
		case 1: if( args[0] == 1) sacaCarta();
				break;
		case 2: setCartaMovida(args[0]); addCartaDestino(args[1]);
				break;
		case 3: mueveColumna(args[0], args[1], args[2]);
		}
		
	}
	
	
}