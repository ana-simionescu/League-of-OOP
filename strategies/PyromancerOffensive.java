package strategies;

import characters.heroes.Hero;
import common.Constants;

public class PyromancerOffensive implements Strategy {
    private Hero player;

    public PyromancerOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.P_OF_HP_NOMINATOR / Constants.P_OF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + Constants.P_OF_COEF);
    }
}
