package Rule;
import Entities.*;
import Game.GameRules;

public class WildRule extends Rule {

    public WildRule() {
        super("Wild");
    }


    @Override
    public GameRules apply(GameRules action) {
        action.wildRule();
        return action;

    }
}
