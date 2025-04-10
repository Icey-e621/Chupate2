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
}
