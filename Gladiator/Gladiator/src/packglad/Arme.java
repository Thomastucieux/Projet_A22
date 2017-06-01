package packglad;

public class Arme {
    /**
     * @attributs
     */
    private Integer ida;
    private String type;
    private Integer puissanceOffensive;
    private Integer puissanceDefensive;

    /**
     * Constructeurs
     */
    public Arme(Integer ida, String type, Integer puissanceOffensive, Integer puissanceDefensive) {
        this.ida = ida;
        this.type = type;
        this.puissanceOffensive = puissanceOffensive;
        this.puissanceDefensive = puissanceDefensive;
    }

    /**
     * Méthodes
     */
    String decrireArme() {
        return this.getType() + " N°" + this.getIda() + ", puissance offensive de " + this.getPuissanceOffensive() + " et puissance défensive de " + this.getPuissanceDefensive();
    }


    public Integer getIda() {
        return this.ida;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Integer getPuissanceOffensive() {
        return this.puissanceOffensive;
    }

    public void setPuissanceOffensive(Integer puissanceOffensive) {
        this.puissanceOffensive = puissanceOffensive;
    }

    Integer getPuissanceDefensive() {
        return this.puissanceDefensive;
    }

    public void setPuissanceDefensive(Integer puissanceDefensive) {
        this.puissanceDefensive = puissanceDefensive;
    }

    @Override
    public String toString() {
        return this.getType();
    }
}
