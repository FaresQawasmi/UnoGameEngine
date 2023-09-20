package Entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] colors = {"Red", "Green", "Blue", "Yellow"};
        String[] values = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "Skip", "Reverse", "Draw Two"};

        for (String color : colors) {
            for (String value : values) {
                cards.add(new Card(color, value));      // Add number cards
            }

            for (int i = 0; i < 2; i++) {
                cards.add(new Card(color, "Skip"));
                cards.add(new Card(color, "Reverse"));      // Add action cards
                cards.add(new Card(color, "Draw Two"));
            }
        }

        // Add wild cards
        for (int i = 0; i < 4; i++) {
            cards.add(new Card("Wild", "Wild"));
            cards.add(new Card("Wild", "Wild Draw Four"));
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {  // deck is empty
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
}