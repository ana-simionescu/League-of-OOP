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
        drain = 20;
        deflect = 35;
    }

    public float calculateDmg (float baseDmg, Terrain terrain) {
        if (terrain.getType() == 'D') {
            return baseDmg * 1.1f;
        }
        return baseDmg;
    }

    @Override
    public void isAttackedBy(Hero player, Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public void attack(Knight knight, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain) * 1.2f;
        dmgDrain = dmgDrain / 100f * Math.min(0.3f * knight.maxHP, knight.hp);
        float dmgDeflect = calculateDmg(deflect, terrain) * 1.4f;

        float victimHpLimit = knight.executeHPLimit / 100f * maxHP;
        float dmgAdv;
        if (hp < victimHpLimit) {
            dmgAdv = hp;
        } else {
            float dmgExecute = calculateDmg(knight.execute, terrain);
            float dmgSlam = calculateDmg(knight.slam, terrain);
            dmgAdv = (float) (round(dmgExecute) + round(dmgSlam));
        }
        dmgDeflect = dmgDeflect / 100f * dmgAdv;

        int totalDmg = round(dmgDrain) + round(dmgDeflect);
        knight.dmg = totalDmg;
    }

    @Override
    public void attack(Pyromancer pyromancer, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain) * 0.9f;
        dmgDrain = dmgDrain / 100f * Math.min(0.3f * pyromancer.maxHP, pyromancer.hp);
        float dmgDeflect = calculateDmg(deflect, terrain) * 1.3f;

        float dmgFireblast = calculateDmg(pyromancer.fireblast, terrain);
        float dmgIgnite = calculateDmg(pyromancer.ignite, terrain);
        float totalDmgAdv = round(dmgFireblast) + round(dmgIgnite);

        dmgDeflect = dmgDeflect / 100f * totalDmgAdv;

        int totalDmg = round(dmgDrain) + round(dmgDeflect);
        pyromancer.dmg = totalDmg;
    }

    public float min(float a, float b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    @Override
    public void attack(Rogue rogue, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain) * 0.8f;
        dmgDrain = dmgDrain / 100f * min(0.3f * rogue.maxHP, rogue.hp);
        float dmgDeflect = calculateDmg(deflect, terrain) * 1.2f;

        float dmgBackstab = rogue.calculateDmg(rogue.backstab, terrain);
        if((rogue.backstabCounter + 1) % 3 == 1 && terrain.getType() == 'W') {
            dmgBackstab *= 1.5;
        }
        float dmgParalysis = rogue.calculateDmg(rogue.paralysis, terrain);
        float dmgAdv = (float) (round(dmgBackstab) + round(dmgParalysis));


        dmgDeflect = dmgDeflect / 100f * dmgAdv;
        int totalDmg = round(dmgDrain) + round(dmgDeflect);
        rogue.dmg = totalDmg;
    }

    @Override
    public void attack(Wizard wizard, Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain) * 1.05f;
        dmgDrain = dmgDrain / 100f * Math.min(0.3f * wizard.maxHP, wizard.hp);
        wizard.dmg = round(dmgDrain);
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
