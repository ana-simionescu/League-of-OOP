package characters;

import common.Constants;

public class Pyromancer extends Hero {

    float fireblast;
    float ignite;
    float igniteOverTime;

    public Pyromancer(int row, int column) {
        super(row, column);
        hp = Constants.PYROMANCER_HP;
        maxHP = Constants.PYROMANCER_HP;
        type = 'P';
        fireblast = 350;
        ignite = 150;
        igniteOverTime = 50;
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
        hp = Constants.PYROMANCER_HP + 50 * level;
        maxHP = Constants.PYROMANCER_HP + 50 * level;
        fireblast = 350 + level * 50;
        ignite = 150 + level * 20;
        igniteOverTime = 50 + level * 30;
    }
}
