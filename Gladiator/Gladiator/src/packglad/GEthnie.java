package packglad;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

class GEthnie {
    /**
     * @attribute
     */
    private static Integer incrementIde = 1;
    private static Collection<Ethnie> listeEthnie = new ArrayList<Ethnie>();

    static Ethnie getEthnie(Integer ide) {
        Ethnie e = null;

        for (Ethnie ethnie : listeEthnie)
            if (ide.equals(ethnie.getIde()))
                e = ethnie;

        return e;
    }

    static void ajouterEthnie(String nom) {
        Ethnie e = new Ethnie(nom, incrementIde);
        listeEthnie.add(e);
        incrementIde++;
    }

    static Collection<Ethnie> getListeEthnie() {
        return new ArrayList<>(GEthnie.listeEthnie);
    }

    static Collection<Integer> getEthnieWin() {
        Collection<Integer> ethnie = new ArrayList<>();
        int score = 0;

        for (Ethnie e : GEthnie.listeEthnie) {
            if (e.getScore() > score) {
                ethnie.clear();
                ethnie.add(e.getIde());
                score = e.getScore();
            } else if (e.getScore() == score)
                ethnie.add(e.getIde());
        }

        return ethnie;
    }
}
