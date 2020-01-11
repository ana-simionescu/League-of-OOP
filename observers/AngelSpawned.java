package observers;

import characters.angels.Angel;

import java.util.List;

public class AngelSpawned {
    public final void update(final Angel angel, final List<String> output) {
        switch (angel.getType()) {
            case "DamageAngel": output.add("Angel DamageAngel was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "DarkAngel": output.add("Angel DarkAngel was spawned at " + angel.getRow() + " "
                    + angel.getColumn() + "\n"); break;
            case "Dracula": output.add("Angel Dracula was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "GoodBoy": output.add("Angel GoodBoy was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "LevelUpAngel": output.add("Angel LevelUpAngel was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "LifeGiver": output.add("Angel LifeGiver was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "SmallAngel": output.add("Angel SmallAngel was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "Spawner": output.add("Angel Spawner was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "TheDoomer": output.add("Angel TheDoomer was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            case "XPAngel": output.add("Angel XPAngel was spawned at "
                    + angel.getRow() + " " + angel.getColumn() + "\n"); break;
            default : break;
        }
    }
}
