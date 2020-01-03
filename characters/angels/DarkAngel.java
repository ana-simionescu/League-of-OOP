package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class DarkAngel extends Angel {

    @Override
    public final void affect(final Knight knight) {
        knight.setHp(knight.getHp() - Constants.DARKANGEL_KNIGHT);
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() - Constants.DARKANGEL_PYROMANCER);
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setHp(rogue.getHp() - Constants.DARKANGEL_ROGUE);
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setHp(wizard.getHp() - Constants.DARKANGEL_WIZARD);
    }
}
