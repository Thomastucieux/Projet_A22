package packglad;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Gladiateur {
    /**
     * @attribute
     */
    private static Integer c_vieMax = 200;
    private String nom;
    private Integer vie;
    private Integer idg;
    private Ethnie Appartenance;

    //Liste d'arme possedé par le gladiateur
    private Collection<Arme> listeArme = new ArrayList<>();


    public Gladiateur(String nom, Integer idg, Ethnie Appartenance) {
        this.nom = nom;
        this.vie = c_vieMax;
        this.idg = idg;
        this.Appartenance = Appartenance;
    }

    public static Integer getC_vieMax() {
        return c_vieMax;
    }

    static void setC_vieMax(Integer c_vieMax) {
        Gladiateur.c_vieMax = c_vieMax;
    }

    String saluer() {
        return "Ave Caesar, " + this.getType() + " n°" + this.getIdg() + " : " + this.getNom() + " , j'appartiens à l'ethnie des " + this.getAppartenance().getNom();
    }

    public String rapport() {
        return this.getType() + " N° " + this.getIdg() + ", mon nom est " + this.getNom() + ", j'appartiens a l'ethnie des " + this.getAppartenance().getNom() + ", je suis " + this.getEtat() + ", il me reste " + this.getVie() + " points de vie, j'ai une force de " + this.getForce();
    }

    Integer recevoirCoup(Integer degat) {
        Integer res = 1;
        if (this.vie > 0) {
            //Calcul des dégats infligés en fonction de la défense
            for (Arme arme : this.listeArme) {
                degat -= arme.getPuissanceDefensive();
            }
            //Application des dégats s'ils sont supérieur à la défense
            if (degat > 0) {
                if (degat > this.vie) {
                    this.vie = 0;
                } else {
                    this.vie -= degat;
                }
                res = 0;
            }
        }
        return res;
    }

    public Boolean recevoirArmes(Arme a) {
        return !listeArme.contains(a) && listeArme.add(a);
    }

    Collection<Arme> declarerArmes() {
        return new ArrayList<>(listeArme);
    }

    private String getEtat() {
        return vie > 50 ? "bien portant" : (vie >= 10 ? "blessé" : "moribond");
    }

    Integer frapper(Arme a, Gladiateur Victime) {
        Integer res = 1;

        if (this.listeArme.contains(a)) {
            res = Victime.recevoirCoup(a.getPuissanceOffensive() + this.getForce(), this);
        }

        return res;
    }

    Boolean perdreArme(Arme a) {
        return listeArme.remove(a);
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    Integer getVie() {
        return this.vie;
    }

    public void setVie(Integer vie) {
        this.vie = vie;
    }

    public Integer getIdg() {
        return this.idg;
    }

    public void setIdg(Integer idg) {
        this.idg = idg;
    }

    Ethnie getAppartenance() {
        return this.Appartenance;
    }

    public void setAppartenance(Ethnie Appartenance) {
        this.Appartenance = Appartenance;
    }

    @Override
    public String toString() {
        return this.getNom();
    }


    public abstract Collection<Gladiateur> getAgresseur();

    public abstract String getType();

    public abstract Integer getForce();

    public abstract Integer recevoirCoup(Integer degat, Gladiateur Agresseur);
}
