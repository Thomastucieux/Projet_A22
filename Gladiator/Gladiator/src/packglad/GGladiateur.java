package packglad;

import java.util.Collection;

public class GGladiateur {
    /**
     * @attribute
     */
    private static Integer incrementIDG=1;
    private static Collection<Gladiateur> listeGladiateur;

    public static void setIncrementIDG(Integer incrementIDG) {
        GGladiateur.incrementIDG = incrementIDG;
    }

    public static Integer getIncrementIDG() {
        return incrementIDG;
    }

    public static Gladiateur getGladiateur(Integer idg){
      Gladiateur g = null;
      for (Gladiateur glad : listeGladiateur)
      {
          if (idg == glad.getIdg())
          {
              g=glad;
          }
      }
      return g;
    }

    public static Collection<Gladiateur> getListeGladiateur() {
        return listeGladiateur;
    }


    public static void nouveauMirmillon(String nom, Integer poids, Ethnie ethnie) {
        if (poids <= Mirmillon.getC_poidsMax()) {
            Mirmillon m = new Mirmillon(nom, GGladiateur.getIncrementIDG(), ethnie, poids);
            GGladiateur.listeGladiateur.add(m);
            GGladiateur.setIncrementIDG(GGladiateur.getIncrementIDG()+1);
        }
    }

    public static void nouveauRetiaire(String nom, Integer agilite, Ethnie ethnie) {
        if (agilite <= Retiaire.getC_agiliteMax()) {
            Retiaire r = new Retiaire(nom, GGladiateur.getIncrementIDG(), ethnie, agilite);
            GGladiateur.listeGladiateur.add(r);
            GGladiateur.setIncrementIDG(GGladiateur.getIncrementIDG()+1);
        }
    }

    public static Integer suppGlad(Integer idg) {
        int res=0;
        for (Gladiateur g : GGladiateur.listeGladiateur) {
            if (g.getIdg()==idg) {
                
            }
        }
        return res;
    }

    public static Collection<Gladiateur> getCompoEthnie(Ethnie e) {
        Collection<Gladiateur> composition = null;
        for (Gladiateur glad : getListeGladiateur())
        {
            if (glad.getAppartenance() == e)
            {
                composition.add(glad);
            }
        }
        return composition;
    }
}
