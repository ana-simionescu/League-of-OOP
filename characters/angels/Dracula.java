package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class Dracula extends Angel {

    public Dracula(int row, int column) {
        super(row,column);
        type = "Dracula";
    }
    @Override
    public final void affect(final Knight knight) {
        knight.setHp(knight.getHp() - Constants.DRACULA_HP_KNIGHT);
        knight.setAngelInfluence(knight.getAngelInfluence() - Constants.DRACULA_DMG_KNIGHT);
        if (knight.getHp() < 0)
            knight.setHp(-1);
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() - Constants.DRACULA_HP_PYROMANCER);
        pyromancer.setAngelInfluence(pyromancer.getAngelInfluence() - Constants.DRACULA_DMG_PYROMANCER);
        if(pyromancer.getHp() < 0)
            pyromancer.setHp(-1);
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setHp(rogue.getHp() - Constants.DRACULA_HP_ROGUE);
        rogue.setAngelInfluence(rogue.getAngelInfluence() - Constants.DRACULA_DMG_ROGUE);
        if(rogue.getHp() < 0)
            rogue.setHp(-1);
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setHp(wizard.getHp() - Constants.DRACULA_HP_WIZARD);
        wizard.setAngelInfluence(wizard.getAngelInfluence() - Constants.DRACULA_DMG_WIZARD);
        if(wizard.getHp() < 0)
            wizard.setHp(-1);
    }
}
