package characters;


import characters.heroes.Hero;

import java.util.Comparator;

public final class IndexComparator implements Comparator<Hero> {
    public int compare(final Hero c1, final Hero c2) {
        return c1.getIndex() - c2.getIndex();
    }
}
