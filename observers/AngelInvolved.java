package observers;

import characters.angels.*;
import characters.heroes.Hero;

import java.util.List;

public class AngelInvolved {
    public void update(final Angel angel, final Hero player, List<String> output) {
        switch (angel.getType()) {
            case "DamageAngel": output.add("DamageAngel helped " + player.toStringName() + "\n"); break;
            case "DarkAngel": output.add("DarkAngel hit " + player.toStringName() + "\n"); break;
            case "Dracula": output.add("Dracula hit " + player.toStringName() + "\n"); break;
            case "GoodBoy": output.add("GoodBoy helped " + player.toStringName() + "\n"); break;
            case "LevelUpAngel": output.add("LevelUpAngel helped " + player.toStringName() + "\n"); break;
            case "LifeGiver": output.add("LifeGiver helped " + player.toStringName() + "\n"); break;
            case "SmallAngel": output.add("SmallAngel helped " + player.toStringName() + "\n"); break;
            case "Spawner": output.add("Spawner helped " + player.toStringName() + "\n"); break;
            case "TheDoomer": output.add("TheDoomer hit " + player.toStringName() + "\n"); break;
            case "XPAngel": output.add("XPAngel helped " + player.toStringName() + "\n"); break;
            default : ;
        }
    }
}
