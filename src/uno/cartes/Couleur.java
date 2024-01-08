package uno.cartes;

/**
 * @brief Enumération des couleurs des cartes
 */
public enum Couleur {

    JAUNE("jaune"),
    BLEU("bleu"),
    ROUGE("rouge"),
    VERT("vert");

    private String nom ; // nom de la couleur

    /**
     * @brief Constructeur de la couleur
     * @param nom nom de la couleur
     */
    private Couleur (String nom) {
        this.nom = nom ;
    }

    /**
     * @brief Getter du nom de la couleur
     * @return le nom de la couleur
     */
    public String getNom() {
        return nom ;
    }

    /**
     * @brief Fonction qui permet de récupérer la couleur à partir de son nom
     * @param nom nom de la couleur
     * @return la couleur
     */
    public String toString(){
        return nom;
    }

    /**
     * @brief Fonction qui permet de savoir si la couleur est la même que celle passée en paramètre
     * @param color couleur à comparer
     * @return true si la couleur est la même, false sinon
     */
    boolean isColor(String color){
        return color == nom;
    }
}