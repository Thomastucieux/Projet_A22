package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class Retiaire extends Gladiateur {
    /**
     * @attributs
     */
    private static Integer c_force = 30;
    private static String c_type = "Retiaire";
    private static Integer c_agiliteMax;
    //Collection des armes disponibles pour les rétiaires
    private static Collection<Integer> armeAcc = new ArrayList<>();
    private Integer agilite;


    /**
     * Constructeurs
     */
    Retiaire(String nom, Integer idg, Ethnie Appartenance, Integer agilite) {
        super(nom, idg, Appartenance);
        this.agilite = agilite;
    }

    static Integer c_autoriserArme(Arme a) {
        Integer res = 1;
        if (!Retiaire.armeAcc.contains(a.getIda())) {
            Retiaire.armeAcc.add(a.getIda());
            res = 0;
        }
        return res;
    }

    static void setC_force(Integer c_force) {
        Retiaire.c_force = c_force;
    }

    static Collection<Integer> getArmeAcc() {
        return new ArrayList<>(Retiaire.armeAcc);
    }

    static void setC_AgiliteMax(Integer agiliteMax) {
        Retiaire.c_agiliteMax = agiliteMax;
    }

    static Integer getC_agiliteMax() {
        return c_agiliteMax;
    }

    /**
     * Méthodes
     */

    @Override
    public String rapport() {
        return super.rapport() + " mon agilite est de " + this.getAgilite() + ", voici mes armes " + this.declarerArmes().toString();
    }

    @Override
    public Integer getForce() {
        return Retiaire.c_force;
    }

    private Integer getAgilite() {
        return this.agilite;
    }

    public void setAgilite(Integer agilite) {
        this.agilite = agilite;
    }

    @Override
    public String getType() {
        return Retiaire.c_type;
    }

    @Override
    public Boolean recevoirArmes(Arme a) {
        if (Retiaire.armeAcc.contains(a.getIda()))
            return super.recevoirArmes(a);

        return false;
    }

    /**
     * Méthodes jamais utilisé puisque normalement réservé aux mirmillons
     */
    @Override
    public Collection<Gladiateur> getAgresseur() {
        return null;
    }

    @Override
    public Integer recevoirCoup(Integer degat, Gladiateur Agresseur) {
        return super.recevoirCoup(degat - agilite);
    }
}
