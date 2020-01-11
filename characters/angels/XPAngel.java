package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class XPAngel extends Angel {

    public XPAngel(final int row, final int column) {
        super(row, column);
        type = "XPAngel";
    }
    @Override
    public final void affect(final Knight knight) {
        knight.addXP(Constants.XPANGEL_KNIGHT);
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.addXP(Constants.XPANGEL_PYROMANCER);
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.addXP(Constants.XPANGEL_ROGUE);
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.addXP(Constants.XPANGEL_WIZARD);
    }
}
