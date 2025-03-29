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
        do{
            this.numOfPlayers = iu.readInt("Introduzca el número de jugadores (min: 2 / max: 5): ");
        }while(this.numOfPlayers < 2 || this.numOfPlayers > 5);
		for(int i= 0; i<this.numOfPlayers; i++){
			this.players[i] = iu.readPlayerx(i);
		}
    }

    /**
     * Metodo principal para jugar
     */
    public void play() {
		this.crearJugadores();
		for(int i = 0; i < this.numOfPlayers * 7; i++){
            this.players[i % numOfPlayers].addCard(this.table.takeCard());
        }
        this.table.setTopCard(this.table.takeCard());
        iu.displaymessage("La última carta jugada es: "+ this.table.getTopCard());
        iu.displaymessage("Quedan "+ this.table.getNumCardDeck() +" cartas en la baraja.");
        iu.displaymessage("Quedan "+ this.table.getNumDescartes() +" cartas en la pila de descartes.");
        for(int i = 0; i < this.numOfPlayers; i++){
            iu.displaymessage("Jugador "+ (i+1) + ": " +  this.players[i]);
        }
    }
}
