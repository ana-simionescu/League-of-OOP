package characters;

import characters.heroes.Hero;
import observers.*;

public class GreatWiz {
    AngelInvolved angelInvolved;
    AngelSpawned angelSpawned;
    HeroKilled heroKilled;
    HeroLeveledUp heroLeveledUp;
    HeroKilledByAngel heroKilledByAngel;
    HeroRevived heroRevived;

    public HeroKilledByAngel getHeroKilledByAngel() {
        return heroKilledByAngel;
    }

    public HeroRevived getHeroRevived() {
        return heroRevived;
    }

    public AngelInvolved getAngelInvolved() {
        return angelInvolved;
    }

    public AngelSpawned getAngelSpawned() {
        return angelSpawned;
    }

    public HeroKilled getHeroKilled() {
        return heroKilled;
    }

    public HeroLeveledUp getHeroLeveledUp() {
        return heroLeveledUp;
    }


    private static GreatWiz instance = null;

    private GreatWiz() {
        angelInvolved = new AngelInvolved();
        angelSpawned = new AngelSpawned();
        heroKilled = new HeroKilled();
        heroLeveledUp = new HeroLeveledUp();
        heroKilledByAngel = new HeroKilledByAngel();
        heroRevived = new HeroRevived();
    }

    static public GreatWiz getInstance() {
        if (instance == null) {
            instance = new GreatWiz();
        }
        return instance;
    }
}
