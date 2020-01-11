package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class DamageAngel extends Angel {

    public DamageAngel(final int row, final int column) {
        super(row, column);
        type = "DamageAngel";
    }
    @Override
    public final void affect(final Knight knight) {
        knight.setAngelInfluence(knight.getAngelInfluence() + Constants.DAMAGEANGEL_KNIGHT);
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setAngelInfluence(pyromancer.getAngelInfluence()
                + Constants.DAMAGEANGEL_PYROMANCER);
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setAngelInfluence(rogue.getAngelInfluence() + Constants.DAMAGEANGEL_ROGUE);
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setAngelInfluence(wizard.getAngelInfluence() + Constants.DAMAGEANGEL_WIZARD);
    }
}
