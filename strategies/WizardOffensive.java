package strategies;

import characters.heroes.Hero;
import common.Constants;

public class WizardOffensive implements Strategy {
    private Hero player;

    public WizardOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.W_OF_HP_NOMINATOR / Constants.W_OF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + Constants.W_OF_COEF);
    }
}
