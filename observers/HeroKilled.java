package observers;

import characters.heroes.Hero;

import java.util.List;

public class HeroKilled {
    public final void update(final Hero first, final Hero second, final List<String> output) {
        output.add("Player " + first.toStringName() + " was killed by "
                + second.toStringName() + "\n");
    }
}
