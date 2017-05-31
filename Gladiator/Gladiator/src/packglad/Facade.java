package packglad;

import java.util.Collection;

public class Facade {
    public static void parametrage(Integer vieInit, Integer forceRet, Integer poidsMax, Integer agilMax) {
        Gladiateur.setC_vieMax(vieInit);
        Retiaire.setC_force(forceRet);
        Mirmillon.setC_poidsMax(poidsMax);
        Retiaire.setC_AgiliteMax(agilMax);
    }

    public static Collection<Integer> listerTousGladiateurs() {
        Collection<Integer> glad = null;
        for (Gladiateur g :GGladiateur.getListeGladiateur()) {
            glad.add(g.getIdg());
        }
        return glad;
    }

    public static Integer donnerUneArme(Integer ida, Integer idg) {
        return GGladiateur.getGladiateur(idg).recevoirArmes(GArme.getArme(ida));
    }

    public static Collection listerAgresseurs(Integer idg) {
        return GGladiateur.getGladiateur(idg).getAgresseur();
    }

    public static Integer creerMirmillon(String nom, Integer poids, Integer ide) {
        GGladiateur.nouveauMirmillon(nom, poids, GEthnie.getEthnie(ide));
        return GGladiateur.getIncrementIDG()-1;
        //retourne L'idg utilisé pour créer le dernier gladiateur
    }

    public static String faireSaluerGladiateur(Integer idg) {
        return GGladiateur.getGladiateur(idg).saluer();
    }

    public static String nomDeLEthnie(Integer ide) {
        return GEthnie.getEthnie(ide).getNom();
    }

    public static Integer supprimerGlad(Integer idg) {
        return GGladiateur.suppGlad(idg);
    }

    public static String nomDuGladiateur(Integer idg) {
        return GGladiateur.getGladiateur(idg).getNom();
    }

    public static Collection<Integer> listerEthnies() {
        Collection<Integer> ethnie=null;
        for (Ethnie e : GEthnie.getListeEthnie()) {
            ethnie.add(e.getIde());
        }
        return ethnie;
    }

    public static String decrireEthnie(Integer ide) {
        return GEthnie.getEthnie(ide).decrireEthnie();
    }

    public static Integer desarmer(Integer idgVictime, Integer ida) {
        return GGladiateur.getGladiateur(idgVictime).perdreArme(GArme.getArme(ida));
    }

    public static String nomDeLArme(Integer ida) {
        return GArme.getArme(ida).getType();
    }

    public static Integer creerRetiaire(String nom, Integer agilite, Integer ide) {
        GGladiateur.nouveauRetiaire(nom, agilite, GEthnie.getEthnie(ide));
        return GGladiateur.getIncrementIDG()-1;
        //retourne L'idg utilisé pour créer le dernier gladiateur
    }

    public static Collection<Integer> listerArmesDispoRetiaire() {
        return Retiaire.getArmeAcc();
    }

    public static Collection<Integer> declarerArmes(Integer idg) {
        Collection<Integer> arme=null;
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
        return GArme.getArme(ida).decrireArme();
    }

    public static Collection<Integer> listerArmesDispoMirmillon() {
        return Mirmillon.getArmeAutorisees();
    }

    public static Integer creerUneArme(String nom, Integer puissOff, Integer puissDef) {
        return GArme.nouvelleArme(puissDef, puissOff, nom);
    }

    public static Integer autoriserArmeAuxMirmillons(Integer ida) {
        return Mirmillon.c_autoriserArme(GArme.getArme(ida));
    }

    public static Integer autoriserArmeAuxRetiaires(Integer ida) {
        return Retiaire.c_autoriserArme(GArme.getArme(ida));
    }

    public static Integer frapper(Integer idgAgresseur, Integer idgVictime, Integer ida) {
        return GGladiateur.getGladiateur(idgAgresseur).frapper(GArme.getArme(ida),GGladiateur.getGladiateur(idgVictime));
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
        return GEthnie.getEthnie(ide).getScore();
    }

    public static String faireRapport(Integer idg) {
        return GGladiateur.getGladiateur(idg).rapport();
    }

    public static Collection<Integer> listerGladiateursDEthnie(Integer ide) {
        Collection<Integer> glad=null;
        for (Gladiateur g : GGladiateur.getCompoEthnie(GEthnie.getEthnie(ide))) {
            glad.add(g.getIdg());
        }
        return glad;
    }
}
