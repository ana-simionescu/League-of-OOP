package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class LevelUpAngel extends Angel {

    public LevelUpAngel(final int row, final int column) {
        super(row, column);
        type = "LevelUpAngel";
    }
    @Override
    public final void affect(final Knight knight) {
        knight.setAngelInfluence(knight.getAngelInfluence() + Constants.LEVELUPANGEL_KNIGHT);
        knight.levelUpByAngel();
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setAngelInfluence(pyromancer.getAngelInfluence()
                + Constants.LEVELUPANGEL_PYROMANCER);
        pyromancer.levelUpByAngel();
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setAngelInfluence(rogue.getAngelInfluence() + Constants.LEVELUPANGEL_ROGUE);
        rogue.levelUpByAngel();
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setAngelInfluence(wizard.getAngelInfluence() + Constants.LEVELUPANGEL_WIZARD);
        wizard.levelUpByAngel();
    }
}
