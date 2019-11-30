package characters;

import common.Constants;

public class Rogue extends Hero {

    float backstab;
    float paralysis;
    int backstabCounter;

    public Rogue(int row, int column) {
        super(row, column);
        hp = Constants.ROGUE_HP;
        type = 'R';
        backstab = 200;
        backstabCounter = 1;
        paralysis = 40;
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
        hp = Constants.ROGUE_HP + 40 * level;
        backstab = 200 + 20 * level;
        paralysis = 40 + 10 * level;
    }
}
