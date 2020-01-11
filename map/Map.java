package map;


import characters.IndexComparator;
import characters.heroes.Hero;

import java.util.ArrayList;
import java.util.List;

public final class Map {
    private List<List<Terrain>> fieldMap;
    private List<List<List<Hero>>> playersMap;
    private TerrainFactory terrainFactory = TerrainFactory.getInstance();

    private static Map instance = null;

    public Map(final List<String> mapInput) {
        fieldMap = new ArrayList<>();
        playersMap = new ArrayList<>();
        for (int i = 0; i < mapInput.size(); i++) {
            fieldMap.add(new ArrayList<>());
            playersMap.add(new ArrayList<>());
            for (int j = 0; j < mapInput.get(i).length(); j++) {
                char type = mapInput.get(i).charAt(j);
                fieldMap.get(i).add(terrainFactory.createTerrain(type));
                playersMap.get(i).add(new ArrayList<>());
            }
        }
    }

    public Terrain getCellType(final int row, final int column) {
        return fieldMap.get(row).get(column);
    }

    private Map() { }

    public static Map getInstance(final List<String> mapInput) {
        if (instance == null) {
            instance = new Map(mapInput);
        }
        return instance;
    }
    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }
        return instance;
    }

    /*
    Metodele primesc ca parametrii coordonatele si jucătorul pe care
    trebuie să îl așeze sau scoată de pe hartă
     */
    public void putPlayerOnMap(final int row, final int column, final Hero player) {
        playersMap.get(row).get(column).add(player);
    }
    public void removePlayerFromMap(final int row, final int column, final Hero player) {
        playersMap.get(row).get(column).remove(player);
    }

    public List<Hero> getPlayersOnMap(final int row, final int column) {
        playersMap.get(row).get(column).sort(new IndexComparator());
        return playersMap.get(row).get(column);
    }

    /*
        Dacă se găsesc 2 jucători în aceeași căsuță aceștia se vor lupta
         */
    public boolean checkIfFightTime(final int row, final int column) {
        int nr = 0;
        for (int i = 0; i < playersMap.get(row).get(column).size(); i++) {
            if (playersMap.get(row).get(column).get(i).isAlive()) {
                nr++;
            }
        }
        if (nr == 2) {
            return true;
        }
        return false;
    }

    public Hero firstFighter(final int row, final int column) {
        int nr = 0;
        for (int i = 0; i < playersMap.get(row).get(column).size(); i++) {
            if (playersMap.get(row).get(column).get(i).isAlive()) {
                nr++;
            }
            if (nr == 1) {
                return playersMap.get(row).get(column).get(i);
            }
        }
        return null;
    }
    public Hero secondFighter(final int row, final int column) {
        int nr = 0;
        for (int i = 0; i < playersMap.get(row).get(column).size(); i++) {
            if (playersMap.get(row).get(column).get(i).isAlive()) {
                nr++;
            }
            if (nr == 2) {
                return playersMap.get(row).get(column).get(i);
            }
        }
        return null;
    }
}
