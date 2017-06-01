package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class Retiaire extends Gladiateur {
    /**
     * @attributs
     */
    private static Integer c_force = 30;
    private static String c_type = "Retiaire";
    private Integer agilite;
    private static Integer c_agiliteMax;

    //Collection des armes disponibles pour les rétiaires
    private static Collection<Integer> armeAcc = new ArrayList<Integer>();


    /**
     * @Constructeurs
     */
    public Retiaire(String nom, Integer idg, Ethnie Appartenance, Integer agilite) {
        super(nom, idg, Appartenance);
        this.agilite = agilite;
    }

    /**
     * @Méthodes
     */
    
    @Override public String rapport() {
        return super.rapport() + " mon agilite est de " + this.getAgilite() + ", voici mes armes " + this.declarerArmes().toString();
    }
    

    @Override public Integer getForce() {
        return Retiaire.c_force;
    }

    public static Integer c_autoriserArme(Arme a) {
        Integer res=1;
        if (!Retiaire.armeAcc.contains(a.getIda())) {
            Retiaire.armeAcc.add(a.getIda());
            res=0;
        }
        return res;
    }

    public static void setC_force(Integer c_force) {
        Retiaire.c_force = c_force;
    }

    public void setAgilite(Integer agilite) {
        this.agilite = agilite;
    }

    public Integer getAgilite() {
        return this.agilite;
    }


    public static Collection<Integer> getArmeAcc() {
        return Retiaire.armeAcc;
    }

    @Override public String getType() {
        return Retiaire.c_type;
    }
    public static void setC_AgiliteMax(Integer agiliteMax) {
        Retiaire.c_agiliteMax = agiliteMax;
    }

    public static Integer getC_agiliteMax() {
        return c_agiliteMax;
    }
    
        
    @Override public Integer recevoirArmes(Arme a) {
        Integer res=1;
        for (Integer arme : Retiaire.armeAcc) {
            if (a.getIda() ==arme) {
                res=0;
            }
        }
        if (res == 0) {
            res = super.recevoirArmes(a);
        }
        return res;
    }
    
    /**
     * Méthodes jamais utilisé puisque normalement réservé aux mirmillons
     */
    @Override public Collection<Gladiateur> getAgresseur() {
        Collection<Gladiateur> a = null;
        return a;
    }
    @Override public Integer recevoirCoup(Integer degat, Gladiateur Agresseur) {
        return null;
    }
}
