package Game;

import Entities.Player;

import java.util.Collections;

public class GameRules extends GameAction {
    public void drawTwoRule() {
        Player nextPlayer = getNextPlayer();
        drawCards(nextPlayer,2);
        System.out.println(nextPlayer.getName() + " drew 2 cards!");
    }

    public void wildDrawFourRule() {
        Player nextPlayerDrawFour = getNextPlayer();
        drawCards(nextPlayerDrawFour, 4);
        System.out.println(nextPlayerDrawFour.getName() + " drew 4 cards!");
        System.out.println("Wild Draw Four card played!");
        chosenColor = chooseColor();
        card.setColor(chosenColor);
        System.out.println("Color chosen: " + chosenColor);
        updateCurrentPlayer();
    }
    public void wildRule() {
        System.out.println("Wild card played!");
        chosenColor = chooseColor();
        card.setColor(chosenColor);
        System.out.println("Color chosen: " + chosenColor);
    }
    public void skipRule() {
        System.out.println("Turn skipped!");
        updateCurrentPlayer();
    }
    public void reverseRule() {
        Collections.reverse(players);
        System.out.println("Game direction reversed!");
    }
}
