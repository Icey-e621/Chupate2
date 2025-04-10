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
     * Metodo para recibir una carta en la mesa
     * si la carta es nula lanza una excepcion
     * @param card
     */
    public void receiveCard(Card card){
        if(card == null) {
            throw new IllegalArgumentException("La carta no puede ser nula");
        }
        this.descartes.push(card);
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
     * 
     * @return numero cartas que hay en deacartes
     */
    public int sizeDescartes() {
        return this.descartes.size();
    }
}
