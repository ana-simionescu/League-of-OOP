package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class LifeGiver extends Angel {

    public LifeGiver(int row, int column) {
        super(row,column);
        type = "LifeGiver";
    }
    @Override
    public final void affect(final Knight knight) {
        knight.setHp(min(knight.getHp() + Constants.LIFEGIVER_KNIGHT, knight.getMaxHP()));
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setHp(min(pyromancer.getHp() + Constants.LIFEGIVER_PYROMANCER,pyromancer.getMaxHP()));
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setHp(min(rogue.getHp() + Constants.LIFEGIVER_ROGUE, rogue.getMaxHP()));
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setHp(min(wizard.getHp() + Constants.LIFEGIVER_WIZARD, wizard.getMaxHP()));
    }
}
