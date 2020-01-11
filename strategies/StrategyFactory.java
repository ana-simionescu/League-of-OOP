package strategies;

import characters.heroes.Hero;
import common.Constants;

public final class StrategyFactory {

        private static StrategyFactory instance;

        public static StrategyFactory getInstance() {
            if (instance == null) {
                instance = new StrategyFactory();
            }
            return instance;
        }

        public Strategy getStrategy(final Hero player) {
            if (player.getType() == 'K') {
               if (player.getMaxHP() / Constants.K_LIMIT_DOWN < player.getHp()
                       && player.getHp() < player.getMaxHP() / Constants.K_LIMIT_UP
                                            && player.isMovingAbility()) {
                   return new KnightOffensive(player);
               }
                if (player.getMaxHP() / Constants.K_LIMIT_DOWN > player.getHp()
                        && player.isMovingAbility()) {
                    return new KnightDefensive(player);
                }
                return new Basic(player);
            }

            if (player.getType() == 'P') {
                if (player.getMaxHP() / Constants.P_LIMIT_DOWN < player.getHp()
                        && player.getHp() < player.getMaxHP() / Constants.P_LIMIT_UP
                        && player.isMovingAbility()) {
                    return new PyromancerOffensive(player);
                }
                if (player.getMaxHP() / Constants.P_LIMIT_DOWN > player.getHp()
                        && player.isMovingAbility()) {
                    return new PyromancerDefensive(player);
                }
                return new Basic(player);
            }

            if (player.getType() == 'R') {
                if (player.getMaxHP() / Constants.R_LIMIT_DOWN < player.getHp()
                        && player.getHp() < player.getMaxHP() / Constants.R_LIMIT_UP
                        && player.isMovingAbility()) {
                    return new RogueOffensive(player);
                }
                if (player.getMaxHP() / Constants.R_LIMIT_DOWN > player.getHp()
                        && player.isMovingAbility()) {
                    return new RogueDefensive(player);
                }
                return new Basic(player);
            }

            if (player.getType() == 'W') {
                if (player.getMaxHP() / Constants.W_LIMIT_DOWN < player.getHp()
                        && player.getHp() < player.getMaxHP() / Constants.W_LIMIT_UP
                        && player.isMovingAbility()) {
                    return new WizardOffensive(player);
                }
                if (player.getMaxHP() / Constants.W_LIMIT_DOWN > player.getHp()
                        && player.isMovingAbility()) {
                    return new WizardDefensive(player);
                }
                return new Basic(player);
            }
            return null;
        }

}
