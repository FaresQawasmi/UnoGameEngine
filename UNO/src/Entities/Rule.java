package Entities;

import Game.GameRules;

public abstract class Rule {
    private String ruleName;

    public Rule(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleName() {
        return ruleName;
    }

    public abstract GameRules apply(GameRules action);

}
