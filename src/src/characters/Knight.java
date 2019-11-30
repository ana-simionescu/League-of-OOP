package characters;

import common.Constants;
import map.Terrain;

import static java.lang.Integer.min;
import static java.lang.Math.round;

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

    public float calculateDmg (float baseDmg, Terrain terrain) {
        if (terrain.getType() == 'L') {
            return baseDmg * 1.15f;
        }
        return baseDmg;
    }

    @Override
    public void isAttackedBy(Hero player, Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public void attack(Knight knight, Terrain terrain) {
        float victimHpLimit = executeHPLimit / 100f * knight.maxHP;
        if (knight.hp < victimHpLimit) {
            knight.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain);
            float dmgSlam = calculateDmg(slam, terrain) * 1.2f;
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            knight.dmg = totalDmg;
            knight.overtimeDmgTimer = 1;
            knight.overtimeDmg = 0;
            knight.movingAbility = false;
        }
    }

    @Override
    public void attack(Pyromancer pyromancer, Terrain terrain) {
        float victimHpLimit = executeHPLimit / 100f * pyromancer.maxHP;
        if (pyromancer.hp < victimHpLimit) {
            pyromancer.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain) * 1.1f;
            float dmgSlam = calculateDmg(slam, terrain) * 0.9f;
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            pyromancer.dmg = totalDmg;
            pyromancer.overtimeDmgTimer = 1;
            pyromancer.overtimeDmg = 0;
            pyromancer.movingAbility = false;
        }
    }

    @Override
    public void attack(Rogue rogue, Terrain terrain) {
        float victimHpLimit = executeHPLimit / 100f * rogue.maxHP;
        if (rogue.hp < victimHpLimit) {
            rogue.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain) * 1.15f;
            float dmgSlam = calculateDmg(slam, terrain) * 0.8f;
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            rogue.dmg = totalDmg;
            rogue.overtimeDmgTimer = 1;
            rogue.overtimeDmg = 0;
            rogue.movingAbility = false;
        }
    }

    @Override
    public void attack(Wizard wizard, Terrain terrain) {
        float victimHpLimit = executeHPLimit / 100f * wizard.maxHP;
        if (wizard.hp < victimHpLimit) {
            wizard.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain) * 0.8f;
            float dmgSlam = calculateDmg(slam, terrain) * 1.05f;
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            wizard.dmg = totalDmg;
            wizard.overtimeDmgTimer = 1;
            wizard.overtimeDmg = 0;
            wizard.movingAbility = false;
        }
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
