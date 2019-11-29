package main;

import java.util.ArrayList;
import java.util.List;
import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }


    public GameInput load() {
        int mapRows = 0;
        int mapColumns = 0;
        int noPlayers = 0;
        int noRounds = 0;
        List<String> map = new ArrayList<>();
        List<PlayerInput> players = new ArrayList<>();
        List<String> playerMoves = new ArrayList<>();

        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);

            mapRows = fs.nextInt();
            mapColumns = fs.nextInt();

            for (int i = 0; i < mapRows; ++i) {
                map.add(fs.nextWord());
            }

            noPlayers = fs.nextInt();

            for (int i = 0; i < noPlayers; ++i) {
                PlayerInput currPlayer = new PlayerInput();
                currPlayer.type = fs.nextWord();
                currPlayer.line = fs.nextInt();
                currPlayer.column = fs.nextInt();
                players.add(currPlayer);
            }

            noRounds = fs.nextInt();
            for (int i = 0; i < noRounds; ++i) {
                playerMoves.add(fs.nextWord());
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mapRows, mapColumns, noPlayers, noRounds, map, playerMoves, players);
    }
}

