package main;

import characters.Hero;
import characters.HeroFactory;
import map.Map;
import map.Terrain;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

        Map map = Map.getInstance(gameInput.getMap());
        HeroFactory heroFactory = HeroFactory.getInstance();

        List<Hero> players = new ArrayList<>();
        List<String> moves = new ArrayList<>();
        moves = gameInput.getPlayerMoves();
        for (int i = 0 ; i < gameInput.getNoPlayers(); i++) {
            players.add(heroFactory.createHero(gameInput.getPlayers().get(i)));
         //   System.out.println(players.get(i));
        }
       //
       /* for(int i = 0; i < gameInput.getMapRows(); i++) {
            for(int j = 0; j < gameInput.getMapColumns(); j++) {
                 System.out.println(map.getCell(i,j).getType());
            }
        }
        */
        // System.out.println(map.getCell(0,0).getType());



       /* System.out.println(gameInput.getNoPlayers());
        System.out.println(gameInput.getNoRounds());


        List<String> map = new ArrayList<>();
        List<PlayerInput> players = new ArrayList<>();
        List<String> playerMoves = new ArrayList<>();

        map = gameInput.getMap();
        players = gameInput.getPlayers();
        playerMoves = gameInput.getPlayerMoves();

        for (int i = 0; i < map.size(); i++) {
            System.out.println(map.get(i));
        }
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).type);
            System.out.println(players.get(i).line);
            System.out.println(players.get(i).column);
        }
        for (int i = 0; i < playerMoves.size(); i++) {
            System.out.println(playerMoves.get(i));
        }*/




    }
}
