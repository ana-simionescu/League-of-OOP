package main;

import characters.GreatWiz;
import characters.angels.Angel;
import characters.angels.AngelFactory;
import characters.heroes.Hero;
import characters.heroes.HeroFactory;
import map.Map;
import strategies.StrategyFactory;

import java.util.ArrayList;
import java.util.List;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        Map map = Map.getInstance(gameInput.getMap());
        HeroFactory heroFactory = HeroFactory.getInstance();
        AngelFactory angelFactory = AngelFactory.getInstance();
        StrategyFactory strategyFactory = StrategyFactory.getInstance();
        GreatWiz greatWiz = GreatWiz.getInstance();

        List<String> output = new ArrayList<>();
        List<Hero> players = new ArrayList<>();
        List<String> moves = gameInput.getPlayerMoves();
        for (int i = 0; i < gameInput.getNoPlayers(); i++) {
            players.add(heroFactory.createHero(gameInput.getPlayers().get(i), i));
        }
        List<List<Angel>> angels = new ArrayList<>();
        for (int i = 0; i < gameInput.getNoRounds(); i++) {
            angels.add(new ArrayList<>());
        }
        for (int i = 0; i < gameInput.getNoRounds(); i++) {
            for (int j = 0; j < gameInput.getAngels().get(i).size(); j++) {
                angels.get(i).add(angelFactory.createAngel(gameInput.getAngels().get(i).get(j)));
            }
        }
        /*for (int i = 0; i < gameInput.getNoRounds(); i++) {
            for (int j = 0; j < gameInput.getAngels().get(i).size(); j++) {
                System.out.println(angels.get(i).get(j).getType());
            }
        }*/
        for (int k = 0; k < gameInput.getNoRounds(); k++) {
            if (k != 0) {
                output.add("\n");
            }
            output.add("~~ Round " + (k+1) + " ~~\n");
            String currMove = moves.get(k);
            /*
            Parcurg mișcările fiecărei runde si dacă jucătorul e în viață și
            nu e incapacitat de un dmg Overtime, se mută pe hartă
             */
            for (int j = 0; j < currMove.length(); j++) {
                players.get(j).setFought(false);
               // players.get(j).sufferOvertimeDmg();
                if (players.get(j).isMovingAbility() && players.get(j).isAlive()) {
                    players.get(j).move(currMove.charAt(j));
                    players.get(j).sufferOvertimeDmg();
                    strategyFactory.getStrategy(players.get(j)).changeCoef();
                    strategyFactory.getStrategy(players.get(j)).changeHp();
                } else {
                    if (players.get(j).isAlive()) {
                        players.get(j).sufferOvertimeDmg();
                    }
                }
                /*
                Imediat după efectuarea mutării, toți jucătorii verifică dacă
                au de suferit de pe urma unui dmg Overtime
                 */
                //players.get(j).sufferOvertimeDmg();
            }
            /*
                Parcurg harta și verific dacă 2 jucători s-au întâlnit
             */
            for (int i = 0; i < players.size(); i++) {
                System.out.println(players.get(i).getRow());
                System.out.println(players.get(i).getColumn());
                System.out.println("\n");
            }
            for (int i = 0; i < players.size(); i++) {
                    if(!players.get(i).isAlive()) continue;
                    int row = players.get(i).getRow();
                    int column = players.get(i).getColumn();
                    if(row < 0 || column < 0) continue;
                    if (map.checkIfFightTime(row, column)) {
                        Hero firstFighter = map.firstFighter(row, column);
                        Hero secondFighter = map.secondFighter(row, column);
                        if(firstFighter.isFought() == true || secondFighter.isFought() == true)
                            continue;
                        firstFighter.setFought(true);
                        secondFighter.setFought(true);
                        /*
                        Vreau să calculez atacul lui wizard mereu a 2a oară
                        pentru a putea calcula dmg-ul dat de adversarul său
                         */
                        if (firstFighter.getType() != 'W') {
                                /*
                                Se calculează daunele produse celuilalt jucător în urma luptei
                                 */
                                secondFighter.isAttackedBy(firstFighter,
                                        map.getCellType(row, column));
                                firstFighter.isAttackedBy(secondFighter,
                                        map.getCellType(row, column));
                                /*
                                Se aplică daunele calculate anterior
                                 */
                                secondFighter.sufferDmg();
                                firstFighter.sufferDmg();
                            if (firstFighter.getIndex() > secondFighter.getIndex()) {
                                if (!firstFighter.isAlive()) {
                                    greatWiz.getHeroKilled().update(firstFighter, secondFighter, output);
                                }
                                if (!secondFighter.isAlive()) {
                                    greatWiz.getHeroKilled().update(secondFighter, firstFighter, output);
                                }} else {
                                if (!secondFighter.isAlive()) {
                                    greatWiz.getHeroKilled().update(secondFighter, firstFighter, output);
                                }
                                if (!firstFighter.isAlive()) {
                                    greatWiz.getHeroKilled().update(firstFighter, secondFighter, output);
                                }
                            }
                                /*
                                Dacă unul dintre jucători îl omoară pe celălalt, Xp-ul său crește
                                 */
                                int levelSecond = secondFighter.getLevel();
                                if (firstFighter.getHp() == -1) {
                                    int level = secondFighter.getLevel();
                                    secondFighter.growXP(firstFighter.getLevel());
                                    if (level != secondFighter.getLevel()) {
                                        greatWiz.getHeroLeveledUp().update(secondFighter, level, output);
                                    }
                                }
                                if (secondFighter.getHp() == -1) {
                                    int level = firstFighter.getLevel();
                                    firstFighter.growXP(levelSecond);
                                    if (level != firstFighter.getLevel()) {
                                        greatWiz.getHeroLeveledUp().update(firstFighter, level, output);
                                    }
                                }

                        } else {
                                firstFighter.isAttackedBy(secondFighter,
                                        map.getCellType(row, column));
                                secondFighter.isAttackedBy(firstFighter,
                                        map.getCellType(row, column));
                                secondFighter.sufferDmg();
                                firstFighter.sufferDmg();
                                if (firstFighter.getIndex() > secondFighter.getIndex()) {
                                if (!firstFighter.isAlive()) {
                                    greatWiz.getHeroKilled().update(firstFighter, secondFighter, output);
                                }
                                if (!secondFighter.isAlive()) {
                                    greatWiz.getHeroKilled().update(secondFighter, firstFighter, output);
                                }} else {
                                    if (!secondFighter.isAlive()) {
                                        greatWiz.getHeroKilled().update(secondFighter, firstFighter, output);
                                    }
                                    if (!firstFighter.isAlive()) {
                                        greatWiz.getHeroKilled().update(firstFighter, secondFighter, output);
                                    }
                                }
                                if (firstFighter.getHp() == -1 && secondFighter.getHp() != -1) {
                                    int level = secondFighter.getLevel();
                                    secondFighter.growXP(firstFighter.getLevel());
                                    if (level != secondFighter.getLevel()) {
                                        greatWiz.getHeroLeveledUp().update(secondFighter, level, output);
                                    }
                                }
                                if (secondFighter.getHp() == -1 && firstFighter.getHp() != -1) {
                                    int level = firstFighter.getLevel();
                                    firstFighter.growXP(secondFighter.getLevel());
                                    if (level != firstFighter.getLevel()) {
                                        greatWiz.getHeroLeveledUp().update(firstFighter, level, output);
                                    }
                                }
                        }
                    }


            }
            for (int i = 0; i < angels.get(k).size(); i++) {
                Angel angel = angels.get(k).get(i);
                greatWiz.getAngelSpawned().update(angel, output);
                for (int j = 0; j < map.getPlayersOnMap(angel.getRow(), angel.getColumn()).size(); j++) {
                    if (map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j).isAlive() && angel.getType() != "Spawner") {
                        int level = map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j).getLevel();
                        map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j).isAffectedBy(angel);
                        greatWiz.getAngelInvolved().update(angel, map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j), output);
                        if (angel.getType() == "LevelUpAngel") {
                            greatWiz.getHeroLeveledUp().update(map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j),
                                    level, output);
                        }
                        if (angel.getType() == "XPAngel") {
                            if (level != map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j).getLevel())
                            greatWiz.getHeroLeveledUp().update(map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j),
                                   level, output);
                        }
                        if(!map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j).isAlive()) {
                            greatWiz.getHeroKilledByAngel().update(map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j), output);
                        }
                    } else {
                        if(!map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j).isAlive() && angel.getType() == "Spawner") {
                            map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j).isAffectedBy(angel);
                            greatWiz.getAngelInvolved().update(angel, map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j), output);
                            greatWiz.getHeroRevived().update(map.getPlayersOnMap(angel.getRow(), angel.getColumn()).get(j), output);
                        }
                    }
                }
            }
        }
        output.add("\n~~ Results ~~\n");
        gameInputLoader.write(output, players);

    }
}
