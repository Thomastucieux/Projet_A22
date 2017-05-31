package packglad;

import java.util.Collection;

public class Mirmillon extends Gladiateur {
    /**
     * @attribute
     */
    private Integer poids;
    private static Integer c_poidsMax = 100;
    private static String c_type = "Mirmillon";
    private Collection<Gladiateur> agresseur;
    //Liste des armes autorisées
    private static Collection<Integer> armeAutorisees;
    


    public Mirmillon(String nom, Integer idg, Ethnie Appartenance, Integer poids) {
        super(nom, idg, Appartenance);
        this.poids = poids;
    }

    public void setPoids(Integer poids) {
        this.poids = poids;
    }

    public Integer getPoids() {
        return poids;
    }

    public static void setC_poidsMax(Integer c_poidsMax) {
        Mirmillon.c_poidsMax = c_poidsMax;
    }

    public static Integer getC_poidsMax() {
        return c_poidsMax;
    }

    public Collection getAgresseur() {
        return agresseur;
    }

    public static Collection<Integer> getArmeAutorisees() {
        return Mirmillon.armeAutorisees;
    }

 
    public Integer getForce() {
        return this.poids/2;
    }


    public String rapport() {
        return super.rapport() + "mon poids est de " + this.getPoids() + " kg";
    }


    public void recevoirCoup(Gladiateur Agresseur, Arme a) {
        this.agresseur.add(Agresseur);
        super.recevoirCoup(a.getPuissanceOffensive()+Agresseur.getForce());
    }


    public static void c_autoriserArme(Arme a) {
        Mirmillon.armeAutorisees.add(a.getIda());
    }
    
    public String saluer() {
        return "Ave Caesar, " + Mirmillon.getType() + " n°" + this.getIdg() + " : " + this.getNom() + " , j'appartiens à l'ethnie des " + this.getAppartenance();
    }
    
    public static String getType() {
        return Mirmillon.c_type;
    }
    
    @Override public Integer recevoirArmes(Arme a) {
        Integer res=1;
        for (Integer arme : Mirmillon.armeAutorisees) {
            if (a.getIda() ==arme) {
                res=0;
            }
        }
        if (res == 0) {
            res = super.recevoirArmes(a);
        }
        return res;
    }

}