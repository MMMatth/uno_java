package uno.cartes;
import uno.jeu.Uno;

/**
 *   Classe abstraite représentant une carte du jeu de Uno
 * @author Matthieu GAUDEL
 */
public abstract class Carte {
    protected Uno u;  /** Référence vers le jeu de Uno */
    protected Couleur couleur;  /** Couleur de la carte null si non colorée */

    /**
     *   Constructeur de la classe Carte
     * @param u Référence vers le jeu de Uno
     */
    public  Carte(Uno u){
        this.u = u;
    }

    /**
     *   Constructeur de la classe Carte
     * @param u Référence vers le jeu de Uno
     * @param c Couleur de la carte
     */
    public Carte(Uno u, Couleur c){
        this.u = u;
        this.couleur = c;
    }

    /**
     *   fonction qui permet d'ajouter la référence vers le jeu de Uno
     * @param u Référence vers le jeu de Uno
     */
    public void setUno(Uno u){
        this.u = u;
    }

    /**
     *  fonction qui permet de récupérer la valeur de la carte
     * @return valeur de la carte (score)
     */
    public abstract int getValeur();

    /**
     * fonction qui permet de savoir si la carte peut être recouverte par la carte passée en paramètre
     * @param c carte à comparer
     * @return true si la carte peut être recouverte par la carte passée en paramètre
     */
    public abstract boolean peutEtreRecouvertePar(Carte c);

    /**
     * fonction qui permet de récupérer la couleur de la carte
     * @return couleur de la carte
     */
    public abstract Couleur getCouleur();

    /**
     *  fonction qui permet de modifier la couleur de la carte
     * @param c nouvelle couleur de la carte
     */
    public abstract void setCouleur(Couleur c);

    /**
     * fonction qui permet de savoir si la carte est sans couleur
     * @return true si la carte est sans couleur
     */
    public abstract boolean estSansCouleur();

    /**
     *  fonction qui permet de savoir si la carte est de la même couleur que la carte passée en paramètre
     * @param c carte à comparer
     * @return true si la carte est de la même couleur que la carte passée en paramètre
     */
    public abstract boolean estDeCouleurCompatibleAvec(Carte c);
    // double dispatch

    /* fonction peut être posée sur */

    /**
     *  fonction qui permet de savoir si la carte peut être posée sur une carte Chiffre
     * @param c carte Chiffre
     * @return true si la carte peut être posée sur une carte Chiffre
     */
    public abstract boolean peutEtrePoseeSur(Chiffre c);

    /**
     * fonction qui permet de savoir si la carte peut être posée sur une carte Plus2
     * @param c carte Plus2
     * @return true si la carte peut être posée sur une carte Plus2
     */
    public abstract boolean peutEtrePoseeSur(Plus2 c);

    /**
     * fonction qui permet de savoir si la carte peut être posée sur une carte Plus4
     * @param c carte Plus4
     * @return true si la carte peut être posée sur une carte Plus4
     */
    public abstract boolean peutEtrePoseeSur(Plus4 c);

    /**
     * fonction qui permet de savoir si la carte peut être posée sur une carte Joker
     * @param c carte Joker
     * @return true si la carte peut être posée sur une carte Joker
     */
    public abstract boolean peutEtrePoseeSur(Joker c);

    /**
     * fonction qui permet de savoir si la carte peut être posée sur une carte PasseTonTour
     * @param c carte PasseTonTour
     * @return true si la carte peut être posée sur une carte PasseTonTour
     */
    public abstract boolean peutEtrePoseeSur(PasseTonTour c);

    /**
     * fonction qui permet de savoir si la carte peut être posée sur une carte ChangementDeSens
     * @param c carte ChangementDeSens
     * @return true si la carte peut être posée sur une carte ChangementDeSens
     */
    public abstract boolean peutEtrePoseeSur(ChangementDeSens c);

    /**
     * fonction qui permet d'appliquer l'effet de la carte
     */
    public abstract void appliquerEffet();

    /**
     *   fonction qui permet de récupérer la couleur de la carte sous forme de String pour l'affichage
     * @return String de la couleur de la carte
     */
    public String getCouleurString(){
        if (couleur == null) {
            return "\u001B[37m";
        }else{
            return switch (couleur) {
                case ROUGE -> "\u001B[31m";
                case BLEU -> "\u001B[34m";
                case VERT -> "\u001B[32m";
                case JAUNE -> "\u001B[33m";
            };
        }
    }

    /**
     *   fonction qui permet de récupérer la valeur de la carte sous forme de String pour l'affichage
     * @return String de la valeur de la carte avec la couleur correspondante
     */
    public abstract String toString();

}