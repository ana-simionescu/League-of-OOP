package strategies;

import characters.heroes.Hero;
import common.Constants;

public class RogueOffensive implements Strategy {
    private Hero player;

    public RogueOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * Constants.R_OF_HP_NOMINATOR / Constants.R_OF_HP_DENOMINATOR);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + Constants.R_OF_COEF);
    }
}
