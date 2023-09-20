package Rule;
import Entities.*;
import Game.*;
import Game.GameRules;

import java.util.Collections;

public class ReverseRule extends Rule {

    public ReverseRule() {
        super("Reverse");
    }


    @Override
    public GameRules apply(GameRules action) {
        action.reverseRule();
        return action;
    }
}
