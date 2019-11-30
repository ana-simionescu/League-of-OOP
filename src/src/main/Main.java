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

        for (int i = 0; i < gameInput.getNoRounds(); i++) {
            String currMove = moves.get(i);
            for (int j = 0; j < currMove.length(); j++) {
                players.get(j).move(currMove.charAt(j));
                int row = players.get(j).getRow();
                int column = players.get(j).getColumn();
                if (map.checkIfFightTime(row, column)) {
                    Hero firstFighter = map.firstFighter(row, column);
                    Hero secondFighter = map.secondFighter(row, column);
                    if (firstFighter.getType() != 'W') {
                        secondFighter.sufferOvertimeDmg();
                        firstFighter.sufferOvertimeDmg();
                        secondFighter.isAttackedBy(firstFighter, map.getCellType(row, column));
                        firstFighter.isAttackedBy(secondFighter, map.getCellType(row, column));
                        secondFighter.sufferDmg();
                        firstFighter.sufferDmg();
                        if (firstFighter.getHp() == -1) {
                            secondFighter.setXp(secondFighter.getXp() + max(0, 200 - (secondFighter.getLevel() -
                                      firstFighter.getLevel()) * 40));
                        }
                        if (secondFighter.getHp() == -1) {
                            firstFighter.setXp(firstFighter.getXp() + max(0, 200 - (firstFighter.getLevel() -
                                    secondFighter.getLevel()) * 40));
                        }
                    } else {
                        secondFighter.sufferOvertimeDmg();
                        firstFighter.sufferOvertimeDmg();
                        firstFighter.isAttackedBy(secondFighter, map.getCellType(row, column));
                        secondFighter.isAttackedBy(firstFighter, map.getCellType(row, column));
                        secondFighter.sufferDmg();
                        firstFighter.sufferDmg();
                        if (firstFighter.getHp() == -1) {
                            secondFighter.setXp(secondFighter.getXp() + max(0, 200 - (secondFighter.getLevel() -
                                    firstFighter.getLevel()) * 40));
                        }
                        if (secondFighter.getHp() == -1) {
                            firstFighter.setXp(firstFighter.getXp() + max(0, 200 - (firstFighter.getLevel() -
                                    secondFighter.getLevel()) * 40));
                        }
                    }
                }
            }
        }

        gameInputLoader.write(players);

    }
}
