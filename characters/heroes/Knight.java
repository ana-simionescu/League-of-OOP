package characters.heroes;

import characters.angels.Angel;
import common.Constants;
import map.Terrain;

import static java.lang.Integer.min;
import static java.lang.Math.round;

public class Knight extends Hero {

    private float execute;
    private float executeHPLimit;
    private float slam;

    public Knight(final int row, final int column, final int index) {
        super(row, column, index);
        hp = Constants.KNIGHT_HP;
        maxHP = Constants.KNIGHT_HP;
        type = 'K';
        execute = Constants.EXECUTE;
        executeHPLimit = Constants.EXECUTE_HP_START;
        slam = Constants.SLAM;
    }

    public final float calculateDmg(final float baseDmg, final Terrain terrain) {
        if (terrain.getType() == 'L') {
            return (baseDmg * Constants.LAND_MODIFIER);
        }
        return baseDmg;
    }

    public final float getSlam() {
        return slam;
    }

    public final float getExecuteHPLimit() {
        return executeHPLimit;
    }

    public final float getExecute() {
        return execute;
    }

    @Override
    public final void isAttackedBy(final Hero player, final Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public final void isAffectedBy(final Angel angel) {
        //System.out.println("*");
        angel.affect(this); }

    @Override
    public final String toStringName() {
        return "Knight " + index;
    }

    @Override
    public final void attack(final Knight knight, final Terrain terrain) {
        float victimHpLimit = executeHPLimit / Constants.PERCENT * knight.maxHP;
        if (knight.hp < victimHpLimit) {
            knight.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain);
            float dmgSlam = calculateDmg(slam, terrain)
                    * (Constants.SLAM_K_MODIFIER + angelInfluence);
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            knight.dmg = totalDmg;
            knight.overtimeDmgTimer = 1;
            knight.overtimeDmg = 0;
            knight.movingAbility = false;
        }
    }

    @Override
    public final void attack(final Pyromancer pyromancer, final Terrain terrain) {
        float victimHpLimit = executeHPLimit / Constants.PERCENT * pyromancer.maxHP;
        if (pyromancer.hp < victimHpLimit) {
            pyromancer.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain)
                    * (Constants.EXECUTE_P_MODIFIER + angelInfluence);
            float dmgSlam = calculateDmg(slam, terrain)
                    * (Constants.SLAM_P_MODIFIER + angelInfluence);
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            pyromancer.dmg = totalDmg;
            pyromancer.overtimeDmgTimer = 1;
            pyromancer.overtimeDmg = 0;
            pyromancer.movingAbility = false;
        }
    }

    @Override
    public final void attack(final Rogue rogue, final Terrain terrain) {
        float victimHpLimit = executeHPLimit / Constants.PERCENT * rogue.maxHP;
        if (rogue.hp < victimHpLimit) {
            rogue.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain)
                    * (Constants.EXECUTE_R_MODIFIER + angelInfluence);
            float dmgSlam = calculateDmg(slam, terrain)
                    * (Constants.SLAM_R_MODIFIER + angelInfluence);
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            rogue.dmg = totalDmg;
            rogue.overtimeDmgTimer = 1;
            rogue.overtimeDmg = 0;
            rogue.movingAbility = false;
        }
    }

    @Override
    public final void attack(final Wizard wizard, final Terrain terrain) {
        float victimHpLimit = executeHPLimit / Constants.PERCENT * wizard.maxHP;
        if (wizard.hp < victimHpLimit) {
            wizard.dmg = -1;
        } else {
            float dmgExecute = calculateDmg(execute, terrain)
                    * (Constants.EXECUTE_W_MODIFIER + angelInfluence);
            float dmgSlam = calculateDmg(slam, terrain)
                    * (Constants.SLAM_W_MODIFIER + angelInfluence);
            int totalDmg = round(dmgExecute) + round(dmgSlam);
            wizard.dmg = totalDmg;
            wizard.overtimeDmgTimer = 1;
            wizard.overtimeDmg = 0;
            wizard.movingAbility = false;
        }
    }

    @Override
    public final void levelUp() {
        if (hp != -1) {
            if (xp >= Constants.LEVEL_UP_LIMIT + level * Constants.LEVEL_UP) {
                level++;
                hp = Constants.KNIGHT_HP + Constants.K_HP_LEVEL * level;
                maxHP = Constants.KNIGHT_HP + Constants.K_HP_LEVEL * level;
                execute = Constants.EXECUTE + level * Constants.K_EXECUTE_LEVEL;
                executeHPLimit = min(Constants.EXECUTE_HP_LIMIT,
                        Constants.EXECUTE_HP_LIMIT + level);
                slam = Constants.SLAM + Constants.SLAM_LEVEL * level;
                levelUp();
            }
        } else {
            if (xp >= Constants.LEVEL_UP_LIMIT + level * Constants.LEVEL_UP) {
                level++;
                maxHP = Constants.KNIGHT_HP + Constants.K_HP_LEVEL * level;
                execute = Constants.EXECUTE + level * Constants.K_EXECUTE_LEVEL;
                executeHPLimit = min(Constants.EXECUTE_HP_LIMIT,
                        Constants.EXECUTE_HP_LIMIT + level);
                slam = Constants.SLAM + Constants.SLAM_LEVEL * level;
                levelUp();
            }
        }
    }

    @Override
    public final void levelUpByAngel() {
        level++;
        xp = Constants.XP + level * Constants.LEVEL_UP;
        hp = Constants.KNIGHT_HP + Constants.K_HP_LEVEL * level;
        maxHP = Constants.KNIGHT_HP + Constants.K_HP_LEVEL * level;
        execute = Constants.EXECUTE + level * Constants.K_EXECUTE_LEVEL;
        executeHPLimit = min(Constants.EXECUTE_HP_LIMIT, Constants.EXECUTE_HP_LIMIT + level);
        slam = Constants.SLAM + Constants.SLAM_LEVEL * level;
    }



}
