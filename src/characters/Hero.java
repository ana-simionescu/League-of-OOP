package characters;

import map.Map;

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
   protected int maxHP;
   protected int xp;
   protected int level;
   protected boolean movingAbility;
   protected int overtimeDmgTimer;
   protected int overtimeDmg;
   Map map = Map.getInstance();

   public Hero(int row, int column) {
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
   }
   public String toString() {
      return type + " " + level + " " + xp + " " + hp + " " + row + " " + column;
   }

   public int getLevel() {
      return level;
   }

   public void move(char direction) {
      if(movingAbility == true) {
         map.removePlayerFromMap(row, column, this);
         switch (direction) {
            case 'U': row--;
            case 'D': row++;
            case 'L': column--;
            case 'R': column++;
            default : ;
         }
         map.putPlayerOnMap(row, column, this);
      }
   }

   public void growXP(Hero player) {
      xp += max(0, 200 - (level - player.getLevel()) * 40);
      levelUp();
   }

   public void levelUp() {
      if (xp >= 250 + level * 50) {
         level++;
         levelUp();
      }
   }

   public abstract void isAttackedBy(Hero player);
   public abstract void attack(Knight knight);
   public abstract void attack(Pyromancer pyromancer);
   public abstract void attack(Rogue rogue);
   public abstract void attack(Wizard wizard);

}