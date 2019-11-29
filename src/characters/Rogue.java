package characters;

import common.Constants;

public class Rogue extends Hero {
    public Rogue(int row, int column) {
        super(row, column);
        hp = Constants.ROGUE_HP;
        type = 'R';
    }
    @Override
    public void isAttackedBy(Hero player) {
        player.attack(this);
    }

    @Override
    public void attack(Knight knight) {

    }

    @Override
    public void attack(Pyromancer pyromancer) {

    }

    @Override
    public void attack(Rogue rogue) {

    }

    @Override
    public void attack(Wizard wizard) {

    }
}
