package strategies;

import characters.heroes.Hero;

public class PyromancerOffensive implements Strategy {
    private Hero player;

    public PyromancerOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
    }

    @Override
    public final void changeCoef() {

    }
}
