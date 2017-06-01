package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class Facade {
    public static void parametrage(Integer vieInit, Integer forceRet, Integer poidsMax, Integer agilMax) {
        Gladiateur.setC_vieMax(vieInit);
        Retiaire.setC_force(forceRet);
        Mirmillon.setC_poidsMax(poidsMax);
        Retiaire.setC_AgiliteMax(agilMax);
    }

    public static Collection<Integer> listerTousGladiateurs() {
        Collection<Integer> glad = new ArrayList<>();
        for (Gladiateur g : GGladiateur.getListeGladiateur()) {
            glad.add(g.getIdg());
        }
        return glad;
    }

    public static Integer donnerUneArme(Integer ida, Integer idg) {
        Gladiateur g = GGladiateur.getGladiateur(idg);

        if (g != null && g.recevoirArmes(GArme.getArme(ida))) {
            return 0;
        }

        return 1;
    }

    public static Collection listerAgresseurs(Integer idg) {
        Gladiateur g = GGladiateur.getGladiateur(idg);

        if (g != null)
            return g.getAgresseur();
        return null;
    }

    public static Integer creerMirmillon(String nom, Integer poids, Integer ide) {
        Ethnie e = GEthnie.getEthnie(ide);

        if (e != null)
            return GGladiateur.nouveauMirmillon(nom, poids, GEthnie.getEthnie(ide)).getIdg();
        return -1;
        //retourne L'idg utilisé pour créer le dernier gladiateur
    }

    public static String faireSaluerGladiateur(Integer idg) {
        Gladiateur g = GGladiateur.getGladiateur(idg);

        if (g != null)
            return g.saluer();
        return null;
    }

    public static String nomDeLEthnie(Integer ide) {
        Ethnie e = GEthnie.getEthnie(ide);

        if (e != null)
            return e.getNom();
        return null;
    }

    public static Integer supprimerGlad(Integer idg) {
        return GGladiateur.suppGlad(idg) ? 0 : 1;
    }

    public static String nomDuGladiateur(Integer idg) {
        Gladiateur g = GGladiateur.getGladiateur(idg);

        if (g != null)
            return g.getNom();
        return null;
    }

    public static Collection<Integer> listerEthnies() {
        Collection<Integer> ethnie = new ArrayList<>();
        for (Ethnie e : GEthnie.getListeEthnie()) {
            ethnie.add(e.getIde());
        }
        return ethnie;
    }

    public static String decrireEthnie(Integer ide) {
        Ethnie e = GEthnie.getEthnie(ide);

        if (e != null)
            return e.decrireEthnie();
        return null;
    }

    public static Integer desarmer(Integer idgVictime, Integer ida) {
        Gladiateur g = GGladiateur.getGladiateur(idgVictime);
        Arme a = GArme.getArme(ida);

        if (g != null && a != null)
            return g.perdreArme(a) ? 0 : 1;
        return 1;
    }

    public static String nomDeLArme(Integer ida) {
        Arme a = GArme.getArme(ida);

        if (a != null)
            return a.getType();
        return null;
    }

    public static Integer creerRetiaire(String nom, Integer agilite, Integer ide) {
        Ethnie e = GEthnie.getEthnie(ide);

        if (e != null)
            return GGladiateur.nouveauRetiaire(nom, agilite, GEthnie.getEthnie(ide)).getIdg();
        return -1;
        //retourne L'idg utilisé pour créer le dernier gladiateur
    }

    public static Collection<Integer> listerArmesDispoRetiaire() {
        return Retiaire.getArmeAcc();
    }

    public static Collection<Integer> declarerArmes(Integer idg) {
        Collection<Integer> arme = new ArrayList<>();
        for (Arme a : GGladiateur.getGladiateur(idg).declarerArmes()) {
            arme.add(a.getIda());
        }
        return arme;
    }

    public static Integer lancerJeu() {
        Facade.parametrage(200, 30, 100, 50);
        return 0;
    }

    public static String decrireArme(Integer ida) {
        Arme a = GArme.getArme(ida);

        if (a != null)
            return a.decrireArme();
        return null;
    }

    public static Collection<Integer> listerArmesDispoMirmillon() {
        return Mirmillon.getArmeAutorisees();
    }

    public static Integer creerUneArme(String nom, Integer puissOff, Integer puissDef) {
        return GArme.nouvelleArme(puissDef, puissOff, nom);
    }

    public static Integer autoriserArmeAuxMirmillons(Integer ida) {
        Arme a = GArme.getArme(ida);

        if (a != null)
            return Mirmillon.c_autoriserArme(a);
        return -1;
    }

    public static Integer autoriserArmeAuxRetiaires(Integer ida) {
        Arme a = GArme.getArme(ida);

        if (a != null)
            return Retiaire.c_autoriserArme(a);
        return -1;
    }

    public static Integer frapper(Integer idgAgresseur, Integer idgVictime, Integer ida) {
        Gladiateur agresseur = GGladiateur.getGladiateur(idgAgresseur);
        Gladiateur victime = GGladiateur.getGladiateur(idgVictime);
        Arme a = GArme.getArme(ida);

        if (a != null && agresseur != null && victime != null)
            return agresseur.frapper(a, victime);
        return -1;
    }

    public static Collection<Integer> vainqueurs() {
        return GEthnie.getEthnieWin();
    }

    public static void lancerJeuDEssai() {
        Facade.lancerJeu();
        //création des Ethnies
        GEthnie.ajouterEthnie("Gaulois");
        Ethnie e1 = GEthnie.getEthnie(1);
        GEthnie.ajouterEthnie("Thraces");
        Ethnie e2 = GEthnie.getEthnie(2);
        GEthnie.ajouterEthnie("Dalmates");
        Ethnie e3 = GEthnie.getEthnie(3);


        //création des Armes et autorisations
        GArme.nouvelleArme(0, 80, "Glaive");
        Arme a1 = GArme.getArme(1);
        Mirmillon.c_autoriserArme(a1);
        Retiaire.c_autoriserArme(a1);

        GArme.nouvelleArme(0, 100, "Trident");
        Arme a2 = GArme.getArme(2);
        Retiaire.c_autoriserArme(a2);

        GArme.nouvelleArme(20, 40, "Filet");
        Arme a3 = GArme.getArme(3);
        Retiaire.c_autoriserArme(a3);

        GArme.nouvelleArme(40, 40, "Bouclier");
        Arme a4 = GArme.getArme(4);
        Mirmillon.c_autoriserArme(a4);

        GArme.nouvelleArme(20, 0, "Casque");
        Arme a5 = GArme.getArme(5);
        Mirmillon.c_autoriserArme(a5);

        GArme.nouvelleArme(10, 0, "Jambiere");
        Arme a6 = GArme.getArme(6);
        Mirmillon.c_autoriserArme(a6);
        Retiaire.c_autoriserArme(a6);


        //Création des Gladiateurs et ajout des armes
        GGladiateur.nouveauRetiaire("Unix", 30, e1);
        Gladiateur g1 = GGladiateur.getGladiateur(1);
        g1.recevoirArmes(a2);
        g1.recevoirArmes(a6);
        g1.recevoirArmes(a3);

        GGladiateur.nouveauMirmillon("Informatix", 100, e1);
        Gladiateur g2 = GGladiateur.getGladiateur(2);
        g2.recevoirArmes(a1);
        g2.recevoirArmes(a4);
        g2.recevoirArmes(a5);
        g2.recevoirArmes(a6);

        GGladiateur.nouveauRetiaire("Ceplusplus", 40, e2);
        Gladiateur g3 = GGladiateur.getGladiateur(3);
        g3.recevoirArmes(a2);
        g3.recevoirArmes(a6);

        GGladiateur.nouveauMirmillon("Pythonus", 60, e2);
        Gladiateur g4 = GGladiateur.getGladiateur(4);
        g4.recevoirArmes(a1);
        g4.recevoirArmes(a4);

        GGladiateur.nouveauRetiaire("Szervlet", 50, e3);
        Gladiateur g5 = GGladiateur.getGladiateur(5);
        g5.recevoirArmes(a1);
        g5.recevoirArmes(a6);

        GGladiateur.nouveauMirmillon("Ramazmjet", 80, e3);
        Gladiateur g6 = GGladiateur.getGladiateur(6);
        g6.recevoirArmes(a4);
        g6.recevoirArmes(a5);
    }

    public static Integer getScore(Integer ide) {
        Ethnie e = GEthnie.getEthnie(ide);

        if (e != null)
            return e.getScore();
        return -1;
    }

    public static String faireRapport(Integer idg) {
        Gladiateur g = GGladiateur.getGladiateur(idg);

        if (g != null)
            return g.rapport();
        return null;
    }

    public static Collection<Integer> listerGladiateursDEthnie(Integer ide) {
        Collection<Integer> glad = new ArrayList<>();
        for (Gladiateur g : GGladiateur.getCompoEthnie(GEthnie.getEthnie(ide))) {
            glad.add(g.getIdg());
        }
        return glad;
    }
}
