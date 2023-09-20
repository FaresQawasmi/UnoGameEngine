package Entities;

import java.util.List;

public class GameEntity {
    public Deck deck;
    public List<Player> players;
    public List<Card> discardPile;
    public String chosenColor;
    public Player nextPlayer; // not used, but could benefit a developer for future game variations
    public int currentPlayerIndex;
    public boolean isClockwise;
    public Card card;
}
