package gal.uvigo.esei.aed1.chupatedos.core;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Class that simulates a Deck and internally acts as a Stack of the enum
 * {@link gal.uvigo.esei.aed1.chupatedos.core.Card}
 */
public class DeckOfCards {
    private Stack<Card> Cards;
    private boolean isShuffled;

    public DeckOfCards() {
        this.isShuffled = false;
        this.fillDeck();
        this.shuffleDeck(3);
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
     * @param Times How many times the deck will be shuffled @throws
     *              IllegalArgumentException if it is not between 1-20
     */
    public void shuffleDeck(int Times) {
        if (Times < 1 || Times > 20) {
            // Im using string builder in case someone wants to catch the error because they
            // do something like ask the user
            throw new IllegalArgumentException(
                    new StringBuilder("Deck cannot be shuffled too many times, tried to shuffle: ").append(Times)
                            .toString());
        }
        for (int j = 0; j < Times; j++) {
            Collections.shuffle(this.Cards);
        }
        this.isShuffled = true;
    }

    /**
     * Invokes {@link #shuffleDeck(int)} with Parameter Times set to 1
     */
    public final void shuffleDeck() {
        this.shuffleDeck(1);
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
        this.shuffleDeck(5);
    }

    /**
     * Searches and removes a carrd from the deck
     * 
     * @param card {@link Card} To be removed from the Deck
     * @return true if card had been found and errased, false if not.
     */
    public boolean SearchRemove(Card card) {
        if (this.isEmpty())
            return false;
        boolean remove = false;

        this.Cards.remove(card);

        return remove;
    }

    // Here non commented and self explanatory methods
    public boolean isEmpty() {
        return this.Cards.size() == 0;
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
