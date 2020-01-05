package strategies;

import characters.heroes.Hero;

public class KnightDefensive implements Strategy {
    private Hero player;

    public KnightDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 5 / 4);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - 0.2f);
    }
}
