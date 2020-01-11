package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class Spawner extends Angel {

    public Spawner(final int row, final int column) {
        super(row, column);
        type = "Spawner";
    }
    @Override
    public final void affect(final Knight knight) {
        if (!knight.isAlive()) {
            knight.setHp(Constants.SPAWNER_KNIGHT);
        }
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        if (!pyromancer.isAlive()) {
            pyromancer.setHp(Constants.SPAWNER_PYROMANCER);
        }
    }
    @Override
    public final void affect(final Rogue rogue) {
        if (!rogue.isAlive()) {
            rogue.setHp(Constants.SPAWNER_ROGUE);
        }
    }

    @Override
    public final void affect(final Wizard wizard) {
        if (!wizard.isAlive()) {
            wizard.setHp(Constants.SPAWNER_WIZARD);
        }
    }
}
