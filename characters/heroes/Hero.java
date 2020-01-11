package characters.heroes;

import characters.angels.Angel;
import common.Constants;
import map.Map;
import map.Terrain;

import static java.lang.Integer.max;


public abstract class Hero {
   protected boolean fought;
   protected int index;
   protected char type;
   protected int row;
   protected int column;
   protected int hp;
   protected int maxHP;
   protected int xp;
   protected int level;
   protected boolean movingAbility;
   protected int overtimeDmgTimer;
   protected int overtimeDmg;
   protected int dmg;
   protected float angelInfluence;
   protected Map map = Map.getInstance();

   public Hero(final int row, final int column, final int index) {
      this.index = index;
      this.row = row;
      this.column = column;
      map.putPlayerOnMap(row, column, this);
      hp = 0;
      maxHP = 0;
      type = '-';
      xp = 0;
      level = 0;
      movingAbility = true;
      overtimeDmgTimer = 0;
      overtimeDmg = 0;
      dmg = 0;
      angelInfluence = 0f;
      fought = false;
   }
   public final String toString() {
      if (hp == -1) {
         return type + " dead";
      } else {
         return type + " " + level + " " + xp + " " + hp + " " + row + " " + column;
      }
   }
   public final boolean isFought() {
      return fought;
   }

   public final void setFought(final boolean fought) {
      this.fought = fought;
   }

   public final int getIndex() {
      return index;
   }

   public final int getRow() {
      return row;
   }

   public final int getColumn() {
      return column;
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

   public final int getMaxHP() {
      return maxHP;
   }

   public final void setHp(final int hp) {
      this.hp = hp;
   }

   public final float getAngelInfluence() {
      return angelInfluence;
   }

   public final void setAngelInfluence(final float angelInfluence) {
      this.angelInfluence = angelInfluence;
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
         //map.removePlayerFromMap(row, column, this);
      }
   }

   public final void move(final char direction) {
      if (row >= 0 && column >= 0) {
         map.removePlayerFromMap(row, column, this);
         switch (direction) {
            case 'U':
               row--;
               break;
            case 'D':
               row++;
               break;
            case 'L':
               column--;
               break;
            case 'R':
               column++;
               break;
            default:
               break;
         }
         if (row >= 0 && column >= 0) {
            map.putPlayerOnMap(row, column, this);
         }
      }
   }

   public final void addXP(final int exp) {
      xp += exp;
      levelUp();
   }

   public final void growXP(final int lev) {
      xp += max(0, Constants.KILL_XP - (this.level - lev) * Constants.KILL_XP_MODIFIER);
      levelUp();
   }

   public abstract void levelUp();
   public abstract void levelUpByAngel();
  // public abstract void levelUpWithoutHp();

   /*
      Metoda primește dmg-ul de bază al abilității și îi aplică modificatorul de teren
    */
   public abstract float calculateDmg(float baseDmg, Terrain terrain);

   public abstract void isAttackedBy(Hero player, Terrain terrain);
   public abstract void attack(Knight knight, Terrain terrain);
   public abstract void attack(Pyromancer pyromancer, Terrain terrain);
   public abstract void attack(Rogue rogue, Terrain terrain);
   public abstract void attack(Wizard wizard, Terrain terrain);

   public abstract void isAffectedBy(Angel angel);
   public abstract String toStringName();

}
