package uno.cartes;
import uno.jeu.Uno;

/**
 * @brief Classe abstraite représentant une carte du jeu de Uno
 */
public abstract class Carte {
    protected Uno u; /** < Référence vers le jeu de Uno */
    protected Couleur couleur; /** < Couleur de la carte null si non colorée */

    /**
     * @brief Constructeur de la classe Carte
     * @param u Référence vers le jeu de Uno
     */
    public  Carte(Uno u){
        this.u = u;
    }

    /**
     * @brief Constructeur de la classe Carte
     * @param u Référence vers le jeu de Uno
     * @param c Couleur de la carte
     */
    public Carte(Uno u, Couleur c){
        this.u = u;
        this.couleur = c;
    }

    /**
     * @brief fonction qui permet d'ajouter la référence vers le jeu de Uno
     * @param u Référence vers le jeu de Uno
     */
    public void setUno(Uno u){
        this.u = u;
    }

    /* getters */
    public abstract int getValeur();
    public abstract boolean peutEtreRecouvertePar(Carte c);
    public abstract Couleur getCouleur();
    public abstract void setCouleur(Couleur c);
    public abstract boolean estSansCouleur();
    public abstract boolean estDeCouleurCompatibleAvec(Carte c);
    // double dispatch

    /* fonction peut être posée sur */
    public abstract boolean peutEtrePoseeSur(Chiffre c);
    public abstract boolean peutEtrePoseeSur(Plus2 c);
    public abstract boolean peutEtrePoseeSur(Plus4 c);
    public abstract boolean peutEtrePoseeSur(Joker c);
    public abstract boolean peutEtrePoseeSur(PasseTonTour c);
    public abstract boolean peutEtrePoseeSur(ChangementDeSens c);


    public abstract void appliquerEffet();

    /**
     * @brief fonction qui permet de récupérer la couleur de la carte sous forme de String pour l'affichage
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
     * @brief fonction qui permet de récupérer la valeur de la carte sous forme de String pour l'affichage
     * @return String de la valeur de la carte avec la couleur correspondante
     */
    public abstract String toString();

}