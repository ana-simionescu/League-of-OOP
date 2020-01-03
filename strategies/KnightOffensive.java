package strategies;

import characters.heroes.Hero;

public class KnightOffensive implements Strategy {
    private Hero player;

    public KnightOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
    }

    @Override
    public final void changeCoef() {

    }
}
