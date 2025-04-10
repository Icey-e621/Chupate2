package gal.uvigo.esei.aed1.chupatedos.core;

import java.util.Stack;

public class Table {
    private DeckOfCards deck;
    private Stack<Card> descartes;
    private Card topCard;
    /**
     *  Constructor for the Table class
     *  Initializes the dek and players stacks
     */
    public Table(DeckOfCards deck) {
        this.deck = deck;
        this.descartes = new Stack<Card>();
        this.topCard = null;
    }

    /**
     *  Metodo para obtener la carta de arriba de la mesa
     *  @return devuelve la carta de arriba de la mesa
     */
    public Card getTopCard() {
        if(this.topCard == null) {
            throw new IllegalStateException("No hay carta en la mesa");
        }
        return this.topCard;
    }
     
    /** 
     * Metodo para coger una carta de la baraja
     * si la baraja esta vacia la llena y la mezcla
     * @return la carta cogida de la baraja
     */
    public Card takeCard() {
        if (this.deck.isEmpty()) {
            while(!descartes.isEmpty()) {
                this.deck.addCard(this.descartes.pop());
this.deck.shuffle(5);
            }
        }
        return deck.pop();
    }
    public void setTopCard(Card card){
        this.topCard = card;
        this.descartes.add(card);
    }
    public int getNumCardDeck(){
        return this.deck.size();
    }
    /**
     * Metodo para tirar una carta a la mesa
     * si la carta es nula lanza una excepcion
     * @param card
     */
    public void throwCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card no puede ser nula");
        }
        this.descartes.push(card);
        this.topCard = card;
    }
    public int getNumDescartes(){
        return this.descartes.size();
    }
}
