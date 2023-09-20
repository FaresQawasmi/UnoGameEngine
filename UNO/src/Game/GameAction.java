package Game;

import Entities.*;

import java.util.ArrayList;
import java.util.Scanner;

public class GameAction extends GameEntity {


    public GameAction(){
        deck = new Deck();
        discardPile = new ArrayList<>();
        players =  new ArrayList<>();
        chosenColor = "";
        currentPlayerIndex  = 0;
        isClockwise = true;
    }


    public void drawCards(Player player,  int numCards) {
        if (numCards <= 0) {
            return; // or throw an exception indicating invalid input
        }

        for (int i = 0; i < numCards; i++) {
            Card card = deck.drawCard();
            player.addCardToHand(card);
        }
    }

    public Player getNextPlayer() {
        updateCurrentPlayer();
        return players.get(currentPlayerIndex);
    }

    public  String chooseColor () {
        Scanner scanner = new Scanner(System.in);
        String chosenColor = "";

        // Prompt the player to choose a color after a Wild Card
        System.out.println("Choose a color: Red, Green, Blue, or Yellow");
        boolean isValidColor = false;

        while (!isValidColor) {
            String newColor = scanner.nextLine().trim().toLowerCase(); // ensure that all cases of a valid color are accepted
            switch (newColor) {
                case "red", "green", "blue", "yellow":
                    chosenColor = newColor;
                    isValidColor = true;
                    break;
                default:
                    System.out.println("Invalid color! Choose a color from the given options.");
                    break;
            }
        }
        return chosenColor;
    }


    public void updateCurrentPlayer() {
        if (isClockwise) {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        } else {
            currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
        }
    }

    public void printCurrentPlayer(Player player) {
        System.out.println(player.getName() + "'s turn. Current card: " +
                discardPile.get(discardPile.size() - 1).getColor() + " " +
                discardPile.get(discardPile.size() - 1).getValue());
    }

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getHand().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    public boolean isValidPlay(Card card) {
        Card currentCard = discardPile.get(discardPile.size() - 1);

        if (card.isWildCard()) {
            return true;
        }

        if (currentCard.isWildCard()) {
            return card.getColor().equalsIgnoreCase(chosenColor);
        }

        return card.getColor().equalsIgnoreCase(currentCard.getColor()) ||
                card.getValue().equalsIgnoreCase(currentCard.getValue());
    }
}
