package characters;

import common.Constants;
import map.Terrain;

import static java.lang.Math.round;

public class Pyromancer extends Hero {

    private float fireblast;
    private float ignite;
    private float igniteOverTime;

    public Pyromancer(final int row, final int column) {
        super(row, column);
        hp = Constants.PYROMANCER_HP;
        maxHP = Constants.PYROMANCER_HP;
        type = 'P';
        fireblast = Constants.FIREBLAST;
        ignite = Constants.IGNITE;
        igniteOverTime = Constants.IGNITE_OVERTIME;
    }

    public final float calculateDmg(final float baseDmg, final Terrain terrain) {
        if (terrain.getType() == 'V') {
            return baseDmg * Constants.VOLCANIC_MODIFIER;
        }
        return baseDmg;
    }

    public final float getFireblast() {
        return fireblast;
    }

    public final float getIgnite() {
        return ignite;
    }

    @Override
    public final void isAttackedBy(final Hero player, final Terrain terrain) {
        player.attack(this, terrain);
    }

    @Override
    public final void attack(final Knight knight, final Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * Constants.FIREBLAST_K_MODIFIER;
        float dmgIgnite = calculateDmg(ignite, terrain) * Constants.IGNITE_K_MODIFIER;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain)
                * Constants.IGNITEOVERTIME_K_MODIFIER;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        knight.dmg = totalDmg;
        knight.overtimeDmgTimer = 2;
        knight.movingAbility = true;
        knight.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public final void attack(final Pyromancer pyromancer, final Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * Constants.FIREBLAST_P_MODIFIER;
        float dmgIgnite = calculateDmg(ignite, terrain) * Constants.IGNITE_P_MODIFIER;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain)
                * Constants.IGNITEOVERTIME_P_MODIFIER;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        pyromancer.dmg = totalDmg;
        pyromancer.overtimeDmgTimer = 2;
        pyromancer.movingAbility = true;
        pyromancer.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public final void attack(final Rogue rogue, final Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * Constants.FIREBLAST_R_MODIFIER;
        float dmgIgnite = calculateDmg(ignite, terrain) * Constants.IGNITE_R_MODIFIER;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain)
                * Constants.IGNITEOVERTIME_R_MODIFIER;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        //System.out.println(totalDmg);
        rogue.dmg = totalDmg;
        rogue.overtimeDmgTimer = 2;
        rogue.movingAbility = true;
        rogue.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public final void attack(final Wizard wizard, final Terrain terrain) {
        float dmgFireblast = calculateDmg(fireblast, terrain) * Constants.FIREBLAST_W_MODIFIER;
        float dmgIgnite = calculateDmg(ignite, terrain) * Constants.IGNITE_W_MODIFIER;
        float dmgIgniteOverTime = calculateDmg(igniteOverTime, terrain)
                * Constants.IGNITEOVERTIME_W_MODIFIER;
        int totalDmg = round(dmgFireblast) + round(dmgIgnite);
        wizard.dmg = totalDmg;
        wizard.movingAbility = true;
        wizard.overtimeDmgTimer = 2;
        wizard.overtimeDmg = round(dmgIgniteOverTime);
    }

    @Override
    public final void levelUp() {
        if (xp >= Constants.LEVEL_UP_LIMIT + level * Constants.LEVEL_UP) {
            level++;
            hp = Constants.PYROMANCER_HP + Constants.P_HP_LEVEL * level;
            maxHP = Constants.PYROMANCER_HP + Constants.P_HP_LEVEL * level;
            fireblast = Constants.FIREBLAST + level * Constants.FIREBLAST_LEVEL;
            ignite = Constants.IGNITE + level * Constants.IGNITE_LEVEL;
            igniteOverTime = Constants.IGNITE_OVERTIME + level * Constants.IGNITEOVERTIME_LEVEL;
            levelUp();
        }
    }
}
