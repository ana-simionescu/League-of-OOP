package main;

import java.util.ArrayList;
import java.util.List;

import characters.Hero;
import fileio.FileSystem;

public final class GameInputLoader {
    private final String mInputPath;
    private final String mOutputPath;

    GameInputLoader(final String inputPath, final String outputPath) {
        mInputPath = inputPath;
        mOutputPath = outputPath;
    }


    public void write(final List<Hero> players) {
        try {
            FileSystem fs = new FileSystem(mInputPath, mOutputPath);
            for (int i = 0; i < players.size(); i++) {
                fs.writeWord(players.get(i).toString());
                fs.writeNewLine();
            }
            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

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
                currPlayer.setType(fs.nextWord());
                currPlayer.setRow(fs.nextInt());
                currPlayer.setColumn(fs.nextInt());
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

