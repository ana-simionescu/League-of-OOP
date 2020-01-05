package strategies;

import characters.heroes.Hero;

public class WizardOffensive implements Strategy {
    private Hero player;

    public WizardOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 9 / 10);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + 0.6f);
    }
}
