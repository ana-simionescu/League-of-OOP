package strategies;

import characters.heroes.Hero;

public class Basic implements Strategy {
    private Hero player;

    public Basic(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
    }

    @Override
    public final void changeCoef() {

    }
}
