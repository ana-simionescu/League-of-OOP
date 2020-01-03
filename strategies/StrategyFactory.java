package strategies;

import characters.heroes.Hero;
import characters.heroes.Knight;

public class StrategyFactory {

        private static StrategyFactory instance;

        public static StrategyFactory getInstance() {
            if (instance == null) {
                instance = new StrategyFactory();
            }
            return instance;
        }

        public Strategy getStrategy(final Hero player) {
            if (player.getType() == 'K') {
               if(player.getMaxHP() / 3 < player.getHp() && player.getHp() < player.getMaxHP() / 2
                                            && player.isMovingAbility()) {
                   return new KnightOffensive(Hero player);
               }
                if(player.getMaxHP() / 3 > player.getHp() && player.isMovingAbility()) {
                    return new KnightDefensive(Hero player);
                }
                return new Basic(Hero player);
            }

            if (player.getType() == 'P') {
                if(player.getMaxHP() / 4 < player.getHp() && player.getHp() < player.getMaxHP() / 3
                        && player.isMovingAbility()) {
                    return new PyromancerOffensive(Hero player);
                }
                if(player.getMaxHP() / 4 > player.getHp() && player.isMovingAbility()) {
                    return new PyromancerDefensive(Hero player);
                }
                return new Basic(Hero player);
            }

            if (player.getType() == 'R') {
                if(player.getMaxHP() / 7 < player.getHp() && player.getHp() < player.getMaxHP() / 5
                        && player.isMovingAbility()) {
                    return new RogueOffensive(Hero player);
                }
                if(player.getMaxHP() / 7 > player.getHp() && player.isMovingAbility()) {
                    return new RogueDefensive(Hero player);
                }
                return new Basic(Hero player);
            }

            if (player.getType() == 'W') {
                if(player.getMaxHP() / 4 < player.getHp() && player.getHp() < player.getMaxHP() / 2
                        && player.isMovingAbility()) {
                    return new WizardOffensive(Hero player);
                }
                if(player.getMaxHP() / 4 > player.getHp() && player.isMovingAbility()) {
                    return new WizardDefensive(Hero player);
                }
                return new Basic(Hero player);
            }
        }

}