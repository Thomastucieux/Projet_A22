package packglad;

import java.util.ArrayList;
import java.util.Collection;

class GArme {
    /**
     * @attribute
     */
    private static Integer incrementIda = 1;
    private static Collection<Arme> listeArme = new ArrayList<>();

    /**
     * Méthodes
     */

    static Integer nouvelleArme(Integer puissanceDef, Integer puissanceOff, String type) {
        Arme a = new Arme(incrementIda, type, puissanceOff, puissanceDef);
        GArme.listeArme.add(a);
        incrementIda++;
        return a.getIda();
    }

    static Arme getArme(Integer ida) {
        Arme a = null;

        for (Arme arme : listeArme)
            if (ida.equals(arme.getIda()))
                a = arme;

        return a;
    }

    public static Collection getListeArme() {
        return new ArrayList<>(listeArme);
    }
}
