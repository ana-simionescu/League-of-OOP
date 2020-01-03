package characters.heroes;

import main.PlayerInput;

public final class HeroFactory {
    private static HeroFactory instance = null;

    private HeroFactory() { }

    public static HeroFactory getInstance() {
        if (instance == null) {
            instance = new HeroFactory();
        }
        return instance;
    }

    public Hero createHero(final PlayerInput player) {
        switch (player.getType()) {
            case "W": return new Wizard(player.getRow(), player.getColumn());
            case "R": return new Rogue(player.getRow(), player.getColumn());
            case "K": return new Knight(player.getRow(), player.getColumn());
            case "P": return new Pyromancer(player.getRow(), player.getColumn());
            default : return null;
        }
    }
}
