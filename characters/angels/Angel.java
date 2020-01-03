package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;
import map.Map;
import map.Terrain;

import static java.lang.Integer.max;


public abstract class Angel {
    protected char type;
    protected int row;
    protected int column;

    protected Map map = Map.getInstance();

    public Angel(final int row, final int column) {
        this.row = row;
        this.column = column;
        type = '-';
    }
    /*public final String toString() {
        if (hp == -1) {
            return type + " dead";
        } else {
            return type + " " + level + " " + xp + " " + hp + " " + row + " " + column;
        }
    }*/

    public final Map getMap() {
        return map;
    }

    public final char getType() {
        return type;
    }

    public abstract void affect(Knight knight);
    public abstract void affect(Pyromancer pyromancer);
    public abstract void affect(Rogue rogue);
    public abstract void affect(Wizard wizard);


    public final float max(final int a, final int b) {
        if (a > b) {
            return a;
        }
        return b;
    }
}
