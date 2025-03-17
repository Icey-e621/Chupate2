package gal.uvigo.esei.aed1.chupatedos.core;

import java.util.Arrays;
import java.util.Random;

/**
 * Class that simulates a Deck and internally acts as a Stack of the enum {@link gal.uvigo.esei.aed1.chupatedos.core.Card}
 */
public class DeckOfCards {
    private Card[] Cards;
    private int amount;
    private boolean isShuffled;

    public DeckOfCards() {
        this.isShuffled = false;
        this.fillDeck();
        this.shuffleDeck(3);
    }

    /**
     * Fills the deck with all instances of {@link gal.uvigo.esei.aed1.chupatedos.core.Card#values()}
     */
    public final void fillDeck() {
        int numCards = Card.values().length;
        System.arraycopy(Card.values(), 0, this.Cards, 0, numCards);
        /** 2 formas de hacerlo :)
         * for (int i = 0; i < numCards; i++) {
         *  this.Cards[i] = Card.values()[i];
         *   }
         */
        
        this.amount = numCards;
        this.isShuffled = false;
    }
    /**
     * @param Times How many times the deck will be shuffled @throws IllegalArgumentException if it is not between 1-20
     */
    public final void shuffleDeck(int Times) {
        if (Times < 1 || Times > 20){
            // Im using string builder in case someone wants to catch the error because they do something like ask the user
            throw new IllegalArgumentException(new StringBuilder("Deck cannot be shuffled too many times, tried to shuffle: ").append(Times).toString());
        }
        for(int j = 0; j < Times;j++){
            Random rnd = new Random();
            for (int i = this.Cards.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                Card a = this.Cards[index];
                this.Cards[index] = this.Cards[i];
                this.Cards[i] = a;
            }
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
     * @return returns and errases card on top of the deck @throws IndexOutOfBoundsException if deck is empty
     */
    public Card pop(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("DeckOfCards is empty");
        }
        this.amount--;
        return Cards[this.amount];
    }
    /**
     * 
     * @return Shows card on top of the deck without errasing it from the Deck @throws IndexOutOfBoundsException if deck is empty
     */
    public Card peek(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("DeckOfCards is empty");
        }
        return Cards[this.amount];
    }
    /**
     * Adds a card to the top of the deck
     * @param card Card to be added to the top of the Deck @throws IndexOutOfBoundsException if the Deck can't hold more cards;
     */
    public void addCard(Card card){
        if (this.amount >= Card.values().length){
            throw new IndexOutOfBoundsException("DeckOfCards is full");
        }
        this.Cards[this.amount] = card;
        this.amount++;
    }
    /**
     * Calls {@link #fillDeck()} followed by {@link #shuffleDeck(int)}
     */
    public void fillShuffle(){
        this.fillDeck();
        this.shuffleDeck(5);
    }

    // Here non commented and self explanatory methods
    public boolean isEmpty(){
        return this.amount==0;
    }
    public boolean isShuffled(){
        return this.isShuffled;
    }
    public boolean isFull(){
        return Card.values().length <= this.amount;
    }

    //Overriden Methods
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DeckOfCards)) return false;
        return obj.hashCode() == this.hashCode();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("DeckOfCards contains {");
        for(int i = 0;i<this.amount;i++){
            sb.append(" ").append(this.Cards[i].toString());
            if (this.amount-1!=i) sb.append(",");
        }
        return sb.toString();
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Arrays.deepHashCode(this.Cards);
        hash = 19 * hash + this.amount;
        hash = 19 * hash + (this.isShuffled ? 1 : 0);
        return hash;
    }
}
