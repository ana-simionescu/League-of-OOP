package observers;

import characters.heroes.Hero;

import java.util.List;

public class HeroKilledByAngel {
    public final void update(final Hero player, final List<String> output) {
        output.add("Player " + player.toStringName() + " was killed by an angel\n");
    }
}
