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
