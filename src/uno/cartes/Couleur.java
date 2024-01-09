package uno.cartes;

/**
 *   Enumération des couleurs des cartes
 * @author Matthieu GAUDEL
 */
public enum Couleur {

    JAUNE("jaune"), /** la couleur jaune */
    BLEU("bleu"), /** la couleur bleue */
    ROUGE("rouge"), /** la couleur rouge */
    VERT("vert"); /** la couleur verte */

    private String nom ; // nom de la couleur

    /**
     *   Constructeur de la couleur
     * @param nom nom de la couleur
     */
    private Couleur (String nom) {
        this.nom = nom ;
    }

    /**
     *   Getter du nom de la couleur
     * @return le nom de la couleur
     */
    public String getNom() {
        return nom ;
    }

    /**
     *   Fonction qui permet de récupérer la couleur à partir de son nom
     * @return la couleur
     */
    public String toString(){
        return nom;
    }

    /**
     *   Fonction qui permet de savoir si la couleur est la même que celle passée en paramètre
     * @param color couleur à comparer
     * @return true si la couleur est la même, false sinon
     */
    boolean isColor(String color){
        return color == nom;
    }
}