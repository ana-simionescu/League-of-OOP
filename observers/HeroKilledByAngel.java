package observers;

import characters.heroes.Hero;

import java.util.List;

public class HeroKilledByAngel{
    public void update(Hero player, List<String> output) {
        output.add("Player " + player.toStringName() + " was killed by an angel\n");
    }
}