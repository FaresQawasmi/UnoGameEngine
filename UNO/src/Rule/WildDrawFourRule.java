package Rule;

import Entities.*;
import Entities.GameEntity;
import Entities.Player;
import Entities.Rule;
import Game.GameRules;

public class WildDrawFourRule extends Rule {

    public WildDrawFourRule() {
        super("Wild Draw Four");
    }

    @Override
    public GameRules apply(GameRules action) {
        action.wildDrawFourRule();
        return action;
    }
}
