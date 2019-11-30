package characters;

import common.Constants;
import map.Terrain;

import static java.lang.Math.round;

public class Rogue extends Hero {

    float backstab;
    float paralysis;
    int backstabCounter = 0;

    public Rogue(int row, int column) {
        super(row, column);
        hp = Constants.ROGUE_HP;
        maxHP = Constants.ROGUE_HP;
        type = 'R';
        backstab = 200;
        backstabCounter = 1;
        paralysis = 40;
    }

    public float calculateDmg (float baseDmg, Terrain terrain) {
        if (terrain.getType() == 'W') {
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
        float dmgBackstab = calculateDmg(backstab, terrain) * 0.9f;
        backstabCounter ++;
        if(backstabCounter % 3 == 1 && terrain.getType() == 'W') {
            dmgBackstab *= 1.5;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain) * 0.8f;
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        knight.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            knight.overtimeDmgTimer = 6;
        } else {
            knight.overtimeDmgTimer = 3;
        }
        knight.overtimeDmg = round(dmgBackstab);
        knight.movingAbility = false;
    }

    @Override
    public void attack(Pyromancer pyromancer, Terrain terrain) {
        float dmgBackstab = calculateDmg(backstab, terrain) * 1.25f;
        backstabCounter ++;
        if(backstabCounter % 3 == 1 && terrain.getType() == 'W') {
            dmgBackstab *= 1.5;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain) * 1.2f;
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        pyromancer.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            pyromancer.overtimeDmgTimer = 6;
        } else {
            pyromancer.overtimeDmgTimer = 3;
        }
        pyromancer.overtimeDmg = round(dmgBackstab);
        pyromancer.movingAbility = false;
    }

    @Override
    public void attack(Rogue rogue, Terrain terrain) {
        float dmgBackstab = calculateDmg(backstab, terrain) * 1.2f;
        backstabCounter ++;
        if(backstabCounter % 3 == 1 && terrain.getType() == 'W') {
            dmgBackstab *= 1.5;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain) * 0.9f;
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        rogue.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            rogue.overtimeDmgTimer = 6;
        } else {
            rogue.overtimeDmgTimer = 3;
        }
        rogue.overtimeDmg = round(dmgBackstab);
        rogue.movingAbility = false;
    }

    @Override
    public void attack(Wizard wizard, Terrain terrain) {
        float dmgBackstab = calculateDmg(backstab, terrain) * 1.25f;
        backstabCounter ++;
        if(backstabCounter % 3 == 1 && terrain.getType() == 'W') {
            dmgBackstab *= 1.5;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain) * 1.25f;
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        wizard.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            wizard.overtimeDmgTimer = 6;
        } else {
            wizard.overtimeDmgTimer = 3;
        }
        wizard.overtimeDmg = round(dmgBackstab);
        wizard.movingAbility = false;
    }
    @Override
    public void levelUp() {
        super.levelUp();
        hp = Constants.ROGUE_HP + 40 * level;
        maxHP = Constants.ROGUE_HP + 40 * level;
        backstab = 200 + 20 * level;
        paralysis = 40 + 10 * level;
    }
}
