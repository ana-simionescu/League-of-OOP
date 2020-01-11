package strategies;

import characters.heroes.Hero;
import common.Constants;

public class PyromancerDefensive implements Strategy {
    private Hero player;

    public PyromancerDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.P_DEF_HP_NOMINATOR
                / Constants.P_DEF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - Constants.P_DEF_COEF);
    }
}
