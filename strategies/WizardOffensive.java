package strategies;

import characters.heroes.Hero;

public class WizardOffensive implements Strategy {
    private Hero player;

    public WizardOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
    }

    @Override
    public final void changeCoef() {

    }
}
