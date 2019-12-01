package characters;

import map.Map;
import map.Terrain;

import java.util.List;

import static java.lang.Integer.max;


public abstract class Hero {
   /* public abstract void isSalutedBy(Person person);
    public abstract void salute(Doctor doctor);
    public abstract void salute(Engineer engineer);
    public abstract void salute(Lawyer lawyer); */
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
   Map map = Map.getInstance();

   public Hero(int row, int column) {
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
   public String toString() {
      if (hp == -1) {
         return type + " dead";
      } else {
         return type + " " + level + " " + xp + " " + hp + " " + row + " " + column;
      }
   }

   public int getDmg() {
      return dmg;
   }

   public int getLevel() {
      return level;
   }

   public int getXp() {
      return xp;
   }

   public void setXp(int xp) {
      this.xp = xp;
   }

   public int getHp() {
      return hp;
   }

   public int getRow() {
      return row;
   }
   public int getColumn() {
      return column;
   }
   public boolean isAlive() {
       if (hp != -1)
           return true;
       return false;
   }

   public boolean isMovingAbility() {
      return movingAbility;
   }

   public char getType() {
      return type;
   }

   public void sufferOvertimeDmg() {
      if (overtimeDmgTimer > 0) {
         hp -= overtimeDmg;
         overtimeDmgTimer--;
         if (overtimeDmgTimer == 0) {
            movingAbility = true;
         }
      }
      die();
   }

   public void sufferDmg() {
      hp -= dmg;
      die();
   }

   public void die() {
      if ( hp <= 0 || dmg == -1) {
         hp = -1;
         map.removePlayerFromMap(row, column, this);
      }
   }

   public void move(char direction) {
      //if(movingAbility == true) {
         map.removePlayerFromMap(row, column, this);
         switch (direction) {
            case 'U': row--; break;
            case 'D': row++; break;
            case 'L': column--; break;
            case 'R': column++; break;
            default : break;
         }
         map.putPlayerOnMap(row, column, this);
     // }
   }

   public void growXP(Hero player) {
      xp += max(0, 200 - (level - player.getLevel()) * 40);
      levelUp();
   }

   public abstract void levelUp();

   public abstract void isAttackedBy(Hero player, Terrain terrain);
   public abstract void attack(Knight knight, Terrain terrain);
   public abstract void attack(Pyromancer pyromancer, Terrain terrain);
   public abstract void attack(Rogue rogue, Terrain terrain);
   public abstract void attack(Wizard wizard, Terrain terrain);

}