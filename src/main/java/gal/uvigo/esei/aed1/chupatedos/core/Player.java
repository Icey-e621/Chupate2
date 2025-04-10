package gal.uvigo.esei.aed1.chupatedos.core;
import java.util.ArrayList;

/**
 *@author Lucía 
*/
public class Player {
    private String name;
    private final ArrayList<Card> cards;

    /**
     * Player's constructor, initializes a player with a name and his cards
     * @param name
     */
    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    /**
     * Set player's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Shows the array of cards
     */
    public void getCards() {
        for (Card card : cards)
            System.out.println(card);
    }

    /**
     * Adds a card to the player's array of cards
     * @param card
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * * Returns the options of cards that a player can choose to play, based by their number
     * @param tableCard
     * @return candidateCards
     */
    public ArrayList<Card> availableCardsToPlayByNumber(Card tableCard) {
        ArrayList<Card> candidateCards = new ArrayList<>(); // if it is the same number

        for (Card card : cards)
            if (card.getNumber() == tableCard.getNumber())
                candidateCards.add(card);

        return candidateCards;
    }

    /**
     * Returns the options of cards that a player can choose to play, based by their suit
     * @param tableCard
     * @return candidateCards
     */
    public ArrayList<Card> availableCardsToPlayBySuit(Card tableCard) {
        ArrayList<Card> candidateCards = new ArrayList<>(); // if it is the same suit

        for (Card card : cards)
            if (card.getSuit() == tableCard.getSuit())
                candidateCards.add(card);

        return candidateCards;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" has cards {");
        for (Card card : this.cards){
            sb.append(card).append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
