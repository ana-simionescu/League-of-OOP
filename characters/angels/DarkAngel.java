package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class DarkAngel extends Angel {

    public DarkAngel(final int row, final int column) {
        super(row, column);
        type = "DarkAngel";
    }
    @Override
    public final void affect(final Knight knight) {
        knight.setHp(knight.getHp() - Constants.DARKANGEL_KNIGHT);
        if (knight.getHp() < 0) {
            knight.setHp(-1);
        }
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() - Constants.DARKANGEL_PYROMANCER);
        if (pyromancer.getHp() < 0) {
            pyromancer.setHp(-1);
        }
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setHp(rogue.getHp() - Constants.DARKANGEL_ROGUE);
        if (rogue.getHp() < 0) {
            rogue.setHp(-1);
        }
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setHp(wizard.getHp() - Constants.DARKANGEL_WIZARD);
        if (wizard.getHp() < 0) {
            wizard.setHp(-1);
        }
    }
}
