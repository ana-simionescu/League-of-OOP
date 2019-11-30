package characters;

import common.Constants;

import static java.lang.Integer.min;

public class Knight extends Hero {

    float execute;
    float executeHPLimit;
    float slam;

    public Knight(int row, int column) {
        super(row, column);
        hp = Constants.KNIGHT_HP;
        maxHP = Constants.KNIGHT_HP;
        type = 'K';
        execute = 200;
        executeHPLimit = 20;
        slam = 100;
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
        hp = Constants.KNIGHT_HP + 80 * level;
        maxHP = Constants.KNIGHT_HP + 80 * level;
        execute = 200 + level * 30;
        executeHPLimit = min(40, 20 + level);
        slam = 100 + 40 * level;
    }
}
