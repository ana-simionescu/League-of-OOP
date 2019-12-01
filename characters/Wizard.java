package characters;

import common.Constants;
import map.Terrain;

import static java.lang.Integer.min;
import static java.lang.Math.round;

public class Wizard extends Hero {

    float drain;
    float deflect;

    public Wizard(int row, int column) {
        super(row, column);
        hp = Constants.WIZARD_HP;
        maxHP = Constants.WIZARD_HP;
        type = 'W';
        drain = 20f;
        deflect = 35f;
    }

    public float calculateDmg (float baseDmg, Terrain terrain) {
        if (terrain.getType() == 'D') {
            return baseDmg * 1.1f;
        }
        return baseDmg;
    }

    public float min(float a, float b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    @Override
    public void isAttackedBy(Hero player, Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public void attack(Knight knight, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain);
        dmgDrain = dmgDrain / 100f;
        dmgDrain *= 1.2f;
        dmgDrain *= min(0.3f * knight.maxHP, knight.hp);
        float dmgDeflect = calculateDmg(deflect, terrain);
        dmgDeflect /= 100f;
        dmgDeflect *= 1.4f;
        float victimHpLimit = knight.executeHPLimit / 100f * maxHP;
        float dmgAdv;
        if (hp < victimHpLimit) {
            dmgAdv = hp;
        } else {
            float dmgExecute = knight.calculateDmg(knight.execute, terrain);
            float dmgSlam = knight.calculateDmg(knight.slam, terrain);
           // System.out.println(dmgExecute);
           // System.out.println(dmgSlam);
            dmgAdv = (float) (round(dmgExecute) + round(dmgSlam));
        }
        dmgDeflect *= dmgAdv;

        int totalDmg = round(dmgDrain) + round(dmgDeflect);
        knight.dmg = totalDmg;
    }

    @Override
    public void attack(Pyromancer pyromancer, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain);
        dmgDrain = dmgDrain / 100f;
        dmgDrain *= 0.9f;
        dmgDrain *= min(0.3f * pyromancer.maxHP, pyromancer.hp);
        float dmgDeflect = calculateDmg(deflect, terrain);
        dmgDeflect /= 100f;
        dmgDeflect *= 1.3f;

        float dmgFireblast = pyromancer.calculateDmg(pyromancer.fireblast, terrain);
        float dmgIgnite = pyromancer.calculateDmg(pyromancer.ignite, terrain);
        float totalDmgAdv =(float)(round(dmgFireblast) + round(dmgIgnite));

        dmgDeflect = dmgDeflect * totalDmgAdv;

        int totalDmg = round(dmgDrain) + round(dmgDeflect);

        pyromancer.dmg = totalDmg;
    }


    @Override
    public void attack(Rogue rogue, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain);
        dmgDrain /= 100f;
        dmgDrain *= 0.8f;
        dmgDrain *= min(0.3f * rogue.maxHP, rogue.hp);
        float dmgDeflect = calculateDmg(deflect, terrain);
        dmgDeflect /= 100f;
        dmgDeflect *= 1.2f;

        float dmgBackstab = rogue.calculateDmg(rogue.backstab, terrain);
        if(rogue.backstabCounter % 3 == 1 && terrain.getType() == 'W') {
            dmgBackstab *= 1.5;
        }
        float dmgParalysis = rogue.calculateDmg(rogue.paralysis, terrain);
        float dmgAdv = (float) (round(dmgBackstab) + round(dmgParalysis));


        dmgDeflect *= dmgAdv;
        int totalDmg = round(dmgDrain) + round(dmgDeflect);
        //System.out.println(totalDmg);
        rogue.dmg = totalDmg;
    }

    @Override
    public void attack(Wizard wizard, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain) ;
        dmgDrain /= 100f;
        dmgDrain *= 1.05f;
        dmgDrain *= min(0.3f * wizard.maxHP, wizard.hp);
        wizard.dmg = round(dmgDrain);
    }
    @Override
    public void levelUp() {
        if (xp >= 250 + level * 50) {
            level ++;
            hp = Constants.WIZARD_HP + 30 * level;
            maxHP = Constants.WIZARD_HP + 30 * level;
            drain = 20 + level * 5;
            deflect = min(35 + 2 * level, 70);
            levelUp();
        }
    }
}
