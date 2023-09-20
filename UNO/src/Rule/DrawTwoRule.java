package Rule;
import Entities.*;
import Game.GameRules;

public class DrawTwoRule extends Rule {

    public DrawTwoRule() {
        super("Draw Two");
    }

    @Override
    public GameRules apply(GameRules action) {
        action.drawTwoRule();
        return action;
    }
}
