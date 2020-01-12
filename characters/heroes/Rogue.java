package characters.heroes;

import characters.angels.Angel;
import common.Constants;
import map.Terrain;

import static java.lang.Math.round;

public class Rogue extends Hero {

    private float backstab;
    private float paralysis;
    private int backstabCounter;

    public Rogue(final int row, final int column, final int index) {
        super(row, column, index);
        hp = Constants.ROGUE_HP;
        maxHP = Constants.ROGUE_HP;
        type = 'R';
        backstab = Constants.BACKSTAB;
        backstabCounter = 0;
        paralysis = Constants.PARALYSIS;
    }

    public final float calculateDmg(final float baseDmg, final Terrain terrain) {
        if (terrain.getType() == 'W') {
            return (baseDmg * Constants.WOODS_MODIFIER);
        }
        return baseDmg;
    }

    public final float getBackstab() {
        return backstab;
    }

    public final float getParalysis() {
        return paralysis;
    }

    public final int getBackstabCounter() {
        return backstabCounter;
    }

    @Override
    public final String toStringName() {
        return "Rogue " + index;
    }

    @Override
    public final void isAttackedBy(final Hero player, final Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public final void isAffectedBy(final Angel angel) {
        angel.affect(this);
    }

    @Override
    public final void attack(final Knight knight, final Terrain terrain) {
        float dmgBackstab = calculateDmg(backstab, terrain)
                * (Constants.BACKSTAB_K_MODIFIER + angelInfluence);
        backstabCounter++;
        if (backstabCounter % Constants.BACKSTAB_COUNTER == 1 && terrain.getType() == 'W') {
            dmgBackstab *= Constants.CRITICAL_HIT;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain) - Constants.ERROR;
        dmgParalysis *= (Constants.PARALYSIS_K_MODIFIER + angelInfluence);
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        knight.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            knight.overtimeDmgTimer = Constants.OVERTIME_DMG_W;
        } else {
            knight.overtimeDmgTimer = Constants.OVERTIME_DMG;
        }
        knight.overtimeDmg = round(dmgParalysis);
        knight.movingAbility = false;
    }

    @Override
    public final void attack(final Pyromancer pyromancer, final Terrain terrain) {
        float dmgBackstab = calculateDmg(backstab, terrain)
                * (Constants.BACKSTAB_P_MODIFIER + angelInfluence);
        backstabCounter++;
        if (backstabCounter % Constants.BACKSTAB_COUNTER == 1 && terrain.getType() == 'W') {
            dmgBackstab *= Constants.CRITICAL_HIT;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain)
                * (Constants.PARALYSIS_P_MODIFIER + angelInfluence);
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        //System.out.println(totalDmg);
        pyromancer.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            pyromancer.overtimeDmgTimer = Constants.OVERTIME_DMG_W;
        } else {
            pyromancer.overtimeDmgTimer = Constants.OVERTIME_DMG;
        }
        pyromancer.overtimeDmg = round(dmgParalysis);
        pyromancer.movingAbility = false;
    }

    @Override
    public final void attack(final Rogue rogue, final Terrain terrain) {
        float dmgBackstab = calculateDmg(backstab, terrain)
                * (Constants.BACKSTAB_R_MODIFIER + angelInfluence);
        backstabCounter++;
        if (backstabCounter % Constants.BACKSTAB_COUNTER == 1 && terrain.getType() == 'W') {
            dmgBackstab *= Constants.CRITICAL_HIT;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain)
                * (Constants.PARALYSIS_R_MODIFIER + angelInfluence) - Constants.ERROR;
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        rogue.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            rogue.overtimeDmgTimer = Constants.OVERTIME_DMG_W;
        } else {
            rogue.overtimeDmgTimer = Constants.OVERTIME_DMG;
        }
        rogue.overtimeDmg = round(dmgParalysis);
        rogue.movingAbility = false;
    }

    @Override
    public final void attack(final Wizard wizard, final Terrain terrain) {
        float dmgBackstab = calculateDmg(backstab, terrain)
                * (Constants.BACKSTAB_W_MODIFIER + angelInfluence);
        backstabCounter++;
        if (backstabCounter % Constants.BACKSTAB_COUNTER == 1 && terrain.getType() == 'W') {
            dmgBackstab *= Constants.CRITICAL_HIT;
        }
        float dmgParalysis = calculateDmg(paralysis, terrain)
                * (Constants.PARALYSIS_W_MODIFIER + angelInfluence);
        int totalDmg = round(dmgBackstab) + round(dmgParalysis);
        wizard.dmg = totalDmg;
        if (terrain.getType() == 'W') {
            wizard.overtimeDmgTimer = Constants.OVERTIME_DMG_W;
        } else {
            wizard.overtimeDmgTimer = Constants.OVERTIME_DMG;
        }
        wizard.overtimeDmg = round(dmgParalysis);
        wizard.movingAbility = false;
    }
    /*
    Verific daca hp este egal cu -1 adica, daca jucatorul este mort
    pentru cazul in care 2 jucatori se omoara reciproc si avanseaza
    in nivel, fara sa reinvie
     */
    @Override
    public final void levelUp() {
        if (hp != -1) {
            if (xp >= Constants.LEVEL_UP_LIMIT + level * Constants.LEVEL_UP) {
                level++;
                hp = Constants.ROGUE_HP + Constants.R_HP_LEVEL * level;
                maxHP = Constants.ROGUE_HP + Constants.R_HP_LEVEL * level;
                backstab = Constants.BACKSTAB + Constants.BACKSTAB_LEVEL * level;
                paralysis = Constants.PARALYSIS + Constants.PARALYSIS_LEVEL * level;
                levelUp();
            }
        } else {
            if (xp >= Constants.LEVEL_UP_LIMIT + level * Constants.LEVEL_UP) {
                level++;
                maxHP = Constants.ROGUE_HP + Constants.R_HP_LEVEL * level;
                backstab = Constants.BACKSTAB + Constants.BACKSTAB_LEVEL * level;
                paralysis = Constants.PARALYSIS + Constants.PARALYSIS_LEVEL * level;
                levelUp();
            }
        }
    }

    @Override
    public final void levelUpByAngel() {
        level++;
        xp = Constants.XP + level * Constants.LEVEL_UP;
        hp = Constants.ROGUE_HP + Constants.R_HP_LEVEL * level;
        maxHP = Constants.ROGUE_HP + Constants.R_HP_LEVEL * level;
        backstab = Constants.BACKSTAB + Constants.BACKSTAB_LEVEL * level;
        paralysis = Constants.PARALYSIS + Constants.PARALYSIS_LEVEL * level;
    }
}
