package characters;

import common.Constants;
import map.Map;
import map.Terrain;

import static java.lang.Integer.max;


public abstract class Hero {
   protected char type;
   protected int row;
   protected int column;
   protected int hp;
   protected float maxHP;
   protected int xp;
   protected int level;
   protected boolean movingAbility;
   protected int overtimeDmgTimer;
   protected int overtimeDmg;
   protected int dmg;
   protected Map map = Map.getInstance();

   public Hero(final int row, final int column) {
      this.row = row;
      this.column = column;
      map.putPlayerOnMap(row, column, this);
      hp = 0;
      maxHP = 0f;
      type = '-';
      xp = 0;
      level = 0;
      movingAbility = true;
      overtimeDmgTimer = 0;
      overtimeDmg = 0;
      dmg = 0;
   }
   public final String toString() {
      if (hp == -1) {
         return type + " dead";
      } else {
         return type + " " + level + " " + xp + " " + hp + " " + row + " " + column;
      }
   }

   public final Map getMap() {
      return map;
   }
   public final int getLevel() {
      return level;
   }
   public final int getHp() {
      return hp;
   }
   public final boolean isAlive() {
       if (hp != -1) {
          return true;
       }
       return false;
   }

   public final boolean isMovingAbility() {
      return movingAbility;
   }

   public final char getType() {
      return type;
   }

   /*
      În variabila overtimeDmgTimer rețin câte runde va mai fi afectat.
      În variabila overtimeDmg rețin dmg-ul overtime pe care îl primește.
      movingAbility reține dacă jucătorul este incapacitat la momentul curent
      La începutul fiecărei runde este apelată metoda sufferOvertimeDmg în care
   hp-ul este afectat de dmg si timerul este decrementat. Dacă perioada de
   overtime dmg s-a terminat, movingAbility devine true deci jucătorul se va
   putea mișca la următoarea rundă.
    */
   public final void sufferOvertimeDmg() {
      if (overtimeDmgTimer > 0) {
         hp -= overtimeDmg;
         overtimeDmgTimer--;
         if (overtimeDmgTimer == 0) {
            movingAbility = true;
         }
      }
      die();
   }

   public final void sufferDmg() {
      hp -= dmg;
      die();
   }

   /*
      Dacă hp-ul jucătorului a devenit 0 sau negativ, îl setez la -1
   pentru a ști că este mort și îl scot de pe hartă.
      Această metodă este apelată de fiecare dată când un jucator
   este afectat de dmg instantaneu sau overtime.
    */
   public final void die() {
      if (hp <= 0 || dmg == -1) {
         hp = -1;
         map.removePlayerFromMap(row, column, this);
      }
   }

   public final void move(final char direction) {
         map.removePlayerFromMap(row, column, this);
         switch (direction) {
            case 'U': row--; break;
            case 'D': row++; break;
            case 'L': column--; break;
            case 'R': column++; break;
            default : break;
         }
         map.putPlayerOnMap(row, column, this);
   }

   public final void growXP(final Hero player) {
      xp += max(0, Constants.KILL_XP - (level - player.getLevel()) * Constants.KILL_XP_MODIFIER);
      levelUp();
   }

   public abstract void levelUp();

   /*
      Metoda primește dmg-ul de bază al abilității și îi aplică modificatorul de teren
    */
   public abstract float calculateDmg(float baseDmg, Terrain terrain);

   public abstract void isAttackedBy(Hero player, Terrain terrain);
   public abstract void attack(Knight knight, Terrain terrain);
   public abstract void attack(Pyromancer pyromancer, Terrain terrain);
   public abstract void attack(Rogue rogue, Terrain terrain);
   public abstract void attack(Wizard wizard, Terrain terrain);

}
