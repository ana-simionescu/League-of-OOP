package strategies;

import characters.heroes.Hero;

public class RogueOffensive implements Strategy {
    private Hero player;

    public RogueOffensive(final Hero player) {
        this.player = player;
    }

    @Override
    public final void changeHp() {
        player.setHp(player.getHp() * 6 / 7);
    }

    @Override
    public final void changeCoef() {
        player.setAngelInfluence(player.getAngelInfluence() + 0.4f);
    }
}
