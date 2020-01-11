package strategies;

import characters.heroes.Hero;
import common.Constants;

public class KnightDefensive implements Strategy {
    private Hero player;

    public KnightDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.K_DEF_HP_NOMINATOR
                / Constants.K_DEF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - Constants.K_DEF_COEF);
    }
}
