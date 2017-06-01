package packglad;

public class Ethnie {
    /**
     * @attributs
     */
    private String nom;
    private Integer ide;

    /**
     * Constructeur
     */
    public Ethnie(String nom, Integer ide) {
        this.nom = nom;
        this.ide = ide;
    }

    String decrireEthnie() {
        return "Les " + this.getNom() + ", numéro " + this.getIde() + ", ont un score de " + this.getScore() + " points.";
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    Integer getScore() {
        Integer res = 0;
        for (Gladiateur g : GGladiateur.getCompoEthnie(this)) {
            Integer vie = g.getVie();
            if (vie > 50) {
                res += 10;
            } else if (vie >= 10) {
                res += 5;
            }
        }
        return res;
    }

    public Integer getIde() {
        return this.ide;
    }

    public void setIde(Integer ide) {
        this.ide = ide;
    }
}
