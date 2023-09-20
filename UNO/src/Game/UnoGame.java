package Game;

import Rule.*;

public class UnoGame extends Game{

    public UnoGame(){
        super(new GameRules());

        addRule(new WildDrawFourRule());
        addRule(new WildRule());
        addRule(new ReverseRule());
        addRule(new SkipRule());
        addRule(new DrawTwoRule());
    }

    @Override
    public void play(){
        super.initializeGame();
        super.play();
    }
}
