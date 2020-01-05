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
                   return new KnightOffensive(player);
               }
                if(player.getMaxHP() / 3 > player.getHp() && player.isMovingAbility()) {
                    return new KnightDefensive(player);
                }
                return new Basic(player);
            }

            if (player.getType() == 'P') {
                if(player.getMaxHP() / 4 < player.getHp() && player.getHp() < player.getMaxHP() / 3
                        && player.isMovingAbility()) {
                    return new PyromancerOffensive(player);
                }
                if(player.getMaxHP() / 4 > player.getHp() && player.isMovingAbility()) {
                    return new PyromancerDefensive(player);
                }
                return new Basic(player);
            }

            if (player.getType() == 'R') {
                if(player.getMaxHP() / 7 < player.getHp() && player.getHp() < player.getMaxHP() / 5
                        && player.isMovingAbility()) {
                    return new RogueOffensive(player);
                }
                if(player.getMaxHP() / 7 > player.getHp() && player.isMovingAbility()) {
                    return new RogueDefensive(player);
                }
                return new Basic(player);
            }

            if (player.getType() == 'W') {
                if(player.getMaxHP() / 4 < player.getHp() && player.getHp() < player.getMaxHP() / 2
                        && player.isMovingAbility()) {
                    return new WizardOffensive(player);
                }
                if(player.getMaxHP() / 4 > player.getHp() && player.isMovingAbility()) {
                    return new WizardDefensive(player);
                }
                return new Basic(player);
            }
            return null;
        }

}