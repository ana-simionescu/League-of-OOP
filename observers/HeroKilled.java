package observers;

import characters.heroes.Hero;

import java.util.List;

public class HeroKilled{
    public void update(Hero first, Hero second, List<String> output) {
        output.add("Player " + first.toStringName() + " was killed by " + second.toStringName() + "\n");
    }
}
