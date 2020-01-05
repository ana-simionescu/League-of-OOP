package strategies;

import characters.heroes.Hero;

public class KnightOffensive implements Strategy {
    private Hero player;

    public KnightOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 4 / 5);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + 0.5f);
    }
}
