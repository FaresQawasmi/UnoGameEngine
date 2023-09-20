package Rule;
import Entities.*;
import Game.GameRules;

public class SkipRule extends Rule {

    public SkipRule() {
        super("Skip");
    }


    @Override
    public GameRules apply(GameRules action) {
        action.skipRule();
        return action;
    }
}
