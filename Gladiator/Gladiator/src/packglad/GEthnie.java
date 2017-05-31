package packglad;

import java.util.Collection;

public class GEthnie {
    /**
     * @attribute
     */
    private static Integer incrementIde=1;
    private static Collection<Ethnie> listeEthnie;

    public static Ethnie getEthnie(Integer ide) {
        Ethnie e = null;
        for (Ethnie ethnie : listeEthnie)
        {
            if (ide == ethnie.getIde())
            {
                e=ethnie;
            }
        }
        return e;
    }

    public static void ajouterEthnie(String nom) {
        Ethnie e = new Ethnie(nom,incrementIde);
        listeEthnie.add(e);
        GEthnie.setIncrementIde(GEthnie.getIncrementIde()+1);
    }

    public static void setIncrementIde(Integer incrementIde) {
        GEthnie.incrementIde = incrementIde;
    }

    public static Integer getIncrementIde() {
        return incrementIde;
    }

    public static Collection<Ethnie> getListeEthnie() {
        return listeEthnie;
    }

    public static Collection<Integer> getEthnieWin() {
        Collection<Integer> ethnie = null;
        int score=0;
        for (Ethnie e : listeEthnie)
        {
            if (e.getScore() > score)
            {
                ethnie.removeAll(ethnie);
                ethnie.add(e.getIde());
                score=e.getScore();
            }
            else if (e.getScore()== score) {
                ethnie.add(e.getIde());
            }
        }
        return ethnie;
    }
}
