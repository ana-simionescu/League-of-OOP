package strategies;

import characters.heroes.Hero;
import common.Constants;

public class RogueDefensive implements Strategy {
    private Hero player;

    public RogueDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.R_DEF_HP_NOMINATOR
                / Constants.R_DEF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - Constants.R_DEF_COEF);
    }
}
