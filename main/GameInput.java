package main;

import java.util.List;

public class GameInput {
    private int mapRows;
    private int mapColumns;
    private int noPlayers;
    private int noRounds;
    private final List<String> map;
    private final List<PlayerInput> players;
    private final List<String> playerMoves;
    private final List<List<AngelInput>> angels;

    public GameInput() {
        map = null;
        players = null;
        playerMoves = null;
        mapRows = -1;
        mapColumns = -1;
        noPlayers = -1;
        noRounds = -1;
        angels = null;
    }

    public GameInput(final int noPlayers, final int rounds,
                     final List<String> map, final List<String> moves,
                     final List<PlayerInput> players, final List<List<AngelInput>> angels) {
       // mapRows = rows;
        //mapColumns = columns;
        this.noPlayers = noPlayers;
        noRounds = rounds;
        this.map = map;
        playerMoves = moves;
        this.players = players;
        this.angels = angels;
    }

    public final List<String> getMap() {
        return map;
    }

    public final List<String> getPlayerMoves() {
        return playerMoves;
    }

    public final List<PlayerInput> getPlayers() {
        return players;
    }

    public final List<List<AngelInput>> getAngels() {
        return angels;
    }

    public final int getNoPlayers() {
        return noPlayers;
    }

    public final int getNoRounds() {
        return noRounds;
    }

    public final int getMapRows() {
        return map.size();
    }

    public final int getMapColumns() {
        return map.get(0).length();
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = map != null && playerMoves != null
                && players != null && angels != null;
        boolean membersNotEmpty = map.size() > 0 && playerMoves.size() > 0
                && players.size() > 0 && angels.size() > 0
                && mapRows > 0 && mapColumns > 0 && noRounds > 0 && noPlayers > 0;

        return membersInstantiated && membersNotEmpty;
    }

}
