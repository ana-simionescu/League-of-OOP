package main;

import characters.angels.Angel;
import characters.heroes.Hero;
import characters.heroes.HeroFactory;
import map.Map;

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

        List<Hero> players = new ArrayList<>();
        List<String> moves = gameInput.getPlayerMoves();
        for (int i = 0; i < gameInput.getNoPlayers(); i++) {
            players.add(heroFactory.createHero(gameInput.getPlayers().get(i)));
        }
        List<List<Angel>> angels = new ArrayList<>();
        for (int i = 0; i < gameInput.getNoRounds(); i++) {
            angels.add(new ArrayList<>());
        }
        angels = gameInput.getAngels();

        for (int k = 0; k < gameInput.getNoRounds(); k++) {
            String currMove = moves.get(k);
            /*
            Parcurg mișcările fiecărei runde si dacă jucătorul e în viață și
            nu e incapacitat de un dmg Overtime, se mută pe hartă
             */
            for (int j = 0; j < currMove.length(); j++) {
                if (players.get(j).isMovingAbility() && players.get(j).isAlive()) {
                    players.get(j).move(currMove.charAt(j));
                }
                /*
                Imediat după efectuarea mutării, toți jucătorii verifică dacă
                au de suferit de pe urma unui dmg Overtime
                 */
                players.get(j).sufferOvertimeDmg();
            }
            /*
                Parcurg harta și verific dacă 2 jucători s-au întâlnit
             */
            for (int i = 0; i < gameInput.getMapRows(); i++) {
                for (int j = 0; j < gameInput.getMapColumns(); j++) {
                    int row = i;
                    int column = j;
                    if (map.checkIfFightTime(row, column)) {
                        Hero firstFighter = map.firstFighter(row, column);
                        Hero secondFighter = map.secondFighter(row, column);
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
                                /*
                                Dacă unul dintre jucători îl omoară pe celălalt, Xp-ul său crește
                                 */
                                if (firstFighter.getHp() == -1 && secondFighter.getHp() != -1) {
                                    secondFighter.growXP(firstFighter);
                                }
                                if (secondFighter.getHp() == -1 && firstFighter.getHp() != -1) {
                                    firstFighter.growXP(secondFighter);
                                }

                        } else {
                                firstFighter.isAttackedBy(secondFighter,
                                        map.getCellType(row, column));
                                secondFighter.isAttackedBy(firstFighter,
                                        map.getCellType(row, column));
                                secondFighter.sufferDmg();
                                firstFighter.sufferDmg();
                                if (firstFighter.getHp() == -1 && secondFighter.getHp() != -1) {
                                    secondFighter.growXP(firstFighter);
                                }
                                if (secondFighter.getHp() == -1 && firstFighter.getHp() != -1) {
                                    firstFighter.growXP(secondFighter);
                                }
                        }
                    }
                }

            }
        }
        gameInputLoader.write(players);

    }
}
