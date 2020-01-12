package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import map.Map;


public abstract class Angel {
    protected String type;
    protected int row;
    protected int column;

    protected Map map = Map.getInstance();

    public Angel(final int row, final int column) {
        this.row = row;
        this.column = column;
        type = "-";
    }
    public final int getColumn() {
        return column;
    }

    public final int getRow() {
        return row;
    }

    public final Map getMap() {
        return map;
    }

    public final String getType() {
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
    public final int min(final int a, final int b) {
        if (a < b) {
            return a;
        }
        return b;
    }
}
