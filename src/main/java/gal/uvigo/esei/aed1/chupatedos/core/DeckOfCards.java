package gal.uvigo.esei.aed1.chupatedos.core;

import java.util.Random;

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
    public void fillDeck() {
        int numCards = Card.values().length;
        for (int i = 0; i < numCards; i++) {
            this.Cards[i] = Card.values()[i];
        }
        this.amount = numCards;
        this.isShuffled = false;
    }
    /**
     * @param Times How many times the deck will be shuffled @throws IllegalArgumentException if it is not between 1-20
     */
    public void shuffleDeck(int Times) {
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
    public void shuffleDeck() {
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
     * @return shows card on top of the deck without errasing it from the Deck @throws IndexOutOfBoundsException if deck is empty
     */
    public Card peek(){
        if (this.isEmpty()){
            throw new IndexOutOfBoundsException("DeckOfCards is empty");
        }
        return Cards[this.amount];
    }
    /**
     * 
     * @param card Card to be added to the top of the Deck @throws IndexOutOfBoundsException if the Deck can't hold more cards;
     */
    public void addCard(Card card){
        if (this.amount >= Card.values().length){
            throw new IndexOutOfBoundsException("DeckOfCards is full");
        }
        this.Cards[this.amount] = card;
        this.amount++;
    }

    // Here non commented and self explanatory methods
    public boolean isEmpty(){
        return this.amount==0;
    }
    public boolean isShuffled(){
        return this.isShuffled;
    }

    //Overriden Methods
    @Override
    public boolean equals(Object obj) {
        DeckOfCards deck = (DeckOfCards) obj;
        for(int i = 0;i<this.amount;i++){
            if (this.Cards[i].getNumber() != deck.Cards[i].getNumber() || this.Cards[i].getSuit() != deck.Cards[i].getSuit()){
                return false;
            }
        }
        return true;
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
}
