package strategies;

import characters.heroes.Hero;
import common.Constants;

public class WizardDefensive implements Strategy {
    private Hero player;

    public WizardDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.W_DEF_HP_NOMINATOR
                / Constants.W_DEF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - Constants.W_DEF_COEF);
    }
}
