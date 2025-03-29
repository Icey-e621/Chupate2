package gal.uvigo.esei.aed1.chupatedos.core;

import gal.uvigo.esei.aed1.chupatedos.iu.IU;

public class Game {

    private final IU iu;
    private Player[] players;
    private int numOfPlayers;
	private Table table;
    private DeckOfCards deck;

    public Game(IU iu) {
        this.iu = iu;
        this.players = new Player[5];
        this.deck = new DeckOfCards();
        this.table = new Table (this.deck);
    }
	/**
	 * Metodo para crear jugadores
	 */
    private void crearJugadores() {
        this.numOfPlayers = iu.readNumber("Introduzca el número de jugadores.");
		for(int i= 0; i<this.numOfPlayers; i++){
			
			this.players[i] = iu.readPlayerx(i);
		}
    }

    /**
     * Metodo principal para jugar
     */
    public void play() {
		this.crearJugadores();
		while () {
			
		}
    }
}
