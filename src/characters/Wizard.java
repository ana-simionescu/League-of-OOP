package characters;

import common.Constants;

public class Wizard extends Hero {
    public Wizard(int row, int column) {
        super(row, column);
        hp = Constants.WIZARD_HP;
        type = 'W';
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
