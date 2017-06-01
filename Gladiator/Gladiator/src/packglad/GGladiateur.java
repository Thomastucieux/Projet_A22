package packglad;

import java.util.ArrayList;
import java.util.Collection;

class GGladiateur {
    /**
     * @attribute
     */
    private static Integer incrementIDG = 1;
    private static Collection<Gladiateur> listeGladiateur = new ArrayList<>();

    static Gladiateur getGladiateur(Integer idg) {
        Gladiateur g = null;

        for (Gladiateur glad : listeGladiateur) {
            if (idg.equals(glad.getIdg()))
                g = glad;
        }

        return g;
    }

    static Collection<Gladiateur> getListeGladiateur() {
        return new ArrayList<>(listeGladiateur);
    }


    static Mirmillon nouveauMirmillon(String nom, Integer poids, Ethnie ethnie) {
        Mirmillon m = new Mirmillon(nom, incrementIDG, ethnie, poids < 0 ? 0 : (poids > Mirmillon.getC_poidsMax() ? Mirmillon.getC_poidsMax() : poids));
        GGladiateur.listeGladiateur.add(m);
        incrementIDG++;
        return m;
    }

    static Retiaire nouveauRetiaire(String nom, Integer agilite, Ethnie ethnie) {
        Retiaire r = new Retiaire(nom, incrementIDG, ethnie, agilite < 0 ? 0 : (agilite > Retiaire.getC_agiliteMax() ? Retiaire.getC_agiliteMax() : agilite));
        GGladiateur.listeGladiateur.add(r);
        incrementIDG++;
        return r;
    }

    static Boolean suppGlad(Integer idg) {
        return listeGladiateur.remove(getGladiateur(idg));
    }

    static Collection<Gladiateur> getCompoEthnie(Ethnie e) {
        Collection<Gladiateur> composition = new ArrayList<>();
        for (Gladiateur glad : getListeGladiateur()) {
            if (glad.getAppartenance().equals(e)) {
                composition.add(glad);
            }
        }
        return composition;
    }
}
