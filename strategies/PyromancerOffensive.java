package strategies;

import characters.heroes.Hero;

public class PyromancerOffensive implements Strategy {
    private Hero player;

    public PyromancerOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 3 / 4);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + 0.7f);
    }
}
