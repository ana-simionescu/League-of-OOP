package observers;

import characters.heroes.Hero;

import java.util.List;

public class HeroLeveledUp {
    public final void update(final Hero player, final int level, final List<String> output) {
        for (int i = level + 1; i <= player.getLevel(); i++) {
            output.add(player.toStringName() + " reached level " + i + "\n");
        }
    }
}
