package gal.uvigo.esei.aed1.chupatedos.core;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getCards() {
        for (Card card : cards)
            System.out.println(card);
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> availableCardsToPlayByNumber(Card tableCard) {
        ArrayList<Card> candidateCards = new ArrayList<>(); // if it is the same number

        for (Card card : cards)
            if (card.getNumber() == tableCard.getNumber())
                candidateCards.add(card);

        return candidateCards;
    }

    public ArrayList<Card> availableCardsToPlayBySuit(Card tableCard) {
        ArrayList<Card> candidateCards = new ArrayList<>(); // if it is the same suit

        for (Card card : cards)
            if (card.getSuit() == tableCard.getSuit())
                candidateCards.add(card);

        return candidateCards;
    }
}
