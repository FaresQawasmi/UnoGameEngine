package Game;

import Entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Game implements IGame {
    private List<Rule> rules = new ArrayList<>();
    private GameRules action;

    public Game(GameRules gameRules){
        action = gameRules;
    }

    public void addRule(Rule _rules){
        rules.add(_rules);
    }

    public void handleCardEffect(Card card) {
        action.card = card;
        for (Rule rule : rules) {
            if(Objects.equals(card.getValue(), rule.getRuleName()))
                 action= rule.apply(action);
        }
    }

    public void initializeGame() {
        System.out.println("Initializing Uno Game....");

        Scanner scanner = new Scanner(System.in);
        int numOfPlayers = 0;

        while (numOfPlayers <= 1) {
            System.out.print("Enter the number of players (must be greater than 1): ");
            numOfPlayers = scanner.nextInt();

            if (numOfPlayers <= 1) {
                System.out.println("Invalid number of players! Please enter a number greater than 1.");
            }
        }
        scanner.nextLine();

        for (int i = 1; i <= numOfPlayers; i++) {
            System.out.print("Enter the name of Player " + i + ": ");
            String playerName = scanner.nextLine();
            action.players.add(new Player(playerName));
        }

        action.deck.shuffle();

        Card firstCard = action.deck.drawCard();
        while (firstCard.isWildCard()) {
            firstCard = action.deck.drawCard();
        }
        action.discardPile.add(firstCard);

        for (Player player : action.players) {
            for (int i = 0; i < 7; i++) {
                Card card = action.deck.drawCard();
                player.addCardToHand(card);
            }
        }
    }


    public void play() {

        Scanner scanner = new Scanner(System.in);

        while (action.isGameOver()) {
            Player currentPlayer = action.players.get(action.currentPlayerIndex);

            action.printCurrentPlayer(currentPlayer);
            System.out.println("Player's Hand: " + currentPlayer.getHand());

            boolean validPlay = false;

            while (!validPlay) {
                System.out.print("Choose a card to play (Enter the index), or enter -1 to draw a card: ");
                int cardIndex = scanner.nextInt();

                if (cardIndex == -1) {
                    Card drawnCard = action.deck.drawCard();
                    if (drawnCard != null) {
                        currentPlayer.addCardToHand(drawnCard);
                        System.out.println(currentPlayer.getName() + " drew a card: " + drawnCard.getColor() + " " + drawnCard.getValue());
                    } else {
                        System.out.println("No more cards in the deck!");
                    }
                    validPlay = true;
                } else if (cardIndex >= 0 && cardIndex < currentPlayer.getHand().size()) {
                    Card selectedCard = currentPlayer.playCard(cardIndex);

                    if (action.isValidPlay(selectedCard)) {
                        validPlay = true;
                        action.discardPile.add(selectedCard);
                        System.out.println(currentPlayer.getName() + " played: " + selectedCard.getColor() + " " + selectedCard.getValue());

                        handleCardEffect(selectedCard);

                        if (currentPlayer.getHand().isEmpty()) {
                            System.out.println("\n______________________________");
                            System.out.println("UNO! " + currentPlayer.getName() + " wins!");
                            break;
                        }
                    } else {
                        System.out.println("Invalid play! Try again.");
                        currentPlayer.addCardToHand(selectedCard);
                    }
                } else {
                    System.out.println("Invalid index! Try again.");
                }
            }
            if (action.isGameOver()) {
                action.updateCurrentPlayer();
            }
        }
        scanner.close();
    }

}


