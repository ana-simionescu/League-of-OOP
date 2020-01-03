package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class LifeGiver extends Angel {

    @Override
    public final void affect(final Knight knight) {
        knight.setHp(knight.getHp() + Constants.LIFEGIVER_KNIGHT);
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() + Constants.LIFEGIVER_PYROMANCER);
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setHp(rogue.getHp() + Constants.LIFEGIVER_ROGUE);
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setHp(wizard.getHp() + Constants.LIFEGIVER_WIZARD);
    }
}
