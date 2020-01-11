package strategies;

import characters.heroes.Hero;
import common.Constants;

public class KnightOffensive implements Strategy {
    private Hero player;

    public KnightOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.K_OF_HP_NOMINATOR / Constants.K_OF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + Constants.K_OF_COEF);
    }
}
