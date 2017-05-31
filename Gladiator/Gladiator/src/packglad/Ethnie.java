package packglad;

public class Ethnie {
    /**
     * @attributs
     */
    private String nom;
    private Integer score;
    private Integer ide;

    /**
     * @Constructeur
     */
    public Ethnie(String nom, Integer ide) {
        this.nom = nom;
        this.score = 0;
        this.ide = ide;
    }

    public String decrireEthnie() {
        return "Ceci est l'ethnie "+this.getNom()+", numéro "+this.getIde()+", elle a le score de "+this.getScore()+" points.";
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setIde(Integer ide) {
        this.ide = ide;
    }

    public Integer getIde() {
        return this.ide;
    }
}
