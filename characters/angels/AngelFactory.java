package characters.angels;

import main.AngelInput;

public final class AngelFactory {
    private static AngelFactory instance = null;

    private AngelFactory() { }

    public static AngelFactory getInstance() {
        if (instance == null) {
            instance = new AngelFactory();
        }
        return instance;
    }

    public Angel createAngel(final AngelInput angel) {
        switch (angel.getType()) {
            case "DamageAngel": return new DamageAngel(angel.getRow(), angel.getColumn());
            case "DarkAngel": return new DarkAngel(angel.getRow(), angel.getColumn());
            case "Dracula": return new Dracula(angel.getRow(), angel.getColumn());
            case "GoodBoy": return new GoodBoy(angel.getRow(), angel.getColumn());
            case "LevelUpAngel": return new LevelUpAngel(angel.getRow(), angel.getColumn());
            case "LifeGiver": return new LifeGiver(angel.getRow(), angel.getColumn());
            case "SmallAngel": return new SmallAngel(angel.getRow(), angel.getColumn());
            case "Spawner": return new Spawner(angel.getRow(), angel.getColumn());
            case "TheDoomer": return new TheDoomer(angel.getRow(), angel.getColumn());
            case "XPAngel": return new XPAngel(angel.getRow(), angel.getColumn());
            default : return null;
        }
    }
}
