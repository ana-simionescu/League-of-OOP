package characters;

import common.Constants;
import map.Terrain;

import static java.lang.Math.round;

public class Wizard extends Hero {

    private float drain;
    private float deflect;

    public Wizard(final int row, final int column) {
        super(row, column);
        hp = Constants.WIZARD_HP;
        maxHP = Constants.WIZARD_HP;
        type = 'W';
        drain = Constants.DRAIN;
        deflect = Constants.DEFLECT;
    }

    public final float calculateDmg(final float baseDmg, final Terrain terrain) {
        if (terrain.getType() == 'D') {
            return baseDmg * Constants.DESERT_MODIFIER;
        }
        return baseDmg;
    }

    public final float min(final float a, final float b) {
        if (a < b) {
            return a;
        }
        return b;
    }

    @Override
    public final void isAttackedBy(final Hero player, final Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public final void attack(final Knight knight, final Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain);
        dmgDrain = dmgDrain / Constants.PERCENT;
        dmgDrain *= Constants.DRAIN_K_MODIFIER;
        dmgDrain *= min(Constants.WIZ_DRAIN_LEVEL * knight.maxHP, knight.hp);
        float dmgDeflect = calculateDmg(deflect, terrain);
        dmgDeflect /= Constants.PERCENT;
        dmgDeflect *= Constants.DEFLECT_K_MODIFIER;
        float victimHpLimit = knight.getExecuteHPLimit() / Constants.PERCENT * maxHP;
        float dmgAdv;
        if (hp < victimHpLimit) {
            dmgAdv = hp;
        } else {
            float dmgExecute = knight.calculateDmg(knight.getExecute(), terrain);
            float dmgSlam = knight.calculateDmg(knight.getSlam(), terrain);
            dmgAdv = (float) (round(dmgExecute) + round(dmgSlam));
        }
        dmgDeflect *= dmgAdv;

        int totalDmg = round(dmgDrain) + round(dmgDeflect);
        knight.dmg = totalDmg;
    }

    @Override
    public final void attack(final Pyromancer pyromancer, final Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain);
        dmgDrain = dmgDrain / Constants.PERCENT;
        dmgDrain *= Constants.DRAIN_P_MODIFIER;
        dmgDrain *= min(Constants.WIZ_DRAIN_LEVEL * pyromancer.maxHP, pyromancer.hp);
        float dmgDeflect = calculateDmg(deflect, terrain);
        dmgDeflect /= Constants.PERCENT;
        dmgDeflect *= Constants.DEFLECT_P_MODIFIER;

        float dmgFireblast = pyromancer.calculateDmg(pyromancer.getFireblast(), terrain);
        float dmgIgnite = pyromancer.calculateDmg(pyromancer.getIgnite(), terrain);
        float totalDmgAdv = (float) (round(dmgFireblast) + round(dmgIgnite));

        dmgDeflect = dmgDeflect * totalDmgAdv;

        int totalDmg = round(dmgDrain) + round(dmgDeflect);

        pyromancer.dmg = totalDmg;
    }


    @Override
    public final void attack(final Rogue rogue, final Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain);
        dmgDrain /= Constants.PERCENT;
        dmgDrain *= Constants.DRAIN_R_MODIFIER;
        dmgDrain *= min(Constants.WIZ_DRAIN_LEVEL * rogue.maxHP, rogue.hp);
        float dmgDeflect = calculateDmg(deflect, terrain);
        dmgDeflect /= Constants.PERCENT;
        dmgDeflect *= Constants.DEFLECT_R_MODIFIER;

        float dmgBackstab = rogue.calculateDmg(rogue.getBackstab(), terrain);
        if (rogue.getBackstabCounter() % Constants.BACKSTAB_COUNTER == 1
                && terrain.getType() == 'W') {
            dmgBackstab *= Constants.CRITICAL_HIT;
        }
        float dmgParalysis = rogue.calculateDmg(rogue.getParalysis(), terrain);
        float dmgAdv = (float) (round(dmgBackstab) + round(dmgParalysis));


        dmgDeflect *= dmgAdv;
        int totalDmg = round(dmgDrain) + round(dmgDeflect);
        rogue.dmg = totalDmg;
    }

    @Override
    public final void attack(final Wizard wizard, final Terrain terrain) {
        float dmgDrain = calculateDmg(drain, terrain);
        dmgDrain /= Constants.PERCENT;
        dmgDrain *= Constants.DRAIN_W_MODIFIER;
        dmgDrain *= min(Constants.WIZ_DRAIN_LEVEL * wizard.maxHP, wizard.hp);
        wizard.dmg = round(dmgDrain);
    }
    @Override
    public final void levelUp() {
        if (xp >= Constants.LEVEL_UP_LIMIT + level * Constants.LEVEL_UP) {
            level++;
            hp = Constants.WIZARD_HP + Constants.W_HP_LEVEL * level;
            maxHP = Constants.WIZARD_HP + Constants.W_HP_LEVEL * level;
            drain = Constants.DRAIN + level * Constants.DRAIN_LEVEL;
            deflect = min(Constants.DEFLECT + Constants.DEFLECT_LEVEL * level,
                    Constants.DEFLECT_LIMIT);
            levelUp();
        }
    }
}
