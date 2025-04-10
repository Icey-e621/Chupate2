package gal.uvigo.esei.aed1.chupatedos.core;

import java.util.Stack;

public class Table {
    private Stack<Card> descartes;
    /**
     *  Constructor for the Table class
     *  Initializes the dek and players stacks
     */
    public Table() {
        this.descartes = new Stack<Card>();
    }

    /**
     *  Metodo para obtener la carta de arriba de la mesa
     *  @return devuelve la carta de arriba de la mesa
     */
    public Card getTopCard() {
        if(descartes.isEmpty()) {
            throw new IllegalStateException("No hay carta en la mesa");
        }
        return descartes.peek();
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
            }
        }
        return deck.pop();
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
}