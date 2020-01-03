package characters.angels;

import characters.heroes.Knight;
import characters.heroes.Pyromancer;
import characters.heroes.Rogue;
import characters.heroes.Wizard;
import common.Constants;

public class SmallAngel extends Angel {

    @Override
    public final void affect(final Knight knight) {
        knight.setHp(knight.getHp() + Constants.SMALLANGEL_HP_KNIGHT);
        knight.setAngelInfluence(knight.getAngelInfluence() + Constants.SMALLANGEL_DMG_KNIGHT);
    }

    @Override
    public final void affect(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() + Constants.SMALLANGEL_HP_PYROMANCER);
        pyromancer.setAngelInfluence(pyromancer.getAngelInfluence() + Constants.SMALLANGEL_DMG_PYROMANCER);
    }

    @Override
    public final void affect(final Rogue rogue) {
        rogue.setHp(rogue.getHp() + Constants.SMALLANGEL_HP_ROGUE);
        rogue.setAngelInfluence(rogue.getAngelInfluence() + Constants.SMALLANGEL_DMG_ROGUE);
    }

    @Override
    public final void affect(final Wizard wizard) {
        wizard.setHp(wizard.getHp() + Constants.SMALLANGEL_HP_WIZARD);
        wizard.setAngelInfluence(wizard.getAngelInfluence() + Constants.SMALLANGEL_DMG_WIZARD);
    }
}
