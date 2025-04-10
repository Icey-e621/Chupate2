package gal.uvigo.esei.aed1.chupatedos.core;

import java.util.Collections;
import java.util.Stack;

/**
 * Class that simulates a Deck and internally acts as a Stack of the enum {@link gal.uvigo.esei.aed1.chupatedos.core.Card}
 * @author Icey-e621
 */
public class DeckOfCards{
    private Stack<Card> Cards;
    private boolean isShuffled;

    public DeckOfCards() {
        this.isShuffled = false;
        this.Cards = new Stack<Card>();
        this.fillDeck();
        this.shuffleDeck();
    }

    /**
     * Fills the deck with all instances of
     * {@link gal.uvigo.esei.aed1.chupatedos.core.Card#values()}
     */
    public final void fillDeck() {
        int numCards = Card.values().length;
        for (int i = 0; i < numCards; i++) {
            this.Cards.push(Card.values()[i]);
        }
        this.isShuffled = false;
    }

    /**
     * Invokes {@link #shuffleDeck(int)} with Parameter Times set to 1
     */
    public final void shuffleDeck() {
        Collections.shuffle(this.Cards);
        this.isShuffled = true;
    }

    /**
     * @return returns and errases card on top of the deck @throws
     *         IndexOutOfBoundsException if deck is empty
     */
    public Card pop() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("DeckOfCards is empty");
        }
        return this.Cards.pop();
    }

    /**
     * 
     * @return Shows card on top of the deck without errasing it from the
     *         Deck @throws IndexOutOfBoundsException if deck is empty
     */
    public Card peek() {
        if (this.isEmpty()) {
            throw new IndexOutOfBoundsException("DeckOfCards is empty");
        }
        return Cards.peek();
    }

    /**
     * Adds a card to the top of the deck
     * 
     * @param card Card to be added to the top of the Deck @throws
     *             IndexOutOfBoundsException if the Deck can't hold more cards;
     */
    public void addCard(Card card) {
        this.Cards.push(card);
    }

    /**
     * Calls {@link #fillDeck()} followed by {@link #shuffleDeck(int)}
     */
    public void fillShuffle() {
        this.fillDeck();
        this.shuffleDeck();
    }
    

    // Here non commented and self explanatory methods
    public boolean isEmpty() {
        return this.Cards.size() == 0;
    }
    public int size(){
        return this.Cards.size();
    }

    public boolean isShuffled() {
        return this.isShuffled;
    }
    
    // Hash Codes :)
    // Please dont use md5 here
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Cards == null) ? 0 : Cards.hashCode());
        result = prime * result + (isShuffled ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        DeckOfCards other = (DeckOfCards) obj;
        if (Cards == null) {
            if (other.Cards != null)
                return false;

        } else if (!Cards.equals(other.Cards))
            return false;

        if (isShuffled != other.isShuffled)
            return false;
            
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DeckOfCards: ")
                .append(this.isShuffled ? "is shuffled " : "is not shuffled ");
        sb.append(this.Cards);
        return sb.toString();
    }
}
