package characters;

import observers.AngelInvolved;
import observers.AngelSpawned;
import observers.HeroKilled;
import observers.HeroLeveledUp;
import observers.HeroRevived;
import observers.HeroKilledByAngel;

public final class GreatWiz {
    private AngelInvolved angelInvolved;
    private AngelSpawned angelSpawned;
    private HeroKilled heroKilled;
    private HeroLeveledUp heroLeveledUp;
    private HeroKilledByAngel heroKilledByAngel;
    private HeroRevived heroRevived;

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

    public static GreatWiz getInstance() {
        if (instance == null) {
            instance = new GreatWiz();
        }
        return instance;
    }
}
