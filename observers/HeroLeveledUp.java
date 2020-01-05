package observers;

import characters.heroes.Hero;

import java.util.List;

public class HeroLeveledUp {
    public void update(Hero player, int level, List<String> output) {
        for(int i = level + 1; i <= player.getLevel(); i++)
            output.add(player.toStringName() + " reached level " + i + "\n");
    }
}
