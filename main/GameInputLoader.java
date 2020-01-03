package main;

import characters.heroes.Hero;
import fileio.FileSystem;

import java.util.ArrayList;
import java.util.List;

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
        List<List<AngelInput>> angels= new ArrayList<>();


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
            for (int i = 0; i < noRounds; i++) {
                angels.add(new ArrayList<>());
            }

            for (int i = 0; i < noRounds; ++i) {
                int noAngels = fs.nextInt();
                for (int j = 0; j < noAngels; j++) {
                    String Angel = fs.nextWord();
                    AngelInput currAngel = new AngelInput();
                    String[] Angelstr = Angel.split(",");
                    currAngel.setType(Angelstr[0]);
                    currAngel.setRow(Angelstr[1].charAt(0) - '0');
                    currAngel.setColumn(Angelstr[2].charAt(0) - '0');
                    angels.get(i).add(currAngel);
                }
            }

            fs.close();

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        return new GameInput(mapRows, mapColumns, noPlayers, noRounds, map, playerMoves, players, angels);
    }
}

