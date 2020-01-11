package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;

public class TheDoomer extends Angel {

    public TheDoomer(final int row, final int column) {
        super(row, column);
        type = "TheDoomer";
    }
    @Override
    public final void affect(final Knight knight) {
        knight.setHp(-1);
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setHp(-1);
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setHp(-1);
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setHp(-1);
    }
}
