package gal.uvigo.esei.aed1.chupatedos.core;

import gal.uvigo.esei.aed1.chupatedos.iu.IU;

public class Game {

    private final IU iu;
    private Player[] players;
    private int numOfPlayers;

    public Game(IU iu) {
        this.iu = iu;
        this.players = new Player[5];

    }
	/**
	 * Metodo para crear jugadores
	 */
    private void crearJugadores() {
        this.numOfPlayers = iu.readNumber("Introduzca el número de jugadores.");
		for(int i= 0; i<this.numOfPlayers; i++){
			
			this.players[i]=new Player(new DeckOfCards(),iu.readString("Nombre del jugador "+ (i+1) +": "));
		}
    }

    /**
     * Metodo principal para jugar
     */
    public void play() {
		this.crearJugadores();
		int turno = 0;
		boolean salio7 = false;
		boolean salio2 = false;
		boolean finPartida = false;
		while (!finPartida) {
			this.players[turno].turno();

		}
    }
}
