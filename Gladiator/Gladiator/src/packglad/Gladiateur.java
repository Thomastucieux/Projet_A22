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
    private Collection<Arme> listeArme = new ArrayList<Arme>();


    public Gladiateur(String nom, Integer idg, Ethnie Appartenance) {
        this.nom = nom;
        this.vie = c_vieMax;
        this.idg = idg;
        this.Appartenance = Appartenance;
    }
    
    public String saluer() {
        return "Ave Caesar, " + this.getType() + " n°" + this.getIdg() + " : " + this.getNom() + " , j'appartiens à l'ethnie des " + this.getAppartenance().getNom();
    }
    
    public String rapport() {
        return this.getType()+" N° " +this.getIdg() + ", mon nom est " + this.getNom() + ", j'appartiens a l'ethnie des " + this.getAppartenance().getNom() + ", je suis " + this.getEtat() +", il me reste " + this.getVie() + " points de vie, j'ai une force de " + this.getForce();
    }
    
    public Integer recevoirCoup(Integer degat) {
        Integer res=1;
        if (this.vie > 0) {
            //Calcul des dégats infligés en fonction de la défense
            for (Arme arme : this.listeArme) {
                degat -= arme.getPuissanceDefensive();
            }
            //Application des dégats s'ils sont supérieur à la défense
            if (degat > 0) {
                if (degat>this.vie) {
                	this.vie=0;
                }
                else {
                	this.vie -= degat;
                }
                res = 0;
            }
        }
        return res;
    }

    public Integer recevoirArmes(Arme a) {
        Integer res=0;
        for (Arme arme : this.listeArme ) {
            if (arme == a) {
                res=1;
            }
        }
        if (res == 0) {
            this.listeArme.add(a);
        }
        return 0;
    }

    public Collection<Arme> declarerArmes() {
        return this.listeArme;
    }
    
    

    public String getEtat() {
        String res = "";
        Integer vie = this.getVie();
        if(vie < 10) {
            res = "moribond";
        }
        else if(vie <= 50) {
            res = "blessé";
        }
        else {
            res = "bien portant";
        }
        return res;
    }

    

    public Integer frapper(Arme a, Gladiateur Victime) {
        Integer res=1;
        if (this.listeArme.contains(a)) {
            if (Victime.getType() == "Mirmillon") {
                res = Victime.recevoirCoup(a.getPuissanceOffensive()+this.getForce(), this);
            }
            else {
                res = Victime.recevoirCoup(a.getPuissanceOffensive()+this.getForce());
            }
        }
        return res;
    }


    public Integer perdreArme(Arme a) {
        Integer res=1;
        for (Arme arme : this.listeArme) {
            if (arme == a) {
                res=0;
            }
        }
        if (res == 0) {
            this.listeArme.remove(a);
        }
        return res;
    }


    public static void setC_vieMax(Integer c_vieMax) {
        Gladiateur.c_vieMax = c_vieMax;
    }

    public static Integer getC_vieMax() {
        return c_vieMax;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setVie(Integer vie) {
        this.vie = vie;
    }

    public Integer getVie() {
        return this.vie;
    }

    public void setIdg(Integer idg) {
        this.idg = idg;
    }

    public Integer getIdg() {
        return this.idg;
    }

    public void setAppartenance(Ethnie Appartenance) {
        this.Appartenance = Appartenance;
    }

    public Ethnie getAppartenance() {
        return this.Appartenance;
    }
    
    @Override public String toString() {
        return this.getNom();
    }
    
    
    public abstract Collection<Gladiateur> getAgresseur();
    public abstract String getType();
    public abstract Integer getForce();
    public abstract Integer recevoirCoup(Integer degat, Gladiateur Agresseur);
}
