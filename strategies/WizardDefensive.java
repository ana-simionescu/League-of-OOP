package strategies;

import characters.heroes.Hero;

public class WizardDefensive implements Strategy {
    private Hero player;

    public WizardDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 6 / 5);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - 0.2f);
    }
}
