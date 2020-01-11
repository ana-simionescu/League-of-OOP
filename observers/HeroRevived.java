package observers;

import characters.heroes.Hero;

import java.util.List;

public class HeroRevived {
    public final void update(final Hero player, final List<String> output) {
        output.add("Player " + player.toStringName() + " was brought to life by an angel\n");
    }
}
