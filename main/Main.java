package main;

import characters.Hero;
import characters.HeroFactory;
import map.Map;
import map.Terrain;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;

public class Main {
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        Map map = Map.getInstance(gameInput.getMap());
        HeroFactory heroFactory = HeroFactory.getInstance();

        List<Hero> players = new ArrayList<>();
        List<String> moves = gameInput.getPlayerMoves();
        for (int i = 0 ; i < gameInput.getNoPlayers(); i++) {
            players.add(heroFactory.createHero(gameInput.getPlayers().get(i)));
        }

        for (int k = 0; k < gameInput.getNoRounds(); k++) {
            String currMove = moves.get(k);
            for (int j = 0; j < currMove.length(); j++) {
                if (players.get(j).isMovingAbility() && players.get(j).isAlive()) {
                    players.get(j).move(currMove.charAt(j));
                }
                players.get(j).sufferOvertimeDmg();
            }
            for (int i = 0; i < gameInput.getMapRows(); i++) {
                for (int j = 0; j < gameInput.getMapColumns(); j++) {
                    int row = i;
                    int column = j;
                    if (map.checkIfFightTime(row, column)) {
                        Hero firstFighter = map.firstFighter(row, column);
                        Hero secondFighter = map.secondFighter(row, column);
                        /*if (k == 26) {
                            System.out.println("\n");
                            System.out.println(firstFighter);
                             System.out.println(secondFighter);
                             System.out.println("\n");
                        }*/
                       // System.out.println(firstFighter);
                       // System.out.println(secondFighter);
                        if (firstFighter.getType() != 'W') {
                                secondFighter.isAttackedBy(firstFighter, map.getCellType(row, column));
                                firstFighter.isAttackedBy(secondFighter, map.getCellType(row, column));
                                secondFighter.sufferDmg();
                                firstFighter.sufferDmg();
                                if (firstFighter.getHp() == -1 && secondFighter.getHp() != -1) {
                                    secondFighter.growXP(firstFighter);
                                }
                                if (secondFighter.getHp() == -1 && firstFighter.getHp() != -1) {
                                    firstFighter.growXP(secondFighter);
                                }

                        } else {
                                firstFighter.isAttackedBy(secondFighter, map.getCellType(row, column));
                                secondFighter.isAttackedBy(firstFighter, map.getCellType(row, column));
                                secondFighter.sufferDmg();
                                firstFighter.sufferDmg();
                                if (firstFighter.getHp() == -1 && secondFighter.getHp() != -1) {
                                    secondFighter.growXP(firstFighter);
                                }
                                if (secondFighter.getHp() == -1 && firstFighter.getHp() != -1) {
                                    firstFighter.growXP(secondFighter);
                                }
                        }
                      //  System.out.println(firstFighter);
                      //  System.out.println(secondFighter);
                      //  System.out.println("\n");
                    }
                }

            }
            //System.out.println(k);
            //System.out.println(players.get(30));
            //System.out.println(players.get(44));
        }
        //System.out.println(players.get(44).getRow());
        //System.out.println(players.get(44).getColumn());
        gameInputLoader.write(players);

    }
}
