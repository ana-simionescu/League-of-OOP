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

    public Hero createHero(final PlayerInput player, final int index) {
        switch (player.getType()) {
            case "W": return new Wizard(player.getRow(), player.getColumn(), index);
            case "R": return new Rogue(player.getRow(), player.getColumn(), index);
            case "K": return new Knight(player.getRow(), player.getColumn(), index);
            case "P": return new Pyromancer(player.getRow(), player.getColumn(), index);
            default : return null;
        }
    }
}
