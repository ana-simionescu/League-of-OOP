package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();

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
