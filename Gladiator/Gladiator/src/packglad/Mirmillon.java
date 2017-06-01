package packglad;

import java.util.ArrayList;
import java.util.Collection;

public class Mirmillon extends Gladiateur {
    private static Integer c_poidsMax = 100;
    private static String c_type = "Mirmillon";
    //Liste des armes autorisées
    private static Collection<Integer> armeAutorisees = new ArrayList<Integer>();
    /**
     * @attributs
     */
    private Integer poids;
    private Collection<Gladiateur> agresseur = new ArrayList<Gladiateur>();

    /**
     * Constructeurs
     */

    public Mirmillon(String nom, Integer idg, Ethnie Appartenance, Integer poids) {
        super(nom, idg, Appartenance);
        this.poids = poids;
    }

    static Integer getC_poidsMax() {
        return c_poidsMax;
    }

    static void setC_poidsMax(Integer c_poidsMax) {
        Mirmillon.c_poidsMax = c_poidsMax;
    }

    static Collection<Integer> getArmeAutorisees() {
        return new ArrayList<>(armeAutorisees);
    }

    static Integer c_autoriserArme(Arme a) {
        Integer res = 1;
        if (!Mirmillon.armeAutorisees.contains(a.getIda())) {
            Mirmillon.armeAutorisees.add(a.getIda());
            res = 0;
        }
        return res;
    }

    private Integer getPoids() {
        return poids;
    }

    /**
     * Méthodes
     */

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    @Override
    public Collection<Gladiateur> getAgresseur() {
        return agresseur;
    }

    @Override
    public Integer getForce() {
        return this.poids / 2;
    }

    @Override
    public String rapport() {
        return super.rapport() + " mon poids est de " + this.getPoids() + " kg" + ", voici mes armes " + this.declarerArmes().toString() + ", mes agresseurs sont : " + this.getAgresseur().toString();
    }

    @Override
    public Integer recevoirCoup(Integer degat, Gladiateur Agresseur) {
        Integer res = this.recevoirCoup(degat);
        this.agresseur.add(Agresseur);

        return res;
    }

    @Override
    public String getType() {
        return Mirmillon.c_type;
    }

    @Override
    public Boolean recevoirArmes(Arme a) {
        if (Mirmillon.armeAutorisees.contains(a.getIda()))
            return super.recevoirArmes(a);

        return false;
    }

}
