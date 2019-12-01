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
        fireblast = 350f;
        ignite = 150f;
        igniteOverTime = 50f;
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
        knight.movingAbility = true;
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
        pyromancer.movingAbility = true;
        pyromancer.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public void attack(Rogue rogue, Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * 0.8f;
        float dmgIgnite = calculateDmg(ignite, terrain) * 0.8f;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain) * 0.8f;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        //System.out.println(totalDmg);
        rogue.dmg = totalDmg;
        rogue.overtimeDmgTimer = 2;
        rogue.movingAbility = true;
        rogue.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public void attack(Wizard wizard, Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * 1.05f;
        float dmgIgnite = calculateDmg(ignite, terrain) * 1.05f;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain) * 1.05f;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        wizard.dmg = totalDmg;
        wizard.movingAbility = true;
        wizard.overtimeDmgTimer = 2;
        wizard.overtimeDmg = round(dmgIgniteOverTime);
    }
    @Override
    public void levelUp() {
        if (xp >= 250 + level * 50) {
            level ++;
            hp = Constants.PYROMANCER_HP + 50 * level;
            maxHP = Constants.PYROMANCER_HP + 50 * level;
            fireblast = 350 + level * 50;
            ignite = 150 + level * 20;
            igniteOverTime = 50 + level * 30;
            levelUp();
        }
    }
}
