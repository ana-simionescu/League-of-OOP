package characters;

import common.Constants;
import map.Terrain;

import static java.lang.Math.round;

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

    public float calculateDmg (float baseDmg, Terrain terrain) {
        if (terrain.getType() == 'V') {
            return baseDmg * 1.25f;
        }
        return baseDmg;
    }

    @Override
    public void isAttackedBy(Hero player, Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public void attack(Knight knight, Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * 1.2f;
        float dmgIgnite = calculateDmg(ignite, terrain) * 1.2f;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain) * 1.2f;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        knight.dmg = totalDmg;
        knight.overtimeDmgTimer = 2;
        knight.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public void attack(Pyromancer pyromancer, Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * 0.9f;
        float dmgIgnite = calculateDmg(ignite, terrain) * 0.9f;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain) * 0.9f;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        pyromancer.dmg = totalDmg;
        pyromancer.overtimeDmgTimer = 2;
        pyromancer.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public void attack(Rogue rogue, Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * 0.8f;
        float dmgIgnite = calculateDmg(ignite, terrain) * 0.8f;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain) * 0.8f;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        rogue.dmg = totalDmg;
        rogue.overtimeDmgTimer = 2;
        rogue.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public void attack(Wizard wizard, Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * 1.05f;
        float dmgIgnite = calculateDmg(ignite, terrain) * 1.05f;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain) * 1.05f;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        wizard.dmg = totalDmg;
        wizard.overtimeDmgTimer = 2;
        wizard.overtimeDmg = round(dmgIgniteOverTime);
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
