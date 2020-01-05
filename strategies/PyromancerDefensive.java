package strategies;

import characters.heroes.Hero;

public class PyromancerDefensive implements Strategy {
    private Hero player;

    public PyromancerDefensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 4 / 3);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() - 0.3f);
    }
}
