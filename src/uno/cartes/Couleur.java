package uno.cartes;

public enum Couleur {

    JAUNE("jaune"),
    BLEU("bleu"),
    ROUGE("rouge"),
    VERT("vert");

    private String nom ;

    private Couleur (String nom) {
        this.nom = nom ;
    }
    public String getNom() {
        return nom ;
    }
    public String toString(){
        return nom;
    }
}