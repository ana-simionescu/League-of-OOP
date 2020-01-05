package strategies;

import characters.heroes.Hero;

public class RogueDefensive implements Strategy {
    private Hero player;

    public RogueDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 3 / 2);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - 0.1f);
    }
}
