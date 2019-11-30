package characters;

import common.Constants;

import static java.lang.Integer.min;

public class Wizard extends Hero {

    float drain;
    float deflect;

    public Wizard(int row, int column) {
        super(row, column);
        hp = Constants.WIZARD_HP;
        maxHP = Constants.WIZARD_HP;
        type = 'W';
        drain = 20;
        deflect = 35;
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
    @Override
    public void levelUp() {
        super.levelUp();
        hp = Constants.WIZARD_HP + 30 * level;
        maxHP = Constants.WIZARD_HP + 30 * level;
        drain = 20 + level * 5;
        deflect = min(35 + 2 * level, 70);
    }
}
