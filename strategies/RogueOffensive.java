package strategies;

import characters.heroes.Hero;

public class RogueOffensive implements Strategy {
    private Hero player;

    public RogueOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
    }

    @Override
    public final void changeCoef() {

    }
}
