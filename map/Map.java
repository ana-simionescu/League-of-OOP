package map;


import characters.Hero;

import java.util.ArrayList;
import java.util.List;

public class Map {
    List<List<Terrain>> fieldMap;
    List<List<List<Hero>>> playersMap;
    TerrainFactory terrainFactory = TerrainFactory.getInstance();

    private static Map instance = null;

    public Map(List<String> mapInput) {
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

    public Terrain getCellType(int row, int column) {
        return fieldMap.get(row).get(column);
    }



    private Map() { }

    public static Map getInstance(List<String> mapInput) {
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
    public void putPlayerOnMap(int row, int column, Hero player) {
        playersMap.get(row).get(column).add(player);
    }
    public void removePlayerFromMap(int row, int column, Hero player) {
        playersMap.get(row).get(column).remove(player);
    }

    public boolean checkIfFightTime(int row, int column) {
        if (playersMap.get(row).get(column).size() == 2) {
            return true;
        }
        return false;
    }

    public Hero firstFighter(int row, int column) {
        return playersMap.get(row).get(column).get(0);
    }
    public Hero secondFighter(int row, int column) {
        return playersMap.get(row).get(column).get(1);
    }
}
