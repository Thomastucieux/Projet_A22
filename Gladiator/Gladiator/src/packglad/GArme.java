package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class GArme {
    /**
     * @attribute
     */
    private static Integer incrementIda=1;
    private static Collection<Arme> listeArme = new ArrayList<Arme>();
    
    /**
     * @Méthodes
     */

    public static Integer nouvelleArme(Integer puissanceDef, Integer puissanceOff, String type) {
        Arme a = new Arme(GArme.getIncrementIda(),type,puissanceOff,puissanceDef);
        GArme.listeArme.add(a);
        GArme.setIncrementIda(GArme.getIncrementIda()+1);
        return a.getIda();
    }

    public static Arme getArme(Integer ida) {
        Arme a = null;
        for (Arme arme : listeArme)
        {
            if (ida == arme.getIda())
            {
                a=arme;
            }
        }
        return a;
    }

    public static void setIncrementIda(Integer incrementIda) {
        GArme.incrementIda = incrementIda;
    }

    public static Integer getIncrementIda() {
        return incrementIda;
    }

    public static Collection getListeArme() {
        return listeArme;
    }
}
