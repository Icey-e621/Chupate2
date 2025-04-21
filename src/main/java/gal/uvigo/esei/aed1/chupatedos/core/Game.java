package gal.uvigo.esei.aed1.chupatedos.core;

import java.util.ArrayList;

import gal.uvigo.esei.aed1.chupatedos.iu.IU;

public class Game {

    private final IU iu;
    private Player[] players;
    private int numOfPlayers;
    private final Table table;
    private DeckOfCards deck;

    private int currentPlayer;
    private boolean antiHorario; // si verdadero aumentar 1,2,3 : si es falso 3,2,1
    private boolean seHaGanado;

    public Game(IU iu) {
        this.currentPlayer = 0;
        this.seHaGanado = false;
        this.antiHorario = true;
        this.iu = iu;
        this.players = new Player[5];
        this.deck = new DeckOfCards();
        this.table = new Table();
    }

    /**
     * Metodo para crear jugadores
     */
    private void crearJugadores() {
        String[] playerstempStrings = iu.readPlayers();
        do {
            this.numOfPlayers = playerstempStrings.length;
        } while (this.numOfPlayers < 2 || this.numOfPlayers > 5);
        for (int i = 0; i < this.numOfPlayers; i++) {
            this.players[i] = new Player(playerstempStrings[i]);
        }
    }

    private void estadoMesa() {
        iu.displaymessage("Carta en la cima " + this.table.getTopCard());
        iu.displaymessage("Es el turno de " + this.players[this.currentPlayer]);
        iu.displaymessage("el siguiente jugador es "
                + this.players[this.siguienteJugador()].getName());
    }

    private ArrayList<Card> availableCards(Card carta) {
        ArrayList<Card> estoHaceFalta = this.players[this.currentPlayer].availableCardsToPlayByNumber(carta);
        estoHaceFalta.addAll(this.players[this.currentPlayer].availableCardsToPlayBySuit(carta));
        return estoHaceFalta;
    }
    private int siguienteJugador(){
        return (antiHorario) ? (this.currentPlayer + 1 >= this.numOfPlayers) ? 0 : this.currentPlayer + 1
        : (this.currentPlayer - 1 < 0) ? this.numOfPlayers-1 : this.currentPlayer - 1;
    }
    private Card robarCarta(){
        Card aRobar = this.deck.pop();
        if (this.deck.isEmpty()){
            Card tempCard = this.table.popCard();
            for (int i = 0; i< this.table.sizeDescartes();i++){
                this.deck.addCard(this.table.popCard());
            }
            this.deck.shuffleDeck();
            this.table.receiveCard(tempCard);
        }
        return aRobar;
    }
    private void jugarCarta(Card carta) {
        this.table.receiveCard(carta);
        this.players[this.currentPlayer].removeCard(carta);
        if (this.players[this.currentPlayer].getCards().isEmpty()){
            this.seHaGanado = true;
        }
        else if (carta.getNumber() == 7) {
            this.antiHorario = !this.antiHorario;
        } else if (carta.getNumber() == 2) {
            this.currentPlayer = this.siguienteJugador();
            this.players[this.currentPlayer].addCard(robarCarta());
            this.players[this.currentPlayer].addCard(robarCarta());
            this.currentPlayer = this.siguienteJugador();
        }
    }

    /**
     * Metodo principal para jugar
     */
    public void play() {
        this.crearJugadores();
        for (int i = 0; i < this.numOfPlayers * 7; i++) {
            this.players[i % numOfPlayers].addCard(this.deck.pop());
        }
        this.table.receiveCard(this.deck.pop());
        iu.displaymessage("\n =======\tPrimer Turno\t=======");

        if (this.table.getTopCard().getNumber() == 7){
            this.antiHorario = false;
            this.currentPlayer = this.numOfPlayers;
            iu.displaymessage("Empezamos invertidos");
        }
        else if (this.table.getTopCard().getNumber() == 2){
            this.players[this.currentPlayer].addCard(robarCarta());
            this.players[this.currentPlayer].addCard(robarCarta());
            this.currentPlayer = this.siguienteJugador();
            iu.displaymessage("Empezamos con un 2 ");
        }
        
        while (!seHaGanado){
            this.estadoMesa();
            ArrayList<Card> cartasDisponibles = this.availableCards(this.table.getTopCard());
            if (cartasDisponibles.size() != 0){
                iu.displaymessage("Que carta quieres jugar: ");
                int opcion = 0;
                do{
                    for (int i = 0; i < cartasDisponibles.size();i++){
                        iu.displaymessage("\t " + i + ": " + cartasDisponibles.get(i));
                    }
                    opcion = iu.readInt("Introduce el número: ");
                } while (opcion < 0 || opcion > cartasDisponibles.size());

                Card cartaEscogida = cartasDisponibles.get(opcion);
                this.jugarCarta(cartaEscogida);
            }
            else{
                Card nextCard = robarCarta();
                iu.displaymessage("No puedes jugar ninguna carta te toca robar: " + nextCard);
                if (nextCard.getSuit() == this.table.getTopCard().getSuit() || nextCard.getNumber() == this.table.getTopCard().getNumber()){
                    iu.displaymessage("Que suerte puedes jugarla!");
                    this.jugarCarta(nextCard);
                }else{
                    this.players[this.currentPlayer].addCard(nextCard);
                }
            }
            if (!seHaGanado){this.currentPlayer = this.siguienteJugador();iu.displaymessage("\n =======\tSiguiente turno\t=======");}
        }
        iu.displaymessage("\n\nEl jugador: " + this.players[this.currentPlayer].getName() + " Ha ganado ");
    }
}
