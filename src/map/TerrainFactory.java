package map;

final class TerrainFactory {
    private static TerrainFactory instance = null;

    private TerrainFactory() { }

    static TerrainFactory getInstance() {
        if (instance == null) {
            instance = new TerrainFactory();
        }
        return instance;
    }

    Terrain createTerrain(final char type) {
        switch (type) {
            case 'W': return new Woods();
            case 'D': return new Desert();
            case 'V': return new Volcanic();
            case 'L': return new Land();
            default : return null;
        }
    }
}
