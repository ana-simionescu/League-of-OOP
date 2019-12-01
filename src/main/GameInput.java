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

    public GameInput() {
        map = null;
        players = null;
        playerMoves = null;
        mapRows = -1;
        mapColumns = -1;
        noPlayers = -1;
        noRounds = -1;
    }

    public GameInput(final int rows, final int columns, final int noPlayers, final int rounds,
                     final List<String> map, final List<String> moves,
                     final List<PlayerInput> players) {
        mapRows = rows;
        mapColumns = columns;
        this.noPlayers = noPlayers;
        noRounds = rounds;
        this.map = map;
        playerMoves = moves;
        this.players = players;
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

    public final int getNoPlayers() {
        return noPlayers;
    }

    public final int getNoRounds() {
        return noRounds;
    }

    public final int getMapRows() {
        return mapRows;
    }

    public final int getMapColumns() {
        return mapColumns;
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = map != null && playerMoves != null && players != null;
        boolean membersNotEmpty = map.size() > 0 && playerMoves.size() > 0 && players.size() > 0
                && mapRows > 0 && mapColumns > 0 && noRounds > 0 && noPlayers > 0;

        return membersInstantiated && membersNotEmpty;
    }

}
