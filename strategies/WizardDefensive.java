package strategies;

import characters.heroes.Hero;

public class WizardDefensive implements Strategy {
    private Hero player;

    public WizardDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
    }

    @Override
    public final void changeCoef() {

    }
}
